document.getElementById("admin_logout").addEventListener("click",logoutadmin)


function logoutadmin(){

    localStorage.removeItem("JWTTOKEN");

    alert("You are Logged Out.")

    window.location.href="/pages/adminlogin.html"

   

}