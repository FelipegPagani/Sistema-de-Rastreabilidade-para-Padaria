package padaria.model;

import java.io.Serializable;

public class Clientes implements Serializable{

    private static final long serialVersionUID = 1L;

    private String cpf;
    private String nome;

    private Clientes(ClientesBuilder clientesBuilder){
        this.nome = clientesBuilder.nome;
        this.cpf = clientesBuilder.cpf;
    }

    public static ClientesBuilder builder(){
        return new ClientesBuilder();
    }

    public String getCpf() {
        return cpf;
    }
    
    public String getNome(){
        return nome;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + " | CPF: " + cpf;
    }

    public static class ClientesBuilder{
        private String nome;
        private String cpf;


        public ClientesBuilder setNome(String nome){
        if(nome.isBlank() || nome.trim().isEmpty()){
           throw new IllegalArgumentException();
        }
        if(!nome.matches("[a-zA-ZÀ-ú\\s]+")){//valida que a string contenha apenas letras e espaços, sem números ou caracteres especiais
            throw new NumberFormatException();
        }

            this.nome = nome;
            return this;    
        }

        public ClientesBuilder setCPF(String cpf) {
            if(cpf.length() < 11 || cpf == null || cpf.trim().isEmpty()){
                throw new IllegalArgumentException();
            }
            this.cpf = cpf;
            return this; 
        }

        public Clientes construir(){
            return new Clientes(this);
        }

    }
}
