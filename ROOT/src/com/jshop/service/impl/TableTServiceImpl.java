package com.jshop.service.impl;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.jshop.dao.TableTDao;
import com.jshop.dao.impl.TableTDaoImpl;
import com.jshop.entity.TableT;
import com.jshop.service.TableTService;
@Service("tableTService")
@Scope("prototype")
public class TableTServiceImpl implements TableTService {

	private TableTDao tableTDao;
	
	
	
	public TableTDao getTableTDao() {
		return tableTDao;
	}

	public void setTableTDao(TableTDao tableTDao) {
		this.tableTDao = tableTDao;
	}

	public int addTableT(TableT t) {
		return this.getTableTDao().addTableT(t);
	}

	public int countfindAllTableT() {
		return this.getTableTDao().countfindAllTableT();
	}

	public int delTableT(String[] strs) {
		return this.getTableTDao().delTableT(strs);
	}

	public List<TableT> findAllTableT() {
		return this.getTableTDao().findAllTableT();
	}

	public TableT findTableBytableid(String tableid) {
		return this.getTableTDao().findTableBytableid(tableid);
	}

	public List<TableT> sortAllTableT(int currentPage, int lineSize, String queryString) {
		return this.getTableTDao().sortAllTableT(currentPage, lineSize, queryString);
	}

	public void updateTableT(TableT t) {
		this.getTableTDao().updateTableT(t);
	}

	public int updateTableTtablestateBytableNo(String tableNumber, String tablestate) {
		return this.getTableTDao().updateTableTtablestateBytableNo(tableNumber, tablestate);
	}

	@Override
	public List<TableT> findAllTableT(int currentPage, int lineSize) {
		return this.getTableTDao().findAllTableT(currentPage, lineSize);
	}

}
