package model.entities.automovel;

import model.enums.*;

import java.util.Map;
import java.util.Set;

public class Carro extends Automovel {

    private final MarcaCarro marca;

    public Carro(String nomeModelo, Integer anoFabricacao, Integer anoModelo, String placa, String chassi,
                 String renavam, Set<AutomovelCombustivel> tipoCombustivel, Double qtdKmParaRevisao,
                 Integer qtdMesesParaRevisao, Map<AutomovelCombustivel, Double> limiteReservatorioPorCombustivel,
                 Map<AutomovelCombustivel, Double> mediaKmRodoviaPorCombustivel, AutomovelCategoria categoriaUso,
                 Integer potencia, Integer cilindrada, MarcaCarro marca) {
        super(nomeModelo, anoFabricacao, anoModelo, placa, chassi, renavam, tipoCombustivel, qtdKmParaRevisao,
              qtdMesesParaRevisao, limiteReservatorioPorCombustivel, mediaKmRodoviaPorCombustivel, categoriaUso,
              potencia, cilindrada);
        this.marca = marca;
    }

    public Carro(String nomeModelo, Integer anoFabricacao, Integer anoModelo,
                 Set<AutomovelCombustivel> tipoCombustivel, String placa, String chassi, String renavam,
                 Double qtdKmParaRevisao, Integer qtdMesesParaRevisao,
                 Map<AutomovelCombustivel, Double> limiteReservatorioPorCombustivel, Map<AutomovelCombustivel,
            Double> mediaKmRodoviaPorCombustivel, MarcaCarro marca) {
        super(nomeModelo, anoFabricacao, anoModelo, tipoCombustivel, placa, chassi, renavam, qtdKmParaRevisao,
              qtdMesesParaRevisao, limiteReservatorioPorCombustivel, mediaKmRodoviaPorCombustivel);
        this.marca = marca;
    }

    public MarcaCarro getMarca() {
        return marca;
    }

    public Automovel.TipoAutomovel getTipoAutomovel() {
        return TipoAutomovel.CARRO;
    }

}
