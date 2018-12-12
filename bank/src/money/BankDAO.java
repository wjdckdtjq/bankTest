package money;


import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.text.StyledEditorKit.ForegroundAction;

public class BankDAO {

	public void insert(BankDTO dto) throws Exception {
		String url = "jdbc:mysql://localhost:3306/bank?useUnicode=true&characterEncoding=utf8";
		String user = "root";
		String password = "1234";

		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, user, password);
		String sql = "insert into member value(?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, dto.getId());
		ps.setString(2, dto.getName());
		ps.setString(3, dto.getAge());
		ps.setString(4, dto.getTel());
	
		ps.executeUpdate();

		con.close();
		ps.close();
	}

	public ArrayList<BankDTO> selectinfo(String id) throws Exception {
		String url = "jdbc:mysql://localhost:3306/bank";
		String user = "root";
		String password = "1234";

		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, user, password);
		String sql = "select * from member where id = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, id);
		ResultSet rs = ps.executeQuery();
		
		ArrayList<BankDTO> list = new ArrayList<BankDTO>();
		BankDTO dto;
		while (rs.next()) {
			dto = new BankDTO();
			dto.setId(rs.getString(1));
			dto.setName(rs.getString(2));
			dto.setAge(rs.getString(3));
			dto.setTel(rs.getString(4));
			list.add(dto);
		}
		con.close();
		ps.close();
		rs.close();

		return list;
	}

	public ArrayList<BankDTO> selectAll() throws Exception {
		String url = "jdbc:mysql://localhost:3306/bank";
		String user = "root";
		String password = "1234";

		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, user, password);
		String sql = "select * from member ";
		PreparedStatement ps = con.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		
		ArrayList<BankDTO> list = new ArrayList<BankDTO>();
		BankDTO dto;
		while (rs.next()) {
			dto = new BankDTO();
			dto.setId(rs.getString(1));
			dto.setName(rs.getString(2));
			dto.setAge(rs.getString(3));
			dto.setTel(rs.getString(4));
			list.add(dto);
		}
		con.close();
		ps.close();
		rs.close();

		return list;
	}

	public void delete(String id) throws Exception {
		String url = "jdbc:mysql://localhost:3306/bank";
		String user = "root";
		String password = "1234";

		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, user, password);
		String sql = "delete from member where id = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, id);
		ps.executeUpdate();
		con.close();
		ps.close();
	}
	
	
	public void updateTel(String tel, String id) throws Exception {
		String url = "jdbc:mysql://localhost:3306/bank?useUnicode=true&characterEncoding=utf8";
		String user = "root";
		String password = "1234";
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, user, password);
		String sql = "update member set tel = ? where id = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, tel);
		ps.setString(2, id);
		ps.executeUpdate();

		con.close();
		ps.close();
	}

	
	
}