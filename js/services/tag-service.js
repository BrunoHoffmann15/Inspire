app.factory('tagService', function ($http) {
    let urlBase = "http://localhost:3000/tag";
    function criarTag(tag){
        return $http.post(urlBase, tag);
    }
    function editarTag(tag){
        return $http.put(urlBase + `/${tag.id}`, tag);
    }
    function deletarTag(tag){
        return $http.delete(urlBase + `/${tag.id}`);
    }
    function buscarPorId(tag){
        return $http.get(urlBase + `/${tag.id}`);
    }
    function listar(){
        return $http.get(urlBase);
    }
    return {
        criarTag : criarTag,
        ediTartag : editarTag,
        deletarTag : deletarTag,
        buscarPorId : buscarPorId,
        listar : listar
    }

});
