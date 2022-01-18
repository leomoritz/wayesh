package model.entities.viagem;

import model.entities.automovel.Automovel;
import model.enums.AutomovelCombustivel;

import java.text.Format;

public class Viagem {

    private final Automovel automovel;
    private String origem;
    private String destino;
    private Double kmTotalViagem;
    private AutomovelCombustivel combustivelUtilizado;
    private Double combustivelNecessarioViagem;
    private Double precoCombustivel;
    private Double totalPrecoCombustivel; // Baseado no preco do combustível e na Kilometragem total da viagem
    // por litro
    private Integer qtdAbastecimentos; // Baseado na quantidade de litros que o reservatório de combustível do veículo
    // suporta, média KMs por litro e na Kilometragem total da viagem.


    public Viagem(Automovel automovel, String origem, String destino, Double kmTotalViagem,
                  AutomovelCombustivel combustivelUtilizado, Double precoCombustivel) {
        this.automovel = automovel;
        this.origem = origem;
        this.destino = destino;
        this.kmTotalViagem = kmTotalViagem;
        this.combustivelUtilizado = combustivelUtilizado;
        this.precoCombustivel = precoCombustivel;
    }

    public Automovel getAutomovel() {
        return automovel;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Double getKmTotalViagem() {
        return kmTotalViagem;
    }

    public void setKmTotalViagem(Double kmTotalViagem) {
        this.kmTotalViagem = kmTotalViagem;
    }

    public AutomovelCombustivel getCombustivelUtilizado() {
        return combustivelUtilizado;
    }

    public Boolean setCombustivelUtilizado(AutomovelCombustivel combustivelUtilizado) {
        if (getAutomovel().getTipoCombustivel().contains(combustivelUtilizado)) {
            this.combustivelUtilizado = combustivelUtilizado;
            return true;
        }
        return false;
    }

    public Double getCombustivelNecessarioViagem() {
        return combustivelNecessarioViagem;
    }

    public void setCombustivelNecessarioViagem(Double combustivelNecessarioViagem) {
        this.combustivelNecessarioViagem = combustivelNecessarioViagem;
    }

    public Double getPrecoCombustivel() {
        return precoCombustivel;
    }

    public void setPrecoCombustivel(Double precoCombustivel) {
        this.precoCombustivel = precoCombustivel;
    }

    public Double getTotalPrecoCombustivel() {
        return totalPrecoCombustivel;
    }

    public void setTotalPrecoCombustivel(Double totalPrecoCombustivel) {
        this.totalPrecoCombustivel = totalPrecoCombustivel;
    }

    public Integer getQtdAbastecimentos() {
        return qtdAbastecimentos;
    }

    public void setQtdAbastecimentos(Integer qtdAbastecimentos) {
        this.qtdAbastecimentos = qtdAbastecimentos;
    }

    @Override
    public String toString() {
        return "Dados da Viagem: " +
                "\nAutomovel: " + automovel.getNomeModelo() +
                "\nOrigem (De): " + origem + '\'' +
                "\nDestino (Para): " + destino + '\'' +
                "\nDistância Total (Km): " + kmTotalViagem +
                "\nCombustível: " + combustivelUtilizado.getTipoCombustivel() +
                "\nQtd. Combustível Necessário: " + String.format("%.2f", combustivelNecessarioViagem) + " "
                + combustivelUtilizado.getUnidadeMedida() +
                "\nQtd. Abastecimentos: " + qtdAbastecimentos +
                "\nGasto Total de Combustível: R$" + String.format("%.2f", totalPrecoCombustivel);
    }
}
