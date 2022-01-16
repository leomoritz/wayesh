package model.entities.automovel;

import model.entities.revisao.Revisao;
import model.enums.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

public abstract class Automovel {

    private final String nomeModelo;
    private final Integer anoFabricacao;
    private final Integer anoModelo;
    private final String placa;
    private final String chassi;
    private final String renavam;
    private final Double qtdKmParaRevisao; // Verificar no manual do veículo
    private final Integer qtdMesesParaRevisao; // Verificar no manual do veículo
    private final Set<Revisao> ultimasRevisoes;
    private AutomovelCombustivel combustivel;
    private AutomovelCategoria categoriaUso;
    private String potenciaCilindrada;
    private Double kmProximaRevisao;
    private LocalDate dataProximaRevisao;

    public Automovel(String nomeModelo, Integer anoFabricacao, Integer anoModelo, String placa,
                     String chassi, String renavam, Double qtdKmParaRevisao, Integer qtdMesesParaRevisao) {
        this.nomeModelo = nomeModelo;
        this.anoFabricacao = anoFabricacao;
        this.anoModelo = anoModelo;
        this.placa = placa;
        this.chassi = chassi;
        this.renavam = renavam;
        this.qtdKmParaRevisao = qtdKmParaRevisao;
        this.qtdMesesParaRevisao = qtdMesesParaRevisao;
        this.ultimasRevisoes = new TreeSet<>();
    }

    public Automovel(String nomeModelo, Integer anoFabricacao, Integer anoModelo,
                     AutomovelCombustivel combustivel, String placa, String chassi, String renavam,
                     Double qtdKmParaRevisao, Integer qtdMesesParaRevisao,
                     AutomovelCategoria categoriaUso, String potenciaCilindrada) {
        this(nomeModelo, anoFabricacao, anoModelo, placa, chassi, renavam, qtdKmParaRevisao, qtdMesesParaRevisao);
        this.combustivel = combustivel;
        this.categoriaUso = categoriaUso;
        this.potenciaCilindrada = potenciaCilindrada;
    }

    public Automovel(String nomeModelo, Integer anoFabricacao, Integer anoModelo,
                     AutomovelCombustivel combustivel, String placa, String chassi, String renavam,
                     Double qtdKmParaRevisao, Integer qtdMesesParaRevisao) {
        this(nomeModelo, anoFabricacao, anoModelo, placa, chassi, renavam, qtdKmParaRevisao, qtdMesesParaRevisao);
        this.combustivel = combustivel;
    }

    // Método usado para listar as marcas de automóveis pelo tipo
    public static List<Enum> getMarcasPeloTipo(TipoAutomovel tipo) {
        switch (tipo) {
            case CARRO -> {
                return List.of(MarcaCarro.values());
            }
            case MOTO -> {
                return List.of(MarcaMoto.values());
            }
            case CAMINHAO -> {
                return List.of(MarcaCaminhao.values());
            }
            default -> throw new IllegalStateException("Unexpected value: " + tipo);
        }
    }

    public abstract TipoAutomovel getTipoAutomovel();

    public String getNomeModelo() {
        return nomeModelo;
    }

    public Integer getAnoFabricacao() {
        return anoFabricacao;
    }

    public Integer getAnoModelo() {
        return anoModelo;
    }

    public String getPlaca() {
        return placa;
    }

    public String getChassi() {
        return chassi;
    }

    public String getRenavam() {
        return renavam;
    }

    public AutomovelCombustivel getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(AutomovelCombustivel combustivel) {
        this.combustivel = combustivel;
    }

    public AutomovelCategoria getCategoriaUso() {
        return categoriaUso;
    }

    public void setCategoriaUso(AutomovelCategoria categoriaUso) {
        this.categoriaUso = categoriaUso;
    }

    public String getPotenciaCilindrada() {
        return potenciaCilindrada;
    }

    public void setPotenciaCilindrada(String potenciaCilindrada) {
        this.potenciaCilindrada = potenciaCilindrada;
    }

    public Double getQtdKmParaRevisao() {
        return qtdKmParaRevisao;
    }

    public Integer getQtdMesesParaRevisao() {
        return qtdMesesParaRevisao;
    }

    public Double getKmProximaRevisao() {
        return kmProximaRevisao;
    }

    public void setKmProximaRevisao(Double kmProximaRevisao) {
        this.kmProximaRevisao = kmProximaRevisao;
    }

    public LocalDate getDataProximaRevisao() {
        return dataProximaRevisao;
    }

    public void setDataProximaRevisao(LocalDate dataProximaRevisao) {
        this.dataProximaRevisao = dataProximaRevisao;
    }

    public Set<Revisao> getUltimasRevisoes() {
        return ultimasRevisoes;
    }

    /**
     * Método para listar as últimas revisões do automóvel
     *
     * @return Retorna uma lista que existe, porém que pode conter objeto nulo
     */

    public Optional<Set<Revisao>> listaUltimasRevisoes() {

        if (!getUltimasRevisoes().isEmpty()) {
            return Optional.ofNullable(getUltimasRevisoes());
        }

        return Optional.empty();
    }

    @Override
    public String toString() {
        return "Automovel{" +
                "Modelo = '" + nomeModelo + '\'' +
                "Ano Fabricacao = '" + anoFabricacao +
                "Ano Modelo = '" + anoModelo +
                "Tipo Combustível = '" + combustivel +
                "Placa = '" + placa + '\'' +
                "Chassi= '" + chassi + '\'' +
                "Renavam = '" + renavam + '\'' +
                "Categoria Uso = '" + categoriaUso +
                "Potência/Cilindrada = '" + potenciaCilindrada + '\'' +
                '}';
    }

    // Inner class (quando não quero deixar exposto o enum, visto que só será usado internamente)
    public enum TipoAutomovel {
        CARRO, MOTO, CAMINHAO;
    }
}
