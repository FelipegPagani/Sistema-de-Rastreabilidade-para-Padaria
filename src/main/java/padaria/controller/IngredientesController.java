package padaria.controller;

import java.util.EmptyStackException;
import java.util.List;
import java.util.NoSuchElementException;

import padaria.model.Ingredientes;
import padaria.service.IngredientesService;
import padaria.service.LoteIngredienteService;
import padaria.utilitarios.Teclado;
import padaria.utilitarios.Video;

public class IngredientesController implements ControllerInterface<Ingredientes>{
    private IngredientesService ingredientesService;

    public IngredientesController(IngredientesService ingredientesService, LoteIngredienteService LIService){
        this.ingredientesService = ingredientesService;
    }

    @Override
    public void cadastrar(){
        Video.mensagemInfo("Cadastrar Ingredientes: ");
    try {
        String nomeIngrediente = Teclado.readString("Informe o nome do ingrediente: ");
     
            
            Ingredientes ingrediente = Ingredientes.builder()
                        .setNome(nomeIngrediente)
                        .construir();
            ingredientesService.adicionar(ingrediente);

            Video.mensagemOk("Ingrediente cadastrado com sucesso!");
        } 
        catch(NumberFormatException e){
            Video.mensagemErro("Digite apenas letras para o nome!");
        }
        catch(IllegalArgumentException e){
            Video.mensagemErro("Nome ou Id inválido, verifique seu cadastro");
        }
        catch(NullPointerException e){
            Video.mensagemErro("Ingrediente nulo, cadastre novamente!");
        }
        catch (Exception e) {
            Video.mensagemErro("Erro ao adicionar o ingrediente, tente novamente!");
        }
    }

    @Override
    public void listar(){
        Video.mensagemInfo("Lista de ingredientes: ");

        try {
            List<Ingredientes> ingredientes = ingredientesService.listar();

            for (Ingredientes ingrediente : ingredientes) {
                Video.print(ingrediente.toString());
            }   
        }
        catch (EmptyStackException e) {
            Video.mensagemErro("Lista vazia, nenhum ingrediente para listar!");
        }catch (Exception e) {
            Video.mensagemErro("Erro não previsto!");
        }
    }

    @Override
    public void excluir(){
        Video.mensagemInfo("Exclusão de ingrediente via nome: ");
        
        String nome = Teclado.readString("Digite o nome do ingrediente a ser deletado: ");

        try{
            ingredientesService.excluir(nome);
            Video.mensagemOk(nome + ", excluído com sucesso!");
        }
        catch (EmptyStackException e) {
            Video.mensagemErro("Lista vazia, nenhum ingrediente para excluir!");
        }
        catch(NoSuchElementException e){
            Video.mensagemErro("Ingrediente não encontrado, tente novamente");
        }
        catch (Exception e) {
            Video.mensagemErro("Erro não previsto!");
        }
    }

    public void excluirViaId(){
        Video.mensagemInfo("Exclusão de ingrediente via id: ");

        int id = Teclado.readInt("Digite o id do ingrediente a ser deletado: ");
        try {
            ingredientesService.excluirViaId(id);
            Video.mensagemOk(id + ", excluído com sucesso!");
        }
        catch (EmptyStackException e) {
            Video.mensagemErro("Lista vazia, nenhum ingrediente para excluir!");
        }
        catch(NoSuchElementException e){
            Video.mensagemErro("Ingrediente não encontrado, tente novamente");
        }
        catch (Exception e) {
            Video.mensagemErro("Erro não previsto!");
        }
    }

    @Override
    public void buscar(){
        Video.mensagemInfo("Buscar ingrediente por nome: ");

        String nome = Teclado.readString("Digite o nome do ingrediente a ser buscado: ");

        try {
            Video.mensagemInfo("Informações do ingrediente: ");
            Video.print(ingredientesService.buscarViaNome(nome).toString());
        }
        catch (EmptyStackException e) {
            Video.mensagemErro("Lista vazia, nenhum ingrediente para buscar!");
        }
        catch(NoSuchElementException e){
            Video.mensagemErro("Ingrediente não encontrado, tente novamente");
        }
        catch (Exception e) {
            Video.mensagemErro("Erro não previsto!");
        }
    }

    public void buscarViaId(){
        Video.mensagemInfo("Buscar ingrediente por Id: ");

       int id = Teclado.readInt("Digite o id do ingrediente a ser buscado: ");

       try {
            Video.mensagemInfo("Informações do ingrediente: ");
            Video.println(ingredientesService.buscarViaID(id).toString());
        } 
        catch (EmptyStackException e) {
            Video.mensagemErro("Lista vazia, nenhum ingrediente para buscar!");
        }
        catch(NoSuchElementException e){
            Video.mensagemErro("Ingrediente não encontrado, tente novamente");
        }
        catch (Exception e) {
            Video.mensagemErro("Erro não previsto!");
        }
    }
}
