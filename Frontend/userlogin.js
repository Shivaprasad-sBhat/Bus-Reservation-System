// async function dummy(){

//     let res =   await fetch("http://localhost:8818/createUser")

//     let data = await res.json();

//    console.log (data);

//    console.log(arr);
//   }

//   // dummy();

// let data = {

//       "userName": "jajja",
//       "password": "sssss",
//       "firstName": "sam",
//       "lastName": "samuel",
//       "contact": 0,
//       "email": "raku@gmail.com"
   
// }



// postData( 'http://localhost:8818/createUser', data)



// async function getUser(){

//     let res =   await fetch("http://localhost:8818/userlogin")

//     let data = await res.json();

//    console.log (data);

//    console.log(arr);
//   }




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
            headers:{
                "Content-Type":"application/json"
            },
            body:JSON.stringify(obj)
        })
        console.log(res)
        if(res.ok){
            console.log("sucesss")
            let data = await res.json();
            console.log(JSON.stringify(data))

        }else{
            console.log("not found")
        }

    }catch(error){
        return "Not sucessful"

    }


}



checkUser()
