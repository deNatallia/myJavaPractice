package com.roxoft.sellcompany.DAO;

import com.roxoft.sellcompany.models.storehouse.LogisticStore;

public interface ILogisticStoreDAO {
	public void insertLogisticStore(LogisticStore logisticstore);
	public void updateLogisticStore(LogisticStore logisticstore);
	public void deleteLogisticStore(int id);
	public LogisticStore getLogisticStoreById(int id);
	public int getIdAddress(int id);
}
