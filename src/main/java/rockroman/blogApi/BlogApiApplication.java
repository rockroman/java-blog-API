package rockroman.blogApi;

import io.github.cdimascio.dotenv.Dotenv;
import me.paulschwarz.springdotenv.DotenvApplicationInitializer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
public class BlogApiApplication {

	public static void main(String[] args) {
		// Check if environment variables are available from Heroku
		String port = System.getenv("PORT");
		if (port != null) {
			// Environment variables are available from Heroku, no need to load .env file
			SpringApplication.run(BlogApiApplication.class, args);
		} else {
			// Load environment variables from .env file
			Dotenv dotenv = Dotenv.configure().load();
			dotenv.entries().forEach(entry ->
					System.setProperty(entry.getKey(), entry.getValue())
			);
			SpringApplication.run(BlogApiApplication.class, args);
		}
	}

}
