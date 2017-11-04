app.factory('categoriaService', function ($http) {
    let urlBase = "http://localhost:3000/categoria";
    function criarcategoria(categoria){
        return $http.post(urlBase, categoria);
    }
    function editarcategoria(categoria){
        return $http.put(urlBase + `/${categoria.id}`, categoria);
    }
    function deletarcategoria(categoria){
        return $http.delete(urlBase + `/${categoria.id}`);
    }
    function buscarPorId(categoria){
        return $http.get(urlBase + `/${categoria.id}`);
    }
    function listar(){
        return $http.get(urlBase);
    }
    return {
        criarcategoria : criarcategoria,
        editarcategoria : editarcategoria,
        deletarcategoria : deletarcategoria,
        buscarPorId : buscarPorId,
        listar : listar
    }

});
