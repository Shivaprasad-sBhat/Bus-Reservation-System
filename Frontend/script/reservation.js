

let resdata = JSON.parse(localStorage.getItem("reservation"));

let userdata = JSON.parse(localStorage.getItem("userDataStorage"));

reservation(resdata , userdata);
//printing reservation page 
function reservation(data , userData){

    


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
  
console.log(data , userData);
//   console.log(x);

}