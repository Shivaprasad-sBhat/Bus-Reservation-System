
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
 



    getAllBus(obj)

    

}

async function getAllBus(obj){

    let jwtToken = JSON.parse(localStorage.getItem("JWTTOKEN"));

    try{
            //new api
        let res = await fetch(`http://localhost:8818/viewBusByRoute/${obj.source}/${obj.destination}/${obj.date}`,{
            method:"GET",
            // body:JSON.stringify(obj),
            headers:{
                "Content-Type":"application/json",
                "Authorization":`Bearer ${jwtToken}`
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
            
                alert("Bus not found!")


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
                bookTicket(elem);
            })
    
    
    
            parentDiv.append(bid,bname,btype,atime,dtime,driverName,seats,btn)   
            let b= document.querySelector("#buslist")
            b.append(parentDiv)
            console.log("hello")
            document.getElementById("details-heading").style.display="flex";
        })

       
    }


async function bookTicket(elem){
    console.log("Inside book ticket function")

    let seatQuantity=prompt("Please enter how many seats you want: ");

    console.log(seatQuantity);

    console.log(elem) 
    // busdetails
    //userdata
    console.log(obj)
    //user input



    let reservationObj={}
    
        reservationObj["travelDate"]=obj.date;
        reservationObj["seatQuantity"]=seatQuantity;
        reservationObj["reservationType"] = elem.busType;

        let jwtToken = JSON.parse(localStorage.getItem("JWTTOKEN"));


        try{
            console.log(elem.busId)
            let res = await fetch(`http://localhost:8818/seatReservation/${elem.busId}`,{
                method:"POST",
                body:JSON.stringify(reservationObj),
                headers:{
                    "Content-Type":"application/json",
                    "Authorization":`Bearer ${jwtToken}`
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












document.getElementById("logout").addEventListener("click",logoutUser)


function logoutUser(){

   event.preventDefault();



    alert("You are Logged Out.")

    window.location.href="/index.html"



}