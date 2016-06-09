package beans;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Inventory {
  private List<Guitar> guitars;

  public Inventory() {
    guitars = new LinkedList();
  }

  //��Ӽ���
  public void addGuitar(String serialNumber, double price,
                        GuitarSpec spec) {
    Guitar guitar = new Guitar(serialNumber, price, spec);
    guitars.add(guitar);
  }

  //ɾ������
  
  
//  public void delGuitar(String serialNumber){
	//  Guitar guitar = new Guitar(serialNumber, price, spec);
	  //  guitars.delete(guitar);
  //}
  
  //ϵ�кŻ�ȡ����
  public Guitar getGuitar(String serialNumber) {
    for (Iterator i = guitars.iterator(); i.hasNext(); ) {
      Guitar guitar = (Guitar)i.next();
      if (guitar.getSerialNumber()==(serialNumber)) {
        return guitar;
      }
    }
    return null;
  }

  //���Ҽ���
  public List search(GuitarSpec searchspec) {
    List matchingGuitars = new LinkedList();
    for (Iterator i = guitars.iterator(); i.hasNext(); ) {
      Guitar guitar = (Guitar)i.next();
      System.out.println(guitar.getSpec().getType());
      System.out.println(searchspec.getType());
      if (guitar.getSpec().matches(searchspec))
        matchingGuitars.add(guitar);
    }
    return matchingGuitars;
  }

public List<Guitar> getGuitars() {
	return guitars;
}

public void setGuitars(List<Guitar> guitars) {
	this.guitars = guitars;
}
  
}
