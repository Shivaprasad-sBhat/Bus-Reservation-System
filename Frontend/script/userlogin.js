

document.querySelector("form").addEventListener("submit",checkUser)



 function checkUser(event){

    event.preventDefault();

    let uname=document.getElementById("uname")

    let userName =uname.value

    let pass = document.getElementById("password")

    let password= pass.value

    // console.log(name,pass)

   

    login(userName , password);

}


async function login(userName , password){


    let auth = btoa(`${userName}:${password}`);

    try{

        let res = await fetch("http://localhost:8818/signIn",{
            method:"GET",
            headers:{
                "Content-Type":"application/json",
                "Authorization":`Basic ${auth}`
            }
            // body:JSON.stringify(obj)
        })
        console.log(res)

        if(res.ok){
            console.log("sucesss")
            

            let data = await res.json();

            if(data.role != "ROLE_CUSTOMER") {

                alert("Admin can't access User DashBoard");

                return;
            }

            let jwtToken = res.headers.get("Authorization");


            // save user data to session storage
            localStorage.setItem("JWTTOKEN",JSON.stringify(jwtToken))


            // Write code here to send user data and user to user dashboard
            alert("Login Succesfull. Redirecting  to customer dashboard.")

            window.location.href="/pages/customerdashboard.html"

        }else{
            
                alert("Username or Password is Incorrect!")


        }

    }catch(error){

        alert(error);

    }


}



// checkUser()
