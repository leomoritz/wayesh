package model.services.revisao;

import model.entities.revisao.Revisao;

import java.time.LocalDate;
import java.util.Optional;

public final class ServicoCalculaRevisao {

    /**
     * Calcula a próxima revisão e salva a revisão atual na lista de últimas revisões do automóvel
     * Se a data/km da próxima revisão estiverem vazias, setar com a data atual e km 0.0
     * @param revisao para buscar o automovel da revisão atual e setar a kilometragem/data da próxima revisão
     */
    public static void calculaProximaRevisaoAutomovel(Revisao revisao) {
        int qtdMesesRevisao = revisao.getAutomovel().getQtdMesesParaRevisao();
        double qtdKmRevisao = revisao.getAutomovel().getQtdKmParaRevisao();

        if (Optional.of(revisao.getAutomovel().getDataProximaRevisao()).isEmpty()) {
            revisao.getAutomovel().setDataProximaRevisao(LocalDate.now());
        } else if (Optional.of(revisao.getAutomovel().getKmProximaRevisao()).isEmpty()) {
            revisao.getAutomovel().setKmProximaRevisao(0.0);
        }

        revisao.getAutomovel().setDataProximaRevisao(revisao.getDataAtualRevisao().plusMonths(qtdMesesRevisao));
        revisao.getAutomovel().setKmProximaRevisao(revisao.getKilometragemAtual() + qtdKmRevisao);

        addUltimaRevisao(revisao);

    }

    private static void addUltimaRevisao(Revisao revisao) {
        revisao.getAutomovel().getUltimasRevisoes().add(revisao);
    }
}
