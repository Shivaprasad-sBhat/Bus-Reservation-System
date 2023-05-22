// let userData= JSON.parse(localStorage.getItem("userDataStorage"))
// console.log(userData)


document.getElementById("logout").addEventListener("click",logoutUser)


function logoutUser(){

   

    localStorage.removeItem("JWTTOKEN")

    alert("You are Logged Out.")

    window.location.href="/pages/userlogin.html"

    console.log("inside logout")

}


