package padaria.model;

import java.io.Serializable;

public class Ingredientes implements Serializable{
    private String nome;
    private int id;

    private static final long serialVersionUID = 1L;
    
    public Ingredientes(IngredientesBuilder ingredientesBuilder){
        this.nome = ingredientesBuilder.nome;
        this.id = ingredientesBuilder.id;
    }

    public static IngredientesBuilder builder(){
        return new IngredientesBuilder();
    }

    public String getNome() {
        return nome;
    }
    
    public int getId() {
        return id;
    }

    @Override
    public String toString(){
        return "Nome do ingrediente: " + nome +
               "\nId: "+ id +
               "\n";
    }

    public static class IngredientesBuilder{
        private String nome;
        private int id;

        public IngredientesBuilder setNome(String nome) {
        if(nome == null || nome.trim().isEmpty()){
            throw new IllegalArgumentException();
        }
        if(!nome.matches("[a-zA-ZÀ-ú\\s]+")){//valida que a string contenha apenas letras e espaços, sem números ou caracteres especiais
            throw new NumberFormatException();
        }
        this.nome = nome;
        return this;
        }

        public IngredientesBuilder setId(int id){
            if(id < 0){
                throw new IllegalArgumentException();
            }
            this.id = id;
            return this;
        }

        public Ingredientes construir(){
            return new Ingredientes(this);
        }

    }
}

