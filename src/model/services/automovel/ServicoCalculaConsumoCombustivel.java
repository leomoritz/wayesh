package model.services.automovel;

import model.entities.abastecimento.Abastecimento;
import model.entities.automovel.Automovel;
import model.services.abastecimento.ServicoAbastecimento;

import java.time.LocalDate;
import java.time.Month;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ServicoCalculaConsumoCombustivel {

    /**
     * Método que calcula a média do total de consumo de combustível dos últimos meses
     *
     * @return a média mensal de consumo (kilômetros por litro/m³)
     */

    public static double calculaMediaTotalConsumoCombustivelUltimosMeses(Automovel automovel, int qtdUltimosMeses) {
        return calculaTotalConsumoUltimosMeses(automovel, qtdUltimosMeses) / qtdUltimosMeses;
    }

    /**
     * Métodos que calculam o total de consumo de combustível do mês escolhido.
     *
     * @param automovel para buscar a kilometragem rodada do automóvel conforme mês escolhido.
     * @param mes       é utilizado como filtro para encontrar a kilometragem rodada no mês.
     * @return retornam a quantidade de litros/m³ conforme a quantidade de kilometros rodados no mês escolhido.
     */

    public static double calculaTotalConsumoPorMes(Automovel automovel, Month mes) {
        return
                getKmRodadosPorMes(automovel, mes)
                        / ServicoAbastecimento.calculaTotalLitrosAbastecidoPorMes(automovel, mes);
    }

    public static double calculaTotalConsumoMesAnterior(Automovel automovel) {
        return
                getKmRodadosMesAnterior(automovel)
                        / ServicoAbastecimento.calculaTotalLitrosAbastecidoMesAnterior(automovel);
    }

    public static double calculaTotalConsumoMesAtual(Automovel automovel) {
        return
                getKmRodadosMesAtual(automovel)
                        / ServicoAbastecimento.calculaTotalLitrosAbastecidoMesAtual(automovel);
    }

    public static double calculaTotalConsumoUltimosMeses(Automovel automovel, int qtdUltimosMeses) {
        return getKmRodadosUltimosMeses(automovel, qtdUltimosMeses) /
                ServicoAbastecimento.calculaTotalLitrosAbastecidoUltimosMeses(automovel, qtdUltimosMeses);
    }


    /**
     * Métodos que retornam a quantidade de kilometros rodados no mês escolhido
     */

    public static double getKmRodadosPorMes(Automovel automovel, Month mes) {
        double somaKmRodados = 0.0;

        for (Map.Entry<LocalDate, Double> entrada : automovel.getKmRodadoPorMes().entrySet()) {
            if (entrada.getKey().getMonth() == mes) {
                somaKmRodados += entrada.getValue();
            }
        }

        return somaKmRodados;
    }

    public static double getKmRodadosMesAnterior(Automovel automovel) {
        double somaKmRodados = 0.0;

        for (Map.Entry<LocalDate, Double> entrada : automovel.getKmRodadoPorMes().entrySet()) {
            if (entrada.getKey().getMonth() == LocalDate.now().getMonth().minus(1)) {
                somaKmRodados += entrada.getValue();
            }
        }
        return somaKmRodados;
    }

    public static double getKmRodadosMesAtual(Automovel automovel) {
        double somaKmRodados = 0.0;

        for (Map.Entry<LocalDate, Double> entrada : automovel.getKmRodadoPorMes().entrySet()) {
            if (entrada.getKey().getMonth() == LocalDate.now().getMonth()) {
                somaKmRodados += entrada.getValue();
            }
        }
        return somaKmRodados;
    }


    public static double getKmRodadosUltimosMeses(Automovel automovel, int qtdUltimosMeses) {
        double somaKmRodados = 0.0;

        for (int i = 0; i <= qtdUltimosMeses; i++) {
            somaKmRodados += getKmRodadosPorMes(automovel, LocalDate.now().getMonth().minus(i));
        }

        return somaKmRodados;
    }
}
