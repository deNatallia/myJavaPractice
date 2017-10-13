package com.roxoft.sellcompany.mybatis;

import java.util.LinkedList;

public interface IProducerDAO {
	public void updateProducers(LinkedList<String> producers);
	public void deleteProducers(int id);
//	public LinkedList<String> getProducersById(int id);
	public void insertProducers(LinkedList<String> producers);
}
