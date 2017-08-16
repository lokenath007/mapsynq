To Execute the test Run the following inside the project

For Chrome Execute the command from terminal:

mvn clean test  -Durl="http://www.mapsynq.com/" -Dbrowser="Chrome" -DxmlFileName=testng.xml


For Firefox Execute the command from terminal:

mvn clean test  -Durl="http://www.mapsynq.com/" -Dbrowser="Firefox" -DxmlFileName=testng.xml

This project use testng framework, maven buid.

This Project support POM and structure define below.

All page class(the basic public methods/operation and its private members)  located at pageclasses package (/mapsynq/src/test/java/com/mapsynq/pageclasses) like Direction Page,Live Page etc

Separete Test class  located at testclass package (/mapsynq/src/test/java/com/mapsynq/testclass) to test the basic public methods/operation of   Direction Page,Live Page etc


All utility class located at utility package (/mapsynq/src/test/java/com/mapsynq/utilityclasses) 
1.CheckDomProperties.java - To check dom properties of an element (it is using javascriptexecutor , to check if dom is not rendered, it check properties)
2. TestListener.java-It implements ITestListener to capture screenshot at /mapsynq/Screenshots if assertion fail


All the firefox gecko driver and chrome driver reside at /mapsynq/target/surefire-reports/(click index.html)

Now the test cases supports below scenarios,
1.open the mapsynq webpage in chrome or firefox,
2.Go to direction tab
3.Give valid source(CHANGI AIRPORT) and destination(BOTANIC GARDENS)
4.Find the Traffic aware route with above the config
5.Find the Toll Aware route with above the config
6.Find the Fastest  route with above the config
7.Find the Shortest route with above the config 
8.Close the browser
9. If above failure occurs it capture screenshot in the  location /mapsynq/Screenshots  and test results in the /mapsynq/target/surefire-reports(click index.html)  


In future it  covers ather test cases like live page data(incident,cameras,tolls) and other major functionality(stay-tuned)


