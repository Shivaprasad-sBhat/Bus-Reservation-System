document.getElementById("delete-routes").addEventListener("click", getRoutes)



function getRoutes(event) {

    event.preventDefault();

    document.getElementById("tbody").innerHTML = null;
    getAllRoutes()
}


async function getAllRoutes() {

    let jwtToken = JSON.parse(localStorage.getItem("JWTTOKEN"));

    try {

        let res = await fetch("http://localhost:8818/viewAllRoute", {
            method: "GET",
            headers: {
                "Content-Type": "application/json",
                "Authorization":`Bearer ${jwtToken}`
            }
           
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
let routeId = document.createElement("td");
routeId.innerText=el.routeId

let routeFrom = document.createElement("td");
routeFrom.innerText = el.routeFrom

let routeTo = document.createElement("td");
routeTo.innerText = el.routeTo

let distance1 = document.createElement("td");
distance1.innerText = el.distance
 
let delete1 = document.createElement("td");
delete1.innerText = "Delete"
delete1.setAttribute("id","updateBtn")
delete1.addEventListener("click",function(){
   
    deleteRoute(el);
    
})


tr.append(routeId, routeFrom, routeTo,distance1,delete1);

document.querySelector("#tbody").append(tr);
});
}



async function deleteRoute(obj){

    let jwtToken = JSON.parse(localStorage.getItem("JWTTOKEN"));

    try{

        let res = await fetch(`http://localhost:8818/deleteRoute/${obj.routeId}`,{
            method:"DELETE",
            headers:{
                "Content-Type":"application/json",
                "Authorization":`Bearer ${jwtToken}`
            }
        
        })
        console.log(res)
        if(res.ok){
            console.log("sucesss")
            let data = await res.json();

            // To get data from response   // admin data
            // let userData=JSON.stringify(data)


            console.log(data)


            // Write code here to send user data and user to user dashboard
            alert(`Route deleted.`)
           
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
