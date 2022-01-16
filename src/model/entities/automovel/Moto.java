package model.entities.automovel;

import model.enums.*;

public class Moto extends Automovel {

    private final MarcaMoto marca;

    public Moto(String nomeModelo, MarcaMoto marca, Integer anoFabricacao, Integer anoModelo,
                AutomovelCombustivel combustivel, String placa, String chassi, String renavam) {
        super(nomeModelo, anoFabricacao, anoModelo, combustivel, placa, chassi, renavam);
        this.marca = marca;
    }

    public Moto(String nomeModelo, MarcaMoto marca, Integer anoFabricacao, Integer anoModelo,
                AutomovelCombustivel combustivel, String placa, String chassi, String renavam,
                AutomovelCategoria categoriaUso, String potenciaCilindrada) {
        super(nomeModelo, anoFabricacao, anoModelo, combustivel, placa, chassi, renavam,
              categoriaUso, potenciaCilindrada);
        this.marca = marca;
    }

    public MarcaMoto getMarca() {
        return marca;
    }

    public Automovel.TipoAutomovel getTipoAutomovel(){
        return TipoAutomovel.MOTO;
    }

}
