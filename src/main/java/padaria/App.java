package padaria;

import padaria.config.AplicacaoFactory;
import padaria.utilitarios.*;
import padaria.utilitarios.menu.*;

public class App {

    public static void iniciar() {

        Video.println("Carregando...");
        Video.barraProgresso(50, 15);
        Video.limparTela();
        Video.exibirCabecalho("Nossa aplicação!");
    }

    public static void main(String[] args) {
        AplicacaoFactory app = new AplicacaoFactory();

        iniciar();

        int opcaoPrincipal;
        do {
            opcaoPrincipal = MenuPrincipal.exibir();
            switch (opcaoPrincipal) {
                case 1 -> {
                    int opcaoPessoa;
                    do {
                        opcaoPessoa = MenuProduto.exibir();
                        switch (opcaoPessoa) { // sem break, com uso de ->
                            case 1 -> app.getProdutoController().listar();
                            case 2 -> app.getProdutoController().cadastrar();
                            case 3 -> app.getProdutoController().excluirViaId();
                            case 4 -> app.getProdutoController().excluir();
                            case 5 -> app.getProdutoController().buscarViaId();
                            case 6 -> app.getProdutoController().buscar();
                        }
                    } while (opcaoPessoa != 7);
                }
                case 2 -> {//Ingrediente
                    int opcaoPessoa;
                    do {
                        opcaoPessoa = MenuIngrediente.exibir();
                        switch (opcaoPessoa) {
                            case 1 -> app.getIngredientesController().listar();
                            case 2 ->  app.getIngredientesController().cadastrar();
                            case 3 -> app.getIngredientesController().excluirViaId();
                            case 4 -> app.getIngredientesController().excluir();
                            case 5 -> app.getIngredientesController().buscarViaId();
                            case 6 ->  app.getIngredientesController().buscar();
                        }
                    } while (opcaoPessoa != 7);
                }
                case 3 -> { // Fornecedor
                    int opcaoPessoa;
                    do {
                        opcaoPessoa = MenuFornecedor.exibir();
                        switch (opcaoPessoa) { 
                            case 1 -> app.getFornecedorController().listar();
                            case 2 ->  app.getFornecedorController().cadastrar();
                            case 3 -> app.getFornecedorController().excluirViaCNPJ();
                            case 4 -> app.getFornecedorController().excluir();
                            case 5 -> app.getFornecedorController().buscarViaCNPJ();
                            case 6 -> app.getFornecedorController().buscar();
                        }
                    } while (opcaoPessoa != 7);
                }
                case 4 -> {// Recebimentos
                    int opcaoPessoa;
                    do {
                        opcaoPessoa = MenuRecebimentos.exibir();
                        switch (opcaoPessoa) { // sem break, com uso de ->
                            case 1 -> app.getRecebimentosController().listar();
                            case 2 -> app.getRecebimentosController().cadastrar();
                            case 3 -> app.getRecebimentosController().excluirViaId();
                            case 4 -> app.getRecebimentosController().excluir();
                            case 5 -> app.getRecebimentosController().buscarViaId();
                            case 6 -> app.getRecebimentosController().buscar();
                            case 7 -> app.getRecebimentosController().buscarViaIngrediente();
                            case 8 -> app.getRecebimentosController().buscarViaFornecedor();
                        }
                    } while (opcaoPessoa != 9);
                }
                case 5 -> { // Clientes
                    int opcaoPessoa;
                    do {
                        opcaoPessoa = MenuClientes.exibir();
                        switch (opcaoPessoa) {
                            case 1 -> app.getClientesController().listar();
                            case 2 -> app.getClientesController().cadastrar();
                            case 3 -> app.getClientesController().excluirViaCpf();
                            case 4 -> app.getClientesController().excluir();
                            case 5 -> app.getClientesController().buscar();
                            case 6 -> app.getClientesController().buscarViaCpf();
                        }
                    } while (opcaoPessoa != 7);
                }
                case 6 -> { // Lote Ingrediente
                    int opcaoPessoa;
                    do {
                        opcaoPessoa = MenuLoteIngrediente.exibir();
                        switch (opcaoPessoa) {
                            case 1 -> app.getLoteIngredienteController().listar();
                            case 2 -> app.getLoteIngredienteController().cadastrar();
                            case 3 -> app.getLoteIngredienteController().excluir();
                            case 4 -> app.getLoteIngredienteController().buscar();
                        }
                    } while (opcaoPessoa != 5);
                }
                case 7 -> { // Lote Produção
                    int opcaoPessoa;
                    do {
                        opcaoPessoa = MenuLoteProducao.exibir();

                        switch (opcaoPessoa) {
                            case 1 -> app.getLoteProducaoController().listar();
                            case 2 -> app.getLoteProducaoController().cadastrar();
                            case 3 -> app.getLoteProducaoController().excluir();
                            case 4 -> app.getLoteProducaoController().buscar();
                        }
                    } while (opcaoPessoa != 5);
                }
                case 8 -> {// Rastrear
                    int opcaoPessoa;
                    do{
                        opcaoPessoa = MenuRastrear.exibir();
                        switch (opcaoPessoa) {
                            case 1 -> app.getRastrearController().rastrearPorLoteIngrediente();
                        }
                    } while(opcaoPessoa != 3);
                }
            }
        } while (opcaoPrincipal != 9);

        Video.mensagemInfo("Saindo do sistema...");
    }
}