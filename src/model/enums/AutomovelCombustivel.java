package model.enums;

public enum AutomovelCombustivel {

    ALCOOL("Álcool", "litro(s)"),
    DIESEL("Diesel", "litro(s)"),
    GAS("GNV", "m³"),
    GASOLINA("Gasolina", "litro(s)");

    private String tipoCombustivel;
    private String unidadeMedida;

    AutomovelCombustivel(String tipoCombustivel, String unidadeMedida) {
        this.tipoCombustivel = tipoCombustivel;
        this.unidadeMedida = unidadeMedida;
    }

    public String getTipoCombustivel() {
        return tipoCombustivel;
    }

    public String getUnidadeMedida() {
        return this.unidadeMedida;
    }
}
