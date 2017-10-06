package com.roxoft.sellcompany.mybatis;

import com.roxoft.sellcompany.models.shop.Pavilion;

public interface IPavilionMapper {
	public int createPavilion(Pavilion pavilion);
	public Pavilion getPavilionById(int id);
	public int updatePavilion(Pavilion pavilion);
	public int deletePavilion(int id);
}
