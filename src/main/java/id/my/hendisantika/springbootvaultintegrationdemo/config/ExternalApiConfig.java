package id.my.hendisantika.springbootvaultintegrationdemo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-vault-integration-demo
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 4/19/24
 * Time: 08:55
 * To change this template use File | Settings | File Templates.
 */
@ConfigurationProperties("external-api")
public class ExternalApiConfig {

    private String uri;
    private String apiKey;


    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }
}
