document.getElementById("update-routes").addEventListener("click", getRoutes)



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
 
let update = document.createElement("td");

update.innerText = "Update"

update.setAttribute("id","updateBtn")

update.addEventListener("click",function(){

    console.log("inside addRoute ")
    updateRoute1(el);
    
})


tr.append(routeId, routeFrom, routeTo,distance1,update);

document.querySelector("#tbody").append(tr);
});
}




async function updateRoute1(ele){
    
    
    localStorage.setItem("updateRoute",JSON.stringify(ele))

    window.location.href="./updateRoute.html"
}






document.querySelector("#updateRoutebtn").addEventListener("click",updateRoute)



 function updateRoute(event){

    event.preventDefault();
    let userData= JSON.parse(localStorage.getItem("updateRoute"))

    let routeId = userData.routeId
    let source2 =document.getElementById("source_2").value

    let destnation2 = document.getElementById("destnation_2").value

    let distance2 = document.getElementById("distance_2").value





    let obj={};
    obj["routeId"] = routeId
    obj["routeFrom"] = source2
    obj["routeTo"]=destnation2
    obj["distance"]= distance2

   


    console.log(obj)

    // login(obj)

    upRouteFun(obj)

}

async function upRouteFun(obj){

    let jwtToken = JSON.parse(localStorage.getItem("JWTTOKEN"));

    try{

        let res = await fetch("http://localhost:8818/updateRoute",{
            method:"PUT",
            body:JSON.stringify(obj),
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
            alert(`Route updated.`)
            
               
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
