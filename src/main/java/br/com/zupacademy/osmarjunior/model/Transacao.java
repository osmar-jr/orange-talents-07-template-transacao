package br.com.zupacademy.osmarjunior.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Transacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String idApiTransacoes;
    private BigDecimal valor;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Estabelecimento estabelecimentoTransacao;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Cartao cartaoTransacao;

    private LocalDateTime efetivadaEm;

    @Deprecated
    public Transacao() {
    }

    public Transacao(String idApiTransacoes, BigDecimal valor, Estabelecimento estabelecimentoTransacao, Cartao cartaoTransacao, LocalDateTime efetivadaEm) {

        this.idApiTransacoes = idApiTransacoes;
        this.valor = valor;
        this.estabelecimentoTransacao = estabelecimentoTransacao;
        this.cartaoTransacao = cartaoTransacao;
        this.efetivadaEm = efetivadaEm;
    }
}
