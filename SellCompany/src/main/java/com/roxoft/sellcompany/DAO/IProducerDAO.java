package com.roxoft.sellcompany.DAO;

public interface IProducerDAO {
	public boolean insertProducer(String producer);
	public boolean updateProducer(String producer,int id);
	public boolean deleteProducer(int id);
	public String getProducerById(int id);
}
