package padaria.controller;

import java.security.InvalidParameterException;
import java.util.EmptyStackException;
import java.util.List;
import java.util.NoSuchElementException;

import padaria.model.Fornecedores;
import padaria.service.FornecedoresService;
import padaria.utilitarios.Teclado;
import padaria.utilitarios.Video;

public class FornecedorController implements ControllerInterface<Fornecedores>{
    private FornecedoresService fornecedorService;

    public FornecedorController(FornecedoresService fornecedorService){
        this.fornecedorService = fornecedorService;
    }

    @Override
    public void cadastrar(){
        Video.mensagemInfo("Cadastrar Fornecedor: ");

        String nome = Teclado.readString("Informe o nome do Fornecedor: ");
        String cnpj = Teclado.readString("Informe o CNPJ do Fornecedor: ");

        try {
            Fornecedores fornecedor = Fornecedores.builder()
                        .setNome(nome)
                        .setCNPJ(cnpj)
                        .construir();

            fornecedorService.adicionar(fornecedor);
            Video.mensagemOk("Fornecedor Cadastrado!");
        }
        catch (InvalidParameterException e){
            Video.mensagemErro("Cnpj maior/menor do que o esperado, verifique seu cadastro!");
        } 
        catch(NumberFormatException e){
            Video.mensagemErro("Digite apenas letras para o nome!");
        }
        catch (IllegalArgumentException e) {
            Video.mensagemErro("Nome ou CNPJ inválidos, verifique seu cadastro!");
        }
        catch (NullPointerException e){
            Video.mensagemErro("Fornecedor nulo, verifique seu cadastro!");
        }
        catch(Exception e){
        Video.mensagemErro("Erro não previsto!");
        }
    }

    @Override
    public void listar(){
        Video.mensagemInfo("Lista de Fornecedores: ");

        try {
            List<Fornecedores> fornecedores = fornecedorService.listar();

            for (Fornecedores fornecedor : fornecedores) {
                Video.print(fornecedor.toString());
            }
        } 
        catch (EmptyStackException e) {
            Video.mensagemErro("Lista vazia, não há fornecedores para listar!");
        }
        catch(Exception e){
        Video.mensagemErro("Erro não previsto!");
        }
    }

    @Override
    public void excluir(){
        Video.mensagemInfo("Exclusão de fornecedor via nome: ");
        
        String nome = Teclado.readString("Digite o nome do fornecedor a ser deletado: ");

        try {
            fornecedorService.excluir(nome);
             Video.mensagemOk("Fornecedor excluido com sucesso!");
        } 
        catch (EmptyStackException e) {
            Video.mensagemErro("Lista Vazia, não há fornecedores para excluir!");
        }
        catch(NoSuchElementException e){
            Video.mensagemErro("Fornecedor não encontrado, tente novamente!");
        }
        catch(Exception e){
        Video.mensagemErro("Erro não previsto!");
        }
    }

    public void excluirViaCNPJ(){
        Video.mensagemInfo("Exclusão de fornecedor via cnpj: ");
        
        String cnpj = Teclado.readString("Digite o cpnj do fornecedor a ser deletado: ");
        try {
            fornecedorService.excluirViaCNPJ(cnpj);
            Video.mensagemOk("Fornecedor excluido com sucesso!");
        } 
        catch (EmptyStackException e) {
            Video.mensagemErro("Lista Vazia, não há fornecedores para excluir!");
        }
        catch(NoSuchElementException e){
            Video.mensagemErro("Fornecedor não encontrado, tente novamente!");
        }
        catch(Exception e){
        Video.mensagemErro("Erro não previsto!");
        }        
    }

    @Override
    public void buscar(){
        Video.mensagemInfo("Buscar fornecedor por nome: ");

        String nome = Teclado.readString("Digite o nome do fornecedor a ser buscado: ");

        try {
            Video.mensagemInfo("Informações do fornecedor: ");
            Video.print(fornecedorService.buscarViaNome(nome).toString());
        } 
        catch (EmptyStackException e) {
            Video.mensagemErro("Lista Vazia, não há fornecedores para buscar!");
        }
        catch(NoSuchElementException e){
            Video.mensagemErro("Fornecedor não encontrado, tente novamente!");
        }
        catch(Exception e){
            Video.mensagemErro("Erro não previsto");
        }
    }

    public void buscarViaCNPJ(){
        Video.mensagemInfo("Buscar fornecedor por CNPJ: ");

        String cnpj = Teclado.readString("Digite o CNPJ do fornecedor a ser buscado: ");

        try {
            Video.mensagemInfo("Informações do fornecedor: ");
            Video.println(fornecedorService.buscarViaCNPJ(cnpj).toString());
        } 
        catch (EmptyStackException e) {
            Video.mensagemErro("Lista Vazia, não há fornecedores para buscar!");
        }
        catch (NoSuchElementException e){
            Video.mensagemErro("Fornecedor não encontrado, tente novamente!");
        }
        catch(Exception e){
            Video.mensagemErro("Erro não previsto");
        }
    }
}
