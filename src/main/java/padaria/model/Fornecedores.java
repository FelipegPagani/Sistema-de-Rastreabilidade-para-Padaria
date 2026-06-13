package padaria.model;

import java.io.Serializable;
import java.security.InvalidParameterException;


public class Fornecedores implements Serializable{
    private String nome;
    private String cnpj;

    private static final long serialVersionUID = 1L;

    private Fornecedores(FornecedoresBuilder fornecedoresBuilder){
        this.nome = fornecedoresBuilder.nome;
        this.cnpj = fornecedoresBuilder.cnpj;
    }

    public static FornecedoresBuilder builder(){
        return new FornecedoresBuilder();
    }

    public String getNome(){
        return nome;
    }
    public String getcnpj() {
        return cnpj;
    }

    @Override
    public String toString(){
        return "Nome do fornecedor: "+ nome + 
               "\nCNPJ: " + cnpj +
               "\n";
    }
    

    public static class FornecedoresBuilder {
        private String nome;
        private String cnpj;

        public FornecedoresBuilder setNome(String nome){
            if(nome == null || nome.trim().isEmpty()){
            throw new IllegalArgumentException();
        }
        if(!nome.matches("[a-zA-ZÀ-ú\\s]+")){//valida que a string contenha apenas letras e espaços, sem números ou caracteres especiais
            throw new NumberFormatException();
        }
            this.nome = nome;
            return this;
        }
        public FornecedoresBuilder setCNPJ(String cnpj){
            if(cnpj == null || cnpj.trim().isEmpty()){
                throw new IllegalArgumentException();
        }
        if(cnpj.length() < 14){
            throw new InvalidParameterException();
        }
            this.cnpj = cnpj;
            return this;
        }

        public Fornecedores construir(){
            return new Fornecedores(this);
        }
     }
}
