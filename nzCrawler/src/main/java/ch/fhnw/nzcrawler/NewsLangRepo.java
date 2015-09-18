package ch.fhnw.nzcrawler;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

/**
 *
 * @author Elias Schorr
 * @since 18.09.2015
 */
@RestResource
public interface NewsLangRepo extends JpaRepository<NewsLang, Long> {

    Collection<NewsLang> findByLanguage(String language);
}
