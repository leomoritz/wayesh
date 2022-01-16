package model.entities.automovel;

import model.enums.*;

public class Caminhao extends Automovel {

    private final MarcaCaminhao marca;

    public Caminhao(String nomeModelo, MarcaCaminhao marca, Integer anoFabricacao, Integer anoModelo,
                    AutomovelCombustivel combustivel, String placa, String chassi, String renavam) {
        super(nomeModelo, anoFabricacao, anoModelo, combustivel, placa, chassi, renavam);
        this.marca = marca;
    }

    public Caminhao(String nomeModelo, MarcaCaminhao marca, Integer anoFabricacao, Integer anoModelo,
                    AutomovelCombustivel combustivel, String placa, String chassi, String renavam,
                    AutomovelCategoria categoriaUso, String potenciaCilindrada) {
        super(nomeModelo, anoFabricacao, anoModelo, combustivel, placa, chassi, renavam,
              categoriaUso, potenciaCilindrada);
        this.marca = marca;
    }

    public MarcaCaminhao getMarca() {
        return marca;
    }

    public Automovel.TipoAutomovel getTipoAutomovel(){
        return TipoAutomovel.CAMINHAO;
    }

}
