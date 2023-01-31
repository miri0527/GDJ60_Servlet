package com.iu.home.product;

import java.util.List;

public class ProductService {
	//Service <->DAO<->DB 
	//DB濡� �뿰寃고빐二쇰뒗 �븘�씠 DAO, DAO濡� �뿰寃고븯�뒗 �븘�씠 Service
	
	//결합도가 높다(강하다)
	
	//1.
	private ProductDAO productDAO; //=new ProductDAO();
	//2.
//	{
//		this.productDAO = new ProductDAO();
//	}
	//3.
	public ProductService() {
		productDAO = new ProductDAO();
	}
	
	//외부에서 가지고 온 거기 때문에 결합도가 낮다(약하다)
	//4.
	public void setProductDAO(ProductDAO productDAO) {
			this.productDAO = productDAO;
	}
	
	public int setAddProduct(ProductDTO productDTO, List<ProductOptionDTO> ar) throws Exception {
		//product, option 등록
		Long product_num = productDAO.getProductNum();
		productDTO.setProduct_num(product_num);
		int result = productDAO.setAddProduct(productDTO);
		
		for (ProductOptionDTO productOptionDTO : ar) {
			productOptionDTO.setProduct_num(product_num);
		    result = productDAO.setAddProductOption(productOptionDTO);

		}
		
		return result;
	}
	

	public static void main(String[] args) {
		ProductDAO productDAO = new ProductDAO();
		
		ProductDTO productDTO = new ProductDTO();
		productDTO.setProduct_name("product1");
		productDTO.setProduct_detail("detail1");
		
		ProductOptionDTO productOptionDTO = new ProductOptionDTO(); //product_num�� �떆���뒪濡� 諛쏆븘以ш린 �븣臾몄뿉 set�븞�빐以섎룄�맖
		productOptionDTO.setOption_name("optionName1");
		productOptionDTO.setOption_price(100L);
		productOptionDTO.setOption_stock(10L);
		productOptionDTO.setProduct_num(null);
		
		try {
			//�떆���뒪遺��꽣 �떎�뻾
			Long num = productDAO.getProductNum();
			//�샇異�
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
