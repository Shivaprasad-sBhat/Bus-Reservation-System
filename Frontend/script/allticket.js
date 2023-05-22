

allTicket();

async function allTicket(){

    let jwtToken = JSON.parse(localStorage.getItem("JWTTOKEN"));


    try{
        let res = await fetch(`http://localhost:8818/viewAllReservations`,{
            method:"GET",
            headers:{
                "Content-Type":"application/json",
                "Authorization":`Bearer ${jwtToken}`
            }
           
        })
        
        if(res.ok){
            console.log("sucesss")
            let data = await res.json();
            // To get data from response   // admin data
            // let userData=JSON.stringify(data)
           
            // Write code here to send user data and user to user dashboard
            
           appendData(data);

            //printing reservation page 

            // window.location.href="."

            
            

            

        }else{
                let data = await res.json();
                let error=JSON.stringify(data)
                let msg =JSON.parse(error);
                alert("No reservation found .. !")
        }
    }catch(error){
        alert(error)
        return "Not sucessful"
    }

}


function appendData(data){

    let tbody = document.getElementById("tbody");

   data.map(function(el){
  
    let tr = document.createElement("tr");

    let td1 = document.createElement("td");
    td1.innerText = el.reservationId;

    let td2 = document.createElement("td");
    td2.innerText = el.reservationType;

    let td3 = document.createElement("td");
    td3.innerText = el.travelDate;

    let td4 = document.createElement("td");
    td4.innerText = el.source;

    let td5 = document.createElement("td");
    td5.innerText = el.destination;

    let td6 = document.createElement("td");
    td6.innerText = el.seatQuantity;


    let td7 = document.createElement("td");
    td7.innerText = el.reservationStatus;
    if(el.reservationStatus =="Reservation cancelled"){
        td7.style.color="red";
    }
    else{

        td7.style.color="green";
    }

    let td8 = document.createElement("td");
    td8.innerText = el.reservationDateAndTime;


    let feedback = document.createElement("td");
    feedback.innerText = "FEEDBACK";
    feedback.setAttribute("id","fb");
    feedback.addEventListener("click" , function(){

        if(el.reservationStatus == "Reservation cancelled"){

            alert("Can't Give the feedback, reservation cancelled")

            return;   
        }

        let blue = JSON.parse(localStorage.getItem("blue"));

        let flag = false;

        if(blue !=null){

          for(let i in blue){

              if(blue[i] == el.reservationId ) flag = true;

          }

        }

        if(flag){
              
            // localStorage.setItem("reservationfeedback",JSON.stringify(el));


            // window.location.href="./updatefeedback.html"

          alert("You alredy Gave the Feedback");
             
        }
        else{

            
            localStorage.setItem("reservationfeedback",JSON.stringify(el));

            window.location.href="./feedback.html"
        }
    })


    


    // let blue = JSON.parse(localStorage.getItem("blue"));

    //     let flag = false;

    //     if(blue !=null){

    //       for(let i in blue){

    //           if(blue[i] == el.reservationId ) flag = true;

    //       }

    //     }

    //     if(flag){
       
    //         feedback.style.backgroundColor="blue";
    //         feedback.style.color = "white";

    //     }




    let td9 = document.createElement("td");
    td9.innerText = "CANCELTICKET";
    td9.style.color="red";
    td9.setAttribute("id","cancel")
    td9.addEventListener("click",function(){

        removes(el);

    })

    tr.append(td1 ,td2 , td3 , td4 , td5 , td6 , td7 , td8 ,feedback ,  td9);

    tbody.append(tr);
    

   })

}


// remove the ticket
async function removes(data){
    
    let jwtToken = JSON.parse(localStorage.getItem("JWTTOKEN"));


    try{
        let res = await fetch(`http://localhost:8818/deleteReservations/${data.reservationId}`,{
            method:"DELETE",
            headers:{
                "Content-Type":"application/json",
                "Authorization":`Bearer ${jwtToken}`
            }
           
        })
        
        if(res.ok){
            console.log("sucesss")
            let data = await res.json();
            // To get data from response   // admin data
            // let userData=JSON.stringify(data)
           
            // Write code here to send user data and user to user dashboard
            

            //printing reservation page 

            // window.location.href="."

            
            
          window.location.reload();
            

        }else{
                let data = await res.json();
                let error=JSON.stringify(data)
                let msg =JSON.parse(error);
                alert("No reservation found .. !")
        }
    }catch(error){
        alert(error)
        return "Not sucessful"
    }

    
}

document.getElementById("logout").addEventListener("click",logoutUser)


function logoutUser(){

   event.preventDefault();



    alert("You are Logged Out.")

    window.location.href="/index.html"



}
