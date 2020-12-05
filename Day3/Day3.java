import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.*;

public class Day3 {
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

// Day 3 -- 262 * 78 * 66 * 69 * 30
    int tree = 0;
    int rightCounter = 3;
    int mapWidth = numList.get(0).length();
    for (int i = 1; i < numList.size(); i += 1) {
        if (Character.toString(numList.get(i).toCharArray()[rightCounter%mapWidth]).equals("#")) {
            tree++;
        }
        rightCounter += 3;
    }

    System.out.println(tree);
  }
}
