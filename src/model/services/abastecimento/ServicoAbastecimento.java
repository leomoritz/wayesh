package model.services.abastecimento;

import model.entities.abastecimento.Abastecimento;
import model.entities.automovel.Automovel;

import java.time.LocalDate;
import java.time.Month;
import java.util.Set;
import java.util.stream.Collectors;

public final class ServicoAbastecimento {

    /**
     * Método que calcula a média do total gasto com abastecimento dos últimos meses.
     *
     * @return a média mensal de gastos com abastecimento
     */

    public static double calculaMediaAbastecimentoUltimosMeses(Automovel automovel, int qtdUltimosMeses) {
        return calculaTotalGastoAbastecimentoUltimosMeses(automovel, qtdUltimosMeses) / qtdUltimosMeses;
    }

    /**
     * Métodos que calculam o total gasto com abastecimento no mês escolhido.
     *
     * @param automovel para buscar a lista de abastecimentos do automóvel no mês escolhido.
     * @param mes       é utilizado como filtro para encontrar a os abastecimentos do mês.
     * @return retorna o total gasto com abastecimentos do mês escolhido.
     */

    public static double calculaTotalGastoAbastecimentoPorMes(Automovel automovel, Month mes) {

        double somaValoresAbastecimento = 0.0;

        if (getListaAbastecimentosPorMes(automovel, mes).isEmpty()) {
            return 0.0;
        }

        for (Abastecimento abastecimentoDoMes : getListaAbastecimentosPorMes(automovel, mes)) {
            somaValoresAbastecimento += abastecimentoDoMes.getValorAbastecimento();
        }

        return somaValoresAbastecimento;
    }

    public static double calculaTotalGastoAbastecimentoMesAnterior(Automovel automovel) {

        double somaValoresAbastecimento = 0.0;

        if (getListaAbastecimentosMesAnterior(automovel).isEmpty()) {
            return 0.0;
        }

        for (Abastecimento abastecimentoMesAnterior : getListaAbastecimentosMesAnterior(automovel)) {
            somaValoresAbastecimento += abastecimentoMesAnterior.getValorAbastecimento();
        }
        return somaValoresAbastecimento;
    }

    public static double calculaTotalGastoAbastecimentoMesAtual(Automovel automovel) {

        double somaValoresAbastecimento = 0.0;

        if (getListaAbastecimentosMesAtual(automovel).isEmpty()) {
            return 0.0;
        }

        for (Abastecimento abastecimentoMesAtual : getListaAbastecimentosMesAtual(automovel)) {
            somaValoresAbastecimento += abastecimentoMesAtual.getValorAbastecimento();
        }
        return somaValoresAbastecimento;
    }

    public static double calculaTotalGastoAbastecimentoUltimosMeses(Automovel automovel, int qtdUltimosMeses) {
        double somaValoresAbastecimento = 0.0;
        Month mes = LocalDate.now().getMonth();

        for (int i = 0; i <= qtdUltimosMeses; i++) {
            for (Abastecimento abastecimentoUltimoMes : getListaAbastecimentosPorMes(automovel, mes.minus(i))) {
                somaValoresAbastecimento += abastecimentoUltimoMes.getValorAbastecimento();
            }
        }
        return somaValoresAbastecimento;
    }

    /**
     * Métodos que calculam o total de litros/m³ abastecidos no mês escolhido.
     *
     * @param automovel para buscar a lista de abastecimentos do automóvel no mês escolhido.
     * @param mes       é utilizado como filtro para encontrar a os abastecimentos do mês.
     * @return retornam a quantidade de litros/m³ abastecidos no mês escolhido.
     */

    public static double calculaTotalLitrosAbastecidoPorMes(Automovel automovel, Month mes) {
        double somaLitrosAbastecimento = 0.0;

        if (getListaAbastecimentosPorMes(automovel, mes).isEmpty()) {
            return 0.0;
        }

        for (Abastecimento abastecimentoDoMes : getListaAbastecimentosPorMes(automovel, mes)) {
            somaLitrosAbastecimento += abastecimentoDoMes.getQtdLitrosAbastecido();
        }

        return somaLitrosAbastecimento;
    }

