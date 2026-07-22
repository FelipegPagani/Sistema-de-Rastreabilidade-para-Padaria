package padaria.repository;

import padaria.model.LoteIngrediente;
import padaria.repository.Persistencia.LoteIngredientePersistencia;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class LoteIngredienteRepository implements RepositoryInterface<LoteIngrediente> {

    private List<LoteIngrediente> lotesIngredientes;
    LoteIngredientePersistencia persistir = new LoteIngredientePersistencia();

    public LoteIngredienteRepository() {
        this.lotesIngredientes = persistir.carregarLotesIngredientes();
    }

    @Override
    public void adicionar(LoteIngrediente loteIngrediente) {

        if (loteIngrediente == null) {
            throw new IllegalArgumentException("Lote inválido");
        }

        lotesIngredientes.add(loteIngrediente);
        persistir.salvarLotesIngredientes(lotesIngredientes);
    }

    @Override
    public List<LoteIngrediente> listar() {

        if (lotesIngredientes.isEmpty()) {
            throw new IllegalStateException("Nenhum lote cadastrado");
        }

        return new ArrayList<LoteIngrediente>(lotesIngredientes);
    }

    @Override
    public LoteIngrediente buscar(String nome) {

        if (lotesIngredientes.isEmpty()) {
            throw new IllegalStateException("Nenhum lote cadastrado");
        }
        for (LoteIngrediente lote : lotesIngredientes) {
            if (lote.getNome().equalsIgnoreCase(nome)) {
                return lote;
            }
        }
        throw new NoSuchElementException("Lote não encontrado");
    }

        public List<LoteIngrediente> buscarPorIngrediente(String nomeIngrediente){

        List<LoteIngrediente> encontrados = new ArrayList<>();

        for(LoteIngrediente lote : lotesIngredientes){

            if(lote.getIngredientes().getNome().equalsIgnoreCase(nomeIngrediente)){

                encontrados.add(lote);
            }
        }

        return encontrados;
    }
    
    @Override
    public void excluir(String nome) {

        LoteIngrediente encontrado = null;

        if (lotesIngredientes.isEmpty()) {
            throw new IllegalStateException("Nenhum lote cadastrado");
        }

        for (LoteIngrediente lote : lotesIngredientes) {

            if (lote.getNome().equalsIgnoreCase(nome)) {
                encontrado = lote;
            }
        }

        if (encontrado == null) {
            throw new NoSuchElementException("Lote não encontrado");
        }

        lotesIngredientes.remove(encontrado);
        persistir.salvarLotesIngredientes(lotesIngredientes);
    }
}