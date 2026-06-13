package padaria.service;

import java.util.List;

import padaria.model.Fornecedores;
import padaria.repository.FornecedoresRepository;

public class FornecedoresService{
    private FornecedoresRepository repositoryFornecedor;

    public FornecedoresService(FornecedoresRepository repositoryFornecedor){
        this.repositoryFornecedor = repositoryFornecedor;
    }

    
    public void adicionar(Fornecedores fornecedor){
        repositoryFornecedor.adicionar(fornecedor);
    }
    
    public List<Fornecedores> listar(){
        return repositoryFornecedor.listar();
    }
    
    public void excluir(String nome){
        repositoryFornecedor.excluir(nome);
    }

    public void excluirViaCNPJ(String cnpj){
        repositoryFornecedor.excluirViaCNPJ(cnpj);
    }
    
    public Fornecedores buscarViaNome(String nome){
        return repositoryFornecedor.buscar(nome);
    }

    public Fornecedores buscarViaCNPJ(String cnpj){
        return repositoryFornecedor.buscarViaCNPJ(cnpj);
    }

}
