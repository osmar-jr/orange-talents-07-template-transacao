package br.com.zupacademy.osmarjunior.requests;

import br.com.zupacademy.osmarjunior.model.Estabelecimento;

public class EstabelecimentoApiRequest {

    private String nome;
    private String cidade;
    private String endereco;

    @Deprecated
    public EstabelecimentoApiRequest() {
    }

    public EstabelecimentoApiRequest(String nome, String cidade, String endereco) {
        this.nome = nome;
        this.cidade = cidade;
        this.endereco = endereco;
    }

    /**
     * Getters para serialização pela api de serviço
     * */
    public String getNome() {
        return nome;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEndereco() {
        return endereco;
    }

    public Estabelecimento toEstabelecimento() {
        return new Estabelecimento(this.nome, this.cidade, this.endereco);
    }
}
