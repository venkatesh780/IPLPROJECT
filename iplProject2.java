import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class iplProject2 {

	public static void main(String[] args) {
		
		String file = "/home/venky/Desktop/IplProject/matches.csv";
	    BufferedReader reader = null;
	    String line = "";
	    Map<String,Integer> noMatchesOwn=new HashMap<>();
	    try {
	    	System.out.println("**************************************");
	        reader = new BufferedReader(new FileReader(file));
	        while((line = reader.readLine()) != null) {
	            String[] row = line.split(",");
	            for(int i = 0; i < row.length; i++) {
	               if(i==10) {
	            	   if(noMatchesOwn.containsKey(row[i])) {
	            		   noMatchesOwn.put(row[i],noMatchesOwn.get(row[i])+1);
	            	   }
	            	   else {
	            		   noMatchesOwn.put(row[i], 1);
	            	   }
	               }
	            }
	        }
	        System.out.println(noMatchesOwn);
	    }
	    catch(Exception e)  {
	        e.printStackTrace();
	    }
	    finally {
	    	 try {
	             reader.close();
	         } catch(IOException e) {
	             e.printStackTrace();
	         }
	  }
	}

}
