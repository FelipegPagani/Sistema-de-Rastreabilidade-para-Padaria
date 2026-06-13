package padaria.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.EmptyStackException;
import java.util.NoSuchElementException;

public class Recebimentos implements Serializable{
    private int id;
    private Ingredientes insumo;
    private Fornecedores fornecedor;
    private String lote;
    private LocalDate dataValidade;
    private LocalDate dataRecebimento;

    private static final long serialVersionUID = 1L;

    private Recebimentos(RecebimentosBuilder recebimentosBuilder){
        this.id = recebimentosBuilder.id;
        this.insumo = recebimentosBuilder.insumo;
        this.fornecedor = recebimentosBuilder.fornecedor;
        this.lote = recebimentosBuilder.lote;
        this.dataValidade = recebimentosBuilder.dataValidade;
        this.dataRecebimento = recebimentosBuilder.dataRecebimento;
    }

    public static RecebimentosBuilder builder() {
        return new RecebimentosBuilder();
    }

    public int getId(){
        return id;
    }

    public Ingredientes getInsumos(){
        return insumo;
    }

    public Fornecedores getFornecedores(){
        return fornecedor;
    }

    public String getLote(){
        return lote;
    }

    public LocalDate getDataValidade(){
        return dataValidade;
    }

    public LocalDate getDataRecebimento(){
        return dataRecebimento;
    }

    @Override
    public String toString(){
        return "Id do recebimento: "+ id + "\n" +
               "Lote do recebimento: "+ lote + "\n" +
               "ingredientes recebidos: \n"+ insumo +
               "Fornecedor do recebimento: \n"+ fornecedor +
               "Data de recebimento: " + dataRecebimento + "\n" +
               "Data de validade: " + dataValidade +
               "\n";
    }

    public static class RecebimentosBuilder{
        private int id;
        private Ingredientes insumo;
        private Fornecedores fornecedor;
        private String lote;
        private LocalDate dataValidade;
        private LocalDate dataRecebimento;
        private LocalDate dataAtual = LocalDate.now();

        public RecebimentosBuilder setId(int id){
            if(id < 0){
                throw new IllegalArgumentException();
            }
            this.id = id ;
            return this;
        }

        public RecebimentosBuilder setInsumo(Ingredientes insumo){
            if(insumo == null){
                throw new NoSuchElementException();
            }
            this.insumo = insumo ;
            return this;
        }
        
         public RecebimentosBuilder setFornecedor(Fornecedores fornecedor){
            if(fornecedor == null){
                throw new NullPointerException();
            }
            this.fornecedor = fornecedor;
            return this;
        }
        public RecebimentosBuilder setLote(String lote){
            if(lote == null || lote.trim().isEmpty()){
                throw new IllegalArgumentException();
            }
            this.lote = lote;
            return this;
        }
        public RecebimentosBuilder setValidade(LocalDate dataValidade){

            if(dataValidade.isBefore(dataAtual)){
                 throw new EmptyStackException();//Recebimento vencido
            }
            this.dataValidade = dataValidade;
            return this;
        }
        public RecebimentosBuilder setRecebimento(LocalDate dataRecebimento){
            if(dataRecebimento.isAfter(dataAtual)){
                throw new ExceptionInInitializerError();
            }
            this.dataRecebimento = dataRecebimento;
            return this;
        }
         public Recebimentos construir(){
            return new Recebimentos(this);
        }
    }
}
