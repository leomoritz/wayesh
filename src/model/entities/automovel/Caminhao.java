package model.entities.automovel;

import model.enums.*;

import java.util.Map;
import java.util.Set;

public class Caminhao extends Automovel {

    private final MarcaCaminhao marca;

    public Caminhao(String nomeModelo, Integer anoFabricacao, Integer anoModelo, String placa, String chassi,
                    String renavam, Set<AutomovelCombustivel> tipoCombustivel, Double qtdKmParaRevisao,
                    Integer qtdMesesParaRevisao, Map<AutomovelCombustivel, Double> limiteReservatorioPorCombustivel,
                    Map<AutomovelCombustivel, Double> mediaKmRodoviaPorCombustivel, AutomovelCategoria categoriaUso,
                    Integer potencia, Integer cilindrada, MarcaCaminhao marca) {
        super(nomeModelo, anoFabricacao, anoModelo, placa, chassi, renavam, tipoCombustivel, qtdKmParaRevisao,
              qtdMesesParaRevisao, limiteReservatorioPorCombustivel, mediaKmRodoviaPorCombustivel, categoriaUso,
              potencia, cilindrada);
        this.marca = marca;
    }

    public Caminhao(String nomeModelo, Integer anoFabricacao, Integer anoModelo,
                    Set<AutomovelCombustivel> tipoCombustivel, String placa, String chassi, String renavam,
                    Double qtdKmParaRevisao, Integer qtdMesesParaRevisao,
                    Map<AutomovelCombustivel, Double> limiteReservatorioPorCombustivel, Map<AutomovelCombustivel,
            Double> mediaKmRodoviaPorCombustivel, MarcaCaminhao marca) {
        super(nomeModelo, anoFabricacao, anoModelo, tipoCombustivel, placa, chassi, renavam, qtdKmParaRevisao,
              qtdMesesParaRevisao, limiteReservatorioPorCombustivel, mediaKmRodoviaPorCombustivel);
        this.marca = marca;
    }

    public MarcaCaminhao getMarca() {
        return marca;
    }

    public Automovel.TipoAutomovel getTipoAutomovel() {
        return TipoAutomovel.CAMINHAO;
    }

}
