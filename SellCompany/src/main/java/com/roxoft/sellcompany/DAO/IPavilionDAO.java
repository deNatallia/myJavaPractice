package com.roxoft.sellcompany.DAO;

import com.roxoft.sellcompany.models.shop.Pavilion;

public interface IPavilionDAO {
	public void insertPavilion(Pavilion pavilion);
	public void updatePavilion(Pavilion pavilion);
	public void deletePavilion(int id);
	public Pavilion getPavilionById(int id);
	public int getIdAddress(int id);
}
