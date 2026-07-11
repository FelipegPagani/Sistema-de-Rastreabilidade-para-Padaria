package padaria.service;

import java.util.List;

import padaria.model.LoteProducao;
import padaria.repository.LoteProducaoRepository;

public class LoteProducaoService {

    private LoteProducaoRepository loteProducaoRepository;

    public LoteProducaoService(LoteProducaoRepository loteProducaoRepository) {
        this.loteProducaoRepository = loteProducaoRepository;
    }

    public void adicionar(LoteProducao loteProducao) {
        loteProducaoRepository.adicionar(loteProducao);
    }

    public List<LoteProducao> listar() {
        return loteProducaoRepository.listar();
    }

    public void excluir(String nome) {
        loteProducaoRepository.excluir(nome);
    }

    public LoteProducao buscarViaNome(String nome) {
        return loteProducaoRepository.buscar(nome);
    }
}