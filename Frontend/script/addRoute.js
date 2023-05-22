document.querySelector("form").addEventListener("submit",createRoute)



 function createRoute(){

    event.preventDefault();


    let source2 =document.getElementById("source_1").value

    let destnation2 = document.getElementById("destnation_1").value

    let distance2 = document.getElementById("distance_1").value

    



    let obj={};

    obj["routeFrom"] = source2
    obj["routeTo"]=destnation2
    obj["distance"]= distance2

   


    console.log("hello")

    // login(obj)

    addRouteFun(obj)

}

async function addRouteFun(obj){

    let jwtToken = JSON.parse(localStorage.getItem("JWTTOKEN"));

    try{

        let res = await fetch("http://localhost:8818/addRoute",{
            method:"POST",
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


            console.log(data)


            // Write code here to send user data and user to user dashboard
            alert(`New route created.`)
            
               

        }else{
            
                let data = await res.json();
                let error=JSON.stringify(data)
              
                let msg =JSON.parse(error);
          

                alert(msg.message)

        }

    }catch(error){
        alert("Failed..")
        return "Not sucessful"

    }


}
