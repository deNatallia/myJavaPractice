package com.roxoft.sellcompany.DAO;

import com.roxoft.sellcompany.models.shop.Supermarket;

public interface ISupermarketDAO {
	public void insertSupermarket(Supermarket supermarket);
	public void updateSupermarket(Supermarket supermarket);
	public void deleteSupermarket(int id);
	public Supermarket getSupermarketById(int id);
	public int getIdAddress(int id);
}
