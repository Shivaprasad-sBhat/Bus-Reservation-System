
let userData= JSON.parse(localStorage.getItem("userDataStorage"))
console.log(userData)
let obj={};


document.getElementById("routeForm").addEventListener("submit",findBuses)



function findBuses(event){

    event.preventDefault();

    document.getElementById("buslist").innerHTML=null;

    let source =document.getElementById("source").value

    let destination = document.getElementById("destination").value

    let date = document.getElementById("date").value

    console.log("inside")


    obj["source"] = source
    obj["destination"]=destination
    obj["date"]= date



    console.log(obj)
   





    const today = new Date();
    const yyyy = today.getFullYear();
    let mm = today.getMonth() + 1; 
    let dd = today.getDate();

    if (dd < 10) dd = '0' + dd;
    if (mm < 10) mm = '0' + mm;

    const formattedToday = yyyy + '-' + mm + '-' + dd;


    if(date<formattedToday){
        alert("Past dates  are not allowed")
        window.location.reload()
    }
 



    getAllBus()

    

}

async function getAllBus(){
    try{

        let res = await fetch("http://localhost:8818/viewallbus",{
            method:"GET",
            // body:JSON.stringify(obj),
            headers:{
                "Content-Type":"application/json"
            }
            // body:JSON.stringify(obj)
        })
        console.log(res)
        if(res.ok){
            console.log("sucesss")
            let data = await res.json();

            // To get data from response   // user data
            // let userData=JSON.stringify(data)
            let d=JSON.stringify(data)
                

            console.log(data)
 

           appendData(data)
            console.log("hello from async")


        }else{
            
                alert("Username or Password is Incorrect!")


        }

    }catch(error){
        return "Not sucessful"

    }


}




    function appendData(data){


        data.map(function(elem){
            console.log("------")
            console.log(elem)
            console.log("------")
    
            let parentDiv=document.createElement("div")
            parentDiv.setAttribute("id","bus-div")
    
           
            
    
    
            let bid=document.createElement("p")
            bid.innerText=elem.busId
    
             let bname=document.createElement("p")
             bname.innerText=elem.busName
    
             let atime=document.createElement("p")
             atime.innerText=elem.arrivalTime
    
             let dtime=document.createElement("p")
             dtime.innerText=elem.departureTime
    
             let btype=document.createElement("p")
             btype.innerText=elem.busType
    
    
             let driverName=document.createElement("p")
             driverName.innerText=elem.driverName
    
    
    
             let seats=document.createElement("p")
             seats.innerText=elem.availableSeats
    
    
            let btn=document.createElement("button")
            btn.innerText="Book"
            btn.setAttribute("id","bookbtn")
    
            btn.addEventListener("click",function(){
                bookTicket(elem,userData);
            })
    
    
    
            parentDiv.append(bid,bname,btype,atime,dtime,driverName,seats,btn)   
            let b= document.querySelector("#buslist")
            b.append(parentDiv)
            console.log("hello")
            document.getElementById("details-heading").style.display="flex";
        })

       
    }


async function bookTicket(elem,userData){
    console.log("Inside book ticket function")

    let seatQuantity=prompt("Please enter how many seats you want: ");

    console.log(seatQuantity);

    console.log(elem)
    console.log(userData)
    console.log(obj)



    let reservationObj={}

    reservationObj["source"]=obj.source;
    reservationObj["destination"]=obj.destination;
    reservationObj["seatQuantity"]=seatQuantity;
    reservationObj["travelDate"]=obj.date;
    reservationObj["reservationType"]=elem.busType;

    console.log(reservationObj)


    try{

        let res = await fetch(`http://localhost:8818/reservationservice/seatReservation/${elem.busId}/${userData.userLoginId}`,{
            method:"POST",
            body:JSON.stringify(reservationObj),
            headers:{
                "Content-Type":"application/json"
            }
            // body:JSON.stringify(obj)
        })
        console.log(res)
        if(res.ok){
            console.log("sucesss")
            let data = await res.json();

            // To get data from response   // admin data
            // let userData=JSON.stringify(data)


            console.log(data)


            // save user data to session storage
            sessionStorage.setItem("adminDataStorage",JSON.stringify(data))


            // Write code here to send user data and user to Admin dashboard
            alert("Login Succesfull. Redirecting  to Admin dashboard.")

            

        }else{


            let data = await res.json();
            let error=JSON.stringify(data)

            let msg =JSON.parse(error);
            // alert(msg["details"])
            console.log(msg)



            
                alert("Username or Password is Incorrect!")


        }

    }catch(error){
        return "Not sucessful"

    }





}




document.getElementById("logout").addEventListener("click",logoutUser)


function logoutUser(){

   event.preventDefault();

    localStorage.removeItem("userDataStorage")


    alert("You are Logged Out.")

    window.location.href="/index.html"



}