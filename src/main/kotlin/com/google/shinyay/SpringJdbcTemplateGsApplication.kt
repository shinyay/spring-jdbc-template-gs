package com.google.shinyay

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringJdbcTemplateGsApplication

fun main(args: Array<String>) {
	runApplication<SpringJdbcTemplateGsApplication>(*args)
}

val Any.logger: Logger
	get() = LoggerFactory.getLogger(this.javaClass)