package br.com.zupacademy.osmarjunior.transacao.listeners.requests;

import br.com.zupacademy.osmarjunior.transacao.model.Cartao;
import br.com.zupacademy.osmarjunior.transacao.model.Estabelecimento;
import br.com.zupacademy.osmarjunior.transacao.model.Transacao;
import br.com.zupacademy.osmarjunior.transacao.repository.CartaoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

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

    public Transacao toTransacao(CartaoRepository cartaoRepository) {
        Estabelecimento estabelecimentoTransacao = this.estabelecimento.toEstabelecimento();
        Cartao cartaoTransacao = criaOuCapturaCartao(cartaoRepository);
        return new Transacao(this.id, this.valor, estabelecimentoTransacao, cartaoTransacao, this.efetivadaEm);
    }

    /**
     * Cria o cartão no banco, caso não exista, visto que a base de dados neste projeto é nova.
     * */
    private Cartao criaOuCapturaCartao(CartaoRepository cartaoRepository) {
        Logger logger = LoggerFactory.getLogger(Cartao.class);
        Optional<Cartao> optionalCartao = cartaoRepository.findByCartaoApiId(this.cartao.getId());
        if(optionalCartao.isPresent()){
            return optionalCartao.get();
        }

        Cartao novoCartao = this.cartao.toCartao();
        cartaoRepository.save(novoCartao);
        logger.info("Novo cartão salvo.");
        return novoCartao;
    }
}
