package application;

import model.entities.automovel.Automovel;
import model.entities.automovel.Caminhao;
import model.entities.automovel.Carro;
import model.entities.automovel.Moto;
import model.enums.*;

import java.util.ArrayList;
import java.util.List;

public class ProgramaPrincipal {

    public static void main(String[] args) {

        List<Automovel> meusAutomoveis = new ArrayList<>();

        System.out.println(Automovel.getMarcasPeloTipo(Automovel.TipoAutomovel.CARRO));

        Automovel carro = new Carro("Clio EXP1016VH", MarcaCarro.RENAULT, 2013,
                2014, AutomovelCombustivel.GASOLINA, "AWS2397", "8A1BB8215EL90342",
                "00529097974");

        System.out.println(Automovel.getMarcasPeloTipo(Automovel.TipoAutomovel.MOTO));

        Automovel moto = new Moto("CG125 Today", MarcaMoto.HONDA, 1993,
                1993, AutomovelCombustivel.GASOLINA, "MAH0944", "9C2JC1801PRP03692",
                "00548099383");

        System.out.println(Automovel.getMarcasPeloTipo(Automovel.TipoAutomovel.CAMINHAO));

        Automovel caminhao = new Caminhao("Scania R540", MarcaCaminhao.SCANIA, 2019,
                2020, AutomovelCombustivel.DIESEL, "MGT3470", "9C2JC1801SCB04952",
                "00548098485");

        meusAutomoveis.add(carro);
        meusAutomoveis.add(moto);
        meusAutomoveis.add(caminhao);

        for (Automovel i : meusAutomoveis) {
            System.out.println(i.getNomeModelo() + " - " + i.getTipoAutomovel());
        }
    }
}
