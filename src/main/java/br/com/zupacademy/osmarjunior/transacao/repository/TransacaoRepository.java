package br.com.zupacademy.osmarjunior.transacao.repository;

import br.com.zupacademy.osmarjunior.transacao.model.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
}
