package com.rebwon.querydslkspsample

import jakarta.persistence.*

@Entity
@Table(name = "companies")
class Company(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L,
    var companyName: String?,
    var address: String?
)