package id.my.hendisantika.springbootvaultintegrationdemo;

import id.my.hendisantika.springbootvaultintegrationdemo.config.ExternalApiConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(ExternalApiConfig.class)
public class SpringBootVaultIntegrationDemoApplication implements CommandLineRunner {
    private static final Logger log = LoggerFactory.getLogger(SpringBootVaultIntegrationDemoApplication.class);

    private final ExternalApiConfig externalApiConfig;

    public SpringBootVaultIntegrationDemoApplication(ExternalApiConfig externalApiConfig) {
        this.externalApiConfig = externalApiConfig;
    }


    public static void main(String[] args) {
        SpringApplication.run(SpringBootVaultIntegrationDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("External Api URI : {} ", externalApiConfig.getUri());
        log.info("External Api Key : {} ", externalApiConfig.getApiKey());
    }
}
