package br.com.zupacademy.osmarjunior.transacao.model;

import javax.persistence.*;

@Entity
public class Cartao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(unique = true)
    private String cartaoApiId;

    private String email;

    @Deprecated
    public Cartao() {
    }

    public Cartao(String cartaoApiId, String email) {

        this.cartaoApiId = cartaoApiId;
        this.email = email;
    }
}
