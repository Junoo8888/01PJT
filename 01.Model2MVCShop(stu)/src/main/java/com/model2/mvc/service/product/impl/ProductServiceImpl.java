package com.model2.mvc.service.product.impl;

import java.util.HashMap;

import com.model2.mvc.common.SearchVO;
import com.model2.mvc.service.product.ProductService;
import com.model2.mvc.service.product.dao.ProductDAO;
import com.model2.mvc.service.product.vo.ProductVO;

public class ProductServiceImpl implements ProductService{
	 
	//Field
	private ProductDAO dao;

	//Constructor
	public ProductServiceImpl() {
		dao = new ProductDAO();
	}
	
	@Override
	public void addProduct(ProductVO productVO) throws Exception {
		dao.insertProduct(productVO);
	}

	public ProductVO getProduct(int prodNo) throws Exception {
		return dao.findProduct(prodNo);
	}

	

	@Override
	public HashMap<String, Object> getProductList(SearchVO searchVO) throws Exception {
		return dao.getProductList(searchVO);
	}

	@Override
	public void updateProduct(ProductVO productVO) throws Exception{
		// TODO Auto-generated method stub
		
	}

}// end of class
