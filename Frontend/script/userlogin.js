

document.querySelector("form").addEventListener("submit",checkUser)



 function checkUser(event){

    event.preventDefault();

    let uname=document.getElementById("uname")

    let name =uname.value

    let password = document.getElementById("password")

    let pass= password.value

    // console.log(name,pass)

    let obj={};
    obj["name"] =name;
    obj["password"] =pass;

    login(obj)

}


async function login(obj){
    try{

        let res = await fetch("http://localhost:8818/userlogin",{
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

            // To get data from response   // user data
            // let userData=JSON.stringify(data)


            console.log(data)


            // save user data to session storage
            localStorage.setItem("userDataStorage",JSON.stringify(data))


            // Write code here to send user data and user to user dashboard
            alert("Login Succesfull. Redirecting  to customer dashboard.")

            window.location.href="/pages/customerdashboard.html"

        }else{
            
                alert("Username or Password is Incorrect!")


        }

    }catch(error){
        return "Not sucessful"

    }


}



// checkUser()
