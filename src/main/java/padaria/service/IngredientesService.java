package padaria.service;

import java.util.List;

import padaria.model.Ingredientes;
import padaria.repository.IngredientesRepository;

public class IngredientesService {
    private IngredientesRepository ingredientesRepository;

    public IngredientesService(IngredientesRepository ingredientesRepository){
        this.ingredientesRepository = ingredientesRepository;
    }

    public void adicionar(Ingredientes ingrediente){
        ingredientesRepository.adicionar(ingrediente);
    }

    public List<Ingredientes> listar(){
        return ingredientesRepository.listar();
    }
    
    public void excluir(String nome){
        ingredientesRepository.excluir(nome);
    }

    public void excluirViaId(int Id){
        ingredientesRepository.excluirViaId(Id);
    }

    public Ingredientes buscarViaNome(String nome){
        return ingredientesRepository.buscar(nome);
    }

    public Ingredientes buscarViaID(int id){
       return ingredientesRepository.buscarViaID(id);
    }
}
