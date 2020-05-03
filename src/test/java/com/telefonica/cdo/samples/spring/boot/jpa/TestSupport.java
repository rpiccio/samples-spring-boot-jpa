package com.telefonica.cdo.samples.spring.boot.jpa;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.testcontainers.containers.MySQLContainer;

@AutoConfigureWebTestClient
@ContextConfiguration(initializers = {TestSupport.Initializer.class})
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public abstract class TestSupport {

    public static MySQLContainer<?> db = new MySQLContainer<>("mysql:8");

    static {
        db.start();
    }

    @Autowired
    protected TestRestTemplate restTemplate;

    @LocalServerPort
    protected int port;

    public static class Initializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

        public void initialize(ConfigurableApplicationContext configurableApplicationContext) {

            TestPropertyValues.of(
                "spring.datasource.url=" + buildJdbcUrl(),
                "spring.datasource.username=" + db.getUsername(),
                "spring.datasource.password=" + db.getPassword()
            ).applyTo(configurableApplicationContext.getEnvironment());

            TestPropertyValues.of(
                "spring.flyway.url=" + buildJdbcUrl(),
                "spring.flyway.username=" + db.getUsername(),
                "spring.flyway.password=" + db.getPassword(),
                "spring.flyway.locations=" + "classpath:db/migration/mysql"
            ).applyTo(configurableApplicationContext.getEnvironment());

        }

        private String buildJdbcUrl() {
            return String.format("jdbc:mysql://%s:%d/%s", db.getContainerIpAddress(), db.getMappedPort(3306), db.getDatabaseName());
        }

    }

}
