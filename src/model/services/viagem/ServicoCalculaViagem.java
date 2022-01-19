package model.services.viagem;

import model.entities.viagem.Viagem;
import model.enums.AutomovelCombustivel;

public final class ServicoCalculaViagem {

    /*
    https://dicasgnv.com.br/2016/01/01/calculadora-do-gnv-como-calcular-a-economia-no-gas/#:~:text=Com%20GNV%2C%20a
    %20unidade%20de,por%20metro%20c%C3%BAbico%20de%20GNV.

    http://gaspoint.com.br/servicos/autonomia.html

    https://www.litoralcar.com.br/preco-combustivel/
     */

    public static Boolean calculaGastoViagem(Viagem viagem) {

        AutomovelCombustivel combustivelUtilizado = viagem.getCombustivelUtilizado();

        if (viagem.getAutomovel().getTipoCombustivel().contains(combustivelUtilizado)) {
            viagem.setCombustivelNecessarioViagem(calculaCombustivelNecessarioViagem(viagem));
            viagem.setTotalPrecoCombustivel(viagem.getCombustivelNecessarioViagem() * viagem.getPrecoCombustivel());
            viagem.setQtdAbastecimentos(calculaQtdAbastecimentosViagem(viagem));
            return true;

        }
        return false;
    }

    public static Double calculaCombustivelNecessarioViagem(Viagem viagem) {
        Double kmTotalViagem = viagem.getKmTotalViagem();
        Double mediaKmVeiculo = viagem.getAutomovel()
                                      .getMediaKmRodoviaPorCombustivel()
                                      .get(viagem.getCombustivelUtilizado());

        return kmTotalViagem / mediaKmVeiculo;
    }

    public static Integer calculaQtdAbastecimentosViagem(Viagem viagem) {
        Double combustivelNecessarioViagem = calculaCombustivelNecessarioViagem(viagem);
        Double limiteReservatorioVeiculo = viagem.getAutomovel()
                                                 .getLimiteReservatorioPorCombustivel()
                                                 .get(viagem.getCombustivelUtilizado());

        return (int) Math.ceil(combustivelNecessarioViagem / limiteReservatorioVeiculo);
    }
}
