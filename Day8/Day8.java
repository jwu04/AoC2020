import java.io.*;
import java.util.*;

public class Day8 {
 public static void main(String[] args) {
    ArrayList<String> numList = new ArrayList<String>();
    try {
      File myFile = new File("input.txt");
      Scanner myReader = new Scanner(myFile);
      while (myReader.hasNextLine()) {
        String dataText = myReader.nextLine();
        numList.add(dataText);
      }
      myReader.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }

    ArrayList<String> tempData = numList;
    for (int i = 0; i < numList.size(); i++) {
    	numList = new ArrayList<String>(tempData);
    	String line = numList.get(i);
    	if (line.indexOf("nop") != -1) {
    		String nopLine = line.replace("nop", "jmp");
    		numList.set(i, nopLine);
    		if (checker(numList) != 0) {
    			System.out.println("Terminated number is " + checker(numList));
    		}
    	}
    	else if (line.indexOf("jmp") != -1) {
    		String jmpLine = line.replace("jmp", "nop");
    		numList.set(i, jmpLine);
    		if (checker(numList) != 0) {
    			System.out.println("Terminated number is " + checker(numList));
    		}    		
    	}
    }
}  

  public static int checker(ArrayList<String> numList) {
    int global = 0;
    int counter = 0;
    boolean tf = true;
    boolean toReturn = true;
    ArrayList<Integer> instructions = new ArrayList<Integer>();
    while (tf) {
	    	if (instructions.contains(counter)) {
	    		tf = false;
	    		toReturn = false;
	    		break;
	    	}
	    	else if (counter >= numList.size()) {
	    		break;
	    	}
	    	String data = numList.get(counter);
	    	String thing = numList.get(counter).substring(0, 3);
	    	int num = Integer.parseInt(data.substring(data.indexOf(" ")+1, data.length()));

	    	if (thing.equals("nop")) {
	    		instructions.add(counter);
	    		counter++;
	    	}
	    	else if (thing.equals("acc")) {
	    		instructions.add(counter);
	    		global += num;
	    	    counter++;
	    	}
	    	else if (thing.equals("jmp")) {
	    		instructions.add(counter);
	    		counter += num;
	    	}
    	}
    if (toReturn == false) {
    	return 0;
    } else {
    	return global;   
    }  	
  }
}
