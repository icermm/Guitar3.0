package dao;

import java.util.List;
import beans.*;

public interface IGuitar {
 	public List<Guitar> getAllGuitars();
	public Inventory Inventory();
	public void addGuitar(String serialNumber, double price, GuitarSpec spec) ;
	public void delGuitar(String serialNumber) ;
}
