package padaria.model;

import padaria.utilitarios.GeradorIdentificadorUnico;
import padaria.utilitarios.Video;

import java.io.Serializable;

public class LoteProducao implements Serializable{

    private static final long serialVersionUID = 1L;

    private int id;
    private String nome;
    private Produto produto;

    public LoteProducao(LoteProducaoBuilder loteProducaoBuilder){
        this.nome = loteProducaoBuilder.nome;
        this.id = loteProducaoBuilder.id;
        this.produto = loteProducaoBuilder.produto;
    }

    public static LoteProducaoBuilder builder(){
        return new LoteProducaoBuilder();
    }

    public String getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }


    @Override
    public String toString() {
        return "ID: " + id + " | Nome: " + nome +
        "\nProduto produzido: " + produto.toString();
    }

    public static class LoteProducaoBuilder{

        private String nome;
        private int id = GeradorIdentificadorUnico.gerarIDUnicoInt();
        private LoteIngrediente loteIngredienteUsado;
        private Produto produto;

        public LoteProducaoBuilder setNome(String nome){

            if(nome == null || nome.trim().isEmpty()){
                Video.mensagemErro("Nome inválido!");
                System.exit(0);
            }

            this.nome = nome;
            return this;
        }

        public LoteProducaoBuilder setProduto(Produto produto){
            if(produto == null){
                throw new IllegalArgumentException();
            }

            this.produto = produto;
            return this;
        }

        public LoteProducao construir(){
            return new LoteProducao(this);
        }
    }

}
