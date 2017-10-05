package com.roxoft.sellcompany.DAO;

import com.roxoft.sellcompany.models.storehouse.LogisticStore;

public interface ILogisticStoreDAO {
	public boolean insertLogisticStore(LogisticStore logisticstore);
	public boolean updateLogisticStore(LogisticStore logisticstore, int id);
	public boolean deleteLogisticStore(int id);
	public LogisticStore getLogisticStoreById(int id);
	public int getIdAddress(int id);
}
