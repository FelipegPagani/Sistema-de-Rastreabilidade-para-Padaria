package padaria.repository;

import java.util.List;


public abstract interface RepositoryInterface<T> {

    void adicionar(T t);

    List<T> listar();
    
    void excluir(String nome);

    Object buscar(String nome);
}
