package com.roxoft.sellcompany.DAO;

public interface IProducerDAO {
	public void insertProducer(String producer);
	public void updateProducer(String producer, int id);
	public void deleteProducer(int id);
	public String getProducerById(int id);
}
