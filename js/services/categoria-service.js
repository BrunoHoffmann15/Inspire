app.factory('categoriaService', function ($http) {
    let urlBase = "http://localhost:3000/categoria";
    function criarCategoria(categoria){
        return $http.post(urlBase, categoria);
    }
    function editarCategoria(categoria){
        return $http.put(urlBase + `/${categoria.id}`, categoria);
    }
    function deletarCategoria(categoria){
        return $http.delete(urlBase + `/${categoria.id}`);
    }
    function buscarPorId(categoria){
        return $http.get(urlBase + `/${categoria.id}`);
    }
    function listar(){
        return $http.get(urlBase);
    }
    return {
        criarCategoria : criarCategoria,
        editarCategoria : editarCategoria,
        deletarCategoria : deletarCategoria,
        buscarPorId : buscarPorId,
        listar : listar
    }

});
