import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class iplProject3 {

	private static final String Integer = null;

	public static void main(String[] args) {

		 String file = "/home/venky/Desktop/IplProject/deliveries.csv";
		    BufferedReader reader = null;
		    String line = "";
		    Map<String,Integer> Teams=new HashMap<>();
		  //  Map<String,Integer> noMatchesOwn=new HashMap<>();
		    try {
		    	System.out.println("**************************************");
		        reader = new BufferedReader(new FileReader(file));
		        List<List<String>> ls = new ArrayList<>();
		        while((line = reader.readLine()) != null) {
		        	String[] row = line.split(",");
		        	 ls.add(Arrays.asList(row));
		        }
		        for(List x:ls) {
		        	System.out.println(x);
		        }
		        
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
