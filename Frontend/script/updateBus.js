document.getElementById("update-Bus").addEventListener("click", getBuses)



function getBuses(event) {

    event.preventDefault();

    document.getElementById("tbody").innerHTML = null;
    getAllBuses()
}


async function getAllBuses() {

    let jwtToken = JSON.parse(localStorage.getItem("JWTTOKEN"));

    try {

        let res = await fetch("http://localhost:8818/viewallbus", {
            method: "GET",
            headers: {
                "Content-Type": "application/json",
                "Authorization":`Bearer ${jwtToken}`
            }
            // body:JSON.stringify(obj)
        })
        console.log(res)
        if (res.ok) {
            console.log("sucesss")
            let data = await res.json();

            // To get data from response   // user data
            // let userData=JSON.stringify(data)
            let d = JSON.stringify(data)


            console.log(d)


            appendData(data)



        } else {

            let data = await res.json();
            let error = JSON.stringify(data)

            let msg = JSON.parse(error);

            console.log(msg)
            alert(msg.message)
        }

    } catch (error) {
        console.log(error)
        alert("Connection failed")
       

    }


}




function appendData(data) {
data.map(function (el) {
let tr = document.createElement("tr");

let busId = document.createElement("td");
busId.innerText=el.busId

let busName = document.createElement("td");
busName.innerText=el.busName

let driverName = document.createElement("td");
driverName.innerText = el.driverName

let busType = document.createElement("td");
busType.innerText = el.busType

let departureTime = document.createElement("td");
departureTime.innerText = el.departureTime

let arrivalTime = document.createElement("td");
arrivalTime.innerText = el.arrivalTime

let date = document.createElement("td");
date.innerText = el.date

let seats = document.createElement("td");
seats.innerText = el.seats

let avilableSeats = document.createElement("td");
avilableSeats.innerText = el.availableSeats
    
let update = document.createElement("td");
update.innerText = "Update"
update.setAttribute("id","updateBtn")
update.addEventListener("click",function(){
   
    updateBusFun(el);
    
})

tr.append(busId, busName, driverName,busType,departureTime,arrivalTime,date , seats,avilableSeats,update);

document.querySelector("#tbody").append(tr);
});
}

async function updateBusFun(ele){
    
    
    localStorage.setItem("BusDetailsLS",JSON.stringify(ele))

    window.location.href="./updateBusDetails.html"
}


document.querySelector("#updateBusDetails").addEventListener("click",updateBusDetails1)




function updateBusDetails1(event){

    event.preventDefault();
    let busData= JSON.parse(localStorage.getItem("BusDetailsLS"))

    let busId = busData["busId"]

    let busName =document.getElementById("busName2").value

    let driverName = document.getElementById("driverName2").value

    let busType = document.getElementById("busType2").value

    let arrivalTime = document.getElementById("arrivalTime2").value

    let departureTime = document.getElementById("departureTime2").value

    let seats1 = document.getElementById("seats2").value

    let avilableSeats = document.getElementById("avilableSeats2").value

    let date = document.getElementById("date").value;
   

    let obj={};

    obj["busId"] = busId
    obj["busName"] = busName
    obj["busName"] = busName
    obj["driverName"]=driverName
    obj["busType"]= busType
    obj["arrivalTime"]= arrivalTime
    obj["departureTime"]= departureTime
    obj["seats"]= seats1
    obj["availableSeats"]= avilableSeats
    obj["date"] = date;
   
    console.log(obj)

    // login(obj)

    updateBus1(obj)
}

async function updateBus1(obj){

    let jwtToken = JSON.parse(localStorage.getItem("JWTTOKEN"));

    try{

        let routeID = document.getElementById("routeID12").value
     
        let res = await fetch(`http://localhost:8818/updatebus/${routeID}`,{
            method:"PUT",
            body:JSON.stringify(obj),
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

            // To get data from response   // admin data
            // let userData=JSON.stringify(data)


            console.log(data)


            // Write code here to send user data and user to user dashboard
            alert(`Bus details updated.`)
            
               
        }else{
            
                let data = await res.json();
                let error=JSON.stringify(data)
                console.log(data)
                let msg =JSON.parse(error);
                alert(msg.message)
                console.log(msg.message)

        }

    }catch(error){
        console.log(error)
        return "Not sucessful"

    }

}