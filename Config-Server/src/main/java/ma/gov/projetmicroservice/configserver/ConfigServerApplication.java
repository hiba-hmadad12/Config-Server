package ma.gov.projetmicroservice.configserver;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@EnableConfigServer
@Slf4j
public class ConfigServerApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(ConfigServerApplication.class);

        log.info("\nAccess URLs:\n------------------------------------------------------\n" +
                        "Url: \thttp://127.0.0.1:{}\n" +
                        "----------------------------------------------------------",
                context.getEnvironment().getProperty("server.port"));
    }
}
