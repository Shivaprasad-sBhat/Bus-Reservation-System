
let userData= JSON.parse(localStorage.getItem("userDataStorage"))
console.log(userData)


document.getElementById("routeForm").addEventListener("submit",findBuses)



function findBuses(event){

    event.preventDefault();


    let source =document.getElementById("source").value

    let destination = document.getElementById("destination").value

    let date = document.getElementById("date").value

    console.log("inside")

    let obj={};

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
            // bid.innerText=elem.busId
    
             let bname=document.createElement("p")
            //  bname.innerText=elem.busName
    
             let atime=document.createElement("p")
            //  atime.innerText=elem.arrivalTime
    
             let dtime=document.createElement("p")
            //  dtime.innerText=elem.departureTime
    
             let btype=document.createElement("p")
            //  btype.innerText=elem.busType
    
    
             let driverName=document.createElement("p")
            //  driverName.innerText=elem.driverName
    
    
    
             let seats=document.createElement("p")
            //  seats.innerText=elem.availableSeats
    
    
            let btn=document.createElement("button")
            // btn.innerText="Book"
            // btn.setAttribute("id","bookSeat")
    
            btn.addEventListener("click",function(){
                bookTicket(elem,userData);
            })
    
    
    
            parentDiv.append(bid,bname,btype,arrivalTime,dtime,driverName,seats)   
            let b= document.querySelector("#buslist")
            b.append(bid)
            console.log("hello")
        })

       
    }


function bookTicket(elem,userData){
    console.log("Inside book ticket function")
}




document.getElementById("logout").addEventListener("click",logoutUser)


function logoutUser(){

   event.preventDefault();

    localStorage.removeItem("userDataStorage")


    alert("You are Logged Out.")

    window.location.href="/index.html"



}