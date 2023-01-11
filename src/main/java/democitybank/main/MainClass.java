package democitybank.main;

import java.util.SortedSet;
import java.util.TreeSet;

public class MainClass {

	public static void main(String[] args) {
	   int[] list = {12,6,5,8,23,98,7}; 
	   int secondLargest = (int) list[0];
	   int largest = list[1];
      
   

       for (int i = 0; i < list.length; i++) {
	    	if(list[i] > secondLargest) {
	    		if(list[i] > largest) {
	    			secondLargest = largest;
	    			largest = list[i];
	    		} else {
	    			secondLargest = list[i];
	    		}
	    	}
	   }
       
       System.out.println("secondLargest :" + secondLargest);
       System.out.println("largest :" + largest);
	   
	}

}
