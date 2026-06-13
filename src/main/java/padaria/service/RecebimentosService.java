package padaria.service;

import java.util.List;

import padaria.model.Recebimentos;
import padaria.repository.RecebimentosRepository;

public class RecebimentosService {
    private RecebimentosRepository recebimentosRepository;

    public RecebimentosService(RecebimentosRepository recebimentosRepository){
        this.recebimentosRepository = recebimentosRepository;
    }

    public void adicionar(Recebimentos recebimento){
       recebimentosRepository.adicionar(recebimento);
    }

    public List<Recebimentos> listar(){
        return recebimentosRepository.listar();
    }

    public void excluir(String lote){
        recebimentosRepository.excluir(lote);
    }

    public void excluirViaId(int id){
       recebimentosRepository.excluirViaId(id);
    }

    public Recebimentos buscarViaLote(String lote){
        return recebimentosRepository.buscar(lote);
    }

    public Recebimentos buscarViaID(int id){
        return recebimentosRepository.buscarViaID(id);
    }

    public Recebimentos buscarViaIngrediente(String nomeIngrediente){
        return recebimentosRepository.buscarViaIngredientes(nomeIngrediente);
    }

    public Recebimentos buscarViaFornecedor(String nomeFornecedor){
        return recebimentosRepository.buscarViaFornecedor(nomeFornecedor);
    }
}
