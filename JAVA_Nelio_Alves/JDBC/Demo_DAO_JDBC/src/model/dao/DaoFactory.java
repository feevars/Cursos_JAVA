package model.dao;

import db.DB;
import model.dao.implement.SellerDaoJDBC;

public class DaoFactory {

	public static SellerDao createSellerDao() {
		return new SellerDaoJDBC(DB.getConnection());
		//n�o exp�e implementa��o, apenas interface
	}
}
