package br.com.fiap.globaljava.condicaoClimatica;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CondicaoClimaticaRepository extends JpaRepository<CondicaoClimatica, Long> {
}
