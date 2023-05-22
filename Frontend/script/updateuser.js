


document.querySelector("form").addEventListener("submit",userUpdate)



 function userUpdate(event){

    event.preventDefault();


    let uname =document.getElementById("uname").value

    let pass = document.getElementById("password").value

    let fname = document.getElementById("fname").value

    let lname = document.getElementById("lname").value

    let phone = document.getElementById("phone").value

    let email = document.getElementById("email").value





    let obj={};
    obj["userName"] = uname
    obj["password"]=pass
    obj["firstName"]= fname
    obj["lastName"]=lname
    obj["contact"]=phone
    obj["email"]=email


    console.log(obj)


    userUpdateFun(obj)

}

async function userUpdateFun(obj){

    let jwtToken = JSON.parse(localStorage.getItem("JWTTOKEN"));

    try{

        let res = await fetch("http://localhost:8818/updateUser",{
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


            console.log("updated")
            console.log(data)


            // Write code here to send user data and user to user dashboard
            alert(`Your profile is updated ${data.firstName}.`)

            
             window.location.href="/pages/customerdashboard.html"

        }else{
            
                let data = await res.json();
                let error=JSON.stringify(data)

                let msg =JSON.parse(error);
                alert(msg["message"])

        }

    }catch(error){
        return "Not sucessful"

    }


}



document.getElementById("logout").addEventListener("click",logoutUser)


function logoutUser(){

   event.preventDefault();



    alert("You are Logged Out.")

    window.location.href="/index.html"



}


