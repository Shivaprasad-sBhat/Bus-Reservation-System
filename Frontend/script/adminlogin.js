document.querySelector("form").addEventListener("submit",checkAdmin)



 function checkAdmin(event){

    event.preventDefault();

    let uname=document.getElementById("uname")

    let userName =uname.value

    let pass = document.getElementById("password")

    let password= pass.value

    // console.log(name,pass)


    
    login(userName , password)

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
            
        })
        console.log(res)
        if(res.ok){

            
            
            console.log("ok");


            let data = await res.json();

            if(data.role != "ROLE_ADMIN") {
                
                alert("User Can't access Admin DashBoard");

                return;
            }

            let jwtToken = res.headers.get("Authorization");


            localStorage.setItem("JWTTOKEN" , JSON.stringify(jwtToken));

            // Write code here to send user data and user to Admin dashboard
            alert("Login Succesfull. Redirecting  to Admin dashboard.")

            window.location.href="/pages/admin/admindashboard.html"
            

        }else{
            
                alert("Username or Password is Incorrect!")


        }

    }catch(error){

        alert(error);
    }


}