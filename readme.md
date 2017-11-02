## Seed code - Boilerplate for step 1 - Activity Stream Assignment

### Assignment Step Description

As a first step in building our Activity Stream application, we will create a monolithic application. 

A monolithic application is built as a single unit. Enterprise Applications are built in three parts: 
1. A database (consisting of many tables usually in a relational database management system), 
2. A client-side user interface (consisting of HTML pages and/or JavaScript running in a browser), 
3. A server-side application. 

This server-side application will handle HTTP requests, execute some domain specific logic, retrieve and update data from the database, and populate the HTML views to be sent to the browser. It is a monolith – a single logical executable. 
To make any alterations to the system, a developer must build and deploy an updated version of the server-side application.

### Problem Statement

In this case study: Activity Stream Step 1, we will develop a monolithic application which will get the sender name, message from the user using a form (JSP/HTML), 
persist in MySQL Database and display all messages with their sender name, message content, timestamp of posting in a reverse chronological order (latest message first).

### Expected solution
![alt](https://s3.ap-south-1.amazonaws.com/stackroute/oie_eqW5sRly35UA.png?response-content-disposition=inline&X-Amz-Security-Token=AgoGb3JpZ2luEJL%2F%2F%2F%2F%2F%2F%2F%2F%2F%2FwEaCmFwLXNvdXRoLTEigAKGjZseNxIh5O0JI7o8xkNZQcHrnOgSPN3BPn8%2FlcDjp5Az2mhEi2k3i1CFpRYfwvGPUCTdKv5eJCibhD1FAfC1y5DA5JM07d%2Bn%2FHohz%2F%2Bn1%2BTpofBfETTCwYwcnku0a42bUaq7WEt83TcQwiTv3yvJM1Ls9GL4SOywx5Q10YCgixTCmibCldVZrwEfW9dYXaV1bMniZSHXjwMHbl%2BjiqhGpoPMGVYYqZ9%2Fp0Eu6xlvY69xGfQz7zfhnsbB7LyS0No4Cewgzo%2F%2Fd5toZvYB2L9bVM33U7OrvuCdBSSkoikkd%2Fi77vRw%2FvwxO6wNp8GkcAZ6jE66pyQF8xXa4bwYKZt4KvsDCLb%2F%2F%2F%2F%2F%2F%2F%2F%2F%2FwEQABoMMDc5NTU0MTAzMjIxIgzfN%2Fxjan3dyM9zgckqzwNgA4wMVRH56MvHmT8zF8tdHqnzQstJZkvPlQDWo%2FMS4bwafx1YOI02P5BqAIyPF2J3%2BqzD15DIpnlpT7X2qaXAEiCJGTFAPW3YbFVmIyW18hEvFGEj%2F0uKhofchMz7r8XTry88bwSEvggHrBB8F6yac6XJvQV2Wh94YEiqlA%2F8AYGZwpmWQNbpRGID8B0iYN4fTX1t51QsyRdMXtN7sP4bEzlcfB7HwZ%2B%2Ff6Wrsc5lWP13wZWcR4eKRMezF2kRUJEPDnBc0gnVHIItDtbTqGiVwgtPe4WKmlO9fkLuyYFZdjr58xb855GpoFD7%2F0ETt%2BdEtFiw5c7p58qqnKYyFrRKSAQ0CDMj1rAjZhtHpbXrnzcylJRTrzrYznd0aoBNKCnB%2FshB3GmENBdC%2BJn2BW3FMvsdzd7YxITROFhTQbEQUF1vfQ5gEH7YQBU9MubgRyAY%2Fcj9PqbvT%2Bsgqh%2BnirQLMHCwZUGEBkwMfxgiaTXvrtiZr8TcvgtivqWDmx3STwm01puC2DFF%2BlfBfIsHebgNB2eOhJoGrTcq4F2YWDRtG9By9t2stdkqGKCoLSgAbpz%2BsUawsdUsGMFgTBfqzgABL%2F6oZEJZc8Z75sFYQD5cMNvf2s8F&X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Date=20171030T055114Z&X-Amz-SignedHeaders=host&X-Amz-Expires=300&X-Amz-Credential=ASIAIFU5LZM24L23AVAA%2F20171030%2Fap-south-1%2Fs3%2Faws4_request&X-Amz-Signature=fbd4e6d35bbeafd41d7978a47c6a15d7b1eb48f78b419d89e4bf957d5a9106f3)


### Following are the broad tasks:
1. Display the list of existing messages from the database. Each message should contain senderName, message, and timestamp. 
2. Send a message which should contain the senderName, message, and timestamp.
3. For hibernate configuration we require the following: Dialect,driver class,username,password,database URL, mapping classes.
4. Build the sessionFactory object based on the parameters from hibernate.cfg.xml file. Also, handle exception if the session factory object can't be created.

### Project structure

The folders and files you see in this repositories, is how it is expected to be in projects, which are submitted for automated evaluation by Hobbes

    Project
	|
	├──src/main
	|   └── com.stackroute.activitystream.config	           
	|	        └── ApplicationContextConfig.java     // This class will contain the application-context for the application.
	|	        └── HibernateUtil.java                // This class build the sessionFactory object based on the parameters.
	|	        └── WebApplicationInitializer.java    // This class WebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer class.
	|   └── com.stackroute.activitystream.controller
	|		    └── AppController.java 		         // This class is used to control all the transactions with the database.
	|   └── com.stackroute.activitystream.model
	|		    └── Message.java                    // The class will be acting as the data model for the message Table in the database. 
	|   └── resources
	|		    └── hibernate.cfg.xml               // This is a XML configuration file for database connectivity
	|   └── webapp/WEB-INF/views
	|		    └── index.jsp                   // A JSP page with a form in it, which will have textboxes for Sender Name and Message content along with a Send Submit button. 
	|
	├──src/test/java/com/stackroute/activitystream/test
	|		    └── ActivityStreamTest.java     // All your test cases are written using JUnit, these test cases can be run by selecting Run As -> JUnit Test
	|
	├── .settings
	├── .classpath			                    // This file is generated automatically while creating the project in eclipse
	├── .hobbes   			                    // Hobbes specific config options, such as type of evaluation schema, type of tech stack etc., Have saved a default values for convenience
	├── .project			                    // This is automatically generated by eclipse, if this file is removed your eclipse will not recognize this as your eclipse project. 
	├── pom.xml 			                    // This is a default file generated by maven, if this file is removed your project will not get recognised in hobbes.
	└── PROBLEM.md  		                    // This files describes the problem of the assignment/project, you can provide as much as information and clarification you want about the project in this file

> PS: All lint rule files are by default copied during the evaluation process, however if need to be customizing, you should copy from this repo and modify in your project repo


#### To use this as a boilerplate for your new project, you can follow these steps

1. Clone the base boilerplate in the folder **assignment-solution-step1** of your local machine
     
    `git clone https://gitlab-dev.stackroute.in/activity-stream-java/step1-boilerplate.git assignment-solution-step1`

2. Navigate to assignment-solution-step6 folder

    `cd assignment-solution-step1`

3. Remove its remote or original reference

     `git remote rm origin`

4. Create a new repo in gitlab named `assignment-solution-step1` as private repo

5. Add your new repository reference as remote

     `git remote add origin https://gitlab-wd.stackroute.in/{{yourusername}}/assignment-solution-step1.git`

     **Note: {{yourusername}} should be replaced by your username from gitlab**

5. Check the status of your repo 
     
     `git status`

6. Use the following command to update the index using the current content found in the working tree, to prepare the content staged for the next commit.

     `git add .`
 
7. Commit and Push the project to git

     `git commit -a -m "Initial commit | or place your comments according to your need"`

     `git push -u origin master`

8. Check on the git repo online, if the files have been pushed

### Important instructions for Participants
> - We expect you to write the assignment on your own by following through the guidelines, learning plan, and the practice exercises
> - The code must not be plagirized, the mentors will randomly pick the submissions and may ask you to explain the solution
> - The code must be properly indented, code structure maintained as per the boilerplate and properly commented
> - Follow through the problem statement shared with you

### Further Instructions on Release

*** Release 0.1.0 ***

- Right click on the Assignment select Run As -> Run on Server to run your Assignment.
- Right click on the Assignment select Run As -> JUnit Test to run your Assignment.