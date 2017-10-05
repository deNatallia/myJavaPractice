package com.roxoft.sellcompany.DAO;

import com.roxoft.sellcompany.models.shop.OnlineShop;

public interface IOnlineShopDAO {
	public boolean insertOnlineShop(OnlineShop onlineshop);
	public boolean updateOnlineShop(OnlineShop onlineshop,int id);
	public boolean deleteOnlineShop(int id);
	public OnlineShop getOnlineShopById(int id);
	public int getIdAddress(int id);
}
