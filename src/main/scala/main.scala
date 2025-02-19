object Main {
  /**
   * The main entry point for the application which processes command line arguments to calculate the price of a shopping basket.
   *
   * @param args Command line arguments representing items in the basket.
   */
  def main(args: Array[String]): Unit = {
    if (args.isEmpty) {
      println("Please specify items to price.")
      System.exit(1)
    }

    val basket = new ShoppingBasket()
    args.foreach(arg => basket.addItem(arg.toLowerCase))

    val result = basket.calculatePrice()
    println(s"Subtotal: £${result.subtotal}")
    if (result.discounts.nonEmpty) {
      result.discounts.foreach { case (item, discount) =>
        println(s"$item ${discount._1}% off: ${discount._2.setScale(2, BigDecimal.RoundingMode.HALF_UP)}p")
      }
    } else {
      println("(No offers available)")
    }
    println(s"Total price: £${result.totalPrice.setScale(2, BigDecimal.RoundingMode.HALF_UP)}")
  }
}