package product

/**
  * The placeholder for an product. A product comprises of a name and quantity.
  *
  * Created by jacobfalzon on 09/09/2017.
  */
class Product(val name: String, val quantity: Int) {

  /**
    * @return the name of the product.
    */
  def getName: String = name

  /**
    * @return the available quantity of the product.
    */
  def getQuantity: Int = quantity

  /**
    * @return a tabular representation of the product.
    */
  def tabulate: String = {
    val cellWidth: Int = 35 // width of each cell in the table
    s"| ${name.padTo(cellWidth, " ").mkString} | ${quantity.toString.padTo(cellWidth, " ").mkString} |"
  }

  override def toString = s"Product($name, $quantity)"
}
