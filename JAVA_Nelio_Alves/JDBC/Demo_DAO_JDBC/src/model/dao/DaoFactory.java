package model.dao;

import db.DB;
import model.dao.implement.SellerDaoJDBC;
import model.dao.implement.DepartmentDaoJDBC;

public class DaoFactory {

	public static SellerDao createSellerDao() {
		return new SellerDaoJDBC(DB.getConnection());
		//n�o exp�e implementa��o, apenas interface
	}
	
	public static DepartmentDao createDepartmentDao() {
		return new DepartmentDaoJDBC(DB.getConnection());
	}
}
