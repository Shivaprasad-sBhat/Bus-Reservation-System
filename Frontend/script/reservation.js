

let resdata = JSON.parse(localStorage.getItem("reservation"));


reservation(resdata );
//printing reservation page 
async function reservation(data ){

   let userData;

    let jwtToken = JSON.parse(localStorage.getItem("JWTTOKEN"));

    try{
      let res = await fetch(`http://localhost:8818/getCurrentUser`,{
          method:"GET",
          headers:{
              "Content-Type":"application/json",
              "Authorization":`Bearer ${jwtToken}`
          }
          // body:JSON.stringify(obj)
      })
      
      if(res.ok){
          console.log("sucesss")
          
          userData= await res.json();
          // To get data from response   // admin data
          // let userData=JSON.stringify(data)
         
          // Write code here to send user data and user to user dashboard
          

          //printing reservation page 

          // window.location.href="."

   

      }else{
              let data = await res.json();
              let error=JSON.stringify(data)
              let msg =JSON.parse(error);
              alert("No User found .. !")
      }
  }catch(error){
      alert(error)
      return "Not sucessful"
  }

   let x = document.querySelector(".reser");
  
   let p1 = document.createElement("p");
   p1.innerText = `FirstName :  ${userData.firstName}`;

   
   let p2 = document.createElement("p");
   p2.innerText = `LastName :  ${userData.lastName}`;

   let p3 = document.createElement("p");
   p3.innerText = `Email :  ${userData.email}`;

   let p4 = document.createElement("p");
   p4.innerText = `ReservationId :  ${data.reservationId}`;

   let p5 = document.createElement("p");
   p5.innerText = `Destination :  ${data.destination}`;

   let p6 = document.createElement("p");
   p6.innerText = `Source :  ${data.source}`;

   let p7 = document.createElement("p");
   p7.innerText = `ReservationType :  ${data.reservationType}`;
   

   let p8 = document.createElement("p");
   p8.innerText = `ReservationStatus :  ${data.reservationStatus}`;

   let p9 = document.createElement("p");
   p9.innerText = `SeatBooked :  ${data.seatQuantity}`;

  x.append(p1 , p2 ,p3 , p4 , p5 ,p6 ,p7 ,p8 ,p9);
  

//   console.log(x);

}

document.getElementById("logout").addEventListener("click",logoutUser)


function logoutUser(){

   event.preventDefault();



    alert("You are Logged Out.")

    window.location.href="/index.html"



}