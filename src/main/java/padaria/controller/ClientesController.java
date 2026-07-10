package padaria.controller;

import java.util.List;
import padaria.model.Clientes;
import padaria.model.Fornecedores;
import padaria.service.ClientesService;
import padaria.utilitarios.Teclado;
import padaria.utilitarios.Video;
import java.util.NoSuchElementException;

public class ClientesController implements ControllerInterface<Clientes>{

    private ClientesService clientesService;

    public ClientesController(ClientesService clientesService) {
        this.clientesService = clientesService;
    }
    @Override
    public void cadastrar() {
        Video.mensagemInfo("Cadastrar Cliente:");

        String nome = Teclado.readString("Informe o nome do cliente: ");
        String cpf = Teclado.readString("Informe o CPF do cliente: ");

        try {
            Clientes cliente = Clientes.builder()
                        .setNome(nome)
                        .setCPF(cpf)
                        .construir();

            clientesService.adicionar(cliente);
            Video.mensagemOk("Cliente cadastrado!");
        } catch (IllegalArgumentException e) {
            Video.mensagemErro(e.getMessage());
        } catch (Exception e) {
            Video.mensagemErro("Erro não previsto!");
        }
    }

    @Override
    public void listar() {
        Video.mensagemInfo("Lista de Clientes:");

        try {
            List<Clientes> clientes = clientesService.listar();

            for (Clientes cliente : clientes) {
                Video.println(cliente.toString());
            }

        } catch (IllegalStateException e) {
            Video.mensagemErro(e.getMessage());
        } catch (Exception e) {
            Video.mensagemErro("Erro não previsto!");
        }
    }

    @Override
    public void excluir() {
        String nome = Teclado.readString("Digite o nome do cliente a ser deletado: ");

        try {
            clientesService.excluir(nome);
            Video.mensagemOk(nome + " excluído com sucesso!");

        } catch (IllegalStateException e) {
            Video.mensagemErro(e.getMessage());
        } catch (NoSuchElementException e) {
            Video.mensagemErro(e.getMessage());
        } catch (Exception e) {
            Video.mensagemErro("Erro não previsto!");
        }
    }

    public void excluirViaCpf() {
        String cpf = Teclado.readString("Digite o CPF do cliente a ser deletado: ");

        try {
            clientesService.excluirViaCpf(cpf);
            Video.mensagemOk(cpf + " excluído com sucesso!");

        } catch (IllegalStateException e) {
            Video.mensagemErro(e.getMessage());
        } catch (NoSuchElementException e) {
            Video.mensagemErro(e.getMessage());
        } catch (Exception e) {
            Video.mensagemErro("Erro não previsto!");
        }
    }

    @Override
    public void buscar() {
        String nome = Teclado.readString("Digite o nome do cliente: ");

        try {
            Object resultado = clientesService.buscarViaNome(nome);

            Video.mensagemInfo("Informações do cliente:");
            Video.println(resultado.toString());

        } catch (IllegalStateException e) {
            Video.mensagemErro(e.getMessage());
        } catch (NoSuchElementException e) {
            Video.mensagemErro(e.getMessage());
        } catch (Exception e) {
            Video.mensagemErro("Erro não previsto!");
        }
    }

    public void buscarViaCpf() {
        String cpf = Teclado.readString("Digite o CPF do cliente: ");

        try {
            Object resultado = clientesService.buscarViaCpf(cpf);

            Video.mensagemInfo("Informações do cliente:");
            Video.println(resultado.toString());

        } catch (IllegalStateException e) {
            Video.mensagemErro(e.getMessage());
        } catch (NoSuchElementException e) {
            Video.mensagemErro(e.getMessage());
        } catch (Exception e) {
            Video.mensagemErro("Erro não previsto!");
        }
    }
}
