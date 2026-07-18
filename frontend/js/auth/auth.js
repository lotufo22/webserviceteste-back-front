function protegerPagina(){
    const token = localStorage.getItem("token");
    if(!token) {
        window.location.href = "./login.html"
    }
}

function atualizarBotoesAuth(){
    const token = localStorage.getItem("token");

    const btnLogin = document.querySelector("#btnLogin");
    const btnLogout = document.querySelector("#btnLogout");

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