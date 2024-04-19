package id.my.hendisantika.springbootvaultintegrationdemo.controller;

import id.my.hendisantika.springbootvaultintegrationdemo.model.Child;
import id.my.hendisantika.springbootvaultintegrationdemo.repository.ChildRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.vault.core.VaultOperations;
import org.springframework.vault.support.Ciphertext;
import org.springframework.vault.support.Plaintext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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

    @PostMapping("save")
    public Child save(@RequestBody Child childReq) {
        Child child = new Child();
        child.setName(childReq.getName());
        Ciphertext encryptedParent = vaultOperations.opsForTransit()
                .encrypt("nik", Plaintext.of(childReq.getParentName()));
        child.setParentName(encryptedParent.getCiphertext());
        return childRepository.save(child);
    }

    @GetMapping("get")
    Child get(@RequestParam int id) {
        Child child = childRepository.getById(id);
        Plaintext decryptedParent = vaultOperations.opsForTransit()
                .decrypt("nik", Ciphertext.of(child.getParentName()));

        Child result = new Child();
        result.setId(child.getId());
        result.setName(child.getName());
        result.setParentName(decryptedParent.asString());
        return result;
    }
}
