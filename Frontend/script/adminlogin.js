document.querySelector("form").addEventListener("submit",checkAdmin)



 function checkAdmin(event){

    event.preventDefault();

    let uname=document.getElementById("uname")

    let name =uname.value

    let password = document.getElementById("password")

    let pass= password.value

    // console.log(name,pass)

    let obj={};
    obj["name"] =name;
    obj["password"] =pass;

    console.log(obj)
    
    login(obj)

}


async function login(obj){
    try{

        let res = await fetch("http://localhost:8818/adminlogin",{
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


            // save user data to session storage
            sessionStorage.setItem("adminDataStorage",JSON.stringify(data))


            // Write code here to send user data and user to Admin dashboard
            alert("Login Succesfull. Redirecting  to Admin dashboard.")



        }else{
            
                alert("Username or Password is Incorrect!")


        }

    }catch(error){
        return "Not sucessful"

    }


}