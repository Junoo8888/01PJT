package com.model2.mvc.service.purchase.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.domain.Purchase;
import com.model2.mvc.service.product.ProductService;
import com.model2.mvc.service.purchase.PurchaseDao;

@Repository
public class PurchaseDaoImpl implements PurchaseDao{

	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSession sqlSession;
	public void setSqlSession(SqlSession sqlSession) {
		System.out.println("PurchaseDaoImpl SqlSession Create");
		this.sqlSession = sqlSession;
	}
	
	
	@Override
	public void addPurchase(Purchase purchase) throws Exception {
		
	}

	@Override
	public Purchase getPurchase(int tranNo) throws Exception {
		return sqlSession.selectOne("PurchaseMapper.getPurchase", tranNo);
	}

	@Override
	public void updatePurchase(Purchase purchase) throws Exception {
		sqlSession.update("PurchaseMapper.updatePurchase", purchase);
	}

	@Override
	public List<Object> getPurchaseList(Search search, String userId) throws Exception {
		
		List<Object> list = new ArrayList<Object>();
		list.add(search);
		list.add(userId);
		return sqlSession.selectList("PurchaseMapper.getPurchaseList", list );
	}

	@Override
	public Map<String, Object> getSaleList(Search serch) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	public int getTotalCount(Search search) throws Exception {
		return sqlSession.selectOne("UserMapper.getTotalCount", search);
	}
	@Override
	public void updateTranCode(Purchase purchaseVO) throws Exception {
		
	}

}// end of class 
