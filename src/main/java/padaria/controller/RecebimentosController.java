package padaria.controller;

import java.time.LocalDate;
import java.util.EmptyStackException;
import java.util.List;
import java.util.NoSuchElementException;

import padaria.model.*;
import padaria.repository.FornecedoresRepository;
import padaria.repository.IngredientesRepository;
import padaria.service.FornecedoresService;
import padaria.service.IngredientesService;
import padaria.service.RecebimentosService;
import padaria.utilitarios.Teclado;
import padaria.utilitarios.Video;

public class RecebimentosController implements ControllerInterface<Recebimentos>{
        private RecebimentosService recebimentosService;
        private Ingredientes ingrediente;
        private Fornecedores fornecedor;

        IngredientesRepository IR = new IngredientesRepository();
        IngredientesService IS = new IngredientesService(IR);
        
        FornecedoresRepository FR = new FornecedoresRepository();
        FornecedoresService FS = new FornecedoresService(FR);

    public RecebimentosController(RecebimentosService recebimentosService){
        this.recebimentosService = recebimentosService;
    }

    @Override
     public void cadastrar(){
        Video.mensagemInfo("Cadastrar recebimento: ");
        try {
            ingrediente = IS.buscarViaNome(Teclado.solicitarString("Digite o nome do ingrediente cadastrado: "));
        if(ingrediente == null){
            throw new NoSuchElementException();
        }                                                                                                                                                                                                                                                                                                                                                                   
            fornecedor = FS.buscarViaNome(Teclado.solicitarString("Digite o nome do fornecedor cadastrado: "));
        if(fornecedor == null){
            throw new NullPointerException();
        }
        } catch(NoSuchElementException e){
            Video.mensagemErro("Ingrediente não cadastrado, verifique e tente novamente!");
        }
        catch(NullPointerException e){
            Video.mensagemErro("Fornecedor não cadastrado, verifique e tente novamente!");
        }
        
        String lote = Teclado.readString("Informe o lote de recebimento: ");
        LocalDate datavalidade = Teclado.readLocalDate("Informe a data de validade do lote ");
        LocalDate dataRecebimento = Teclado.readLocalDate("Informe a da ta de recebimento: ");

        Recebimentos recebimento = Recebimentos.builder()
                        .setInsumo(ingrediente) 
                        .setFornecedor(fornecedor)
                        .setLote(lote)
                        .setValidade(datavalidade)
                        .setRecebimento(dataRecebimento)
                        .construir();
        try {
            recebimentosService.adicionar(recebimento);
            Video.mensagemOk("recebimento Cadastrado!");
        } 
        catch(EmptyStackException e){
            Video.mensagemErro("Ingrediente recebido vencido, verifique a data de validade!");
        }
        catch(ExceptionInInitializerError e){
            Video.mensagemErro("Data do recebimento não pode ser maior que data atual, verifique!");
        }
        catch(IllegalArgumentException e){
            Video.mensagemErro("Informações inválidas adicionadas, verifique!");
        }
        catch (Exception e) {
            Video.mensagemErro("Erro ao cadastrar recebimento, tente novamente!");
        }
    }

    @Override
    public void listar(){
        Video.mensagemInfo("Lista de recebimentos: ");

        try {
            List<Recebimentos> recebimentos = recebimentosService.listar();

            for (Recebimentos recebimento : recebimentos) {
            Video.print(recebimento.toString());
            }
        } catch (EmptyStackException e) {
            Video.mensagemErro("Lista vazia, nenhum recebimento para listar.");
        }
    }

    @Override
    public void excluir(){
        Video.mensagemInfo("Exclusão de recebimento via lote: ");
        
        String lote = Teclado.readString("Digite o lote do recebimento a ser deletado: ");

        try {
            recebimentosService.excluir(lote);
            Video.mensagemOk("Recebimento excluído com sucesso!");
        }
        catch(EmptyStackException e){
            Video.mensagemErro("Lista vazia, nenhum recebimento para excluir.");
        }
        catch(NoSuchElementException e){
            Video.mensagemErro("Recebimento não encontrado, tente novamente.");
        }
        catch(Exception e){
            Video.mensagemErro("Erro não previsto!");
        }
    }

    public void excluirViaId(){
        Video.mensagemInfo("Exclusão de recebimento via id: ");
        
        int id = Teclado.readInt("Digite o id do recebimento a ser deletado: ");

        try{
            recebimentosService.excluirViaId(id);
            Video.mensagemOk("Recebimento excluído com sucesso!");
        }
        catch(EmptyStackException e){
            Video.mensagemErro("Lista vazia, nenhum recebimento para excluir.");
        }
        catch(NoSuchElementException e){
            Video.mensagemErro("Recebimento não encontrado, tente novamente.");
        }
        catch(Exception e){
            Video.mensagemErro("Erro não previsto!");
        }               
    }

    @Override
    public void buscar(){
        Video.mensagemInfo("Buscar recebimento por lote: ");

        String lote = Teclado.readString("Digite o lote do recebimento a ser buscado: ");

        try {
            Video.println(recebimentosService.buscarViaLote(lote).toString());
        } 
        catch(EmptyStackException e){
            Video.mensagemErro("Lista vazia, nenhum recebimento para buscar.");
        }
        catch(NoSuchElementException e){
            Video.mensagemErro("Nenhum recebimento com esse lote encontrado, tente novamente.");
        }
        catch(Exception e){
            Video.mensagemErro("Erro não previsto!");
        }
    }

    public void buscarViaId(){
        Video.mensagemInfo("Buscar recebimento por id: ");

        int id = Teclado.readInt("Digite o id do recebimento a ser buscado: ");

        try {
            Video.println(recebimentosService.buscarViaID(id).toString());
        } 
        catch(EmptyStackException e){
            Video.mensagemErro("Lista vazia, nenhum recebimento para buscar.");
        }
        catch(NoSuchElementException e){
            Video.mensagemErro("Nenhum recebimento com esse id encontrado, tente novamente.");
        }
        catch(Exception e){
            Video.mensagemErro("Erro não previsto!");
        }
    }

    public void buscarViaFornecedor(){
        Video.mensagemInfo("Buscar recebimento por Fornecedor: ");

        String nomeFornecedor = Teclado.readString("Digite o nome do fornecedor do recebimento: ");

        try {
            Video.println(recebimentosService.buscarViaFornecedor(nomeFornecedor).toString());
        } 
        catch(EmptyStackException e){
            Video.mensagemErro("Lista vazia, nenhum recebimento para buscar.");
        }
        catch(NoSuchElementException e){
            Video.mensagemErro("Nenhum recebimento com esse fornecedor encontrado, tente novamente.");
        }
        catch(Exception e){
            Video.mensagemErro("Erro não previsto!");
        }
    }

    public void buscarViaIngrediente(){
        Video.mensagemInfo("Buscar recebimento por Ingrediente: ");

        String nomeIngrediente = Teclado.readString("Digite o nome do ingrediente do recebimento: ");

        try {
            Video.println(recebimentosService.buscarViaIngrediente(nomeIngrediente).toString());
        } 
        catch(EmptyStackException e){
            Video.mensagemErro("Lista vazia, nenhum recebimento para buscar.");
        }
        catch(NoSuchElementException e){
            Video.mensagemErro("Nenhum recebimento com esse ingrediente encontrado, tente novamente.");
        }
        catch(Exception e){
            Video.mensagemErro("Erro não previsto!");
        }
    }

}


