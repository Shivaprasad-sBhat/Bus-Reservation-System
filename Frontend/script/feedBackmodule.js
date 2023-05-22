
allTicket();

async function allTicket(){

    let jwtToken = JSON.parse(localStorage.getItem("JWTTOKEN"))

    try{
        let res = await fetch(`http://localhost:8818/getAllFeedbacks`,{
            method:"GET",
            headers:{
                "Content-Type":"application/json",
                "Authorization":`Bearer ${jwtToken}`
            }
            // body:JSON.stringify(obj)
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
                alert("No FeedBack found .. !")
        }
    }catch(error){
        alert(error)
        return "Not sucessful"
    }

}



function appendData(data){

      console.log(data)
    let tbody = document.getElementById("tbody");

   data.map(function(el){
  
    let tr = document.createElement("tr");

    let td1 = document.createElement("td");
    td1.innerText = el.customer.firstName;

    let td2 = document.createElement("td");
    td2.innerText = el.feedBackId;

    let td3 = document.createElement("td");
    td3.innerText = el.driverRating;

    let td4 = document.createElement("td");
    td4.innerText = el.serviceRating;

    let td5 = document.createElement("td");
    td5.innerText = el.overallRating;

    let td6 = document.createElement("td");
    td6.innerText = el.comments;

    let td7 = document.createElement("td");
    td7.innerText = el.feedBackDate;

    let td8 = document.createElement("td");
    td8.innerText = el.reserc.reservationId;

    tr.append(td1 , td2 , td3 , td4, td5, td6 , td7 , td8 );

    tbody.append(tr);


   })

}


