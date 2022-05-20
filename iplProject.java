
import java.io.*;
import java.util.*;
public class iplProject {

	public static void main(String[] args) {
		
		 String file = "/home/venky/Desktop/IplProject/matches.csv";
		    BufferedReader reader = null;
		    String line = "";
		    Map<String,Integer> noMatchesPerYear=new HashMap<>();
		    try {
		        reader = new BufferedReader(new FileReader(file));
		        while((line = reader.readLine()) != null) {
		            String[] row = line.split(",");
		            for(int i = 0; i < row.length; i++) {
		               if(i==1) {
		            	   if(noMatchesPerYear.containsKey(row[i])) {
		            		   noMatchesPerYear.put(row[i],noMatchesPerYear.get(row[i])+1);
		            	   }
		            	   else {
		            		   noMatchesPerYear.put(row[i], 1);
		            	   }
		               }
		            }
		        }
		        System.out.println(noMatchesPerYear);
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
