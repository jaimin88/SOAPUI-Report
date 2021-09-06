package com.soapuiutils.extentter.soapui.listener;

import java.io.File;

public class Test1 {
	
	public static void main(String[] args) {
		
		String str = "${#Project#PorticoEndpoint${#Project#Environment}}";
		
		int countOfHash = getHashCount(str);
		String actualEndPoint = "";
		
		if (countOfHash == 2) {

			String[] arrOfStr = str.split("#", 0);

			String EndpointPartOne = arrOfStr[1];
			String[] EndpointPartTwo = arrOfStr[2].split("}", 2);

			System.out.println(EndpointPartOne);
			System.out.println(EndpointPartTwo[0]);

			actualEndPoint = EndpointPartOne + EndpointPartTwo[0];

		} else if (countOfHash == 4) {
			String[] arrOfStr = str.split("#", 0);

			String[] EndpointPartOne = arrOfStr[2].split("\\$", 2);
			String[] EndpointPartTwo = arrOfStr[4].split("}", 2);

			System.out.println(EndpointPartOne[0]);
			System.out.println(EndpointPartTwo[0]);

			actualEndPoint = EndpointPartOne[0] + EndpointPartTwo[0];
		}
		
	}
	
	private static int getHashCount(String str) {
		char someChar = '#';
		int count = 0;

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == someChar) {
				count++;
			}
		}
		return count;
	}

}
