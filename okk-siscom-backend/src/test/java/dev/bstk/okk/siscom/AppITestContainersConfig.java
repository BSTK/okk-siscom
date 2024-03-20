package dev.bstk.okk.siscom;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.oracle.OracleContainer;

@Slf4j
@Testcontainers
public abstract class AppITestContainersConfig {

  private static final OracleContainer ORACLE_DB = new OracleContainer("gvenzl/oracle-free")
    .withEnv("ORACLE_DATABASE", "OKKSISCOMDB")
    .withEnv("APP_USER", "mock-user")
    .withEnv("APP_USER_PASSWORD", "mock-password");


  @DynamicPropertySource
  static void propertyConfig(final DynamicPropertyRegistry registry) {
    registry.add("spring.datasource.url", ORACLE_DB::getJdbcUrl);
    registry.add("spring.datasource.username", ORACLE_DB::getUsername);
    registry.add("spring.datasource.password", ORACLE_DB::getPassword);
    registry.add("spring.datasource.driverClassName", ORACLE_DB::getDriverClassName);

    registry.add("spring.flyway.url", ORACLE_DB::getJdbcUrl);
    registry.add("spring.flyway.user", ORACLE_DB::getUsername);
    registry.add("spring.flyway.password", ORACLE_DB::getPassword);
  }

  @BeforeAll
  public static void setUp() {
    ORACLE_DB.start();
    log.info("Container Id: [ {} ] Image: [ {} ] iniciado.",
      ORACLE_DB.getContainerId(),
      ORACLE_DB.getContainerInfo().getImageId()
    );
  }

  @AfterAll
  public static void tearDown() {
    final var containerId = ORACLE_DB.getContainerId();
    final var containerName = ORACLE_DB.getContainerInfo().getName();

    ORACLE_DB.stop();

    log.info("Container Id: [ {} ] Image: [ {} ] finalizado.",
      containerId,
      containerName
    );
  }
}
