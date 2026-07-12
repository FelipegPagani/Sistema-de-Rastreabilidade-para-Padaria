package padaria.repository;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.NoSuchElementException;

import padaria.model.Ingredientes;
import padaria.repository.Persistencia.IngredientesPersistencia;

public class IngredientesRepository implements RepositoryInterface<Ingredientes>{
    
    private List<Ingredientes> ingredientes;
    IngredientesPersistencia persistir = new IngredientesPersistencia();

    public IngredientesRepository(){
        this.ingredientes = persistir.carregarIngredientes();
    }
    
    @Override
    public void adicionar(Ingredientes ingrediente){
        if(ingrediente == null){
            throw new NullPointerException();
        }
        ingredientes.add(ingrediente);
        persistir.salvarIngredientes(ingredientes);
    }

    @Override
    public List<Ingredientes> listar(){
        if(ingredientes.isEmpty()){
            throw new IllegalArgumentException();
        }
        return new ArrayList<Ingredientes>(ingredientes);
    }
    
    @Override
    public void excluir(String nome){
        Ingredientes encontrado = null;
        if(ingredientes.isEmpty()){
            throw new EmptyStackException();
        }
        for (Ingredientes ingrediente : ingredientes) {
            if(ingrediente.getNome().equals(nome)){
                encontrado = ingrediente;
            }
        }
        if(encontrado == null){
            throw new NoSuchElementException();
        }        
            ingredientes.remove(encontrado);
            persistir.salvarIngredientes(ingredientes);
    }

    public void excluirViaId(int Id){
        Ingredientes encontrado = null;
        if(ingredientes.isEmpty()){
            throw new EmptyStackException();
        }
        for (Ingredientes ingrediente : ingredientes) {
            if(ingrediente.getId() == Id){
                encontrado = ingrediente;
            }
        }
        if(encontrado == null){
            throw new NoSuchElementException();
        }
        ingredientes.remove(encontrado);
        persistir.salvarIngredientes(ingredientes);
    }

    @Override
    public Ingredientes buscar(String nome){
        if(ingredientes.isEmpty()){
            throw new EmptyStackException();
        }
        for (Ingredientes ingrediente : ingredientes) {
            if(nome.equals(ingrediente.getNome())){
                return ingrediente;
            }
        }
           throw new NoSuchElementException(); 
    }

    public Ingredientes buscarViaID(int id){
        Ingredientes encontrado = null;
        if(ingredientes.isEmpty()){
            throw new EmptyStackException();
        }
        for (Ingredientes ingrediente : ingredientes) {
            if(id == ingrediente.getId()){
                encontrado = ingrediente;
            }
        }
        if(encontrado == null){
           throw new NoSuchElementException(); 
        }
        return encontrado;
    }
}
