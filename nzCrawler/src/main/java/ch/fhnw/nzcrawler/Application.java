package ch.fhnw.nzcrawler;

import java.util.Arrays;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 *
 * @author Elias Schorr
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner runner(NewsRepo newsRepo) {
        return args -> {
            Arrays.asList("news_1,news_2,news_3".split(","))
                    .forEach(a -> {
                        News account = newsRepo.save(new News(a, a + " untertitle", "www.nzzz.ch/" + a));
                    });
        };
    }
}
