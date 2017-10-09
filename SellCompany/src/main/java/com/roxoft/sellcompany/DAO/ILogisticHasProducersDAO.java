package com.roxoft.sellcompany.DAO;

import java.util.ArrayList;

public interface ILogisticHasProducersDAO {
	public void insertLogisticHasProducers(int idProducer, int idLogistics);
	public void updateLogisticHasProducers(int idProducer, int idLogistics);
	public ArrayList<Integer> getAllProducersId(int idLogistics);
}
