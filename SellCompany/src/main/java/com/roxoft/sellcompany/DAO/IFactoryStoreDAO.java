package com.roxoft.sellcompany.DAO;

import com.roxoft.sellcompany.models.storehouse.FactoryStore;

public interface IFactoryStoreDAO {
	public void insertFactoryStore(FactoryStore factorystore);
	public void updateFactoryStore(FactoryStore factorystore);
	public void deleteFactoryStore(int id);
	public FactoryStore getFactoryStoreById(int id);
	public int getIdAddress(int id);
}
