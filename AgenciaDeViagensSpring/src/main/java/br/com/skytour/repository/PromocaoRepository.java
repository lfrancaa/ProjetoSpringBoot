package br.com.skytour.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.skytour.model.Promocao;

public interface PromocaoRepository extends JpaRepository<Promocao, Long> {

}
