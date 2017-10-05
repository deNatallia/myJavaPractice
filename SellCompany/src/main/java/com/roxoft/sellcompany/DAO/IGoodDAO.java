package com.roxoft.sellcompany.DAO;

public interface IGoodDAO {
	public boolean insertGood(String good);
	public boolean updateGood(String good,int id);
	public boolean deleteGood(int id);
	public String getGoodById(int id);
}
