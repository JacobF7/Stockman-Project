package inventory

import product.{Product, ProductFactory}

import scala.io.Source

/**
  * This factory is responsible for the creation of the [[Inventory]].
  *
  * Created by jacobfalzon on 09/09/2017.
  */
object InventoryFactory {

  /**
    * Create the [[Inventory]] by parsing each [[Product]] contained within a text file.
    *
    * @param path the location of the text file.
    * @return the [[Inventory]].
    */
  def create(path: String): Inventory = new Inventory(parseProducts(Source.fromFile(path).getLines().toList.tail))

  /**
    * Parse each [[Product]] contained within the inventory text file.
    *
    * @param inventory a [[List]] representing each line within the inventory text file.
    * @return the [[List]] of [[Product]]s.
    */
  private def parseProducts(inventory: List[String]): List[Product] = filter(inventory).map(product => ProductFactory.create(product))

  /**
    * Filter the inventory by discarding anything that is considered unwanted.
    *
    * @param inventory a [[List]] representing each line within the inventory text file.
    * @return a [[List]] representing the filtered inventory text file.
    */
  private def filter(inventory: List[String]) : List[String] = inventory.filter(product => !product.startsWith(getIgnoreKeyword))

  /**
    * @return a [[String]] containing the keyword to ignore whilst parsing the file
    */
  private def getIgnoreKeyword: String = "#"

}
