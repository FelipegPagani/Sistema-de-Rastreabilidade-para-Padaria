package padaria.service;

import java.util.List;

import padaria.model.Clientes;
import padaria.repository.ClientesRepository;

public class ClientesService {

    private ClientesRepository clientesRepository;

    public ClientesService(ClientesRepository clientesRepository) {
        this.clientesRepository = clientesRepository;
    }

    public void adicionar(Clientes cliente) {
        clientesRepository.adicionar(cliente);
    }

    public List<Clientes> listar() {
        return clientesRepository.listar();
    }

    public void excluir(String nome) {
        clientesRepository.excluir(nome);
    }

    public Object buscarViaNome(String nome) {
        return clientesRepository.buscar(nome);
    }

    public void excluirViaCpf(String cpf) {
        clientesRepository.excluirViaCpf(cpf);
    }

    public Object buscarViaCpf(String cpf) {
        return clientesRepository.buscarViaCpf(cpf);
    }
}