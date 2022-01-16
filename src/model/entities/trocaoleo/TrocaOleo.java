package model.entities.trocaoleo;

public class TrocaOleo {

    private final Double kilometragemAtual;
    private Double kilometragemProximaTroca;
    private final Double litrosOleo;
    private final Double precoOleo;
    private final Double precoServicoTroca;
    private final String localTroca;
    private final Boolean trocouFiltroOleo;
    private final Double precoFiltroOleo;

    public TrocaOleo(Double kilometragemAtual, Double litrosOleo, Double precoOleo, Double precoServicoTroca,
                     String localTroca, Boolean trocouFiltroOleo, Double precoFiltroOleo) {
        this.kilometragemAtual = kilometragemAtual;
        this.litrosOleo = litrosOleo;
        this.precoOleo = precoOleo;
        this.precoServicoTroca = precoServicoTroca;
        this.localTroca = localTroca;
        this.trocouFiltroOleo = trocouFiltroOleo;
        this.precoFiltroOleo = precoFiltroOleo;
    }

    public Double getKilometragemAtual() {
        return kilometragemAtual;
    }

    public Double getKilometragemProximaTroca() {
        return kilometragemProximaTroca;
    }

    public void setKilometragemProximaTroca(Double kilometragemProximaTroca) {
        this.kilometragemProximaTroca = kilometragemProximaTroca;
    }

    public Double getLitrosOleo() {
        return litrosOleo;
    }

    public Double getPrecoOleo() {
        return precoOleo;
    }

    public Double getPrecoServicoTroca() {
        return precoServicoTroca;
    }

    public String getLocalTroca() {
        return localTroca;
    }

    public Boolean getTrocouFiltroOleo() {
        return trocouFiltroOleo;
    }

    public Double getPrecoFiltroOleo() {
        return precoFiltroOleo;
    }
}
