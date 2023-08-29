package com.model2.mvc.service.purchase;

import java.util.List;
import java.util.Map;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Purchase;

public interface PurchaseDao {
	
	public void addPurchase(Purchase purchase)throws Exception;
	
	public Purchase getPurchase(int tranNo)throws Exception;
	
	public void updatePurchase(Purchase purchase)throws Exception;
	
	public List<Object> getPurchaseList(Search search, String userId) throws Exception;
	
	public Map<String, Object> getSaleList(Search serch) throws Exception;
	
	public int getTotalCount(Search search) throws Exception ;
	
	public void updateTranCode(Purchase purchaseVO) throws Exception;

}// end of class 
