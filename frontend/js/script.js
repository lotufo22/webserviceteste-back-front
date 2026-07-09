const formulario = document.querySelector("form");
const Inome = document.querySelector(".nome");
const Iemail = document.querySelector(".email");
const Isenha = document.querySelector(".senha");
const Itel = document.querySelector(".tel");

function cadastrar () {

    fetch("http://localhost:8080/usuarios",
        {
            headers: {
                'Accept' : 'application/json',
                'Content-type' : 'application/json'
            },
            method: "POST",
            body: JSON.stringify({
                nome: Inome.value,
                email: Iemail.value,
                senha: Isenha.value,
                telefone: Itel.value
            })
        })
        .then(function(res) {
            if(!res.ok){
                // status HTTP de erro (400, 404, 500, ...)
                throw new Error("Erro na requisição: " + res.status);
            }
            return res.json(); // converte o corpo da resposta em objeto JS
        })
        .then(function(dados) {
            console.log("Cadastro realizado: ", dados);
        })
        .catch(function(erro) {
            console.error("Falha ao cadastrar: ", erro)
        })
}

function limpar () {
    Inome.value = "";
    Iemail.value = "";
    Isenha.value = "";
    Itel.value = "";
}

formulario.addEventListener("submit", function(event) {
    event.preventDefault();

    cadastrar();
    limpar();
})