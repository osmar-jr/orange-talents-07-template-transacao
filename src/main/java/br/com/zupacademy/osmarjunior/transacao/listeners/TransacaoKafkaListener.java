package br.com.zupacademy.osmarjunior.transacao.listeners;

import br.com.zupacademy.osmarjunior.transacao.model.Transacao;
import br.com.zupacademy.osmarjunior.transacao.repository.CartaoRepository;
import br.com.zupacademy.osmarjunior.transacao.repository.TransacaoRepository;
import br.com.zupacademy.osmarjunior.transacao.listeners.requests.TransacaoApiRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


@Component
public class TransacaoKafkaListener {

    @Autowired
    private TransacaoRepository transacaoRepository;

    @Autowired
    private CartaoRepository cartaoRepository;

    @KafkaListener(topics = "${spring.kafka.topic.transactions}")
    public void ouvir(TransacaoApiRequest transacaoApiRequest) {
        Transacao transacao = transacaoApiRequest.toTransacao(cartaoRepository);
        transacaoRepository.save(transacao);
    }
}
