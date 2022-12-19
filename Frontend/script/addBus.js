document.querySelector("form").addEventListener("submit",createRoute)



 function createRoute(){

    event.preventDefault();


    let busName =document.getElementById("busName").value

    let driverName = document.getElementById("driverName").value

    let busType = document.getElementById("busType").value

    let arrivalTime = document.getElementById("arrivalTime").value

    let departureTime = document.getElementById("departureTime").value

    let seats = document.getElementById("seats").value

    let routes = document.getElementById("routes").value

    let obj={};

    obj["busName"] = busName
    obj["driverName"]=driverName
    obj["busType"]= busType
    obj["arrivalTime"]= arrivalTime
    obj["departureTime"]= departureTime
    obj["seats"]= seats
    obj["routes"]= routes
    console.log(obj)

    // login(obj)

    addRouteFun(obj)

}

async function addRouteFun(obj){
    try{

        let res = await fetch("http://localhost:8818/addRoute",{
            method:"POST",
            body:JSON.stringify(obj),
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


            // Write code here to send user data and user to user dashboard
            alert(`New route created.`)
            
               

        }else{
            
                let data = await res.json();
                let error=JSON.stringify(data)
              
                let msg =JSON.parse(error);
          

                alert(msg.message)

        }

    }catch(error){
        alert("Failed..")
        return "Not sucessful"

    }


}
