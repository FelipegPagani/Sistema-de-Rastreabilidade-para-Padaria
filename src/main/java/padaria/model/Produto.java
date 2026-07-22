package padaria.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import padaria.utilitarios.GeradorIdentificadorUnico;

public class Produto implements Serializable{
    private int id;
    private String nome;
    private List<Ingredientes> ingredientes;

    private static final long serialVersionUID = 1L;

    public Produto(ProdutoBuilder produtoBuilder){
        this.id = produtoBuilder.id;
        this.nome = produtoBuilder.nome;
        this.ingredientes = produtoBuilder.ingredientes;
    }
    
    public static ProdutoBuilder builder() {
        return new ProdutoBuilder();
    }

    public int getId(){
        return id;
    }
    public String getNome() {
        return nome;
    }
    public List<Ingredientes> getIngredientes(){
        return ingredientes;
    }

    @Override
    public String toString(){
        return "Nome produto: " + nome +
               "\nId: " + id +
               "\nIngredientes utilizados: \n" + ingredientes;
                
    }

    public static class ProdutoBuilder{
        private int id = GeradorIdentificadorUnico.gerarIDUnicoInt();;
        private String nome;
        private List<Ingredientes> ingredientes = new ArrayList<>();

         public ProdutoBuilder setNome(String nome){
            if(nome == null || nome.trim().isEmpty()){
                throw new IllegalArgumentException();
            }
            if(!nome.matches("[a-zA-ZÀ-ú\\s]+")){//valida que a string contenha apenas letras e espaços, sem números ou caracteres especiais
                throw new NumberFormatException();
            }
            this.nome = nome;
            return this;
        }

        public ProdutoBuilder setIngredientes(List<Ingredientes> ingredientes){
            if(ingredientes == null){
                throw new NullPointerException();
            }
            this.ingredientes.addAll(ingredientes);
            return this;
        }

         public Produto construir(){
            return new Produto(this);
        }
    }

}
































