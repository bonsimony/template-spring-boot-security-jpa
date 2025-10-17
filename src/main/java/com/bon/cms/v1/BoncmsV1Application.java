package com.bon.cms.v1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;       // ① 임포트 추가
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration; // ② 임포트 추가

@SpringBootApplication(
    exclude = {
        DataSourceAutoConfiguration.class,       // ③ DB 연결 자동 설정 제외
        HibernateJpaAutoConfiguration.class      // ④ JPA/Hibernate 자동 설정 제외
    }
)
public class BoncmsV1Application {

    public static void main(String[] args) {
        SpringApplication.run(BoncmsV1Application.class, args);
    }
}