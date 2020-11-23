package oracle.assignmnet.deviceFactory;

import org.openqa.selenium.Dimension;

public class DeviceFactory {
	
	public static Dimension getDeviceDimesion(String device)
	{
		Dimension dimension = null;
		
		switch(device)
		{
		case "desktop" 	: 	dimension = new Dimension(1600,1200);
						 	break;
		case "tablet"  	: 	dimension = new Dimension(1152,864);
							break;
		case "mobile"  	: 	dimension = new Dimension(800,600);
						 	break;
		default			:	System.out.println("In Correct Device Type");
		}
		
		return	dimension;
		
		
	}

}
