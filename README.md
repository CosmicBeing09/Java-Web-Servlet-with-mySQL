# Java-Web-Servlet-with-mySQL
--> Basic servlet operations: doGet and doPost
--> MySQL database is used with the help of my-sql connector jars
--> To connect with database, user can use xampp/wampp and start Apache and MySQL server
--> Create a database named: demo-servlet
--> Run the query: 
                  CREATE TABLE person(
                  id int,
                  name varchar(45),
                  age int    
                   );
                   
--> Add apache server in your IDE (For Intelij Idea, at first download apache server core from offical site and unzip it. Goto Run -> Edit
    Configuration -> + -> select tomcat server -> local -> configure, and then add the unzipped apache server)

--> Content negotiation is used for application/json and application/xml MIME types. To test the api, add Accept header in the request
   field and add any of those two MIME type
   
--> RequestDispatcher is demonstrated
--> Filter is demonstrated
--> XML, JSON parser are demonstrated
--> Database connection is demonstrated
