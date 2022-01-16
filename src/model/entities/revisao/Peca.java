package model.entities.revisao;

public class Peca {

    private String nomePeca;
    private Double valorPeca;

    public Peca(String nomePeca, Double valorPeca) {
        this.nomePeca = nomePeca;
        this.valorPeca = valorPeca;
    }

    public String getNomePeca() {
        return nomePeca;
    }

    public void setNomePeca(String nomePeca) {
        this.nomePeca = nomePeca;
    }

    public Double getValorPeca() {
        return valorPeca;
    }

    public void setValorPeca(Double valorPeca) {
        this.valorPeca = valorPeca;
    }
}
