
# Bus Reservation System 
<img src="https://github.com/Shivaprasad-sBhat/posh-fact-2211/blob/avinash-readme-update/Frontend/assests/banner.png?raw=true"  style = "width:90%; height:450px" />

* Bus Reservation System is a full stack project where REST API's are developed using Java and Spring Boot technologies and UI or frontend is developed using HTML,CSS,     JavaScript
*  These API's performs all the fundamental CRUD operations of any Bus Reservation Application platform with user validation at every step.
*  Our frontend application consumes these API's and allows customer to perform all the operations easily with user friendly UI.
* This project is developed by team of 4 Back-end Developers during project week in Masai School. 

## Tech Stack

* Java
* Spring Framework
* Spring Boot
* Spring Data JPA
* Hibernate
* MySQL
* HTML
* CSS
* JavaScript


## Modules

* Login, Logout Module
* Admin Module
* User Module
* Route Module
* Bus Module
* Reservation Module
* Feedback Module

## Entity Relationship Diagram
 ###### ER Diagram for the database tables.
![App Screenshot](https://github.com/Shivaprasad-sBhat/posh-fact-2211/blob/main/Frontend/assests/ER%20Diagram.png?raw=true)

## Features

* Admin Features:
    * Only registered admins with valid credentials can login.
    
     <img src="https://github.com/Shivaprasad-sBhat/posh-fact-2211/blob/avinash-readme-update/Frontend/assests/adminLogin.png?raw=true"  style = "width:90%; height:450px" />

    * Administrator Role of the entire application.   
          <img src="https://github.com/Shivaprasad-sBhat/posh-fact-2211/blob/avinash-readme-update/Frontend/assests/adminhomepage.png?raw=true"  style = "width:90%; height:450px" />
    
    * Admin can add/update/delete route and bus from main database.
         <img src="https://github.com/Shivaprasad-sBhat/posh-fact-2211/blob/avinash-readme-update/Frontend/assests/routemodule.png?raw=true"  style = "width:90%; height:450px" />
              <img src="https://github.com/Shivaprasad-sBhat/posh-fact-2211/blob/avinash-readme-update/Frontend/assests/busmodule.png?raw=true"  style = "width:90%; height:450px" />
              
              
* User Features:
    * User can signup with proper details.
       <img src="https://github.com/Shivaprasad-sBhat/posh-fact-2211/blob/avinash-readme-update/Frontend/assests/usersignup.png?raw=true"  style = "width:90%; height:450px" />
       
    * User can login using his credentials.
      <img src="https://github.com/Shivaprasad-sBhat/posh-fact-2211/blob/avinash-readme-update/Frontend/assests/userlogin.png?raw=true"  style = "width:90%; height:450px" />
    
    * User can view list of available buses and can book a reservation.
          <img src="https://github.com/Shivaprasad-sBhat/posh-fact-2211/blob/avinash-readme-update/Frontend/assests/booktickets.png?raw=true"  style = "width:90%; height:450px" />
          
    * User can view all his tickets,cancel tickets and user can also give feedback.
    
    <img src="https://github.com/Shivaprasad-sBhat/posh-fact-2211/blob/avinash-readme-update/Frontend/assests/alltickets.png?raw=true" style =
    "width:90%; height:450px" />
    
     <img src="https://github.com/Shivaprasad-sBhat/posh-fact-2211/blob/avinash-readme-update/Frontend/assests/feedback.png?raw=true" style =
    "width:90%; height:450px" />
    
    * User can update all his details including username and password.
    
     <img src="https://github.com/Shivaprasad-sBhat/posh-fact-2211/blob/avinash-readme-update/Frontend/assests/userupdate.png?raw=true" style =
    "width:90%; height:450px" />
       
        

## Installation & Run

* Before using the web application or running the API server, you should update the database config inside the [application.properties](https://github.com/Shivaprasad-sBhat/posh-fact-2211/blob/main/BusReservation/src/main/resources/application.properties) file. 
* Update the port number, username and password as per your local database config.

```
    server.port=8818

    spring.datasource.url=jdbc:mysql://localhost:3306/bus_reservation_db
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    spring.datasource.username=root
    spring.datasource.password=root

```
* Now you can perform all the operations by using either our web application or Swagger.

## API Root Endpoint

`http://localhost:8818/`

`http://localhost:8818/swagger-ui.html`




 


# THANK YOU EVERYONE FOR VISITING OUR PROJECT

---
