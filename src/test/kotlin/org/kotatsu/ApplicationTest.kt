package org.kotatsu

import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.server.testing.*
import org.kotatsu.plugins.configureRouting
import kotlin.test.*

class ApplicationTest {
	@Test
	fun testRoot() = testApplication {
		application {
			configureRouting()
		}
		client.get("/").apply {
			assertEquals(HttpStatusCode.OK, status)
			assertEquals("Alive", bodyAsText())
		}
	}
}