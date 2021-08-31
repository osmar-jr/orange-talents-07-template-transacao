package br.com.zupacademy.osmarjunior.transacao.model;

import javax.persistence.*;

@Entity
public class Cartao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String idApiTransacoes;
    private String email;

    @Deprecated
    public Cartao() {
    }

    public Cartao(String idApiTransacoes, String email) {

        this.idApiTransacoes = idApiTransacoes;
        this.email = email;
    }
}
