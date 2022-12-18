
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
 



// getAllBus()



}

// async function getAllBus(){
//     try{

//         let res = await fetch("http://localhost:8818/viewallbus",{
//             method:"GET",
//             // body:JSON.stringify(obj),
//             headers:{
//                 "Content-Type":"application/json"
//             }
//             // body:JSON.stringify(obj)
//         })
//         console.log(res)
//         if(res.ok){
//             console.log("sucesss")
//             let data = await res.json();

//             // To get data from response   // user data
//             // let userData=JSON.stringify(data)


//             console.log(data)


//             // save user data to session storage
//             localStorage.setItem("userDataStorage",JSON.stringify(data))


//             // Write code here to send user data and user to user dashboard
//             alert("Login Succesfull. Redirecting  to customer dashboard.")

//             window.location.href="/pages/customerdashboard.html"

//         }else{
            
//                 alert("Username or Password is Incorrect!")


//         }

//     }catch(error){
//         return "Not sucessful"

//     }


// }


document.getElementById("logout").addEventListener("click",logoutUser)


function logoutUser(){

   event.preventDefault();

    localStorage.removeItem("userDataStorage")


    alert("You are Logged Out.")

    window.location.href="/index.html"



}