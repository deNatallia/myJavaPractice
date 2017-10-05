package com.roxoft.sellcompany.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.roxoft.sellcompany.Address;
import com.roxoft.sellcompany.City;
import com.roxoft.sellcompany.Country;

public class JDBCAddressDAO extends AbstractDAO implements IAddressDAO {
	private final static Logger LOGGER = LogManager.getLogger(JDBCAddressDAO.class);
	
	private Connection connection = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	private volatile static int generatedKey;
	
	@Override
	public boolean insertAddress(Address address) {
		String sql = "INSERT into addresses (STREET,HOUSE_NUM,CITIES_ID,COUNTRIES_ID) VALUES (?,?,(SELECT idCITIES from cities WHERE CITY=?),(SELECT idCOUNTRIES from countries WHERE COUNTRY=?))";
		try {
			connection = getConpool().getConnection();
			ps = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			ps.setString(1,address.getStreet());
			ps.setInt(2,address.getHouseNum());
			ps.setString(3, address.getCity().toString());
			ps.setString(4,address.getCountry().toString());
			int i = ps.executeUpdate();
			if (i==1) {
				rs = ps.getGeneratedKeys();
			    if (rs.next()){
			    	this.setGeneratedKey(rs.getInt(1));
			    }
				LOGGER.info(address.toString() + " was successfully added to Addresses table");
				return true;
			}
		} catch (SQLException | InterruptedException e) {
			e.printStackTrace();
		}
		finally {
			closeRSet(rs);
			closePrStatement(ps);
			getConpool().returnConnection(connection);
		}
		return false;
	}
	
	@Override
	public boolean updateAddress(Address address,int id) {
		String sql = "UPDATE addresses SET STREET=?,HOUSE_NUM=?,COUNTRIES_ID=(SELECT idCOUNTRIES from countries WHERE COUNTRY=?),CITIES_ID=(SELECT idCITIES from cities WHERE CITY=?) WHERE idAddress=?";
		try {
			connection = getConpool().getConnection();
			ps = connection.prepareStatement(sql);
			ps.setString(1,address.getStreet());
			ps.setInt(2,address.getHouseNum());
			ps.setString(3,address.getCountry().toString());
			ps.setString(4,address.getCity().toString());
			ps.setInt(5,id);
			int i = ps.executeUpdate();
			if (i==1) {
				LOGGER.info(address.toString() + " was updated at Addresses table");
				return true;
			}
		} catch (SQLException | InterruptedException e) {
			e.printStackTrace();
		}
		finally {
			closePrStatement(ps);
			getConpool().returnConnection(connection);
		}
		return false;
		
	}

	@Override
	public boolean deleteAddress(int id) {
		String sql = "DELETE from addresses WHERE idAddress=?";
		try {
			connection = getConpool().getConnection();
			ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			int i = ps.executeUpdate();
			
			if (i==1) {
				LOGGER.info("Address with id="+ id +" was deleted from Addresses table");
				return true;
			}
		} catch (SQLException | InterruptedException e) {
			e.printStackTrace();
		}
		finally {
			closePrStatement(ps);
			getConpool().returnConnection(connection);
		}
		return false;
	}

	@Override
	public Address getAddressById(int id) {
		String sql = "SELECT COUNTRY,CITY,STREET,HOUSE_NUM FROM addresses adr LEFT JOIN countries cntr ON cntr.idCOUNTRIES=adr.COUNTRIES_ID LEFT JOIN cities c ON c.idCITIES=adr.CITIES_ID WHERE idAddress=?";
		Address a = new Address();
		try {
			connection = getConpool().getConnection();
			ps = connection.prepareStatement(sql);
	        ps.setInt(1, id);
	        rs = ps.executeQuery();
	        rs.next();
	        a.setCountry(Country.valueOf(rs.getString("COUNTRY")));
	        a.setCity(City.valueOf(rs.getString("CITY")));
	        a.setStreet(rs.getString("STREET"));
	        a.setHouseNum(rs.getInt("HOUSE_NUM"));
	    } catch (SQLException | InterruptedException e) {
			LOGGER.error(e.getCause());
	    }
		finally {
			closeRSet(rs);
			closePrStatement(ps);
			getConpool().returnConnection(connection);
		}
		return a;
		
	}

	public static int getGeneratedKey() {
		return generatedKey;
	}

	public void setGeneratedKey(int generatedKey) {
		JDBCAddressDAO.generatedKey = generatedKey;
	}

}
