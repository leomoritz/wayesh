package model.entities.revisao;

import model.entities.automovel.Automovel;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

public abstract class Revisao {

    private final String nomeRevisao;
    private final LocalDate dataAtualRevisao;
    private final Double kilometragemAtual;
    private final Set<Peca> pecasTrocadas;
    private final Set<Peca> pecasTrocaProximaRevisao;
    private final Automovel automovel;
    private final Double precoRevisao;
    private final String nomeAtendente;
    private final String nomeMecanico;
    private final String localRevisao;
    private String descricaoRevisao;

    public Revisao(Automovel automovel, LocalDate dataAtualRevisao, Double kilometragemAtual, Double precoRevisao,
                   String nomeAtendente, String nomeMecanico, String localRevisao, Set<Peca> pecasTrocadas,
                   Set<Peca> pecasTrocaProximaRevisao) {
        this.nomeRevisao = "Revisão: "
                + dataAtualRevisao + " - " + automovel.getNomeModelo() + " - " + localRevisao;
        this.automovel = automovel;
        this.dataAtualRevisao = dataAtualRevisao;
        this.kilometragemAtual = kilometragemAtual;
        this.precoRevisao = precoRevisao;
        this.nomeAtendente = nomeAtendente;
        this.nomeMecanico = nomeMecanico;
        this.localRevisao = localRevisao;
        this.pecasTrocadas = pecasTrocadas;
        this.pecasTrocaProximaRevisao = pecasTrocaProximaRevisao;
    }

    public Revisao(Automovel automovel, String descricaoRevisao, LocalDate dataAtualRevisao, Double kilometragemAtual
            , Double precoRevisao, String nomeAtendente, String nomeMecanico, String localRevisao,
                   Set<Peca> pecasTrocadas, Set<Peca> pecasTrocaProximaRevisao) {
        this(automovel, dataAtualRevisao, kilometragemAtual, precoRevisao, nomeAtendente, nomeMecanico, localRevisao,
             pecasTrocadas, pecasTrocaProximaRevisao);
        this.descricaoRevisao = descricaoRevisao;
    }

    public Revisao(Automovel automovel, String descricaoRevisao, LocalDate dataAtualRevisao, Double kilometragemAtual
            , Double precoRevisao, String nomeAtendente, String nomeMecanico, String localRevisao,
                   Set<Peca> pecasTrocadas) {
        this(automovel, dataAtualRevisao, kilometragemAtual, precoRevisao, nomeAtendente, nomeMecanico, localRevisao,
             pecasTrocadas, new TreeSet<>());
        this.descricaoRevisao = descricaoRevisao;
    }

    public String getNomeRevisao() {
        return nomeRevisao;
    }

    public LocalDate getDataAtualRevisao() {
        return dataAtualRevisao;
    }

    public Double getKilometragemAtual() {
        return kilometragemAtual;
    }

    public Set<Peca> getPecasTrocadas() {
        return pecasTrocadas;
    }

    public Set<Peca> getPecasTrocaProximaRevisao() {
        return pecasTrocaProximaRevisao;
    }

    public String getDescricaoRevisao() {
        return descricaoRevisao;
    }

    public void setDescricaoRevisao(String descricaoRevisao) {
        this.descricaoRevisao = descricaoRevisao;
    }

    public Double getPrecoRevisao() {
        return precoRevisao;
    }

    public String getNomeAtendente() {
        return nomeAtendente;
    }

    public String getNomeMecanico() {
        return nomeMecanico;
    }

    public String getLocalRevisao() {
        return localRevisao;
    }

    public Automovel getAutomovel() {
        return automovel;
    }

}
