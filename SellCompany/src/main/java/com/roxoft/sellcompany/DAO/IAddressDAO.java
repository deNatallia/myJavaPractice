package com.roxoft.sellcompany.DAO;

import com.roxoft.sellcompany.Address;

public interface IAddressDAO {
	public void insertAddress(Address address);
	public void updateAddress(Address address);
	public void deleteAddress(int id);
	public Address getAddressById(int id);
}
