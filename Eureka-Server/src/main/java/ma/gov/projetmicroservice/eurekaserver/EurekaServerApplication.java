package ma.gov.projetmicroservice.eurekaserver;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.ApplicationContext;

@Slf4j
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(EurekaServerApplication.class, args);

        String port = context.getEnvironment().getProperty("server.port");

        log.info("\nAccess URLs:\n------------------------------------------------------\n" +
                        "Eureka Dashboard: \t\thttp://127.0.0.1:{}/\n" +
                        "----------------------------------------------------------",
                port);
    }
}

