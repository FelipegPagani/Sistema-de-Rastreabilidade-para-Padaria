package padaria.repository;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.NoSuchElementException;

import padaria.model.Recebimentos;
import padaria.repository.Persistencia.RecebimentosPersistencia;

public class RecebimentosRepository implements RepositoryInterface<Recebimentos>{
    private List<Recebimentos> recebimentos;

    RecebimentosPersistencia persistir = new RecebimentosPersistencia();

    public RecebimentosRepository(){
        this.recebimentos = persistir.carregarRecebimentos();
    }

    @Override
    public void adicionar(Recebimentos recebimento){
        if(recebimento == null){
            throw new NullPointerException();
        }
        recebimentos.add(recebimento);
        persistir.salvarRecebimentos(recebimentos);
    }

    @Override
    public List<Recebimentos> listar(){
        if(recebimentos.isEmpty()){
            throw new EmptyStackException();
        }
        return new ArrayList<Recebimentos>(recebimentos);
    }

    @Override
    public void excluir(String lote){
        Recebimentos encontrado = null;

        if(recebimentos.isEmpty()){
            throw new EmptyStackException();
        }
        for(Recebimentos recebimento : recebimentos){
            if(lote.equals(recebimento.getLote())){
                encontrado = recebimento;
                
            }
        }
        if(encontrado == null){
            throw new NoSuchElementException();
        }
        recebimentos.remove(encontrado);
        persistir.salvarRecebimentos(recebimentos);
    }

    public void excluirViaId(int id){
        Recebimentos encontrado = null;

        if(recebimentos.isEmpty()){
            throw new EmptyStackException();
        }
        for(Recebimentos recebimento : recebimentos){
            if(id == recebimento.getId()){
                encontrado = recebimento;
                
            }
        }
        if(encontrado == null){
            throw new NoSuchElementException();
        }
        recebimentos.remove(encontrado);
        persistir.salvarRecebimentos(recebimentos);
    }

    @Override
    public Recebimentos buscar(String lote){
        Recebimentos encontrado = null;

        if(recebimentos.isEmpty()){
            throw new EmptyStackException();
        }
        for (Recebimentos recebimento : recebimentos) {
            if(lote.equals(recebimento.getLote())){
                encontrado = recebimento;
            }
        }
        if(encontrado == null){
            throw new NoSuchElementException();
        }
        return encontrado;
    }

    public Recebimentos buscarViaID(int id){
        Recebimentos encontrado = null; 

        if(recebimentos.isEmpty()){
            throw new EmptyStackException();
        }
        for (Recebimentos recebimento : recebimentos) {
            if(id == recebimento.getId()){
                encontrado = recebimento;
            }
        }
        if(encontrado == null){
            throw new NoSuchElementException();
        }
        return encontrado;
    }

    public Recebimentos buscarViaIngredientes(String nomeIngrediente){
        Recebimentos encontrado = null;
        
        if(recebimentos.isEmpty()){
            throw new EmptyStackException();
        }
        for (Recebimentos recebimento : recebimentos) {
            if(nomeIngrediente.equals(recebimento.getInsumos().getNome())){
                encontrado = recebimento;
            }
        }
        if(encontrado == null){
            throw new NoSuchElementException();
        }
        return encontrado;
    }

    public Recebimentos buscarViaFornecedor(String nomeFornecedor){
        Recebimentos encontrado = null;
        
        if(recebimentos.isEmpty()){
            throw new EmptyStackException();
        }
        for (Recebimentos recebimento : recebimentos) {
            if(nomeFornecedor.equals(recebimento.getFornecedores().getNome())){
                encontrado = recebimento;
            }
        }
        if(encontrado == null){
            throw new NoSuchElementException();
        }
        return encontrado;
    }
}
