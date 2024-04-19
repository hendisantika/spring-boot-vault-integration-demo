package id.my.hendisantika.springbootvaultintegrationdemo.repository;

import id.my.hendisantika.springbootvaultintegrationdemo.model.Child;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

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
@Repository
public interface ChildRepository extends JpaRepository<Child, Integer> {
}
