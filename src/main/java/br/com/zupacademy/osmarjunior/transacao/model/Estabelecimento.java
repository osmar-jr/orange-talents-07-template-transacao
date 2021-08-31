package br.com.zupacademy.osmarjunior.transacao.model;

import br.com.zupacademy.osmarjunior.transacao.controller.response.EstabelecimentoResponse;

import javax.persistence.*;

@Entity
public class Estabelecimento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String nome;
    private String cidade;
    private String endereco;


    @Deprecated
    public Estabelecimento() {
    }

    public Estabelecimento(String nome, String cidade, String endereco) {

        this.nome = nome;
        this.cidade = cidade;
        this.endereco = endereco;
    }

    public EstabelecimentoResponse toEstabelecimentoResponse(){
        return new EstabelecimentoResponse(this.nome, this.cidade, this.endereco);
    }
}
