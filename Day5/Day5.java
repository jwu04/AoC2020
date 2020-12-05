import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.*;

public class Day5 {
 public static void main(String[] args) {
    ArrayList<String> numList = new ArrayList<String>();
    try {
      File myFile = new File("input.txt");
      Scanner myReader = new Scanner(myFile);
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        numList.add(data);
      }
      myReader.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }

    int seatIDs = 0;
    ArrayList<Integer> seatIDList = new ArrayList<Integer>();
   	for (int i = 0; i < numList.size(); i++) {
	   String seats = numList.get(i).replace("F", "0").replace("B", "1").replace("L", "0").replace("R", "1");;
	   int row = Integer.parseInt(seats.substring(0, 7), 2);
	   int column = Integer.parseInt(seats.substring(7, 10), 2);
	   int seatID = (row * 8) + column;
	   seatIDList.add(seatID);
	   if (seatID > seatIDs) {
	   	seatIDs = seatID;
	   }
   	}
   	System.out.println(seatIDs);

   	for (int i = 0; i < 1024; i++) {
   		if (!seatIDList.contains(i) && seatIDList.contains(i+1) && seatIDList.contains(i-1)) {
   			System.out.println(i);
   		}
   	}
  }
}
