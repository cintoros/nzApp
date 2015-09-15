package ch.fhnw.nzcrawler;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

/**
 *
 * @author Elias Schorr
 */
@RestResource
public interface NewsRepo extends JpaRepository<News, Long> {

    Optional<News> findById(Long id);
}
