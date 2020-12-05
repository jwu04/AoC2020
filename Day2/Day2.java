import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.*;

public class Day2 {
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

    int validPass1 = 0;
    int validPass2 = 0;
    for (int i = 0; i < numList.size(); i++) {
      String data = numList.get(i);
      int letterCounter = 0;
      char currentChar = data.charAt(data.indexOf(" ")+1);
      int min = Integer.parseInt(data.substring(0,data.indexOf("-")));
      int max = Integer.parseInt(data.substring(data.indexOf("-")+1, data.indexOf(" ")));
      String actualString = data.substring(data.lastIndexOf(" "), data.length());
      for (int j = 0; j < actualString.length(); j++) {
        if (actualString.charAt(j) == currentChar) {
          letterCounter++;
        }
      }
      if (letterCounter >= min && letterCounter <= max) {
        validPass1++;
      }
    }

    for (int i = 0; i < numList.size(); i++) {
      String data = numList.get(i);
      char currentChar = data.charAt(data.indexOf(" ")+1);
      int min = Integer.parseInt(data.substring(0,data.indexOf("-")));
      int max = Integer.parseInt(data.substring(data.indexOf("-")+1, data.indexOf(" ")));
      String actualString = data.substring(data.lastIndexOf(" "), data.length());
      if ((actualString.charAt(min) == currentChar) ^ (actualString.charAt(max) == currentChar)) {
        validPass2++;
      }
    }

    System.out.println(validPass1);
    System.out.println(validPass2);
  }
}
