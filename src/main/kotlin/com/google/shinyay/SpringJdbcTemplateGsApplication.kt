package com.google.shinyay

import com.google.shinyay.model.Child
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.jdbc.core.JdbcTemplate
import java.sql.ResultSet
import java.util.function.Consumer

@SpringBootApplication
class SpringJdbcTemplateGsApplication(val jdbcTemplate: JdbcTemplate) : CommandLineRunner {
	override fun run(vararg args: String?) {
		logger.info("Creating Tables...")
		jdbcTemplate.execute("DROP TABLE children IF EXISTS")
		jdbcTemplate.execute("""
					CREATE TABLE children(
						id SERIAL,
						first_name VARCHAR(255),
						last_name VARCHAR(255));
		""".trimIndent())

		jdbcTemplate.execute("INSERT INTO children(first_name, last_name) VALUES ('Rei','Ayanami')")
		jdbcTemplate.execute("INSERT INTO children(first_name, last_name) VALUES ('Shinji','Ikari')")
		jdbcTemplate.execute("INSERT INTO children(first_name, last_name) VALUES ('Asuka','Soryu')")

		jdbcTemplate.query<Any>(
				"SELECT id, first_name, last_name FROM children WHERE first_name = ?", arrayOf<Any>("Rei")
		) {
			rs: ResultSet, rowNum: Int -> Child(
				rs.getLong("id"),
				rs.getString("first_name"),
				rs.getString("last_name")
		) }.forEach(
				Consumer { child: Any -> logger.info(child.toString()) }
		)
	}
}

fun main(args: Array<String>) {
	runApplication<SpringJdbcTemplateGsApplication>(*args)
}

val Any.logger: Logger
	get() = LoggerFactory.getLogger(this.javaClass)