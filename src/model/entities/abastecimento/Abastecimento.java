package model.entities.abastecimento;

import java.time.LocalDate;
import java.util.Objects;

public class Abastecimento implements Comparable<Abastecimento> {

    private final Double qtdLitrosAbastecido;
    private final Double valorAbastecimento;
    private final LocalDate dataAbastecimento;

    public Abastecimento(Double qtdLitrosAbastecido, Double valorAbastecimento,
                         LocalDate dataAbastecimento) {
        this.qtdLitrosAbastecido = qtdLitrosAbastecido;
        this.valorAbastecimento = valorAbastecimento;
        this.dataAbastecimento = dataAbastecimento;
    }

    public Double getQtdLitrosAbastecido() {
        return qtdLitrosAbastecido;
    }

    public Double getValorAbastecimento() {
        return valorAbastecimento;
    }

    public LocalDate getDataAbastecimento() {
        return dataAbastecimento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Abastecimento)) return false;
        Abastecimento that = (Abastecimento) o;
        return Objects.equals(getQtdLitrosAbastecido(), that.getQtdLitrosAbastecido()) && Objects.equals(getValorAbastecimento(), that.getValorAbastecimento()) && Objects.equals(getDataAbastecimento(), that.getDataAbastecimento());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getQtdLitrosAbastecido(), getValorAbastecimento(), getDataAbastecimento());
    }

    @Override
    public int compareTo(Abastecimento o) {
        return qtdLitrosAbastecido.compareTo(o.qtdLitrosAbastecido)
                + valorAbastecimento.compareTo(o.valorAbastecimento)
                + dataAbastecimento.compareTo(o.getDataAbastecimento());
    }

    @Override
    public String toString() {
        return "\nData Abastecimento: " + dataAbastecimento +
                "\nQuantidade de Litros/m³ abastecidos: " + qtdLitrosAbastecido +
                "\nValor Abastecimento : R$" + valorAbastecimento;
    }
}
