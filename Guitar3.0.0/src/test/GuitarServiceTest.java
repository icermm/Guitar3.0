package test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import dao.IGuitar;
import dao.dataAccess;
import beans.Guitar;

public class GuitarServiceTest {

	@Test
	public void test() {
		IGuitar i = dataAccess.createGuitarDao();
		List<Guitar> list = i.getAllGuitars();
		assertEquals(list.size(),5);
	}

}
