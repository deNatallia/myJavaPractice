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
	
	@Override
	public void insertAddress(Address address) {
		String sql = "INSERT into addresses (STREET,HOUSE_NUM,CITIES_ID,COUNTRIES_ID) VALUES (?,?,?,?)";
		try {
			connection = getConpool().getConnection();
			ps = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			ps.setString(1,address.getStreet());
			ps.setInt(2,address.getHouseNum());
			ps.setInt(3,address.getCity().getId());
			ps.setInt(4,address.getCountry().getId());
			ps.executeUpdate();
			rs = ps.getGeneratedKeys();
			if (rs.next()){
			   	address.setId(rs.getInt(1));
			}
			LOGGER.info("ID" + address.getId() +" "+ address.toString() + " was successfully added to Addresses table");
		} catch (SQLException | InterruptedException e) {
			LOGGER.error(e.getMessage());
		}
		finally {
			closeRSet(rs);
			closePrStatement(ps);
			getConpool().returnConnection(connection);
		}
	}
	
	@Override
	public void updateAddress(Address address) {
		String sql = "UPDATE addresses SET STREET=?,HOUSE_NUM=?,COUNTRIES_ID=?,CITIES_ID=? WHERE ID=?";
		try {
			connection = getConpool().getConnection();
			ps = connection.prepareStatement(sql);
			ps.setString(1,address.getStreet());
			ps.setInt(2,address.getHouseNum());
			ps.setInt(3,address.getCountry().getId());
			ps.setInt(4,address.getCity().getId());
			ps.setInt(5,address.getId());
			ps.executeUpdate();
			LOGGER.info(address.toString() + " was updated at Addresses table");
		} catch (SQLException | InterruptedException e) {
			LOGGER.error(e.getMessage());
		}
		finally {
			closePrStatement(ps);
			getConpool().returnConnection(connection);
		}
		
	}

	@Override
	public void deleteAddress(int id) {
		String sql = "DELETE from addresses WHERE ID=?";
		try {
			connection = getConpool().getConnection();
			ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
			LOGGER.info("Address with id="+ id +" was deleted from Addresses table");
		} catch (SQLException | InterruptedException e) {
			LOGGER.error(e.getMessage());
		}
		finally {
			closePrStatement(ps);
			getConpool().returnConnection(connection);
		}
	}

	@Override
	public Address getAddressById(int id) {
		String sql = "SELECT COUNTRY,CITY,STREET,HOUSE_NUM FROM addresses adr LEFT JOIN countries cntr ON cntr.idCOUNTRIES=adr.COUNTRIES_ID LEFT JOIN cities c ON c.idCITIES=adr.CITIES_ID WHERE ID=?";
		Address a = new Address();
		try {
			connection = getConpool().getConnection();
			ps = connection.prepareStatement(sql);
	        ps.setInt(1, id);
	        rs = ps.executeQuery();
	        rs.next();
	        //a.setId(rs.getInt("ID"));
	        a.setCountry(Country.valueOf(rs.getString("COUNTRY")));
	        a.setCity(City.valueOf(rs.getString("CITY")));
	        a.setStreet(rs.getString("STREET"));
	        a.setHouseNum(rs.getInt("HOUSE_NUM"));
	    } catch (SQLException | InterruptedException e) {
			LOGGER.error(e.getMessage());
	    }
		finally {
			closeRSet(rs);
			closePrStatement(ps);
			getConpool().returnConnection(connection);
		}
		return a;
	}
}
