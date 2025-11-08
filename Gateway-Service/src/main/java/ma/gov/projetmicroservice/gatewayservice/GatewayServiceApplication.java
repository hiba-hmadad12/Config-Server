package ma.gov.projetmicroservice.gatewayservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@Slf4j
@SpringBootApplication
public class GatewayServiceApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(GatewayServiceApplication.class, args);

        String serverPort = context.getEnvironment().getProperty("server.port");

        log.info("\nACCESS URLS:\n------------------------------------------------------\n" +
                        "URL SWAGGER:\thttp://127.0.0.1:{}/swagger-ui/index.html\n" +
                        "URL H2 BASE:\thttp://127.0.0.1:{}/h2-console\n" +
                        "----------------------------------------------------------",
                serverPort, serverPort);
    }
}
