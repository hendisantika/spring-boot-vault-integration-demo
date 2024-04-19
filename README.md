# spring-boot-vault-integration-demo

### What is HasiCorp Vault ?

HashiCorp Vault is an identity-based secrets and encryption management system.
A secret is anything that you want to tightly control access to, such as API encryption keys, passwords and
certificates.
Vault provides encryption services that are gated by authentication and authorization methods.

### Vault Server Setup

If you don’t have vault server please go to this official website to download and setup vault
server. https://developer.hashicorp.com/vault/downloads

Unzip the downloaded file you will get vault.exe, Now to use the vault commands you need to set the env. variable.

Once you set the env. variable you are good to go, to verify If you have done it successfully open you cmd/terminal
according to your operating system to verify.

Write below command on your terminal

```shell
vault version
```

Now you should see the result as shown in below screenshot.

```shell
Vault v1.16.1 (6b5986790d7748100de77f7f127119c4a0f78946), built 2024-04-03T12:35:53Z
```

### Things todo list

1. Clone this repository: `git clone https://github.com/hendisantika/spring-boot-vault-integration-demo.git`
2. Navigate to the folder: `cd spring-boot-vault-integration-demo`
3. Run the application: `gradle clean bootRun`
4. Check console

```shell
 .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                (v3.2.5)

2024-04-19T09:03:31.967+07:00  INFO 74487 --- [spring-boot-vault-integration-demo] [           main] pringBootVaultIntegrationDemoApplication : Starting SpringBootVaultIntegrationDemoApplication using Java 21 with PID 74487 (/Users/hendisantika/IdeaProjects/spring-boot-vault-integration-demo/build/classes/java/main started by hendisantika in /Users/hendisantika/IdeaProjects/spring-boot-vault-integration-demo)
2024-04-19T09:03:31.967+07:00  INFO 74487 --- [spring-boot-vault-integration-demo] [           main] pringBootVaultIntegrationDemoApplication : No active profile set, falling back to 1 default profile: "default"
2024-04-19T09:03:31.983+07:00  INFO 74487 --- [spring-boot-vault-integration-demo] [           main] o.s.v.c.e.LeaseAwareVaultPropertySource  : Vault location [kv/spring-boot-vault-integration-demo] not resolvable: Not found
2024-04-19T09:03:32.188+07:00  INFO 74487 --- [spring-boot-vault-integration-demo] [           main] o.s.cloud.context.scope.GenericScope     : BeanFactory id=b2f53bc0-d02e-346e-a183-238b5e233773
2024-04-19T09:03:32.322+07:00  INFO 74487 --- [spring-boot-vault-integration-demo] [           main] pringBootVaultIntegrationDemoApplication : Started SpringBootVaultIntegrationDemoApplication in 0.876 seconds (process running for 1.169)
2024-04-19T09:03:32.324+07:00  INFO 74487 --- [spring-boot-vault-integration-demo] [           main] pringBootVaultIntegrationDemoApplication : External Api URI : https://external-api-demo.com/v1/ 
2024-04-19T09:03:32.324+07:00  INFO 74487 --- [spring-boot-vault-integration-demo] [           main] pringBootVaultIntegrationDemoApplication : External Api Key : Naruto2024! 
```
