package io.github.brunafs.clientes.model.repository;

import io.github.brunafs.clientes.model.entity.Servico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicoRepository extends JpaRepository<Servico, Integer> {
}
