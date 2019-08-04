package br.com.fiap.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.entity.Pagamento;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {

}
