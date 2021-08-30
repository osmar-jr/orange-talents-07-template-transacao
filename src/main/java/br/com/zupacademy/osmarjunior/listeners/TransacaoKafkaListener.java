package br.com.zupacademy.osmarjunior.listeners;

import br.com.zupacademy.osmarjunior.model.Transacao;
import br.com.zupacademy.osmarjunior.repository.TransacaoRepository;
import br.com.zupacademy.osmarjunior.requests.TransacaoApiRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class TransacaoKafkaListener {

    @Autowired
    private TransacaoRepository transacaoRepository;

    @KafkaListener(topics = "${spring.kafka.topic.transactions}")
    public void ouvir(TransacaoApiRequest transacaoApiRequest) {
        Transacao transacao = transacaoApiRequest.toTransacao();
        transacaoRepository.save(transacao);
    }
}
