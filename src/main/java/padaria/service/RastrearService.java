package padaria.service;

import java.util.ArrayList;
import java.util.List;
import padaria.model.LoteIngrediente;
import padaria.model.LoteProducao;
import padaria.repository.LoteProducaoRepository;

public class RastrearService {

    private LoteProducaoRepository loteProducaoRepository;

    public RastrearService(LoteProducaoRepository loteProducaoRepository){
        this.loteProducaoRepository = loteProducaoRepository;
    }

    public List<LoteProducao> buscarProducoesPorLoteIngrediente(String nomeLoteIngrediente) {

        List<LoteProducao> producoesUtilizadas = new ArrayList<>();

        for (LoteProducao loteProducao : loteProducaoRepository.listar()) {

            if (loteProducao.possuiLoteIngrediente(nomeLoteIngrediente)) {
                producoesUtilizadas.add(loteProducao);
            }
        }

        return producoesUtilizadas;
    }

}
