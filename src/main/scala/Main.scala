import inventory.InventoryFactory

/**
  * Serves to test implementation.
  *
  * Created by jacobfalzon on 08/09/2017.
  */
object Main {

  def main(args: Array[String]): Unit = {
    println(InventoryFactory.create("src/main/scala/stock.txt").tabulate)
  }

}
