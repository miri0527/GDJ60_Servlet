package com.iu.home.product;

public class ProductService {
	//Service <->DAO<->DB 
	//DB로 연결해주는 아이 DAO, DAO로 연결하는 아이 Service

	public static void main(String[] args) {
		ProductDAO productDAO = new ProductDAO();
		
		ProductDTO productDTO = new ProductDTO();
		productDTO.setProduct_name("product1");
		productDTO.setProduct_detail("detail1");
		
		ProductOptionDTO productOptionDTO = new ProductOptionDTO(); //product_num은 시퀀스로 받아줬기 때문에 set안해줘도됨
		productOptionDTO.setOption_name("optionName1");
		productOptionDTO.setOption_price(100L);
		productOptionDTO.setOption_stock(10L);
		productOptionDTO.setProduct_num(null);
		
		try {
			//시퀀스부터 실행
			Long num = productDAO.getProductNum();
			//호출
			productDTO.setProduct_num(num);
			
			int result = productDAO.setAddProduct(productDTO);
			
			productOptionDTO.setProduct_num(num);
			
			if(result > 0) {
				productDAO.setAddProductOption(productOptionDTO);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
