package test;
import java.util.Iterator;
import java.util.List;

import beans.*;


public class FindGuitarTest {

  public static void main(String[] args) {
    // Set up Rick's guitar inventory
    Inventory inventory = new Inventory();
    initializeInventory(inventory);

    GuitarSpec test = 
      new GuitarSpec("a", "a", "a", "a","a");
    List matchingGuitars = inventory.search(test);
    if (!matchingGuitars.isEmpty()) {
      System.out.println("ËÑË÷½á¹û----");
      for (Iterator i = matchingGuitars.iterator(); i.hasNext(); ) {
        Guitar guitar = (Guitar)i.next();
        GuitarSpec spec = guitar.getSpec();
        System.out.println(spec.getBuilder() + "--" + spec.getModel() + "--" +
          spec.getType() + "--" +spec.getBackWood() + "--" +spec.getTopWood() + "--" +
          guitar.getPrice()+"--"+guitar.getSerialNumber());
      }
    } else {
      System.out.println("Sorry, Erin, we have nothing for you.");
    }
  }

  private static void initializeInventory(Inventory inventory) {
    inventory.addGuitar("v1", 3999, 
      new GuitarSpec("a", "a", "a", "a","a"));
    inventory.addGuitar("V2", 1499, 
      new GuitarSpec("b", "b", "b", "b","b"));
    inventory.addGuitar("V3", 1549, 
      new GuitarSpec("c", "c", "c", "c","c"));

  }
}
