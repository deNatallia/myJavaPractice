package com.roxoft.sellcompany.DAO;

import java.util.ArrayList;

public interface IFactoryHasGoodsDAO {
	public boolean insertFactoryHasGoods(int idGood, int idFactory);
	public boolean updateFactoryHasGoods(int idGood, int idFactory);
	public ArrayList<Integer> getAllGoodsId(int idFactory);
}
