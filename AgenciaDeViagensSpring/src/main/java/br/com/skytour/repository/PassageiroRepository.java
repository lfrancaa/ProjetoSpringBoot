package br.com.skytour.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.skytour.model.Passageiro;

public interface PassageiroRepository extends JpaRepository<Passageiro, Long> {
	Optional<Passageiro> findByEmail(String email);
}
