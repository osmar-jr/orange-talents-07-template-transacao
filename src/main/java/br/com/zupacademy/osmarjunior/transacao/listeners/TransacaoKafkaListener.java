package br.com.zupacademy.osmarjunior.transacao.listeners;

import br.com.zupacademy.osmarjunior.transacao.model.Transacao;
import br.com.zupacademy.osmarjunior.transacao.repository.CartaoRepository;
import br.com.zupacademy.osmarjunior.transacao.repository.TransacaoRepository;
import br.com.zupacademy.osmarjunior.transacao.listeners.requests.TransacaoApiRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


@Component
public class TransacaoKafkaListener {

    @Autowired
    private TransacaoRepository transacaoRepository;

    @Autowired
    private CartaoRepository cartaoRepository;

    private final Logger logger = LoggerFactory.getLogger(Transacao.class);

    @KafkaListener(topics = "${spring.kafka.topic.transactions}")
    public void ouvir(TransacaoApiRequest transacaoApiRequest) {
        Transacao transacao = transacaoApiRequest.toTransacao(cartaoRepository);
        transacaoRepository.save(transacao);
        logger.info("Nova transação salva no banco de dados.");
    }
}
