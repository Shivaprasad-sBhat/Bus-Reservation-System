
# Bus Reservation System 
<img src="./Frontend/assests/banner.png"  style = "width:90%; height:450px" />

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

* Admin Module
* User Module
* Route Module
* Bus Module
* Reservation Module
* Feedback Module

## Entity Relationship Diagram
 ###### ER Diagram for the database tables.
<!-- ![App Screenshot](https://github.com/Shivaprasad-sBhat/posh-fact-2211/blob/main/Frontend/assests/ER%20Diagram.png?raw=true) -->
![App Screenshot](./Frontend/assests/er-diagram.png)

## Features

* Admin Features:
    * Only registered admins with valid credentials can login.
    
     <img src="./Frontend/assests/adminLogin.png"  style = "width:90%; height:450px" />

    * Administrator Role of the entire application.   
          <img src="./Frontend/assests/adminhomepage.png"  style = "width:90%; height:450px" />
    
    * Admin can add/update/delete route and bus from main database.
         <img src="./Frontend/assests/routemodule.png"  style = "width:90%; height:450px" />
              <img src="./Frontend/assests/busmodule.png"  style = "width:90%; height:450px" />
              
              
* User Features:
    * User can signup with proper details.
       <img src="./Frontend/assests/usersignup.png"  style = "width:90%; height:450px" />
       
    * User can login using his credentials.
      <img src="./Frontend/assests/userlogin.png"  style = "width:90%; height:450px" />
    
    * User can view list of available buses and can book a reservation.
          <img src="./Frontend/assests/booktickets.png"  style = "width:90%; height:450px" />
          
    * User can view all his tickets,cancel tickets and user can also give feedback.
    
    <img src="./Frontend/assests/alltickets.png" style =
    "width:90%; height:450px" />
    
     <img src="./Frontend/assests/feedback.png" style =
    "width:90%; height:450px" />
    
    * User can update all his details including username and password.
    
     <img src="./Frontend/assests/userupdate.png" style =
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
```
`http://localhost:8818/`
```

```
`http://localhost:8818/swagger-ui.html`
```


## Contributors

* Contact Contributors of this project for any suggestion or feedback.

    #### Shivaprasad Bhat
    > Github:[Shivaprasad-sBhat](https://github.com/Shivaprasad-sBhat) 
    
    > LinkedIn:[shivaprasad-bhat](https://www.linkedin.com/in/shivaprasad-bhat/)
  
    #### Avinash Kumar
    > Github:[avinashkumar-06](https://github.com/avinashkumar-06)
    
    > LinkedIn:[avinashkumar06](https://www.linkedin.com/in/avinashkumar06/)

    #### Riyas S 
    >Github:[RIYAS11](https://github.com/RIYAS11)
    
    > LinkedIn:[riyas973](https://www.linkedin.com/in/riyas973/)
   

    #### Chiranjivi Pattanayak
    >Github:[chiranjivi-7](https://github.com/chiranjivi-7)
    
    > LinkedIn:[chiranjivi-pattanayak-b02784197](https://www.linkedin.com/in/chiranjivi-pattanayak-b02784197/)
   

 


# THANK YOU FOR VISITING OUR PROJECT

