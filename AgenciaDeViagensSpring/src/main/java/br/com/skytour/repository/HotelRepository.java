package br.com.skytour.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.skytour.model.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Long> {

}
