package br.com.zupacademy.osmarjunior.transacao.model;

import br.com.zupacademy.osmarjunior.transacao.controller.response.TransacaoResponse;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Transacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(unique = true)
    private String transacaoApiId;
    private BigDecimal valor;

    @ManyToOne(cascade = CascadeType.ALL)
    private Estabelecimento estabelecimento;

    @ManyToOne
    private Cartao cartao;

    private LocalDateTime efetivadaEm;

    @Deprecated
    public Transacao() {
    }

    public Transacao(String transacaoApiId,
                     BigDecimal valor,
                     Estabelecimento estabelecimento,
                     Cartao cartao,
                     LocalDateTime efetivadaEm) {

        this.transacaoApiId = transacaoApiId;
        this.valor = valor;
        this.estabelecimento = estabelecimento;
        this.cartao = cartao;
        this.efetivadaEm = efetivadaEm;
    }

    public TransacaoResponse toTransacaoResponse() {
        return new TransacaoResponse(this.transacaoApiId, this.valor, this.efetivadaEm, this.estabelecimento);
    }

}
