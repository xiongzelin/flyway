package xzl.xiongzelin.flyway;

import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.migration.JavaMigration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FlywayApplication {

    private static Logger log = LoggerFactory.getLogger(FlywayApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(FlywayApplication.class, args);

        Flyway flyway = Flyway.configure().dataSource("jdbc:h2:file:./foobardb","xzl","123456").load();

        log.info("数据开始迁移======");
        flyway.migrate();
        log.info("数据结束迁移------");
    }
}
