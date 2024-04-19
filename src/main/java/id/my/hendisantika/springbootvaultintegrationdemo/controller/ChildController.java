package id.my.hendisantika.springbootvaultintegrationdemo.controller;

import id.my.hendisantika.springbootvaultintegrationdemo.repository.ChildRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.vault.core.VaultOperations;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-vault-integration-demo
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 4/19/24
 * Time: 12:56
 * To change this template use File | Settings | File Templates.
 */
@RestController
@RequiredArgsConstructor
public class ChildController {
    private final ChildRepository childRepository;
    private final VaultOperations vaultOperations;
}
