package padaria.repository;

import padaria.model.LoteProducao;
import padaria.repository.Persistencia.LoteProducaoPersistencia;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class LoteProducaoRepository implements RepositoryInterface<LoteProducao> {

    private List<LoteProducao> lotesProducao;
    LoteProducaoPersistencia persistir = new LoteProducaoPersistencia();

    public LoteProducaoRepository() {
        this.lotesProducao = persistir.carregarLotesProducao();
    }

    @Override
    public void adicionar(LoteProducao loteProducao) {

        if (loteProducao == null) {
            throw new IllegalArgumentException("Lote inválido");
        }

        lotesProducao.add(loteProducao);
        persistir.salvarLotesProducao(lotesProducao);
    }

    @Override
    public List<LoteProducao> listar() {

        if (lotesProducao.isEmpty()) {
            throw new IllegalStateException("Nenhum lote cadastrado");
        }

        return new ArrayList<LoteProducao>(lotesProducao);
    }

    @Override
    public void excluir(String nome) {

        LoteProducao encontrado = null;

        if (lotesProducao.isEmpty()) {
            throw new IllegalStateException("Nenhum lote cadastrado");
        }

        for (LoteProducao lote : lotesProducao) {

            if (lote.getNome().equalsIgnoreCase(nome)) {
                encontrado = lote;
            }
        }

        if (encontrado == null) {
            throw new NoSuchElementException("Lote não encontrado");
        }

        lotesProducao.remove(encontrado);
        persistir.salvarLotesProducao(lotesProducao);
    }

    @Override
    public LoteProducao buscar(String nome) {

        if (lotesProducao.isEmpty()) {
            throw new IllegalStateException("Nenhum lote cadastrado");
        }

        for (LoteProducao lote : lotesProducao) {

            if (lote.getNome().equalsIgnoreCase(nome)) {
                return lote;
            }
        }

        throw new NoSuchElementException("Lote não encontrado");
    }
}