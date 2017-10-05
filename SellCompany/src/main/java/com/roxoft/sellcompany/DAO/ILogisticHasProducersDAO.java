package com.roxoft.sellcompany.DAO;

import java.util.ArrayList;

public interface ILogisticHasProducersDAO {
	public boolean insertLogisticHasProducers(int idProducer, int idLogistics);
	public boolean updateLogisticHasProducers(int idProducer, int idLogistics);
	public ArrayList<Integer> getAllProducersId(int idLogistics);
}
