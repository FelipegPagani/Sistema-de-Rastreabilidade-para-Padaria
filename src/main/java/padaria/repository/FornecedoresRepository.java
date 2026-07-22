package padaria.repository;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.NoSuchElementException;

import padaria.model.Fornecedores;
import padaria.repository.Persistencia.FornecedorPersistencia;

public class FornecedoresRepository implements RepositoryInterface<Fornecedores>{
    private List<Fornecedores> fornecedores;
    FornecedorPersistencia persistir = new FornecedorPersistencia();

    public FornecedoresRepository(){
        this.fornecedores = persistir.carregarFornecedor();
    }

    @Override
    public void adicionar(Fornecedores fornecedor){
        if(fornecedor == null){
            throw new NullPointerException();
        }
        fornecedores.add(fornecedor);
        persistir.salvarFornecedores(fornecedores);
    }

    @Override
    public List<Fornecedores> listar(){
        if(fornecedores.isEmpty()){
            throw new EmptyStackException();
        }
        return new ArrayList<Fornecedores>(fornecedores);
    }

    @Override
    public void excluir(String nome){
        Fornecedores encontrado = null;
        if(fornecedores.isEmpty()){
            throw new EmptyStackException();
        }
        for(Fornecedores fornecedor : fornecedores){
            if(nome.equals(fornecedor.getNome())){
                encontrado = fornecedor;
            }
        }
        if(encontrado == null){
          throw new NoSuchElementException();  
        }
        fornecedores.remove(encontrado);
        persistir.salvarFornecedores(fornecedores);
    }

    public void excluirViaCNPJ(String cnpj){
        Fornecedores encontrado = null;

        if(fornecedores.isEmpty()){
            throw new EmptyStackException();
        }
        for(Fornecedores fornecedor : fornecedores){
            if(cnpj.equals(fornecedor.getcnpj())){
                encontrado = fornecedor;
            }
        }
        if(encontrado == null){
            throw new NoSuchElementException();
        }
        fornecedores.remove(encontrado);
        persistir.salvarFornecedores(fornecedores);
    }

    @Override
    public Fornecedores buscar(String nome){
        Fornecedores encontrado = null;
        if(fornecedores.isEmpty()){
            throw new EmptyStackException();
        }
        for (Fornecedores fornecedor : fornecedores) {
            if(nome.equals(fornecedor.getNome())){
                encontrado = fornecedor;
            }
        }
        if(encontrado == null){
            throw new NullPointerException();
        }
        return encontrado;
       
    }

    public Fornecedores buscarViaCNPJ(String cnpj){
        Fornecedores encontrado = null;
        if(fornecedores.isEmpty()){
            throw new EmptyStackException();
        }
        for (Fornecedores fornecedor : fornecedores) {
            if(cnpj.equals(fornecedor.getcnpj())){
                encontrado = fornecedor;
            }
        }
        if(encontrado == null){
            throw new NoSuchElementException();
        }
        return encontrado;
    }

    
}
