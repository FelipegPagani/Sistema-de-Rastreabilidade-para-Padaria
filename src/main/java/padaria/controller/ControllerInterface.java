package padaria.controller;

import java.util.List;

public interface ControllerInterface <T>{

    void cadastrar();

    List<T> listar();
    
    void excluir(String nome);

    Object buscar(String nome);

}
