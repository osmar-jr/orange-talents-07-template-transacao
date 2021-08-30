package br.com.zupacademy.osmarjunior.repository;

import br.com.zupacademy.osmarjunior.model.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
}
