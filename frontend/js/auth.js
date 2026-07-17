function protegerPagina(){
    const token = localStorage.getItem("token");
    if(!token) {
        window.location.href = "../login.html"
    }
}

function atualizarBotoesAuth(){
    const token = localStorage.getItem("token");

        console.log("Token encontrado:", token); // <- debug temporário

    const btnLogin = document.querySelector("#btnLogin");
    const btnLogout = document.querySelector("#btnLogout");

    console.log("btnLogin existe?", !!btnLogin, "btnLogout existe?", !!btnLogout); // <- debug temporário

    if (!btnLogin || !btnLogout) return;

    if(token) {
        btnLogin.style.display = "none";
        btnLogout.style.display = "block";
    }
    else {
        btnLogin.style.display = "block";
        btnLogout.style.display = "none";
    }

    btnLogout.addEventListener("click", function(event){
        localStorage.removeItem("token");
        window.location.href = "login.html"
    });
}

atualizarBotoesAuth();