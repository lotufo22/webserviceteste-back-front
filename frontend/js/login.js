const formularioLogin = document.querySelector(".loginForm");
const InomeLogin = document.querySelector(".nome");
const IsenhaLogin = document.querySelector(".senha");
const mensagemErro = document.querySelector("#erroLogin");

function login() {

    fetch("http://localhost:8080/usuarios/login", {
        headers: {
            'Accept': 'application/json',
            'content-type': 'application/json'
        },
        method: "POST",
        body: JSON.stringify({
            nome: InomeLogin.value,
            senha: IsenhaLogin.value
        })
    })
    .then(function(res) {
        if(!res.ok) {
            throw new Error("Usuário ou senha inválidos");
        }
        return res.json();
    })
    .then((dados) => {
        localStorage.setItem("token", dados.token);

        window.location.href = "./index.html";
    })
    .catch((err) => {
        console.error("Falha ao logar: ", erro);
        mensagemErro.textContent = "Usuário ou senha inválidos";
    });
}

formularioLogin.addEventListener("submit", function(event) {
    event.preventDefault();
    login();
});