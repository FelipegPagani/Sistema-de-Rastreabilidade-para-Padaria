package padaria.model;

import padaria.utilitarios.Video;
import java.io.Serializable;

public class Clientes implements Serializable{

    private static final long serialVersionUID = 1L;

    private String cpf;
    private String nome;

    public Clientes(String nome, String cpf, String endereco){
        setCPF(cpf);
        setNome(nome);
    }

    public void setCPF(String cpf) {
        if(cpf.length() < 11 || cpf == null || cpf.trim().isEmpty()){
            return;
        }
        this.cpf = cpf;    
    }

    public String getCpf() {
        return cpf;
    }

    public void setNome(String nome){
        if(nome.isBlank() || nome.isEmpty()){
            Video.mensagemErro("Nome Invalido.");
            return;
        }
        this.nome = nome;
    }

    public String getNome(){
        return nome;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + " | CPF: " + cpf;
    }
}
