app.factory('usuarioService', function ($http) {
    let urlBase = "http://localhost:3000/usuario";
    function criarUsuario(usuario){
        return $http.post(urlBase, usuario);
    }
    function editarUsuario(usuario){
        return $http.put(urlBase + `/${usuario.id}`, usuario);
    }
    function deletarUsuario(usuario){
        return $http.delete(urlBase + `/${usuario.id}`);
    }
    function buscarPorId(usuario){
        return $http.get(urlBase + `/${usuario.id}`);
    }
    function buscarPorLogin(usuario){
        return $http.get(urlBase+`?email=${usuario.email}`);
    }
    function listar(){
        return $http.get(urlBase);
    }
    return {
        criarUsuario : criarUsuario,
        buscarPorLogin : buscarPorLogin,
        editarUsuario : editarUsuario,
        deletarUsuario : deletarUsuario,
        buscarPorId : buscarPorId,
        listar : listar
    }

});
