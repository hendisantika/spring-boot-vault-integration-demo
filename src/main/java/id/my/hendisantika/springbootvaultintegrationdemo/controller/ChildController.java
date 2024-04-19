package id.my.hendisantika.springbootvaultintegrationdemo.controller;

import id.my.hendisantika.springbootvaultintegrationdemo.model.Child;
import id.my.hendisantika.springbootvaultintegrationdemo.repository.ChildRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.vault.core.VaultOperations;
import org.springframework.vault.support.Ciphertext;
import org.springframework.vault.support.Plaintext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

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
    public Child get(@RequestParam int id) {
        Child child = childRepository.getById(id);
        Plaintext decryptedParent = vaultOperations.opsForTransit()
                .decrypt("nik", Ciphertext.of(child.getParentName()));

        Child result = new Child();
        result.setId(child.getId());
        result.setName(child.getName());
        result.setParentName(decryptedParent.asString());
        return result;
    }

    @SneakyThrows
    @GetMapping("encryptFile")
    public void encryptFile() {
        File file = new File("/Users/hendisantika/Desktop/Images/jvm.jpg");
        byte[] bytes = Files.readAllBytes(file.toPath());
        Ciphertext encrypt = vaultOperations.opsForTransit()
                .encrypt("nik", Plaintext.of(bytes));
        byte[] context = encrypt.getCiphertext().getBytes(StandardCharsets.UTF_8);
        OutputStream outputStream = new FileOutputStream("/Users/hendisantika/Desktop/Images/jvm.jpg.enc");
        outputStream.write(context);
    }

    @SneakyThrows
    @GetMapping("decryptFile")
    public void decryptFile() {
        File file = new File("/Users/hendisantika/Desktop/Images/jvm.jpg.enc");
        String string = Files.readString(file.toPath());
        Plaintext encrypt = vaultOperations.opsForTransit()
                .decrypt("nik", Ciphertext.of(string));
        byte[] context = encrypt.getPlaintext();
        OutputStream outputStream = new FileOutputStream("/Users/hendisantika/Desktop/Images/jvm.dec.jpg");
        outputStream.write(context);
    }
}
