package com.jshop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.jshop.dao.ElectronicMenuOrderTDao;
import com.jshop.dao.impl.ElectronicMenuOrderTDaoImpl;
import com.jshop.entity.ElectronicMenuOrderT;
import com.jshop.service.ElectronicMenuOrderTService;
@Service("electronicMenuOrderTService")
@Scope("prototype")
public class ElectronicMenuOrderTServiceImpl implements ElectronicMenuOrderTService {
	private ElectronicMenuOrderTDao electronicMenuOrderTDao;
	
	
	public ElectronicMenuOrderTDao getElectronicMenuOrderTDao() {
		return electronicMenuOrderTDao;
	}

	public void setElectronicMenuOrderTDao(ElectronicMenuOrderTDao electronicMenuOrderTDao) {
		this.electronicMenuOrderTDao = electronicMenuOrderTDao;
	}

	public int addElectronicMenuOrderT(ElectronicMenuOrderT eo) {
		return this.getElectronicMenuOrderTDao().addElectronicMenuOrderT(eo);
	}

	public int countfindAllElectronicMenuOrderT() {
		return this.getElectronicMenuOrderTDao().countfindAllElectronicMenuOrderT();
	}

	public int countsortAllElectronicMenuOrderTByshippingusername(String shippingusername) {
		return this.getElectronicMenuOrderTDao().countsortAllElectronicMenuOrderTByshippingusername(shippingusername);
	}

	public int countsortAllTobeShippedElectronicMenuOrderT(String shippingstate) {
		return this.getElectronicMenuOrderTDao().countsortAllTobeShippedElectronicMenuOrderT(shippingstate);
	}

	public List<ElectronicMenuOrderT> findAllElectronicMenuOrderTBytableNumberandstate(String tableNumber, String tablestate, String electronicorderstate) {
		return this.getElectronicMenuOrderTDao().findAllElectronicMenuOrderTBytableNumberandstate(tableNumber, tablestate, electronicorderstate);
	}

	public ElectronicMenuOrderT findElectronicMenuOrderTByelectronicMenuOrderid(String electronicMenuOrderid) {
		return this.getElectronicMenuOrderTDao().findElectronicMenuOrderTByelectronicMenuOrderid(electronicMenuOrderid);
	}

	public List<ElectronicMenuOrderT> sortAllElectronicMenuOrderT(int currentPage, int lineSize, String queryString) {
		return this.getElectronicMenuOrderTDao().sortAllElectronicMenuOrderT(currentPage, lineSize, queryString);
	}

	public List<ElectronicMenuOrderT> sortAllTobeShippedElectronicMenuOrderT(int currentPage, int lineSize, String shippingstate) {
		return this.getElectronicMenuOrderTDao().sortAllTobeShippedElectronicMenuOrderT(currentPage, lineSize, shippingstate);
	}

	public void updateElectronicMenuOrderT(ElectronicMenuOrderT eo) {
		this.getElectronicMenuOrderTDao().updateElectronicMenuOrderT(eo);
	}

	public int updateElectronicMenuOrderTelectronicorderstateByelectronicMenuOrderid(String electronicMenuOrderid, String electronicorderstate) {
		return this.getElectronicMenuOrderTDao().updateElectronicMenuOrderTelectronicorderstateByelectronicMenuOrderid(electronicMenuOrderid, electronicorderstate);
	}

	public int updateElectronicMenuOrderTpayshippingstate(String electronicMenuOrderid, String electronicorderstate, String paystate, String shippingstate) {
		return this.getElectronicMenuOrderTDao().updateElectronicMenuOrderTpayshippingstate(electronicMenuOrderid, electronicorderstate, paystate, shippingstate);
	}

	public int updateElectronicMenuOrderTpaystateByelectronicMenuOrderid(String electronicMenuOrderid, String paystate) {
		return this.getElectronicMenuOrderTDao().updateElectronicMenuOrderTpaystateByelectronicMenuOrderid(electronicMenuOrderid, paystate);
	}

	public int updateElectronicMenuOrderTshippingstateByelectronicMenuOrderid(String electronicMenuOrderid, String shippingstate) {
		return this.getElectronicMenuOrderTDao().updateElectronicMenuOrderTshippingstateByelectronicMenuOrderid(electronicMenuOrderid, shippingstate);
	}

	public int updateInvoiceByelectronicMenuOrderid(String electronicMenuOrderid, String invoice) {
		return this.getElectronicMenuOrderTDao().updateInvoiceByelectronicMenuOrderid(electronicMenuOrderid, invoice);
	}

	public int updateexpressnumberByelectronicMenuOrderid(String electronicMenuOrderid, String expressnumber) {
		return this.getElectronicMenuOrderTDao().updateexpressnumberByelectronicMenuOrderid(electronicMenuOrderid, expressnumber);
	}

	@Override
	public int updateElectronicMenuOrderElectrobicOrderState(
			String electronicorderstate) {
		
		return this.getElectronicMenuOrderTDao().updateElectronicMenuOrderElectrobicOrderState(electronicorderstate);
	}

	@Override
	public ElectronicMenuOrderT findElectronicMenuOrderTByelectronicMenuTablenumber(
			String tablenumber) {
		return this.getElectronicMenuOrderTDao().findElectronicMenuOrderTByelectronicMenuTablenumber(tablenumber);
	}

}
