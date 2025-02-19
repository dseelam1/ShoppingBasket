import scala.collection.mutable

/**
 * Represents a shopping basket where items can be added, and pricing calculations including discounts can be performed.
 */
class ShoppingBasket {
  /**
   * Map of item names to their prices in BigDecimal for precise calculations.
   */
  private val prices = Map(
    "soup" -> BigDecimal("0.65"),
    "bread" -> BigDecimal("0.80"),
    "milk" -> BigDecimal("1.30"),
    "apples" -> BigDecimal("1.00")
  )

  /**
   * Mutable map to hold items in the basket with their quantities.
   */
  private val items = mutable.Map[String, Int]()

  /**
   * Adds an item to the basket. If the item already exists, increments its count.
   *
   * @param item The name of the item to add.
   */
  def addItem(item: String): Unit = {
    items.update(item, items.getOrElse(item, 0) + 1)
  }

  /**
   * Calculates the price of items in the basket, including any applicable discounts.
   *
   * @return A PriceCalculation object containing the subtotal, discounts, and total price.
   */
  def calculatePrice(): PriceCalculation = {
    val subtotal = items.map { case (item, count) => prices(item) * count }.sum

    val discounts = List(
      applyAppleDiscount(),
      applySoupBreadOffer()
    ).flatten

    val totalDiscount = discounts.map(_._2._2).sum
    PriceCalculation(subtotal, discounts, subtotal - totalDiscount)
  }

  /**
   * Applies a 10% discount on apples.
   *
   * @return An Option containing the discount details if apples are in the basket, else None.
   */
  private def applyAppleDiscount(): Option[(String, (Int, BigDecimal))] = {
    items.get("apples").map { count =>
      ("Apples", (10, prices("apples") * count * BigDecimal("0.1")))
    }
  }

  /**
   * Applies the special offer where buying 2 soups gives half price on bread.
   *
   * @return An Option with discount details if conditions are met, else None.
   */
  private def applySoupBreadOffer(): Option[(String, (Int, BigDecimal))] = {
    val soupCount = items.getOrElse("soup", 0)
    val breadCount = items.getOrElse("bread", 0)
    if (soupCount >= 2 && breadCount > 0) {
      Some(("Bread", (50, prices("bread") * breadCount * BigDecimal("0.5"))))
    } else None
  }
}

/**
 * Case class to hold the result of price calculation including discounts.
 *
 * @param subtotal The sum of all items before discounts.
 * @param discounts List of tuples where each tuple contains (item name, (discount percentage, discount amount in pence)).
 * @param totalPrice The final price after all discounts.
 */
case class PriceCalculation(subtotal: BigDecimal, discounts: List[(String, (Int, BigDecimal))], totalPrice: BigDecimal)