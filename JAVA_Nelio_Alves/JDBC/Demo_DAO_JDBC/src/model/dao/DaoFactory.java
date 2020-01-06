package model.dao;

import model.dao.implement.SellerDaoJDBC;

public class DaoFactory {

	public static SellerDao createSellerDao() {
		return new SellerDaoJDBC();
		//n�o exp�e implementa��o, apenas interface
	}
}
