document.querySelector("form").addEventListener("submit",userSignup)



 function userSignup(event){

    event.preventDefault();


    let uname =document.getElementById("uname").value

    let pass = document.getElementById("password").value

    let fname = document.getElementById("fname").value

    let lname = document.getElementById("lname").value

    let phone = document.getElementById("phone").value

    let email = document.getElementById("email").value





    let obj={};

    obj["name"] = uname
    obj["password"]=pass
    obj["firstName"]= fname
    obj["lastName"]=lname
    obj["contact"]=phone
    obj["email"]=email


    console.log(obj)

    // login(obj)

    userSignUpFun(obj)

}

async function userSignUpFun(obj){
    try{

        let res = await fetch("http://localhost:8818/createUser",{
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
            alert(`Welcome to Masai Bus ${data.firstName}. Redirecting to Login page.`)
            
                window.location.href="/pages/userlogin.html"

        }else{
            
                let data = await res.json();
                let error=JSON.stringify(data)

                let msg =JSON.parse(error);

                alert(msg["message"])

        }

    }catch(error){
        
        console.log(error);
    }


}
