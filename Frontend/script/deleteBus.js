document.getElementById("delete-bus").addEventListener("click", deleteBus)



function deleteBus(event) {

    event.preventDefault();

    document.getElementById("tbody").innerHTML = null;
    deleteBuses()
}


async function deleteBuses() {

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
    
let delete1 = document.createElement("td");
delete1.innerText = "Delete"
delete1.setAttribute("id","updateBtn")
delete1.addEventListener("click",function(){
   
    deleteBusFun(el);
    
})

tr.append(busId, busName, driverName,busType,departureTime,arrivalTime,date , seats,avilableSeats,delete1);

document.querySelector("#tbody").append(tr);
});
}


async function deleteBusFun(obj){

    let jwtToken = JSON.parse(localStorage.getItem("JWTTOKEN"));

    try{
        console.log(obj.busId)
        let res = await fetch(`http://localhost:8818/deletebus/${obj.busId}`,{
            method:"DELETE",
            
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
            alert(`Bus deleted.`)
           
          window.location.reload();
          

        }else{
            
                let data = await res.json();
                let error=JSON.stringify(data)
                console.log(data)
                let msg =JSON.parse(error);
                alert(msg.message)

        }

    }catch(error){
        console.log(error)
        return "Not sucessful"

    }


}
