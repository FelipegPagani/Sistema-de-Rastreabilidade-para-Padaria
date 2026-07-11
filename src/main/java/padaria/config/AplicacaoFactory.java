package padaria.config;

import padaria.controller.*;
import padaria.repository.*;
import padaria.service.FornecedoresService;
import padaria.service.IngredientesService;
import padaria.service.ProdutoService;
import padaria.service.RastrearService;
import padaria.service.RecebimentosService;
import padaria.service.ClientesService;
import padaria.service.LoteIngredienteService;
import padaria.service.LoteProducaoService;

public class AplicacaoFactory {

    private ProdutoController produtoController;
    private FornecedorController fornecedorController;
    private IngredientesController ingredientesController;
    private RecebimentosController recebimentosController;
    private RastrearController rastrearController;
    private ClientesController clientesController;
    private LoteIngredienteController loteIngredienteController;
    private LoteProducaoController loteProducaoController;
    private LoteProducaoRepository loteProducaoRepository;

    public ProdutoController getProdutoController() {
        if (produtoController == null) {
            produtoController = criarProdutoController();
        }

        return produtoController;
    }

    private ProdutoController criarProdutoController() {
        ProdutosRepository produtoRepository = criarProdutoRepository();
        ProdutoService produtoService = new ProdutoService(produtoRepository);

        return new ProdutoController(produtoService);
    }

    private ProdutosRepository criarProdutoRepository() {
        return new ProdutosRepository();
    }

    public IngredientesController getIngredientesController() {
        if (ingredientesController == null) {
            ingredientesController = criarIngredientesController();
        }

        return ingredientesController;
    }

    private IngredientesController criarIngredientesController() {
        IngredientesRepository ingredientesRepository = criarIngredientesRepository();
        IngredientesService ingredientesService = new IngredientesService(ingredientesRepository);

        return new IngredientesController(ingredientesService);
    }

    private IngredientesRepository criarIngredientesRepository() {
        return new IngredientesRepository();
    }

    public FornecedorController getFornecedorController() {
        if (fornecedorController == null) {
            fornecedorController = criarFornecedorController();
        }

        return fornecedorController;
    }

    private FornecedorController criarFornecedorController() {
        FornecedoresRepository fornecedoresRepository = criaFornecedoresRepository();
        FornecedoresService fornecedoresService = new FornecedoresService(fornecedoresRepository);

        return new FornecedorController(fornecedoresService);
    }

    private FornecedoresRepository criaFornecedoresRepository() {
        return new FornecedoresRepository();
    }

    public RecebimentosController getRecebimentosController() {
        if (recebimentosController == null) {
            recebimentosController = criaRecebimentosController();
        }
        return recebimentosController;
    }

    private RecebimentosController criaRecebimentosController() {
        RecebimentosRepository recebimentosRepository = criaRecebimentoRepository();
        RecebimentosService recebimentosService = new RecebimentosService(recebimentosRepository);

        return new RecebimentosController(recebimentosService);
    }

    private RecebimentosRepository criaRecebimentoRepository() {
        return new RecebimentosRepository();
    }

    public RastrearController getRastrearController() {
        if (rastrearController == null) {
            rastrearController = criarRastrearController();
        }

        return rastrearController;
    }

    private RastrearController criarRastrearController() {
        LoteProducaoRepository loteProducaoRepository = criarLoteProducaoRepository();
        RastrearService rastrearService = new RastrearService(loteProducaoRepository);

        LoteIngredienteService loteIngredienteService = new LoteIngredienteService(criarLoteIngredienteRepository());

        return new RastrearController(rastrearService, loteIngredienteService);
    }

    private LoteProducaoRepository criarLoteProducaoRepository() {
        if (loteProducaoRepository == null) {
            loteProducaoRepository = new LoteProducaoRepository();
        }

        return loteProducaoRepository;
    }

    private LoteIngredienteRepository criarLoteIngredienteRepository() {
         return new LoteIngredienteRepository();
    }

    public ClientesController getClientesController() {
        if (clientesController == null) {
            clientesController = criarClientesController();
        }
        return clientesController;
    }

    private ClientesController criarClientesController() {
        ClientesRepository clientesRepository = new ClientesRepository();
        ClientesService clientesService = new ClientesService(clientesRepository);

        return new ClientesController(clientesService);
    }

    public LoteIngredienteController getLoteIngredienteController() {
        if (loteIngredienteController == null) {
            loteIngredienteController = criarLoteIngredienteController();
        }
        return loteIngredienteController;
    }

    private LoteIngredienteController criarLoteIngredienteController() {
        LoteIngredienteRepository loteIngredienteRepository = criarLoteIngredienteRepository();
        LoteIngredienteService loteIngredienteService = new LoteIngredienteService(loteIngredienteRepository);

        return new LoteIngredienteController(loteIngredienteService);
    }

    public LoteProducaoController getLoteProducaoController() {
        if (loteProducaoController == null) {
            loteProducaoController = criarLoteProducaoController();
        }
        return loteProducaoController;
    }

    private LoteProducaoController criarLoteProducaoController() {
        LoteProducaoRepository loteProducaoRepository = criarLoteProducaoRepository();
        LoteProducaoService loteProducaoService = new LoteProducaoService(loteProducaoRepository);

        return new LoteProducaoController(loteProducaoService);
    }
}