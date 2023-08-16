package com.model2.mvc.service.purchase;

import java.util.HashMap;

import com.model2.mvc.common.SearchVO;
import com.model2.mvc.service.purchase.vo.PurchaseVO;

public interface PurchaseService {
	
	public void addPurcharse(PurchaseVO purcharseVO) throws Exception;
	
	public PurchaseVO getPurcharse(int no) throws Exception;
	
	public HashMap<String, Object> getPurcharseList(SearchVO searchVO, String search) throws Exception;
	
	public HashMap<String, Object> getSaleList(SearchVO serchVO) throws Exception;
	
	public void updatePurchase(PurchaseVO purcharseVO) throws Exception;
	
	public void updateTranCode(PurchaseVO purchaseVO) throws Exception;

	

}
