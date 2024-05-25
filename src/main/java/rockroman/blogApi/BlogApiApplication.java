package rockroman.blogApi;

import io.github.cdimascio.dotenv.Dotenv;
import me.paulschwarz.springdotenv.DotenvApplicationInitializer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BlogApiApplication {

	public static void main(String[] args) {
		Dotenv dotenv = Dotenv.configure().load();
		dotenv.entries().forEach(entry ->
				System.setProperty(entry.getKey(), entry.getValue())
		);
		SpringApplication.run(BlogApiApplication.class, args);
	}

}
