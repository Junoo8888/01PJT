package com.model2.mvc.service.purchase.impl;

import java.util.HashMap;

import com.model2.mvc.common.SearchVO;
import com.model2.mvc.service.product.dao.ProductDAO;
import com.model2.mvc.service.product.vo.ProductVO;
import com.model2.mvc.service.purchase.PurchaseService;
import com.model2.mvc.service.purchase.dao.PurchaseDAO;
import com.model2.mvc.service.purchase.vo.PurchaseVO;

public class PurchaseServiceImpl implements PurchaseService{

	//Field 
	private PurchaseDAO dao;
	private ProductDAO productDao;
	
	//Constructor
	public PurchaseServiceImpl() {
		dao = new PurchaseDAO();
	}
	
	//Method 
	@Override
	public void addPurcharse(PurchaseVO purcharseVO) throws Exception {
		dao.insertPurcharse(purcharseVO);
		
	}
	@Override
	public PurchaseVO getPurcharse(int tranNo) throws Exception {
		return dao.findPurchase(tranNo);
	}
	@Override
	public HashMap<String, Object> getPurcharseList(SearchVO searchVO, String userId) throws Exception {
		return dao.getPurchaseList(searchVO, userId);
	}
	@Override
	public HashMap<String, Object> getSaleList(SearchVO serchVO) throws Exception {
		return dao.getSaleList(serchVO);
	}
	@Override
	public void updatePurchase(PurchaseVO purcharseVO) throws Exception {
		System.out.println("updatePurchaseDao ½ÇÇà ");
		dao.updatePurcharse(purcharseVO);
		
	}
	@Override
	public void updateTranCode(PurchaseVO purchaseVO) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	
}// end of class 
