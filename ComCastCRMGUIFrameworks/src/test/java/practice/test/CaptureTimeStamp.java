package practice.test;

import java.util.Date;

import org.apache.poi.ss.formula.functions.Replace;

public class CaptureTimeStamp {
	public static void main(String[] args) {
		
		String currentTime = new Date().toString().replace(" ", "_").replace(":", " ");
		System.out.println(currentTime);
	}

}
