package br.com.skytour.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.skytour.model.Voo;

public interface VooRepository extends JpaRepository<Voo, Long> {

}
