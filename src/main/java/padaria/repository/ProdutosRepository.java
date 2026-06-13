package padaria.repository;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.NoSuchElementException;

import padaria.model.Produto;
import padaria.repository.Persistencia.ProdutosPersistencia;

public class ProdutosRepository implements RepositoryInterface<Produto>{

    private List<Produto> produtos;
    ProdutosPersistencia persistir = new ProdutosPersistencia();

    public ProdutosRepository(){
        this.produtos = persistir.carregarProdutos();
    }
    
    @Override
    public void adicionar(Produto produto){
        if(produto == null){
            throw new NullPointerException();
        }
        produtos.add(produto);
        persistir.salvarProdutos(produtos);
    }

    @Override
    public List<Produto> listar(){
        if(produtos.isEmpty()){
            throw new EmptyStackException();
        }
        return new ArrayList<Produto>(produtos);
    }
    
    @Override
    public void excluir(String nome){
        Produto encontrado = null;
        
        if(produtos.isEmpty()){
            throw new EmptyStackException();
        }
        for (Produto produto : produtos) {
            if(produto.getNome().equals(nome)){
                encontrado = produto;
            }
        }
        if(encontrado == null){
            throw new NoSuchElementException();
        }
            produtos.remove(encontrado);
            persistir.salvarProdutos(produtos);
    }


    public void excluirViaId(int Id){
        Produto encontrado = null;
        
        if(produtos.isEmpty()){
            throw new EmptyStackException();
        }
        for (Produto produto : produtos) {
            if(produto.getId() == Id){
                encontrado = produto;
            }
        }
        if(encontrado == null){
            throw new NoSuchElementException();
        }
            produtos.remove(encontrado);
            persistir.salvarProdutos(produtos);
    }

    @Override
    public Produto buscar(String nome){
    Produto encontrado = null;

        if(produtos.isEmpty()){
            throw new EmptyStackException();
        }
        for (Produto produto : produtos) {
            if(nome.equals(produto.getNome())){
                encontrado = produto;
            }
        }
        if(encontrado == null){
            throw new NoSuchElementException();
        }
        return encontrado;
    }

    public Produto buscarViaID(int id){
        Produto encontrado = null;

        if(produtos.isEmpty()){
            throw new EmptyStackException();
        }
        for (Produto produto : produtos) {
            if(id == produto.getId()){
                encontrado = produto;
            }
        }
        if(encontrado == null){
            throw new NoSuchElementException();
        }
        return encontrado;
    }
}
