package com.roxoft.sellcompany.DAO;

import com.roxoft.sellcompany.models.shop.OnlineShop;

public interface IOnlineShopDAO {
	public void insertOnlineShop(OnlineShop onlineshop);
	public void updateOnlineShop(OnlineShop onlineshop);
	public void deleteOnlineShop(int id);
	public OnlineShop getOnlineShopById(int id);
	public int getIdAddress(int id);
}
