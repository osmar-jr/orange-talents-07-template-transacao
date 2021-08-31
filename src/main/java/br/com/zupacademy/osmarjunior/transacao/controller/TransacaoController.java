package br.com.zupacademy.osmarjunior.transacao.controller;

import br.com.zupacademy.osmarjunior.transacao.controller.response.TransacaoResponse;
import br.com.zupacademy.osmarjunior.transacao.model.Cartao;
import br.com.zupacademy.osmarjunior.transacao.model.Transacao;
import br.com.zupacademy.osmarjunior.transacao.repository.CartaoRepository;
import br.com.zupacademy.osmarjunior.transacao.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.Optional;

@Validated
@RestController
@RequestMapping("/api/v1/transacoes")
public class TransacaoController {

    @Autowired
    private TransacaoRepository transacaoRepository;

    @Autowired
    private CartaoRepository cartaoRepository;

    @GetMapping(value = "/{cartaoId}")
    public ResponseEntity<?> ultimasTransacoes(@PathVariable("cartaoId") @NotNull Long cartaoId,
                                                  @PageableDefault(page = 0, size = 10) Pageable pageable){

        Optional<Cartao> optionalCartao = cartaoRepository.findById(cartaoId);
        if(optionalCartao.isEmpty()){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("O cartão informado não existe no sistema.");
        }
        Cartao cartao = optionalCartao.get();
        Page<Transacao> transacoesPage = transacaoRepository.findByCartaoOrderByEfetivadaEmDesc(cartao, pageable);

        Page<TransacaoResponse> transacoesResponsePage = TransacaoResponse
                .toTransacoesResponsePage(transacoesPage);

        return ResponseEntity.ok().body(transacoesResponsePage);
    }
}
