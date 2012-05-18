package com.jshop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.jshop.dao.CartTDao;
import com.jshop.dao.impl.CartTDaoImpl;
import com.jshop.entity.CartT;
import com.jshop.service.CartTService;

@Service("cartTService")
@Scope("prototype")
public class CartTServiceImpl implements CartTService {
	@Resource(name="cartTDao")
	private CartTDao cartTDao;


	public CartTDao getCartTDao() {
		return cartTDao;
	}

	public void setCartTDao(CartTDao cartTDao) {
		this.cartTDao = cartTDao;
	}

	public int addCart(CartT c) {
		return this.getCartTDao().addCart(c);
	}

	public int countfindAllCart() {
		return this.getCartTDao().countfindAllCart();
	}

	public List<CartT> findAllCart(int currentPage, int lineSize) {
		return this.getCartTDao().findAllCart(currentPage, lineSize);
	}

	public List<CartT> findAllCartByUserId(String userid) {
		return this.getCartTDao().findAllCartByUserId(userid);
	}

	public CartT findGoodsInCartOrNot(String userid, String goodsid, String state) {
		return this.getCartTDao().findGoodsInCartOrNot(userid, goodsid, state);
	}

	public int updateCartNeedquantityByGoodsid(String userid, String goodsid, int needquantity, String state) {
		return this.getCartTDao().updateCartNeedquantityByGoodsid(userid, goodsid, needquantity, state);
	}

	public int reduceCartNeddquantityByGoodsid(String userid, String goodsid, int needquantity) {
		return this.getCartTDao().reduceCartNeddquantityByGoodsid(userid, goodsid, needquantity);
	}

	public int delCartByGoodsId(String userid, String goodsid) {
		return this.getCartTDao().delCartByGoodsId(userid, goodsid);
	}

	public int updateCartNeedquantity(String userid, String goodsid, int needquantity) {
		return this.getCartTDao().updateCartNeedquantity(userid, goodsid, needquantity);
	}

	public int updateCartSubtotal(String userid, String goodsid, double subtotal) {
		return this.getCartTDao().updateCartSubtotal(userid, goodsid, subtotal);
	}

	public int updateCartState(String userid, String goodsid, String state) {
		return this.getCartTDao().updateCartState(userid, goodsid, state);
	}

	public int updateCartStateandOrderidByGoodsidList(String cartid, String orderid, String userid, String state) {
		return this.getCartTDao().updateCartStateandOrderidByGoodsidList(cartid, orderid, userid, state);
	}

	public List<CartT> findCartGoodsByOrderid(String orderid) {
		return this.getCartTDao().findCartGoodsByOrderid(orderid);
	}

	public int updateCartStateByGoodsidList(String userid, String[] goodsid, String state) {
		return this.getCartTDao().updateCartStateByGoodsidList(userid, goodsid, state);
	}

	public int updateCartId(String cartid, String userid, String goodsid, String state) {
		return this.getCartTDao().updateCartId(cartid, userid, goodsid, state);
	}

	public List<CartT> findCartByCartid(String cartid, String state) {
		return this.getCartTDao().findCartByCartid(cartid, state);
	}
	
	
	
}
