package application;

import model.entities.automovel.Automovel;
import model.entities.automovel.Carro;
import model.entities.viagem.Viagem;
import model.enums.*;
import model.services.viagem.ServicoCalculaViagem;

import java.util.*;

public class ProgramaPrincipal {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);

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

        carro.addTipoCombustivel(AutomovelCombustivel.GAS);
        carro.addLimiteReservatorioPorCombustivel(AutomovelCombustivel.GAS, 15.0);
        carro.addMediaKmRodoviaPorCombustivel(AutomovelCombustivel.GAS, carro
                .getMediaKmRodoviaPorCombustivel()
                .get(AutomovelCombustivel.GASOLINA) * 1.3);


        System.out.println("\nTipo(s) de Combustivel(is) do veículo " + carro.getNomeModelo() + ": ");
        for (AutomovelCombustivel tipo : carro.getTipoCombustivel()) {
            System.out.println(tipo.name());
        }

        System.out.println("\nMédia de KMs feito na rodovia pelo veículo " + carro.getNomeModelo() + ": ");

        for (Map.Entry<AutomovelCombustivel, Double> entrada : carro.getMediaKmRodoviaPorCombustivel().entrySet()) {
            System.out.println(entrada.getKey() + " - " + entrada.getValue());
        }

        System.out.println("\nLimite do reservatório do veículo " + carro.getNomeModelo() + ": ");
        for (Map.Entry<AutomovelCombustivel, Double> entrada : carro.getLimiteReservatorioPorCombustivel().entrySet()) {
            System.out.println(entrada.getKey() + " - " + entrada.getValue());
        }

         /*
        System.out.println(Automovel.getMarcasPeloTipo(Automovel.TipoAutomovel.MOTO));

        Automovel moto = new Moto("CG125 Today", MarcaMoto.HONDA, 1993,
                                  1993, AutomovelCombustivel.GASOLINA, "MAH0944", "9C2JC1801PRP03692",
                                  "00548099383");

        System.out.println(Automovel.getMarcasPeloTipo(Automovel.TipoAutomovel.CAMINHAO));

        Automovel caminhao = new Caminhao("Scania R540", MarcaCaminhao.SCANIA, 2019,
                                          2020, AutomovelCombustivel.DIESEL, "MGT3470", "9C2JC1801SCB04952",
                                          "00548098485");*/

        List<Automovel> meusAutomoveis = new ArrayList<>();
        meusAutomoveis.add(carro);
        // meusAutomoveis.add(moto);
        // meusAutomoveis.add(caminhao);

        System.out.println("\nMeus Veículos: ");
        for (Automovel i : meusAutomoveis) {
            System.out.println(i.getNomeModelo() + " - " + i.getTipoAutomovel());
        }

        System.out.println("\n------------------------------------");

        Viagem minhaPrimeiraViagem = new Viagem(carro, "Blumenau/SC", "São Paulo/SC", 1197.20,
                                                AutomovelCombustivel.GASOLINA, 6.620);

        System.out.println("\nCALCULAR GASTO VIAGEM PELO COMBUSTIVEL ESCOLHIDO: ");
        ServicoCalculaViagem.calculaGastoViagem(minhaPrimeiraViagem);
        System.out.println(minhaPrimeiraViagem);

        System.out.println("\nMUDAR TIPO DE COMBUSTÍVEL DA VIAGEM E RECALCULAR: ");
        if (minhaPrimeiraViagem.setCombustivelUtilizado(AutomovelCombustivel.GAS)) {
            minhaPrimeiraViagem.setPrecoCombustivel(3.79);
            ServicoCalculaViagem.calculaGastoViagem(minhaPrimeiraViagem);
            System.out.println(minhaPrimeiraViagem);
        } else {
            System.out.println("O automóvel escolhido para a viagem não possui o tipo de combustível informado!");
        }

        System.out.println("\nMUDAR TIPO DE COMBUSTÍVEL DA VIAGEM E RECALCULAR: ");
        if (minhaPrimeiraViagem.setCombustivelUtilizado(AutomovelCombustivel.ALCOOL)) {
            minhaPrimeiraViagem.setPrecoCombustivel(5.922);
            ServicoCalculaViagem.calculaGastoViagem(minhaPrimeiraViagem);
            System.out.println(minhaPrimeiraViagem);
        } else {
            System.out.println("O automóvel escolhido para a viagem não possui o tipo de combustível informado!");
        }


        System.out.println("\nMUDAR TIPO DE COMBUSTÍVEL DA VIAGEM E RECALCULAR: ");
        if (minhaPrimeiraViagem.setCombustivelUtilizado(AutomovelCombustivel.DIESEL)) {
            minhaPrimeiraViagem.setPrecoCombustivel(5.246);
            ServicoCalculaViagem.calculaGastoViagem(minhaPrimeiraViagem);
            System.out.println(minhaPrimeiraViagem);
        } else {
            System.out.println("O automóvel escolhido para a viagem não possui o tipo de combustível informado!");
        }

        sc.close();
    }
}
