package com.metacube.webservices;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class TempConverter {
	
	@WebMethod
	public double fahrenhiteToCelsiusConverter(double temperatureInFahrenhite)
	{
		return (temperatureInFahrenhite-32)*5/9;
	}

}
