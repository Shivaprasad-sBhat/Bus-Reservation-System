
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
    // busdetails
    console.log(userData)
    //userdata
    console.log(obj)
    //user input



    let reservationObj={}

    reservationObj["source"]=obj.source;
    reservationObj["destination"]=obj.destination;
    reservationObj["travelDate"]=obj.date;
    reservationObj["seatQuantity"]=seatQuantity;
    reservationObj["reservationType"] = elem.busType;


        try{
            let res = await fetch(`http://localhost:8818/seatReservation/${elem.busId}/${userData.userLoginId}`,{
                method:"POST",
                body:JSON.stringify(reservationObj),
                headers:{
                    "Content-Type":"application/json"
                }
                // body:JSON.stringify(obj)
            })
            
            if(res.ok){
                console.log("sucesss")
                let data = await res.json();
                // To get data from response   // admin data
                // let userData=JSON.stringify(data)
                console.log(data)
                // Write code here to send user data and user to user dashboard
                alert(`Reservation Success`);


                //printing reservation page 

                // window.location.href="."

                
                window.location.href="./reservation.html"
                 
                localStorage.setItem("reservation",JSON.stringify(data))


                console.log("end");

            }else{
                    let data = await res.json();
                    let error=JSON.stringify(data)
                    let msg =JSON.parse(error);
                    alert(msg.message)
            }
        }catch(error){
            console.log(error)
            alert(error)
            return "Not sucessful"
        }
     

  
}



//printing reservation page 
function reservation(data , userData){

    


  
//    let p1 = document.createElement("p");
//    p1.innerText = "kl";
//     document.querySelector(".reser").innerHTML="k";

//    x.innerHTML = p1 ;
//    let p2 = document.createElement("p");
//    p2.innerText = userData.lastName;

//    let p3 = document.createElement("p");
//    p3.innerText = userData.email;

//    let p4 = document.createElement("p");
//    p4.innerText = data.reservationId;

//    let p5 = document.createElement("p");
//    p5.innerText = data.destination;

//    let p6 = document.createElement("p");
//    p6.innerText = data.source;

//    let p7 = document.createElement("p");
//    p7.innerText = data.reservationType;
   

//    let p8 = document.createElement("p");
//    p8.innerText = data.reservationStatus;

//    let p9 = document.createElement("p");
//    p9.innerText = data.seatQuantity;

//   x.append(p1);
  
console.log(data , userData);
//   console.log(x);

}








document.getElementById("logout").addEventListener("click",logoutUser)


function logoutUser(){

   event.preventDefault();

    localStorage.removeItem("userDataStorage")


    alert("You are Logged Out.")

    window.location.href="/index.html"



}