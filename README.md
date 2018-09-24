# automateShoppingCart-APItests
SeleniumWebdriver-Java-PageObjectModel-RESTAssured

Requirement:-

•	Java 10.0 JDK

•	Maven to create and maintain dependencies such as Selenium, testNG, Page Object Model and REST Assured.

•	Chromedriver.exe

•	Firefoxdriver.exe 


Description:-
The following   tests were automated using Selenium+Webdriver in Java, with Page Object Model design pattern.

TEST 1: HAPPY PATH, PURCHASE 2 ITEMS 
1. ‘Quick view’ an item 
2. Change the size of the item 
3. Add that item to basket 
4. Continue shopping 
5. ‘Quick view’ a different item (leave the size at the default) 
6. Add that item to basket 
7. View the basket and confirm that the items are of the size tests selected, that their prices are correct, that Total Products is the sum of the two items and that ‘Total’ equals the Total Products + Shipping. 
8. Proceed through checkout to payment (complete by wire) 
(Logout) 

TEST 2: REVIEW PREVIOUS ORDERS AND ADD A MESSAGE 
(Login to the site using the above credentials) 
1. View previous orders 
2. Select an item from previous order (there will be others – confirm this by date/time) and add a comment 
3. Confirm that the comment appears under ‘messages’ 
(Logout) 

TEST 3: CAPTURE IMAGES 
(Login to the site using the above credentials) 
From Test 2 create an assertion which will cause a fail (e.g. confirm the dress is red when in fact it is blue) and capture a screen-grab on fail using Selenium 
(Logout) 
TEST 4: API CALLS 
1. Visit https://reqres.in/ where tests will find the documentation needed to create API calls using that base URL. 
2. Create ‘happy path’ tests for each of the CRUD actions, demonstrating that tests have asserted against one or more things of value which demonstrate success or failure of the test. 

Screen Shots
Screenshots saved under IdeaProjects\automateShpCart

Note: Please note that this is a maven project. Hence after cloning this project, ensure the Maven added to run the project. 
Please following steps from below link
https://www.lagomframework.com/documentation/1.4.x/java/IntellijMaven.html
