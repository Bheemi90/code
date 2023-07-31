import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

/**
 * 参考: https://kotest.io/
 */
class SampleKotestTest : StringSpec({
    "~のとき、〇〇になること" {
        1 shouldBe 1
    }
})
