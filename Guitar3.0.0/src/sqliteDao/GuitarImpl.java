package sqliteDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import beans.*;
import dao.IGuitar;
import util.DbUtil;

public class GuitarImpl implements IGuitar {

	@Override
	//查找吉他
		public  Inventory Inventory()
		{
			Inventory inventory = new Inventory();
			DbUtil jdbc=new DbUtil();
			Connection conn = jdbc.getConnection();
			PreparedStatement pstat;
			ResultSet rs;
			try {
				pstat = conn.prepareStatement("select * from guitar");
				rs = pstat.executeQuery();
				while (rs.next()) {
					GuitarSpec spec = new GuitarSpec( null, null, null, null,null);
					spec.setBuilder(rs.getString("builder"));
					spec.setModel(rs.getString("model"));
					spec.setType(rs.getString("type"));
					spec.setTopWood(rs.getString("topWood"));
					spec.setBackWood(rs.getString("backWood"));
					inventory.addGuitar(rs.getString("serialNumber"), rs.getDouble("price"), spec);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			finally{
				jdbc.closeConnection(conn);
			}
			return inventory;
		}
		
	//所有吉他	
	public List<Guitar> getAllGuitars(){
		Connection Conn = DbUtil.getConnection();
		String sql = "select * from Guitar";
		List<Guitar> inventory = new ArrayList<Guitar>();
		try {
			PreparedStatement pstmt = Conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				GuitarSpec spec = new GuitarSpec( null, null, null, null,null);
				spec.setBuilder(rs.getString("builder"));
				spec.setModel(rs.getString("model"));
				spec.setType(rs.getString("type"));
				spec.setTopWood(rs.getString("topWood"));
				spec.setBackWood(rs.getString("backWood"));				
				Guitar guitar = new Guitar(rs.getString("serialNumber"),rs.getDouble("price"),spec);
				inventory.add(guitar);				
			}			
			rs.close();
			pstmt.close();
			Conn.close();
		} catch (SQLException se) {
			se.printStackTrace();
		} catch(Exception e){
		    e.printStackTrace();	
		}finally{
			try{
		         if(Conn!=null)
		        	 Conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }
		}
		return inventory;
	}
		
		
		//添加吉他
		public void addGuitar(String serialNumber, double price,
	            GuitarSpec spec) {
			String sql="insert into guitar(serialNumber,builder,price,model,type,backWood,topWood) values(?,?,?,?,?,?,?)";
			Connection conn=DbUtil.getConnection();
			
			try {
				PreparedStatement ps=conn.prepareStatement(sql);
				ps.setString(1, serialNumber);
				ps.setString(2, spec.getBuilder());
				ps.setDouble(3, price);
				ps.setString(4,spec.getModel());			
				ps.setString(5, spec.getType());
			    ps.setString(6, spec.getBackWood());	
			    ps.setString(7, spec.getTopWood());			
				ps.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			
			}
		}
		
		
		//删除吉他
		 public void delGuitar(String serialNumber) {
				// TODO Auto-generated method stub
				String sql="delete from guitar where serialNumber=?";
		//		DbUtil jdbc=new DbUtil();
				Connection conn=DbUtil.getConnection();
				
				try {
					PreparedStatement ps=conn.prepareStatement(sql);
					ps.setString(1, serialNumber);
					ps.executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			}

}
