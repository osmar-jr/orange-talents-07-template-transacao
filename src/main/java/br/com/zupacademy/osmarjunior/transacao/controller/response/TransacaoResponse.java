package br.com.zupacademy.osmarjunior.transacao.controller.response;

import br.com.zupacademy.osmarjunior.transacao.model.Estabelecimento;
import br.com.zupacademy.osmarjunior.transacao.model.Transacao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public class TransacaoResponse {

    private String identificacaoCompra;
    private BigDecimal valor;
    private String efetivadaEm;
    private EstabelecimentoResponse estabelecimento;

    public TransacaoResponse(String identificacaoCompra, BigDecimal valor, LocalDateTime efetivadaEm, Estabelecimento estabelecimento) {
        this.identificacaoCompra = identificacaoCompra;
        this.valor = valor;
        this.efetivadaEm = efetivadaEm.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
        this.estabelecimento = estabelecimento.toEstabelecimentoResponse();
    }

    public static Page<TransacaoResponse> toTransacoesResponsePage(Page<Transacao> transacoesPage) {
        List<TransacaoResponse> transacoes = transacoesPage.stream()
                .map(Transacao::toTransacaoResponse)
                .collect(Collectors.toList());

        return new PageImpl<>(transacoes);
    }

    /**
     * Getters para deserialização pelo jackson
     * */
    public String getIdentificacaoCompra() {
        return identificacaoCompra;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public String getEfetivadaEm() {
        return efetivadaEm;
    }

    public EstabelecimentoResponse getEstabelecimento() {
        return estabelecimento;
    }
}
