package application;

import model.entities.abastecimento.Abastecimento;
import model.entities.automovel.Automovel;
import model.entities.automovel.Carro;
import model.enums.AutomovelCombustivel;
import model.enums.MarcaCarro;
import model.services.abastecimento.ServicoAbastecimento;
import model.services.automovel.ServicoCalculaConsumoCombustivel;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class ProgramaPrincipalServicoAbastecimento {

    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        Scanner sc = new Scanner(System.in);

        //System.out.println(Automovel.getMarcasPeloTipo(Automovel.TipoAutomovel.CARRO));

        Set<AutomovelCombustivel> tipoCombustivel = new TreeSet<>();
        Map<AutomovelCombustivel, Double> limiteReservatorioPorCombustivel = new HashMap<>();
        Map<AutomovelCombustivel, Double> mediaKmRodoviaPorCombustivel = new HashMap<>();

        tipoCombustivel.add(AutomovelCombustivel.GASOLINA);
        tipoCombustivel.add(AutomovelCombustivel.ALCOOL);

        limiteReservatorioPorCombustivel.put(AutomovelCombustivel.ALCOOL, 50.0);
        mediaKmRodoviaPorCombustivel.put(AutomovelCombustivel.ALCOOL, 11.06);
        limiteReservatorioPorCombustivel.put(AutomovelCombustivel.GASOLINA, 50.0);
        mediaKmRodoviaPorCombustivel.put(AutomovelCombustivel.GASOLINA, 15.80);


        Automovel carro = new Carro("Clio EXP1016VH", 2013, 2014,
                                    tipoCombustivel, "AWS2397",
                                    "8A1BB8215EL90342",
                                    "00529097974", 10000.0, 12,
                                    limiteReservatorioPorCombustivel, mediaKmRodoviaPorCombustivel,
                                    MarcaCarro.RENAULT);
        String dia;
        for (int i = 1; i <= 9; i++) {
            dia = "0" + i + "/11/2021";
            carro.getKmRodadoPorMes().put(LocalDate.parse(dia, dtf), 13.0);
        }

        for (int i = 10; i <= 30; i++) {
            dia = i + "/11/2021";
            carro.getKmRodadoPorMes().put(LocalDate.parse(dia, dtf), 13.0);
        }

        for (int i = 1; i <= 9; i++) {
            dia = "0" + i + "/12/2021";
            carro.getKmRodadoPorMes().put(LocalDate.parse(dia, dtf), 10.0);
        }

        for (int i = 10; i <= 31; i++) {
            dia = i + "/12/2021";
            carro.getKmRodadoPorMes().put(LocalDate.parse(dia, dtf), 10.0);
        }

        for (int i = 1; i <= 9; i++) {
            dia = "0" + i + "/01/2022";
            carro.getKmRodadoPorMes().put(LocalDate.parse(dia, dtf), 10.0);
        }

        for (int i = 10; i <= 19; i++) {
            dia = i + "/01/2022";
            carro.getKmRodadoPorMes().put(LocalDate.parse(dia, dtf), 10.0);
        }

        carro.getUltimosAbastecimentos()
             .add(new Abastecimento(50.0, 333.0, LocalDate.parse("05/11/2021", dtf)));

        carro.getUltimosAbastecimentos()
             .add(new Abastecimento(15.0, 99.9, LocalDate.parse("25/11/2021", dtf)));

        carro.getUltimosAbastecimentos()
             .add(new Abastecimento(50.0, 333.0, LocalDate.parse("20/12/2021", dtf)));

        carro.getUltimosAbastecimentos()
             .add(new Abastecimento(20.0, 133.2, LocalDate.parse("15/01/2022", dtf)));

        System.out.println("CALCULA TOTAL GASTO COM COMBUSTIVEL");

        System.out.println("Total Gasto Novembro: "
                                   + ServicoAbastecimento.calculaTotalGastoAbastecimentoPorMes(carro, Month.NOVEMBER));
        System.out.println("Total Gasto Dezembro: "
                                   + ServicoAbastecimento.calculaTotalGastoAbastecimentoMesAnterior(carro));

        System.out.println("Total Gasto Janeiro(atual): "
                                   + ServicoAbastecimento.calculaTotalGastoAbastecimentoMesAtual(carro));

        System.out.println("Total Gasto Ultimos 3 Meses: "
                                   + ServicoAbastecimento
                .calculaTotalGastoAbastecimentoUltimosMeses(carro, 3));

        System.out.println("Média total gasto últimos 3 meses: "
                                   + ServicoAbastecimento
                .calculaMediaAbastecimentoUltimosMeses(carro, 3));

        System.out.println("\nCALCULA QUANTIDADE LITROS/M³ ABASTECIDOS");

        System.out.println("Total Litros/m³ Abastecidos em Novembro: "
                                   + ServicoAbastecimento.calculaTotalLitrosAbastecidoPorMes(carro, Month.NOVEMBER));
        System.out.println("Total Litros/m³ Abastecidos em Dezembro:  "
                                   + ServicoAbastecimento.calculaTotalLitrosAbastecidoMesAnterior(carro));

        System.out.println("Total Litros/m³ Abastecidos em Janeiro(atual): "
                                   + ServicoAbastecimento.calculaTotalLitrosAbastecidoMesAtual(carro));

        System.out.println("Total Litros/m³ Abastecidos nos últimos 3 meses: "
                                   + ServicoAbastecimento
                .calculaTotalLitrosAbastecidoUltimosMeses(carro, 3));


        System.out.println("\nQUANTIDADE DE ABASTECIMENTOS");

        System.out.println("Quantidade de abastecimentos em Novembro: "
                                   + ServicoAbastecimento.getQtdAbastecimentosPorMes(carro, Month.NOVEMBER));
        System.out.println("Quantidade de abastecimentos em Dezembro:  "
                                   + ServicoAbastecimento.getQtdAbastecimentoMesAnterior(carro));

        System.out.println("Quantidade de abastecimentos em Janeiro(atual): "
                                   + ServicoAbastecimento.getQtdAbastecimentoMesAtual(carro));

        System.out.println("Quantidade de abastecimentos nos últimos 3 meses: "
                                   + ServicoAbastecimento
                .getQtdAbastecimentoUltimosMeses(carro, 3));

        System.out.println("\nLISTA ABASTECIMENTOS");

        System.out.println("\nAbastecimentos de Novembro: ");
        for (Abastecimento abastecimento : ServicoAbastecimento.getListaAbastecimentosPorMes(carro, Month.NOVEMBER)) {
            System.out.println(abastecimento);
        }

        System.out.println("\nAbastecimentos de Dezembro: ");
        for (Abastecimento abastecimento : ServicoAbastecimento.getListaAbastecimentosMesAnterior(carro)) {
            System.out.println(abastecimento);
        }

        System.out.println("\nAbastecimentos de Janeiro(atual): ");
        for (Abastecimento abastecimento : ServicoAbastecimento.getListaAbastecimentosMesAtual(carro)) {
            System.out.println(abastecimento);
        }


        System.out.println("\nCALCULA TOTAL CONSUMO COMBUSTIVEL");
        System.out.println("Total Consumo Combustível Novembro: " +
                                   ServicoCalculaConsumoCombustivel.calculaTotalConsumoPorMes(carro, Month.NOVEMBER));
        System.out.println("Total Consumo Combustível Dezembro: " +
                                   ServicoCalculaConsumoCombustivel.calculaTotalConsumoMesAnterior(carro));
        System.out.println("Total Consumo Combustível Janeiro(atual): " +
                                   ServicoCalculaConsumoCombustivel.calculaTotalConsumoMesAtual(carro));
        System.out.println("Total Consumo Combustível Últimos 3 Meses: " +
                                   ServicoCalculaConsumoCombustivel
                                           .calculaTotalConsumoUltimosMeses(carro, 3));
        System.out.println("Média Consumo Combustível Últimos 3 Meses: " +
                                   ServicoCalculaConsumoCombustivel
                                           .calculaMediaTotalConsumoCombustivelUltimosMeses(carro, 3));

        System.out.println("\nCALCULA KMS RODADOS");
        System.out.println("Total KMs Rodados em Novembro: " +
                                   ServicoCalculaConsumoCombustivel.getKmRodadosPorMes(carro, Month.NOVEMBER));
        System.out.println("Total KMs Rodados em Dezembro: " +
                                   ServicoCalculaConsumoCombustivel.getKmRodadosMesAnterior(carro));
        System.out.println("Total KMs Rodados em Janeiro(atual): " +
                                   ServicoCalculaConsumoCombustivel.getKmRodadosMesAtual(carro));
        System.out.println("Total KMs Rodados nos Últimos 3 Meses: " +
                                   ServicoCalculaConsumoCombustivel.getKmRodadosUltimosMeses(carro, 3));


    }
}
