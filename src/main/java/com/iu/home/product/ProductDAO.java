package com.iu.home.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.iu.home.util.DBConnection;

public class ProductDAO {
	
	public Long getProductNum() throws Exception {
		Connection con = DBConnection.getConnection();
		
		String sql = "SELECT PRODUCT_SEQ.NEXTVAL FROM DUAL";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		
		rs.next();
		
		Long num =  rs.getLong(1); //Long타입으로 담아주기
		
		DBConnection.disConnection(rs, st, con);
		
		return num;
		
	}
	
	public List<ProductOptionDTO> getProductOptionList() throws Exception {
		List<ProductOptionDTO> ar = new ArrayList<ProductOptionDTO>();
		
		Connection con = DBConnection.getConnection();
		
		String sql = "SELECT * FROM PRODUCTOPTION";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			ProductOptionDTO productOptionDTO = new ProductOptionDTO();
			productOptionDTO.setOption_num(rs.getLong("OPTION_NUM"));
			productOptionDTO.setProduct_num(rs.getLong("PRODUCT_NUM"));
			productOptionDTO.setOption_name(rs.getString("OPTION_NAME"));
			productOptionDTO.setOption_price(rs.getLong("OPTION_PRICE"));
			productOptionDTO.setOption_stock(rs.getLong("OPTION_STOCK"));
		}
		DBConnection.disConnection(rs, st, con);
		return ar;
	}
	
	public int setAddProductOption(ProductOptionDTO productOptionDTO) throws Exception {
		Connection con = DBConnection.getConnection();
		
		String sql = "INSERT INTO PRODUCTOPTION (OPTION_NUM, PRODUCT_NUM, OPTION_NAME, OPTION_PRICE, OPTION_STOCK) "
				+ "VALUES (PRODUCT_SEQ.NEXTVAL,?,?,?,?)";
		
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setLong(1, productOptionDTO.getOption_num());
		st.setLong(2, productOptionDTO.getProduct_num());
		st.setString(3, productOptionDTO.getOption_name());
		st.setLong(4, productOptionDTO.getOption_price());
		st.setLong(5, productOptionDTO.getOption_stock());
		
		int result = st.executeUpdate();
		DBConnection.disConnection(st, con);
		
		return result;
		
	}
	
	public List<ProductDTO> getProductList() throws Exception {
		ArrayList<ProductDTO> ar = new ArrayList<ProductDTO>();
		
		Connection con = DBConnection.getConnection();
		String sql = "SELECT PRODUCT_NUM, PRODUCT_NAME, PRODUCT_JUMSU "
				+ "FROM PRODUCT ORDER BY PRODUCT_JUMSU DESC";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			ProductDTO productDTO = new ProductDTO();
			productDTO.setProduct_num(rs.getLong("PRODUCT_NUM"));
			productDTO.setProduct_name(rs.getString("PRODUCT_NAME"));
			productDTO.setProduct_jumsu(rs.getDouble("PRODUCT_JUMSU"));
			ar.add(productDTO);
		}
		
		DBConnection.disConnection(rs, st, con);
		return ar;
	}
	
	public int setAddProduct(ProductDTO productDTO) throws Exception {
		Connection con = DBConnection.getConnection();
		
		String sql = "INSERT INTO PRODUCT VALUES (?,?,?,0.0)";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setLong(1, productDTO.getProduct_num());
		st.setString(2, productDTO.getProduct_name());
		st.setString(3, productDTO.getProduct_detail());
		
		int result = st.executeUpdate();
		DBConnection.disConnection(st, con);
		
		return result;
		
	}
	
//	public static void main(String[] args) {
//		ProductDAO productDAO = new ProductDAO();
//		ProductOptionDTO productOptionDTO = new ProductOptionDTO();
//		
//		try {
//			int result = productDAO.setProductOption(productOptionDTO);
//			System.out.println(result !=0);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
	//}
}
