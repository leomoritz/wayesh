package model.entities.automovel;

import model.entities.abastecimento.Abastecimento;
import model.entities.revisao.Revisao;
import model.enums.*;

import java.time.LocalDate;
import java.util.*;

public abstract class Automovel {

    private final String nomeModelo;
    private final Integer anoFabricacao;
    private final Integer anoModelo;
    private final String placa;
    private final String chassi;
    private final String renavam;
    private final Map<AutomovelCombustivel, Double> limiteReservatorioPorCombustivel;
    private final Map<AutomovelCombustivel, Double> mediaKmRodoviaPorCombustivel;
    private final Double qtdKmParaRevisao; // Verificar no manual do veículo
    private final Integer qtdMesesParaRevisao; // Verificar no manual do veículo
    private final Set<Revisao> ultimasRevisoes;
    private final Set<Abastecimento> ultimosAbastecimentos;
    private Set<AutomovelCombustivel> tipoCombustivel;
    private AutomovelCategoria categoriaUso;
    private Integer potencia;
    private Integer cilindrada;
    private Map<LocalDate, Double> kmRodadoPorMes;
    private Double kmProximaRevisao;
    private LocalDate dataProximaRevisao;

    public Automovel(String nomeModelo, Integer anoFabricacao, Integer anoModelo, String placa,
                     String chassi, String renavam, Double qtdKmParaRevisao, Integer qtdMesesParaRevisao,
                     Map<AutomovelCombustivel, Double> limiteReservatorioPorCombustivel,
                     Map<AutomovelCombustivel, Double> mediaKmRodoviaPorCombustivel) {
        this.nomeModelo = nomeModelo;
        this.anoFabricacao = anoFabricacao;
        this.anoModelo = anoModelo;
        this.placa = placa;
        this.chassi = chassi;
        this.renavam = renavam;
        this.qtdKmParaRevisao = qtdKmParaRevisao;
        this.qtdMesesParaRevisao = qtdMesesParaRevisao;
        this.limiteReservatorioPorCombustivel = limiteReservatorioPorCombustivel;
        this.mediaKmRodoviaPorCombustivel = mediaKmRodoviaPorCombustivel;
        this.kmRodadoPorMes = new HashMap<>();
        this.ultimasRevisoes = new TreeSet<>();
        this.ultimosAbastecimentos = new TreeSet<>();
    }

    public Automovel(String nomeModelo, Integer anoFabricacao, Integer anoModelo,
                     String placa, String chassi, String renavam,
                     Set<AutomovelCombustivel> tipoCombustivel,
                     Double qtdKmParaRevisao, Integer qtdMesesParaRevisao,
                     Map<AutomovelCombustivel, Double> limiteReservatorioPorCombustivel,
                     Map<AutomovelCombustivel, Double> mediaKmRodoviaPorCombustivel,
                     AutomovelCategoria categoriaUso, Integer potencia, Integer cilindrada) {
        this(nomeModelo, anoFabricacao, anoModelo, placa, chassi, renavam, qtdKmParaRevisao, qtdMesesParaRevisao,
             limiteReservatorioPorCombustivel, mediaKmRodoviaPorCombustivel);
        this.tipoCombustivel = tipoCombustivel;
        this.categoriaUso = categoriaUso;
        this.potencia = potencia;
        this.cilindrada = cilindrada;
    }

    public Automovel(String nomeModelo, Integer anoFabricacao, Integer anoModelo,
                     Set<AutomovelCombustivel> tipoCombustivel, String placa, String chassi, String renavam,
                     Double qtdKmParaRevisao, Integer qtdMesesParaRevisao,
                     Map<AutomovelCombustivel, Double> limiteReservatorioPorCombustivel,
                     Map<AutomovelCombustivel, Double> mediaKmRodoviaPorCombustivel) {
        this(nomeModelo, anoFabricacao, anoModelo, placa, chassi, renavam, qtdKmParaRevisao, qtdMesesParaRevisao,
             limiteReservatorioPorCombustivel, mediaKmRodoviaPorCombustivel);
        this.tipoCombustivel = tipoCombustivel;

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

    public Set<AutomovelCombustivel> getTipoCombustivel() {
        return tipoCombustivel;
    }

    public void addTipoCombustivel(AutomovelCombustivel tipoCombustivel) {
        this.tipoCombustivel.add(tipoCombustivel);
    }

    public AutomovelCategoria getCategoriaUso() {
        return categoriaUso;
    }

    public void setCategoriaUso(AutomovelCategoria categoriaUso) {
        this.categoriaUso = categoriaUso;
    }

    public Integer getPotencia() {
        return potencia;
    }

    public void setPotencia(Integer potencia) {
        this.potencia = potencia;
    }

    public Integer getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(Integer cilindrada) {
        this.cilindrada = cilindrada;
    }

    public Map<LocalDate, Double> getKmRodadoPorMes() {
        return kmRodadoPorMes;
    }

    public void setKmRodadoPorMes(Map<LocalDate, Double> kmRodadoPorMes) {
        this.kmRodadoPorMes = kmRodadoPorMes;
    }
    public Double getQtdKmParaRevisao() {
        return qtdKmParaRevisao;
    }

    public Integer getQtdMesesParaRevisao() {
        return qtdMesesParaRevisao;
    }

    public Map<AutomovelCombustivel, Double> getLimiteReservatorioPorCombustivel() {
        return limiteReservatorioPorCombustivel;
    }

    public Boolean addLimiteReservatorioPorCombustivel(AutomovelCombustivel tipoCombustivel, Double limiteTanque) {
        if (!getLimiteReservatorioPorCombustivel().containsKey(tipoCombustivel)) {
            getLimiteReservatorioPorCombustivel().put(tipoCombustivel, limiteTanque);
            return true;
        }
        return false;
    }

    public Map<AutomovelCombustivel, Double> getMediaKmRodoviaPorCombustivel() {
        return mediaKmRodoviaPorCombustivel;
    }

    public Boolean addMediaKmRodoviaPorCombustivel(AutomovelCombustivel tipoCombustivel,
                                                   Double mediaConsumoKmRodovia) {
        if (!getMediaKmRodoviaPorCombustivel().containsKey(tipoCombustivel)) {
            getMediaKmRodoviaPorCombustivel().put(tipoCombustivel, mediaConsumoKmRodovia);
            return true;
        }
        return false;
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

    public Set<Abastecimento> getUltimosAbastecimentos() {
        return ultimosAbastecimentos;
    }

    public Optional<Set<Abastecimento>> listaUltimosAbastecimentos() {

        if (!getUltimosAbastecimentos().isEmpty()) {
            return Optional.ofNullable(getUltimosAbastecimentos());
        }

        return Optional.empty();
    }

    @Override
    public String toString() {
        return "Automovel{" +
                "Modelo = '" + nomeModelo + '\'' +
                "Ano Fabricacao = '" + anoFabricacao +
                "Ano Modelo = '" + anoModelo +
                "Tipo Combustível = '" + tipoCombustivel.toString() +
                "Placa = '" + placa + '\'' +
                "Chassi= '" + chassi + '\'' +
                "Renavam = '" + renavam + '\'' +
                "Categoria Uso = '" + categoriaUso +
                "Potência/Cilindrada = '" + potencia + '\'' + cilindrada +
                '}';
    }

    // Inner class (quando não quero deixar exposto o enum, visto que só será usado internamente)
    public enum TipoAutomovel {
        CARRO, MOTO, CAMINHAO;
    }
}
