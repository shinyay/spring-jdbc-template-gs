package com.google.shinyay

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.jdbc.core.JdbcTemplate

@SpringBootApplication
class SpringJdbcTemplateGsApplication(val jdbcTemplate: JdbcTemplate) : CommandLineRunner {
	override fun run(vararg args: String?) {
		logger.info("Creating Tables...")
		jdbcTemplate.execute("DROP TABLE customers IF EXISTS")
		jdbcTemplate.execute("""
					CREATE TABLE customers(
						id SERIAL,
						first_name VARCHAR(255),
						last_name VARCHAR(255)
		""".trimIndent())
	}
}

fun main(args: Array<String>) {
	runApplication<SpringJdbcTemplateGsApplication>(*args)
}

val Any.logger: Logger
	get() = LoggerFactory.getLogger(this.javaClass)