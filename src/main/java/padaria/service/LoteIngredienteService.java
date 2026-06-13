package padaria.service;

import java.util.List;

import padaria.model.LoteIngrediente;
import padaria.repository.LoteIngredienteRepository;

public class LoteIngredienteService {

    private LoteIngredienteRepository loteIngredienteRepository;

    public LoteIngredienteService() {
        this.loteIngredienteRepository = new LoteIngredienteRepository();
    }

    public void cadastrarLoteIngrediente(int id, String nome) {

        LoteIngrediente loteIngrediente = LoteIngrediente.builder()
                .setId(id)
                .setNome(nome)
                .construir();

        loteIngredienteRepository.adicionar(loteIngrediente);
    }

    public List<LoteIngrediente> listarLotesIngredientes() {
        return loteIngredienteRepository.listar();
    }

    public Object buscarLoteIngrediente(String nome) {
        return loteIngredienteRepository.buscar(nome);
    }

    public void excluirLoteIngrediente(String nome) {
        loteIngredienteRepository.excluir(nome);
    }
}