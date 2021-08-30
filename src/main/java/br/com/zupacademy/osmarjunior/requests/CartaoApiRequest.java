package br.com.zupacademy.osmarjunior.requests;

import br.com.zupacademy.osmarjunior.model.Cartao;

public class CartaoApiRequest {

    private String id;
    private String email;

    @Deprecated
    public CartaoApiRequest() {
    }

    public CartaoApiRequest(String id, String email) {
        this.id = id;
        this.email = email;
    }

    /**
     * Getters para serialização pela api de serviço
     * */
    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public Cartao toCartao() {
        return new Cartao(this.id, this.email);
    }
}
