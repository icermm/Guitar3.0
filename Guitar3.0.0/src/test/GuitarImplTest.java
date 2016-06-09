package test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

public class GuitarImplTest {

	@Test
	public void test(){
		sqliteDao.GuitarImpl impl = new sqliteDao.GuitarImpl();
		assertEquals(impl.getAllGuitars().size(),5);
	}


}
