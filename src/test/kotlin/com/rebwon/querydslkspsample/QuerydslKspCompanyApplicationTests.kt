package com.rebwon.querydslkspsample

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.Transactional
import java.time.ZonedDateTime

@SpringBootTest
@Transactional
class QuerydslKspCompanyApplicationTests {

    @Test
    fun name(@Autowired repo: CompanyRepo) {
        repo.findAll(
            size = 100L,
            currentDate = ZonedDateTime.now(),
            nextId = 1L
        )
    }
}
