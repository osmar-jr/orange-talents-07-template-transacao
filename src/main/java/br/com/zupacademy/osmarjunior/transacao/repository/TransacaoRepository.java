package br.com.zupacademy.osmarjunior.transacao.repository;

import br.com.zupacademy.osmarjunior.transacao.model.Cartao;
import br.com.zupacademy.osmarjunior.transacao.model.Transacao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface TransacaoRepository extends PagingAndSortingRepository<Transacao, Long> {

    Page<Transacao> findByCartaoOrderByEfetivadaEmDesc(Cartao cartao, Pageable pageable);
}
