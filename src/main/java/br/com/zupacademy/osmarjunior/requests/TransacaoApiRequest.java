package br.com.zupacademy.osmarjunior.requests;

import br.com.zupacademy.osmarjunior.model.Cartao;
import br.com.zupacademy.osmarjunior.model.Estabelecimento;
import br.com.zupacademy.osmarjunior.model.Transacao;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransacaoApiRequest {

    private String id;
    private BigDecimal valor;
    private EstabelecimentoApiRequest estabelecimento;
    private CartaoApiRequest cartao;
    private LocalDateTime efetivadaEm;

    @Deprecated
    public TransacaoApiRequest() {
    }

    public TransacaoApiRequest(String id,
                               BigDecimal valor,
                               EstabelecimentoApiRequest estabelecimento,
                               CartaoApiRequest cartao,
                               LocalDateTime efetivadaEm) {
        this.id = id;
        this.valor = valor;
        this.estabelecimento = estabelecimento;
        this.cartao = cartao;
        this.efetivadaEm = efetivadaEm;
    }

    /**
     * Getters para serialização pela api de serviço
     * */
    public String getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public EstabelecimentoApiRequest getEstabelecimento() {
        return estabelecimento;
    }

    public CartaoApiRequest getCartao() {
        return cartao;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }

    public Transacao toTransacao() {
        Estabelecimento estabelecimentoTransacao = this.estabelecimento.toEstabelecimento();
        Cartao cartaoTransacao = cartao.toCartao();
        return new Transacao(this.id, this.valor, estabelecimentoTransacao, cartaoTransacao, this.efetivadaEm);
    }
}
