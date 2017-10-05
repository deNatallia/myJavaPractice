package com.roxoft.sellcompany.DAO;

import com.roxoft.sellcompany.models.shop.Supermarket;

public interface ISupermarketDAO {
	public boolean insertSupermarket(Supermarket supermarket);
	public boolean updateSupermarket(Supermarket supermarket,int id);
	public boolean deleteSupermarket(int id);
	public Supermarket getSupermarketById(int id);
	public int getIdAddress(int id);
}