    public static double calculaTotalLitrosAbastecidoMesAnterior(Automovel automovel) {

        double somaLitrosAbastecimento = 0.0;

        if (getListaAbastecimentosMesAnterior(automovel).isEmpty()) {
            return 0.0;
        }

        for (Abastecimento abastecimentoMesAnterior : getListaAbastecimentosMesAnterior(automovel)) {
            somaLitrosAbastecimento += abastecimentoMesAnterior.getQtdLitrosAbastecido();
        }
        return somaLitrosAbastecimento;
    }

    public static double calculaTotalLitrosAbastecidoMesAtual(Automovel automovel) {

        double somaLitrosAbastecimento = 0.0;

        if (getListaAbastecimentosMesAtual(automovel).isEmpty()) {
            return 0.0;
        }

        for (Abastecimento abastecimentoMesAtual : getListaAbastecimentosMesAtual(automovel)) {
            somaLitrosAbastecimento += abastecimentoMesAtual.getQtdLitrosAbastecido();
        }
        return somaLitrosAbastecimento;
    }

    public static double calculaTotalLitrosAbastecidoUltimosMeses(Automovel automovel, int qtdUltimosMeses) {
        double somaLitrosAbastecimento = 0.0;
        Month mes = LocalDate.now().getMonth();

        for (int i = 0; i <= qtdUltimosMeses; i++) {
            for (Abastecimento abastecimentoUltimoMes : getListaAbastecimentosPorMes(automovel, mes.minus(i))) {
                somaLitrosAbastecimento += abastecimentoUltimoMes.getQtdLitrosAbastecido();
            }
        }
        return somaLitrosAbastecimento;
    }

    /**
     * Métodos que retornam a quantidade de vezes que o carro foi abastecido no mês escolhido.
     */

    public static int getQtdAbastecimentosPorMes(Automovel automovel, Month mes) {
        return getListaAbastecimentosPorMes(automovel, mes).size();
    }

    public static int getQtdAbastecimentoMesAnterior(Automovel automovel) {
        return getListaAbastecimentosMesAnterior(automovel).size();
    }

    public static int getQtdAbastecimentoMesAtual(Automovel automovel) {
        return getListaAbastecimentosMesAtual(automovel).size();
    }

    public static int getQtdAbastecimentoUltimosMeses(Automovel automovel, int qtdUltimosMeses) {

        int somaQtdAbastecimentos = 0;
        Month mes = LocalDate.now().getMonth();

        for (int i = 0; i <= qtdUltimosMeses; i++) {
            somaQtdAbastecimentos += getListaAbastecimentosPorMes(automovel, mes.minus(i)).size();
        }

        return somaQtdAbastecimentos;
    }

    /**
     * Métodos que retornam uma lista dos abastecimentos realizados no automóvel conforme mês escolhido
     */

    public static Set<Abastecimento> getListaAbastecimentosMesAnterior(Automovel automovel) {
        Month mesAnterior = LocalDate.now().getMonth().minus(1);
        Set<Abastecimento> abastecimentosMesAnterior =
                automovel.getUltimosAbastecimentos()
                         .stream()
                         .filter(abastecimento -> abastecimento.getDataAbastecimento().getMonth() == mesAnterior)
                         .collect(Collectors.toSet());

        return abastecimentosMesAnterior;
    }

    public static Set<Abastecimento> getListaAbastecimentosPorMes(Automovel automovel, Month mes) {
        Set<Abastecimento> abastecimentosDoMes =
                automovel.getUltimosAbastecimentos()
                         .stream()
                         .filter(abastecimento -> abastecimento.getDataAbastecimento().getMonth() == mes)
                         .collect(Collectors.toSet());

        return abastecimentosDoMes;
    }

    public static Set<Abastecimento> getListaAbastecimentosMesAtual(Automovel automovel) {

        Month mesAtual = LocalDate.now().getMonth();

        Set<Abastecimento> abastecimentosMesAtual =
                automovel.getUltimosAbastecimentos()
                         .stream()
                         .filter(abastecimento -> abastecimento.getDataAbastecimento().getMonth() == mesAtual)
                         .collect(Collectors.toSet());

        return abastecimentosMesAtual;
    }
}
