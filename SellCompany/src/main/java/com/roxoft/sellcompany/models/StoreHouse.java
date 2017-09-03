package com.roxoft.sellcompany.models;

import javax.xml.bind.annotation.XmlElement;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.roxoft.sellcompany.Address;
import com.roxoft.sellcompany.InvalidValueException;
import com.roxoft.sellcompany.SellCompany;

/**
 * This is an abstract class for StoreHouses
 * @author natalia.m
 * @version 1.0
 * @see SellCompany#Constructor(String,Address)
 * @see SellCompany#sell()
 * @see IClean#clean()
 * @see IWork#work()
 * @see ITrans#transportIn()
 * @see ITrans#transportOut()
 * @see #loadCar()
 */
public abstract class StoreHouse extends SellCompany implements IClean, IWork, ITrans{
	@JsonProperty
	private int square;
	@JsonProperty
	private int loaderNum;
	
	public StoreHouse(){};
	
	public StoreHouse(String name, Address address, int loaderNum, int square) {
		super(name, address);
	}
	
	public void loadCar(){
		System.out.println("loadingCar");
	}
	
	public int getSquare() {
		return square;
	}

	/**
	 * Set the value of store square with handling exception
	 * @param square - square of the store
	 * @throws {@link}InvalidValueException - if can't set square it's reported as not valid
	 */
	@XmlElement
	public void setSquare(int square) throws InvalidValueException {
			if (square<40)
			{
				throw new InvalidValueException("not valid", null);
			}
			else {this.square = square;}
	}

	public int getLoaderNum() {
		return loaderNum;
	}

	@XmlElement
	public void setLoaderNum(int loaderNum) {
		this.loaderNum = loaderNum;
	}
	
}
