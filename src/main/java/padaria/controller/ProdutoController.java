package padaria.controller;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.NoSuchElementException;

import padaria.model.*;
import padaria.service.IngredientesService;
import padaria.service.ProdutoService;
import padaria.utilitarios.Teclado;
import padaria.utilitarios.Video;

public class ProdutoController implements ControllerInterface<Produto>{
    private ProdutoService ProdutoService;
    private IngredientesService IService;
    private List<Ingredientes> ingredientes = new ArrayList<>();

    public ProdutoController(ProdutoService ProdutoService, IngredientesService IService){
        this.ProdutoService = ProdutoService;
        this.IService = IService;
    }

    @Override
    public void cadastrar(){
        Video.mensagemInfo("Cadastrar Produtos: ");

        String nome = Teclado.readString("Informe o nome do produto: ");
        
        Video.mensagem("Adicione os ingredientes utilizados: ");
        int opcao = 0;
        do {
            opcao = Teclado.solicitarInt("Digite uma opção:\n 0 - Salvar\n 1 - Add ingrediente ");
            if(opcao == 1){
                try {
                    ingredientes.add(IService.buscarViaNome(Teclado.solicitarString("Informe o ingrediente utilizado: ")));
                    Video.mensagemOk("Ingrediente Adicionado!");
                } catch (Exception e) {
                    Video.mensagemErro("Ingrediente não encontrado, tente novamente!");
                }
                
            }            
        } while (opcao == 1);

        try {
            if(ingredientes.isEmpty()){
            throw new EmptyStackException();
        }          
            Produto produto = Produto.builder()
                        .setNome(nome)
                        .setIngredientes(ingredientes)
                        .construir();
            
            ProdutoService.adicionar(produto);
            Video.mensagemOk("Produto Cadastrado!");
        } 
        catch(EmptyStackException e){
            Video.mensagemErro("Ao menos um ingrediente deve ser informado, produto não cadastrado!");
        }
        catch(NumberFormatException e){
            Video.mensagemErro("Digite apenas letras para o nome!");
        }
        catch(IllegalArgumentException e){
            Video.mensagemErro("Nome ou Id inválido, verifique o cadastro!");
        }
        catch(NullPointerException e){
            Video.mensagemErro("Produto nulo, cadastre novamente!");
        }
        catch (Exception e) {
            Video.mensagemErro("Erro ao adicionar produto, tente novamente!");
        }
    }

    @Override
    public void listar(){
        Video.mensagemInfo("Lista de Produtos: ");

        try {
            List<Produto> Produto = ProdutoService.listar();

            for (Produto produto : Produto) {
                Video.print(produto.toString());
            }
        } catch (EmptyStackException e) {
            Video.mensagemErro("Lista vazia, nenhum produto para listar!");
        }
    }

    @Override
    public void excluir(){
        Video.mensagemInfo("Exclusão de produto via nome: ");
        
        String nome = Teclado.readString("Digite o nome do produto a ser deletado: ");
        try {
            ProdutoService.excluir(nome);
            Video.mensagemOk(nome + ", excluído com sucesso!");
        } catch (EmptyStackException e) {
            Video.mensagemErro("Lista vazia, nenhum produto para excluir!");
        }
        catch(NoSuchElementException e){
            Video.mensagemErro("Produto não encontrado, digite novamente.");
        }
        catch(Exception e){
            Video.mensagemErro("Erro não previsto!");
        }      
    }

    public void excluirViaId(){
        Video.mensagemInfo("Exclusão de produto via id: ");

        int id = Teclado.readInt("Digite o id do produto a ser deletado: ");
        try {
            ProdutoService.excluirViaId(id);
            Video.mensagemOk(id + ", excluído com sucesso!");  
        }
        catch (EmptyStackException e) {
            Video.mensagemErro("Lista vazia, nenhum produto para excluir!");
        }
        catch(NoSuchElementException e){
            Video.mensagemErro("Produto não encontrado, digite novamente.");
        }
        catch(Exception e){
            Video.mensagemErro("Erro não previsto!");
        }
    }

    @Override
    public void buscar(){
        Video.mensagemInfo("Buscar produto por nome: ");

        String nome = Teclado.readString("Digite o nome do produto a ser buscado: ");

        try {
            Video.mensagemInfo("Informações do produto: ");
            Video.println(ProdutoService.buscarViaNome(nome).toString());
        
       } catch (EmptyStackException e) {
            Video.mensagemErro("Lista vazia, nenhum produto para buscar!");
        }
        catch(NoSuchElementException e){
            Video.mensagemErro("Produto não encontrado, digite novamente.");
        }
        catch(Exception e){
            Video.mensagemErro("Erro não previsto!");
        }
    }

    public void buscarViaId(){
        Video.mensagemInfo("Buscar produto por Id: ");

       int id = Teclado.readInt("Digite o id do produto a ser buscado: ");

       try {
            Video.mensagemInfo("Informações do produto: ");
            Video.println(ProdutoService.buscarViaID(id).toString());
        
       } catch (EmptyStackException e) {
            Video.mensagemErro("Lista vazia, nenhum produto para excluir!");
        }
        catch(NoSuchElementException e){
            Video.mensagemErro("Produto não encontrado, digite novamente.");
        }
        catch(Exception e){
            Video.mensagemErro("Erro não previsto!");
        }
    }
}
