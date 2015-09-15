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

    /**
     * finds the News by the id
     *
     * @param id the id to search for
     * @return
     */
    Optional<News> findById(Long id);
}
