import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.*;

public class Day1 {
 public static void main(String[] args) {
    ArrayList<Integer> numList = new ArrayList<Integer>();
    try {
      File myFile = new File("input.txt");
      Scanner myReader = new Scanner(myFile);
      while (myReader.hasNextLine()) {
        Integer data = Integer.parseInt(myReader.nextLine());
        numList.add(data);
      }
      myReader.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }

    for (int i = 0; i < numList.size(); i++) {
      int diff = 2020 - numList.get(i);
      if (numList.indexOf(diff) != -1) {
        System.out.println(diff * numList.get(i));
      }
    }

    for (int i = 0; i < numList.size(); i++) {
      int currentNum = numList.get(i);
      for (int j = i; j < numList.size(); j++) {
        int nextNum = numList.get(j);
        for (int k = j; k < numList.size(); k++) {
          if (currentNum + nextNum + numList.get(k) == 2020) {
          System.out.println("Product of three digits that equal 2020");
            System.out.println(currentNum * nextNum * numList.get(k));
          }
        }
      }
    }
  }
}
