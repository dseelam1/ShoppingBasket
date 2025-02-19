import org.scalatest.funsuite.AnyFunSuite

/**
 * Test suite for ShoppingBasket class to ensure correct pricing and discount application.
 */
class ShoppingBasketSpec extends AnyFunSuite {
  test("Basket with only apples should apply 10% discount") {
    val basket = new ShoppingBasket()
    basket.addItem("apples")
    val result = basket.calculatePrice()
    assert(result.subtotal == BigDecimal("1.00"))
    assert(result.discounts == List(("Apples", (10, BigDecimal("0.10")))))
    assert(result.totalPrice == BigDecimal("0.90"))
  }

  test("Basket with soup and bread should apply bread discount") {
    val basket = new ShoppingBasket()
    basket.addItem("soup")
    basket.addItem("soup")
    basket.addItem("bread")
    val result = basket.calculatePrice()
    assert(result.subtotal == BigDecimal("2.10"))
    assert(result.discounts == List(("Bread", (50, BigDecimal("0.40")))))
    assert(result.totalPrice == BigDecimal("1.70"))
  }

  test("Basket with no offers") {
    val basket = new ShoppingBasket()
    basket.addItem("milk")
    val result = basket.calculatePrice()
    assert(result.subtotal == BigDecimal("1.30"))
    assert(result.discounts.isEmpty)
    assert(result.totalPrice == BigDecimal("1.30"))
  }
}