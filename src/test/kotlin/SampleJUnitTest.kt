@file:Suppress("NonAsciiCharacters")

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

/**
 * 参考: https://junit.org/junit5/docs/current/user-guide/
 */
class SampleJUnitTest {

    @Test
    fun `~のとき、〇〇になること`() {
        assertEquals(1, 1)
    }
}
