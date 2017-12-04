package com.stackroute.activitystream.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.stackroute.activitystream.model.Message;
import com.stackroute.activitystream.repository.MessageRepository;

/*Annotate the class with @Controller annotation.@Controller annotation is used to mark 
 * any POJO class as a controller so that Spring can recognize this class as a Controller*/
@Controller
public class MessageController {
	@Autowired
	MessageRepository messageRepository;

	/*
	 * From the problem statement, we can understand that the application requires
	 * us to implement two functionalities. They are as following:
	 * 
	 * 1. display the list of existing messages from the database. Each message
	 * should contain senderName, message, and timestamp 2. send a message which
	 * should contain the senderName, message, and timestamp.
	 * 
	 */
	// @RequestMapping(value = "/")
	// public String welcomePage(Locale locale, Model model) {
	//// Date date = new Date();
	//// DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
	// DateFormat.LONG, locale);
	////
	//// String formattedDate = dateFormat.format(date);
	////
	//// model.addAttribute("serverTime", formattedDate);
	// return "index";
	// }

	/*
	 * Define a handler method which will read the senderName and message from
	 * request parameters and save the message by calling the sendMessage() method
	 * of MessageRepository class. Please note that the timestamp should always be
	 * auto populated with system time and should not be accepted from the user.
	 * Also, after saving the message, it should show the same along with existing
	 * messages. Hence, reading messages has to be done here again and the retrieved
	 * messages object should be sent back to the view using ModelMap. This handler
	 * method should map to the URL "/sendMessage".
	 */
	@RequestMapping(value = "/sendMessage", method = RequestMethod.POST)
	public ModelAndView sendMessage(Message message) {
		message.setPostedDate();
		if (null == message.getSenderName() || null == message.getMessage() || message.getSenderName().isEmpty()
				|| message.getMessage().isEmpty()) {
			return new ModelAndView("index");
		}

		boolean isSaveSuccess = messageRepository.sendMessage(message);
		if (isSaveSuccess) {
			return new ModelAndView("redirect:/?success=true");
		}
		return new ModelAndView("redirect:/");
	}

	/*
	 * Define a handler method to read the existing messages by calling the
	 * getAllMessages() method of the MessageRepository class and add it to the
	 * ModelMap which is an implementation of Map for use when building model data
	 * for use with views. it should map to the default URL i.e. "/"
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getAllMessages(@RequestParam(required = false) boolean success, ModelMap modelMap) {
		List<Message> messageList = messageRepository.getAllMessages();
		modelMap.put("messageList", messageList);
		return "index";
	}

}
