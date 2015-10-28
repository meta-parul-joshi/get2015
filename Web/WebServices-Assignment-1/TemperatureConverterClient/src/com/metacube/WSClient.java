package com.metacube;

import com.metacube.webservices.TempConverter;
import com.metacube.webservices.TempConverterServiceLocator;

public class WSClient {

	public static void main(String[] args) {
		
		TempConverterServiceLocator calcCTCWebServiceImplServiceLocator = new TempConverterServiceLocator();
		calcCTCWebServiceImplServiceLocator.setTempConverterEndpointAddress("http://localhost:8080/TemperatureConverter/services/TempConverter");
		
		try {
			TempConverter calcCTCWebService = calcCTCWebServiceImplServiceLocator.getTempConverter();
			
			System.out.println(calcCTCWebService.fahrenhiteToCelsiusConverter(98));
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
}
