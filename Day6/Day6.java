import java.io.*;
import java.util.*;

public class Day6 {
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

    int total = 0;
    int total2 = 0;

    // Part 1
    ArrayList<String> letters = new ArrayList<String>();
    for (int i = 0; i < numList.size(); i++) {
      String oneline = "";
      while (i < numList.size() && !numList.get(i).equals("")) {
        oneline += numList.get(i);
        i++;
      }
      letters.add(oneline);
    }

    ArrayList<String> newLetters = new ArrayList<String>();
    for (int i = 0; i < letters.size(); i++) {
      String line = letters.get(i);
      String noRepeat = "";
      for (int k = 0; k < line.length(); k++) {
        String singleChar = Character.toString(line.charAt(k));
        if (k < line.length() && noRepeat.indexOf(singleChar) == -1) {
          noRepeat += singleChar;
        }
      }
      total += noRepeat.length();
    }

    System.out.println(total);

    //Part 2
    ArrayList<String> setWords = new ArrayList<String>();
    for (int i = 0; i < numList.size(); i++) {
      while (i < numList.size() && !numList.get(i).equals("")) {
        setWords.add(numList.get(i));     
        i++;  
      }
      for (int k = 0; k < setWords.get(0).length() ; k++) {
        String repeatChars = Character.toString(setWords.get(0).charAt(k));
        int counter = 0;
        int totalChars = 0;
        while (counter < setWords.size()) {
          if (setWords.get(counter).indexOf(repeatChars) != -1) {
            totalChars++;
            counter++;
          } else {
            counter++;
          }
        }
        if (totalChars == setWords.size()) {
          total2++;
        }
      }
      setWords.clear();
    }

    System.out.println(total2);
  }
}
