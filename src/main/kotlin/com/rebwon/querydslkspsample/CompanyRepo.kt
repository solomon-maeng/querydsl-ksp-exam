package com.rebwon.querydslkspsample

import com.querydsl.jpa.impl.JPAQueryFactory
import com.rebwon.querydslkspsample.QCompany.Companion.company
import org.springframework.stereotype.Repository
import java.time.ZonedDateTime

@Repository
class CompanyRepo(
    private val jpaQueryFactory: JPAQueryFactory
) {

    fun findAll(
        size: Long,
        currentDate: ZonedDateTime,
        nextId: Long?
    ): List<Long> {
        return nextId?.let {
            jpaQueryFactory.select(company.id)
                .from(company)
                .where(company.id.gt(nextId))
                .limit(size)
                .orderBy(company.id.asc())
                .fetch()
        } ?: jpaQueryFactory.select(company.id)
            .from(company)
            .limit(size)
            .fetch()
    }
}