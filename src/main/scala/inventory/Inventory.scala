package inventory

import product.Product

/**
  * The placeholder for the inventory. An inventory comprises of several [[Product]]s.
  *
  * Created by jacobfalzon on 09/09/2017.
  */
class Inventory(val products: List[Product]) {

  /**
    * @return the [[List]] of [[Product]]s within the inventory.
    */
  def getProducts: List[Product] = products

  /**
    * @return a tabular representation of the inventory, sorted by [[Product]] quantity in descending order.
    */
  def tabulate: String = products.sortWith(_.quantity > _.quantity)
                                 .map(_.tabulate)
                                 .mkString("+=====================================+=====================================+\n" +
                                           "|            Product Name             |            Available Qty            |\n" +
                                           "+=====================================+=====================================+\n",
                                           "\n+-------------------------------------+-------------------------------------+\n",
                                           "\n+=====================================+=====================================+")

  override def toString = s"Inventory($products)"
}
