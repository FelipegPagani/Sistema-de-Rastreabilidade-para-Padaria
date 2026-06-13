package padaria.controller;

import java.util.EmptyStackException;
import java.util.List;
import java.util.NoSuchElementException;

import padaria.model.Produto;
import padaria.service.ProdutoService;
import padaria.utilitarios.Teclado;
import padaria.utilitarios.Video;

public class ProdutoController {
    private ProdutoService ProdutoService;

    public ProdutoController(ProdutoService ProdutoService){
        this.ProdutoService = ProdutoService;
    }

    public void cadastrarproduto(){
        Video.mensagemInfo("Cadastrar Produtos: ");

        String nome = Teclado.readString("Informe o nome do produto: ");
        int id = Teclado.readInteger("Informe o id do produto: ");

       
        try {
            
            Produto produto = Produto.builder()
                        .setId(id)
                        .setNome(nome)
                        .construir();
            
            ProdutoService.adicionar(produto);
            Video.mensagemOk("Produto Cadastrado!");
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

    public void listarProduto(){
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

    public void excluirViaNome(){
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

    public void buscarViaNome(){
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
