package com.model2.mvc.service.purchase.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.domain.Purchase;
import com.model2.mvc.service.domain.User;
import com.model2.mvc.service.product.ProductDao;
import com.model2.mvc.service.product.ProductService;
import com.model2.mvc.service.purchase.PurchaseDao;
import com.model2.mvc.service.purchase.PurchaseService;
import com.model2.mvc.service.user.UserDao;
import com.model2.mvc.service.user.UserService;

@Service
public class PurchaseServiceImpl implements PurchaseService{

	//Field
	private PurchaseDao purchaseDao;
	private ProductDao productDao;
	private UserDao userDao;
	
	
	//Constructor
	public PurchaseServiceImpl() {
		
	}
	
	@Autowired
	public PurchaseServiceImpl(ProductDao productDao, UserDao userDao, PurchaseDao purchaseDao) {
		this.purchaseDao = purchaseDao;
		this.productDao = productDao;
		this.userDao = userDao;
	}
//	
//	@Autowired
//	private PurchaseDao purchaseDao;
//	public void setPurchaseDao(PurchaseDao purchaseDao) {
//		this.purchaseDao = purchaseDao;
//	}


	//Method
	
	// if문 다음에 기능 추가 필요  / User 누적금액 내용 추가 필요 
	@Override
	public void addPurchase(Purchase purchase) throws Exception {	
		
		Product product = purchase.getPurchaseProd(); // Purchase 에 담긴 Product 정보 대입 
		
		if(product.getStock() >= purchase.getQuantity()) {
			
			product.setStock(product.getStock() - purchase.getQuantity());
			productDao.updateStockProduct(product);
			
			purchaseDao.addPurchase(purchase);	
			
		}
		
	}


	@Override
	public Purchase getPurchase(int tranNo) throws Exception {
		System.out.println("PurcahseServiceImpl ==> getPurchase-->>>>>>>>");
		return purchaseDao.getPurchase(tranNo);
	}

	@Override
	public void updatePurchase(Purchase purchase) throws Exception {
		System.out.println("PurcahseServiceImpl ==> updatePurchase-->>>>>>>>");
		purchaseDao.updatePurchase(purchase);
	}


	@Override
	public Map<String, Object> getPurchaseList(Search search, String userId) throws Exception {
		List<Object> list= purchaseDao.getPurchaseList(search,userId);
		int totalCount = purchaseDao.getTotalCount(search);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list );
		map.put("totalCount", new Integer(totalCount));
		
		return map;
	}


	@Override
	public Map<String, Object> getSaleList(Search search) throws Exception {
		return purchaseDao.getSaleList(search);
	}


	@Override
	public void updateTranCode(Purchase purchase) throws Exception {	
		purchaseDao.updateTranCode(purchase);
	}

	
}// end of class 
