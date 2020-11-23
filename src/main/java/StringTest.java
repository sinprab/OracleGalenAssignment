import java.util.HashMap;

public class StringTest {
	
	public static void main(String[] args) {
		/*
		 * 
		 * String str ="Hello World"; String newStr=""; int length = str.length();
		 * for(int i=0;i<length;i++) {
		 * 
		 * if(!newStr.contains(str.charAt(i)+"")) { newStr=newStr+str.charAt(i); } }
		 * 
		 * System.out.println("New String :: "+newStr);
		 */
		usingHashMap();
		}
	
	public static void usingHashMap()
	{
		String str ="Hello World";
		String newStr="";
		int length = str.length();
		HashMap<String, String> newStrMap = new HashMap<String, String>();
		for(int i=0;i<length;i++)
		{
			
			newStrMap.put(str.charAt(i)+"","");
		}
		
		for(int i=0;i<newStrMap.size();i++)
		{
			System.out.println(newStrMap.values());
		}
		
	
	}


}

	