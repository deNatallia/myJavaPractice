package com.roxoft.sellcompany.DAO;

import com.roxoft.sellcompany.Address;

public interface IAddressDAO {
	public boolean insertAddress(Address address);
	public boolean updateAddress(Address address,int id);
	public boolean deleteAddress(int id);
	public Address getAddressById(int id);
}
