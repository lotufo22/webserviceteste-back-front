fetch("../navbar.html")
    .then(function(res) {
        return res.text();
    })
    .then(function(html) {
        document.querySelector("#navbar-container").innerHTML = html;

        atualizarBotoesAuth();
    })
    .catch(function(erro) {
        console.error("Erro ao carregar navbar: ", erro);
    });