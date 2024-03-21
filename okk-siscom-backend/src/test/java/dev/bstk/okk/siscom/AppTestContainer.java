package dev.bstk.okk.siscom;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.oracle.OracleContainer;


@Slf4j
@Testcontainers
@ExtendWith(AppTestExtension.class)
public abstract class AppTestContainer {

  private static final OracleContainer ORACLE_DB = new OracleContainer("gvenzl/oracle-free")
    .withEnv("ORACLE_DATABASE", "OKKSISCOMDB")
    .withEnv("APP_USER", "mock-user")
    .withEnv("APP_USER_PASSWORD", "mock-password")
    .withReuse(true);

  @DynamicPropertySource
  static void propertyConfig(final DynamicPropertyRegistry registry) {
    registry.add("spring.datasource.url", ORACLE_DB::getJdbcUrl);
    registry.add("spring.datasource.username", ORACLE_DB::getUsername);
    registry.add("spring.datasource.password", ORACLE_DB::getPassword);
    registry.add("spring.datasource.driverClassName", ORACLE_DB::getDriverClassName);

    registry.add("spring.flyway.url", ORACLE_DB::getJdbcUrl);
    registry.add("spring.flyway.user", ORACLE_DB::getUsername);
    registry.add("spring.flyway.password", ORACLE_DB::getPassword);


    registry.add("spring.datasource.hikari.minimum-idle", () -> 5);
    registry.add("spring.datasource.hikari.max-lifetime", () -> 100);
    registry.add("spring.datasource.hikari.maximum-pool-size", () -> 20);
    registry.add("spring.datasource.hikari.connection-timeout", () -> 5000);
  }

  public static void startContainer() {
    ORACLE_DB.start();
    log.info("Container Id: [ {} ] Image: [ {} ] iniciado.",
      ORACLE_DB.getContainerId(),
      ORACLE_DB.getContainerInfo().getImageId()
    );
  }

  public static void stopContainer() {
    final var containerId = ORACLE_DB.getContainerId();
    final var containerName = ORACLE_DB.getContainerInfo().getName();

    ORACLE_DB.stop();

    log.info("Container Id: [ {} ] Image: [ {} ] finalizado.",
      containerId,
      containerName
    );
  }
}
