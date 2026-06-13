package padaria.service;

import java.util.List;

import padaria.model.Produto;
import padaria.repository.ProdutosRepository;

public class ProdutoService {
    private ProdutosRepository produtosRepository;

    public ProdutoService(ProdutosRepository produtosRepository){
        this.produtosRepository = produtosRepository;
    }

    public void adicionar(Produto produto){
        produtosRepository.adicionar(produto);
    }

    public List<Produto> listar(){
        return produtosRepository.listar();
    }
    
    public void excluir(String nome){
        produtosRepository.excluir(nome);
    }

    public void excluirViaId(int Id){
        produtosRepository.excluirViaId(Id);
    }

    public Produto buscarViaNome(String nome){
        return produtosRepository.buscar(nome);
    }

    public Produto buscarViaID(int id){
       return produtosRepository.buscarViaID(id);
    }
}
