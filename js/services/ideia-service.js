app.factory('ideiaService', function($http){
  function adicionarideia(novoideia) {
    return $http.post('http://localhost:3000/ideia', novoideia);
  }
  function listar() {
    return $http.get('http://localhost:3000/ideia')
  }

  function buscarPorId(id) {
    return $http.get('http://localhost:3000/ideia/' + id);
  }
  function alterar(ideia) {
    return $http.put('http://localhost:3000/ideia/' + ideia.id, ideia);
  }
  function deletar(ideia) {
    return $http.delete('http://localhost:3000/ideia/' + ideia.id);
  }

  return {
    listar: listar,
    adicionarideia: adicionarideia,
    buscarPorId: buscarPorId,
    alterar: alterar,
    deletar: deletar
  }
});
