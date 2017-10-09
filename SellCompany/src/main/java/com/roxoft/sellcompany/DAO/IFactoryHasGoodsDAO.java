package com.roxoft.sellcompany.DAO;

import java.util.ArrayList;

public interface IFactoryHasGoodsDAO {
	public void insertFactoryHasGoods(int idGood, int idFactory);
	public void updateFactoryHasGoods(int idGood, int idFactory);
	public ArrayList<Integer> getAllGoodsId(int idFactory);
}
