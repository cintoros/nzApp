package ch.fhnw.nzcrawler.repos;

import ch.fhnw.nzcrawler.model.NewsLink;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

/**
 *
 * @author Elias Schorr
 * @since 18.09.2015
 */
@RestResource
public interface NewsLinkRepo extends JpaRepository<NewsLink, Long> {

    Optional<NewsLink> findByNewsId(Long newsId);
}
