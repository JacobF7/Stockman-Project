package product

/**
  * This factory is responsible for the creation of a [[Product]].
  *
  * Created by jacobfalzon on 09/09/2017.
  */
object ProductFactory {

  /**
    * Create a [[Product]] by parsing the name and quantity.
    *
    * @param product a [[String]] representation of the [[Product]].
    * @throws IllegalArgumentException if the [[String]] representation of the [[Product]] is invalid.
    * @return the [[Product]].
    */
  def create(product: String): Product = {

    val productDetails: Array[String] = product.split(getSeparator)

    // product must have a name and quantity
    if (productDetails.length != 2) {
      throw new IllegalArgumentException(s"Product is invalid ${productDetails.toList}")
    }

    new Product(parseName(productDetails.apply(0)),
                parseQuantity(productDetails.apply(1)))
  }

  /**
    * Parse the product name.
    *
    * @param name the product name.
    * @return the sanitized product name.
    */
  private def parseName(name: String) : String = name.trim

  /**
    * Parse the product quantity and convert it into an [[Int]].
    *
    * @param quantity the product quantity.
    * @throws IllegalArgumentException if the `quantity` is not numeric.
    * @return the [[Int]] representation of the sanitized product quantity.
    */
  private def parseQuantity(quantity: String) : Int = {

    val sanitizedQuantity: String = quantity.trim

    if(!(sanitizedQuantity forall Character.isDigit)){
      throw new IllegalArgumentException(s"Quantity is invalid $sanitizedQuantity")
    }

    sanitizedQuantity.toInt
  }

  /**
    * @return the separator used to partition the [[Product]] details, i.e. the name and quantity.
    */
  private def getSeparator: String = ","

}
