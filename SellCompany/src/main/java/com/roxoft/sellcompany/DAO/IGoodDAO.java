package com.roxoft.sellcompany.DAO;

public interface IGoodDAO {
	public void insertGood(String good);
	public void updateGood(String good, int id);
	public void deleteGood(int id);
	public String getGoodById(int id);
}
