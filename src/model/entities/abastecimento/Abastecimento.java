package model.entities.abastecimento;

import java.time.LocalDate;

public class Abastecimento {

    private final Double qtdLitros;
    private final Double valorAbastecimento;
    private final Double kilometragemAtual;
    private final LocalDate dataAbastecimento;
    private LocalDate dataUltimoAbastecimento;

    public Abastecimento(Double qtdLitros, Double valorAbastecimento, Double kilometragemAtual,
                         LocalDate dataAbastecimento) {
        this.qtdLitros = qtdLitros;
        this.valorAbastecimento = valorAbastecimento;
        this.kilometragemAtual = kilometragemAtual;
        this.dataAbastecimento = dataAbastecimento;
    }

    public Double getQtdLitros() {
        return qtdLitros;
    }

    public Double getValorAbastecimento() {
        return valorAbastecimento;
    }

    public Double getKilometragemAtual() {
        return kilometragemAtual;
    }

    public LocalDate getDataAbastecimento() {
        return dataAbastecimento;
    }

    public LocalDate getDataUltimoAbastecimento() {
        return dataUltimoAbastecimento;
    }

    public void setDataUltimoAbastecimento(LocalDate dataUltimoAbastecimento) {
        this.dataUltimoAbastecimento = dataUltimoAbastecimento;
    }
}
