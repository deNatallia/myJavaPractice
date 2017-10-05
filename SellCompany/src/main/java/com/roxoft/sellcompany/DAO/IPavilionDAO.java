package com.roxoft.sellcompany.DAO;

import com.roxoft.sellcompany.models.shop.Pavilion;

public interface IPavilionDAO {
	public boolean insertPavilion(Pavilion pavilion);
	public boolean updatePavilion(Pavilion pavilion,int id);
	public boolean deletePavilion(int id);
	public Pavilion getPavilionById(int id);
	public int getIdAddress(int id);
}
