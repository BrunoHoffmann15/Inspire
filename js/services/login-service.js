app.factory('loginService', function($localStorage){
    function usuarioLogado(){
        return $localStorage.usuario;
    }
    function loqarUsuario(usuario){
        $localStorage.usuario = usuario;
    }
    function deslogarUsuario(){
        localStorage.clear();
    }
    return{
        usuarioLogado : usuarioLogado,
        loqarUsuario : loqarUsuario,
        deslogarUsuario : deslogarUsuario
    }
});
