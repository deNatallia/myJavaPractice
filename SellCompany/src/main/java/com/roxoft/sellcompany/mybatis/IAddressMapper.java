package com.roxoft.sellcompany.mybatis;

import com.roxoft.sellcompany.Address;

public interface IAddressMapper {
	public int createAddress(Address address);
	public Address getAddressById(int id);
	public int updateAddress(Address address);
	public int deleteAddress(int id);
}
