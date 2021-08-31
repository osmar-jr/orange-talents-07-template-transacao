package br.com.zupacademy.osmarjunior.transacao.repository;

import br.com.zupacademy.osmarjunior.transacao.model.Cartao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartaoRepository extends JpaRepository<Cartao, Long> {

    Optional<Cartao> findByCartaoApiId(String cartaoApiId);
}
