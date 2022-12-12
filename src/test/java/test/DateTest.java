package test;

import java.util.Date;

public class DateTest {

	public static void main(String[] args) {
		
		Date d=new Date();
		System.out.println(d.toString());
		
	String dateFile=d.toString().replace(":", "_").replace(" ", "_")+".png";
	
	System.out.println(dateFile);

	}

}
