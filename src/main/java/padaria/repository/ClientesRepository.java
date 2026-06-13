package padaria.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import padaria.model.Clientes;
import padaria.repository.Persistencia.ClientesPersistencia;

public class ClientesRepository implements RepositoryInterface<Clientes> {

    private List<Clientes> clientes;
    ClientesPersistencia persistir = new ClientesPersistencia();

    public ClientesRepository() {
        this.clientes = persistir.carregarClientes();
    }

    @Override
    public void adicionar(Clientes cliente) {

        if (cliente == null) {
            throw new IllegalArgumentException("Cliente inválido");
        }

        clientes.add(cliente);
        persistir.salvarClientes(clientes);
    }

    @Override
    public List<Clientes> listar() {

        if (clientes.isEmpty()) {
            throw new IllegalStateException("Nenhum cliente cadastrado");
        }

        return new ArrayList<Clientes>(clientes);
    }

    @Override
    public void excluir(String nome) {

        Clientes encontrado = null;

        if (clientes.isEmpty()) {
            throw new IllegalStateException("Nenhum cliente cadastrado");
        }

        for (Clientes cliente : clientes) {
            if (cliente.getNome().equalsIgnoreCase(nome)) {
                encontrado = cliente;
            }
        }

        if (encontrado == null) {
            throw new NoSuchElementException("Cliente não encontrado");
        }

        clientes.remove(encontrado);
        persistir.salvarClientes(clientes);
    }

    @Override
    public Clientes buscar(String nome) {

        if (clientes.isEmpty()) {
            throw new IllegalStateException("Nenhum cliente cadastrado");
        }

        for (Clientes cliente : clientes) {
            if (cliente.getNome().equalsIgnoreCase(nome)) {
                return cliente;
            }
        }

        throw new NoSuchElementException("Cliente não encontrado");
    }

    public void excluirViaCpf(String cpf) {

        Clientes encontrado = null;

        if (clientes.isEmpty()) {
            throw new IllegalStateException("Nenhum cliente cadastrado");
        }

        for (Clientes cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                encontrado = cliente;
            }
        }

        if (encontrado == null) {
            throw new NoSuchElementException("CPF não encontrado");
        }

        clientes.remove(encontrado);
        persistir.salvarClientes(clientes);
    }

    public Clientes buscarViaCpf(String cpf) {

        if (clientes.isEmpty()) {
            throw new IllegalStateException("Nenhum cliente cadastrado");
        }

        for (Clientes cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                return cliente;
            }
        }

        throw new NoSuchElementException("CPF não encontrado");
    }
}