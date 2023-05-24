document.querySelector("#addBusBtn").addEventListener("click",createBus)



 function createBus(){

    event.preventDefault();


    let busName =document.getElementById("busName1").value

    let driverName = document.getElementById("driverName1").value

    let busType = document.getElementById("busType1").value

    let arrivalTime = document.getElementById("arrivalTime1").value

    let departureTime = document.getElementById("departureTime1").value

    let seats1 = document.getElementById("seats1").value
    let avilableSeats = document.getElementById("avilableSeats1").value

    let date = document.getElementById("date").value;
 

    let obj={};

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

    addBusFun(obj)

}

async function addBusFun(obj){

    let jwtToken =JSON.parse(localStorage.getItem("JWTTOKEN"));

    try{

    let routeid = document.getElementById("routesid1").value
    console.log(routeid)
        let res = await fetch(`http://localhost:8818/savebus/${routeid}`,{
            method:"POST",
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
            alert(`New bus added.`)
            
               

        }else{
            
                let data = await res.json();
                let error=JSON.stringify(data)
              
                let msg =JSON.parse(error);
          
                console.log(msg)
                alert(msg.message)

        }

    }catch(error){
        console.log(error)
        alert("Failed..")
        return "Not sucessful"

    }


}
