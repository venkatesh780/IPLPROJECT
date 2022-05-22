import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.*;

public class EconomyProblem {

	public static void main(String[] args) {

		String file = "/home/venky/Desktop/IplProject/matches.csv";
		String dfile="/home/venky/Desktop/IplProject/deliveries.csv";
		BufferedReader dreader=null;
	    BufferedReader reader = null;
	    List<Integer> matchIds_2016=new ArrayList<>();
	    String line = "";
	    String dline="";
	    int falg=0;
	    int skip=0;
	    int remove=0;
	    Map<String,Integer> teamConscedRuns=new HashMap<>();
	    Map<String,Integer> bowlersRuns=new HashMap<>();
	    Map<String,Integer> bowlersBalls=new HashMap<>();
	    Map<String,Double> bowlersEconomy=new HashMap<>();
	    List<Integer> matchIds_2015=new ArrayList<>();
	    Map<String,Integer> noMatchesPerYear=new HashMap<>();
	    Map<String,Integer> noMatchesOwn=new HashMap<>();
	    try {
	    	 reader = new BufferedReader(new FileReader(file));
		        while((line = reader.readLine()) != null) {
		        	if(skip==0) {
		        		skip=1;
		        		continue;
		        	}
		        	else {
		        		 String[] row = line.split(",");
				            for(int i = 0; i < row.length; i++) {
				               if(i==1) {
				            	   if(noMatchesPerYear.containsKey(row[i])) {
				            		   noMatchesPerYear.put(row[i],noMatchesPerYear.get(row[i])+1);
				            	   }
				            	   else {
				            		   if(row[i]!="season") {
				            			   noMatchesPerYear.put(row[i], 1);
				            		   }
				            	   }
				               }
				            }
		        	}
		        }
		        System.out.println(noMatchesPerYear); // 1st problem output
		        reader = new BufferedReader(new FileReader(file));
		        while((line = reader.readLine()) != null) {
		        	if(remove==0) {
		        		remove=1;
		        		continue;
		        	}
		        	else {
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
		            
		        }
		        System.out.println(noMatchesOwn); // 2nd problem output
	    	//System.out.println("********************scenioro 3 START**************************");
	        reader = new BufferedReader(new FileReader(file));
	        while((line = reader.readLine()) != null) {
	           if(falg==0) {
	        	   falg=1;
	        	   continue;
	           }
	           else {
	        	   String [] row= line.split(",",-1);
	        	   int value= Integer.parseInt(row[0]);
	        	   if(row[1].equals("2016")) {
	        		   matchIds_2016.add(value);
	        	   }
	        	   if(row[1].equals("2015")) {
	        		   matchIds_2015.add(value);
	        	   }
	           } 
	           
	           
	        }
	      //  System.out.println(matchIds_2016);
	      //System.out.println(matchIds_2015);
	        dreader = new BufferedReader(new FileReader(dfile));
	        int flag=0;
	        while((dline = dreader.readLine()) != null) {
	           if(flag==0) {
	        	   flag=1;
	        	   continue;
	           }
	           String [] drow= dline.split(",",-1);
	         for(Integer mid:matchIds_2016) {
	        	 int index=Integer.parseInt(drow[0]); 
	        	 if(mid==index) {
	        		 int extras=Integer.parseInt(drow[16]);
	        		 if(extras>0) {
	        			 if(teamConscedRuns.containsKey(drow[3])) {
		        			 teamConscedRuns.put(drow[3], teamConscedRuns.get(drow[3])+extras);
		        		 } 
		        		 else {
		        			 teamConscedRuns.put(drow[3], extras);
		        		 }
	        		 }
	        		
	        	 };
	        	
	         }
	         //System.out.println("*******4th scenior START*************");
        	 for(Integer dmid:matchIds_2015) {
        		 int dindex=Integer.parseInt(drow[0]);
        		 if(dmid==dindex) {
	        		 int totalRuns=Integer.parseInt(drow[17]);
	        		 //System.out.println(totalRuns);
	        		 if(bowlersRuns.containsKey(drow[8])) {
	        			 bowlersRuns.put(drow[8],bowlersRuns.get(drow[8])+totalRuns);
	        		 }
	        		 else {
	        			 bowlersRuns.put(drow[8], totalRuns);
	        		 }
	        		 if(bowlersBalls.containsKey(drow[8])) {
	        			 bowlersBalls.put(drow[8], bowlersRuns.get(drow[8])+1);
	        		 }
	        		 else {
	        			 bowlersBalls.put(drow[8], 0);
	        		 }
	        	 }
        		// System.out.println(dmid);
        	 }
        	 
	          
	        }
	   // System.out.println(bowlersRuns);
	     //System.out.println(bowlersBalls);
	       System.out.println(teamConscedRuns); //3rd problem output
	     for(String i: bowlersBalls.keySet()) {
	    	 bowlersBalls.put(i, bowlersBalls.get(i)/6);
	    	 bowlersEconomy.put(i, 0.0);
	     }
	  //  System.out.println(bowlersRuns);
	    //System.out.println(bowlersBalls);
	     //System.out.println(bowlersEconomy);
	    double economy;
	     for(String k:bowlersEconomy.keySet()) {
	    	 if(bowlersBalls.get(k)>0) {
	    		 economy=bowlersRuns.get(k)/bowlersBalls.get(k);
	    		 bowlersEconomy.put(k, economy);
	    	 }
	    	 
	     }
	     System.out.println(bowlersEconomy); //4th problem output
	   //  System.out.println("******************5th problem*****************************");
	     
	     
	     
	     
	     
	    
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
