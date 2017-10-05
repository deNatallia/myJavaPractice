package com.roxoft.sellcompany.DAO;

import com.roxoft.sellcompany.models.storehouse.FactoryStore;

public interface IFactoryStoreDAO {
	public boolean insertFactoryStore(FactoryStore factorystore);
	public boolean updateFactoryStore(FactoryStore factorystore, int id);
	public boolean deleteFactoryStore(int id);
	public FactoryStore getFactoryStoreById(int id);
	public int getIdAddress(int id);
}
