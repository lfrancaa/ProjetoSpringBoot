package br.com.skytour.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.skytour.model.Passagem;

public interface PassagemRepository extends JpaRepository<Passagem, Long> {

}
