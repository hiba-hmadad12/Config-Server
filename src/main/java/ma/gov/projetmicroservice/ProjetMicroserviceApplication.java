package ma.gov.projetmicroservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;

@SpringBootApplication
@Slf4j
public class ProjetMicroserviceApplication {

    public static void main(String[] args) throws UnknownHostException {
        SpringApplication app = new SpringApplication(ProjetMicroserviceApplication.class);
        Environment env = app.run(args).getEnvironment();

        String port = env.getProperty("server.port");

        log.info(
                "Access URLs:\n----------------------------------------------------------\n" +
                        "Swagger UI: \thttp://127.0.0.1:{}/swagger-ui/index.html\n" +
                        "H2 Console: \thttp://127.0.0.1:{}/h2-console\n" +
                        "----------------------------------------------------------",port,port);
    }
}
