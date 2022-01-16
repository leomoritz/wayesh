package model.entities.automovel;

import model.enums.*;

public class Carro extends Automovel {

    private final MarcaCarro marca;

    public Carro(String nomeModelo, MarcaCarro marca, Integer anoFabricacao, Integer anoModelo,
                 AutomovelCombustivel combustivel, String placa, String chassi, String renavam) {
        super(nomeModelo, anoFabricacao, anoModelo, combustivel, placa, chassi, renavam);
        this.marca = marca;
    }

    public Carro(String nomeModelo, MarcaCarro marca, Integer anoFabricacao, Integer anoModelo,
                 AutomovelCombustivel combustivel, String placa, String chassi, String renavam,
                 AutomovelCategoria categoriaUso, String potenciaCilindrada) {
        super(nomeModelo, anoFabricacao, anoModelo, combustivel, placa, chassi, renavam,
              categoriaUso, potenciaCilindrada);
        this.marca = marca;
    }

    public MarcaCarro getMarca() {
        return marca;
    }

    public Automovel.TipoAutomovel getTipoAutomovel(){
        return TipoAutomovel.CARRO;
    }

}
