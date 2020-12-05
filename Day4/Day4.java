import java.io.*;
import java.util.*;
public class Day4{
    public static void main(String[]args){
    	File myFile = new File("input.txt");
    	try {
        Scanner scanner = new Scanner(myFile);
        int total = 0;
        int o = 8;
        boolean p = true;
        boolean s = true;
        ArrayList<String> idk = new ArrayList<String>();
        ArrayList<String> idk2 = new ArrayList<String>();
        while(scanner.hasNextLine()){
            p = true;
            String x = scanner.nextLine();
            if (x.equals("")){
                for (String m : idk){
                    System.out.print(m + " ");
                }
                System.out.println();
                for (String m : idk2){
                    System.out.print(m + " ");
                }
                System.out.println();
                if (idk.size() == 8){
                    for (int i = 0; i < idk.size(); i++){
                        String y = idk.get(i);
                        if (y.equals("byr")){
                            int u = Integer.parseInt(idk2.get(i));
                            if (u < 1920 || u > 2002){
                                p = false;
                            }
                        }
                        if (y.equals("iyr")){
                            int u = Integer.parseInt(idk2.get(i));
                            if (u < 2010 || u > 2020){
                                p = false;
                            }
                        }
                        if (y.equals("eyr")){
                            int u = Integer.parseInt(idk2.get(i));
                            if (u < 2020 || u > 2030){
                                p = false;
                            }
                        }
                        if (y.equals("hgt")){
                            if (idk2.get(i).charAt(idk2.get(i).length()-1) != 'n' && idk2.get(i).charAt(idk2.get(i).length()-1) != 'm'){
                                p = false;
                            }
                            else{
                                if (idk2.get(i).charAt(idk2.get(i).length()-1) == 'n'){
                                    String[]b = idk2.get(i).split("i");
                                    int v = Integer.parseInt(b[0]);
                                    if (v < 59 || v > 76)
                                        p = false;
                                }
                                else if (idk2.get(i).charAt(idk2.get(i).length()-1) == 'm'){
                                    String[]b = idk2.get(i).split("c");
                                    int v = Integer.parseInt(b[0]);
                                    if (v < 150 || v > 193)
                                        p = false;
                                }
                            }
                        }
                        if (y.equals("hcl")){
                            if (idk2.get(i).charAt(0) != '#'){
                                p = false;
                            }
                            else {
                                for (int c = 1; c < idk2.get(i).length(); c++){
                                    if (idk2.get(i).charAt(c) != '0' && idk2.get(i).charAt(c) != '1' && 
                                    idk2.get(i).charAt(c) != '2' && idk2.get(i).charAt(c) != '3' && idk2.get(i).charAt(c) != '4' 
                                    && idk2.get(i).charAt(c) != '5' && idk2.get(i).charAt(c) != '6' && idk2.get(i).charAt(c) != '7'
                                    && idk2.get(i).charAt(c) != '8' && idk2.get(i).charAt(c) != '9' && idk2.get(i).charAt(c) != 'a'
                                    && idk2.get(i).charAt(c) != 'b' && idk2.get(i).charAt(c) != 'c'&& idk2.get(i).charAt(c) != 'd'
                                    && idk2.get(i).charAt(c) != 'e'&& idk2.get(i).charAt(c) != 'f'){
                                        p = false;
                                    }
                                }
                            }
                        }
                        if (y.equals("ecl")){
                            if (!idk2.get(i).equals("amb") && !idk2.get(i).equals("brn") && !idk2.get(i).equals("blu") && !idk2.get(i).equals("gry") 
                            && !idk2.get(i).equals("grn") && !idk2.get(i).equals("hzl") && !idk2.get(i).equals("oth"))
                                p = false;
                        }
                        if (y.equals("pid")){
                            System.out.println(idk2.get(i).length());
                            if (idk2.get(i).length() != 9)
                                p = false;
                        }
                    }
                }
                else if (!idk.contains("cid") && idk.size() == 7){
                    for (int i = 0; i < idk.size(); i++){
                        String y = idk.get(i);
                        if (y.equals("byr")){
                            int u = Integer.parseInt(idk2.get(i));
                            if (u < 1920 || u > 2002){
                                p = false;
                            }
                        }
                        if (y.equals("iyr")){
                            int u = Integer.parseInt(idk2.get(i));
                            if (u < 2010 || u > 2020){
                                p = false;
                            }
                        }
                        if (y.equals("eyr")){
                            int u = Integer.parseInt(idk2.get(i));
                            if (u < 2020 || u > 2030){
                                p = false;
                            }
                        }
                        if (y.equals("hgt")){
                            if (idk2.get(i).charAt(idk2.get(i).length()-1) != 'n' && idk2.get(i).charAt(idk2.get(i).length()-1) != 'm'){
                                p = false;
                            }
                            else{
                                if (idk2.get(i).charAt(idk2.get(i).length()-1) == 'n'){
                                    String[]b = idk2.get(i).split("i");
                                    int v = Integer.parseInt(b[0]);
                                    if (v < 59 || v > 76)
                                        p = false;
                                }
                                else if (idk2.get(i).charAt(idk2.get(i).length()-1) == 'm'){
                                    String[]b = idk2.get(i).split("c");
                                    int v = Integer.parseInt(b[0]);
                                    if (v < 150 || v > 193)
                                        p = false;
                                }
                            }
                        }
                        if (y.equals("hcl")){
                            if (idk2.get(i).charAt(0) != '#'){
                                p = false;
                            }
                            else {
                                for (int c = 1; c < idk2.get(i).length(); c++){
                                    if (idk2.get(i).charAt(c) != '0' && idk2.get(i).charAt(c) != '1' && 
                                    idk2.get(i).charAt(c) != '2' && idk2.get(i).charAt(c) != '3' && idk2.get(i).charAt(c) != '4' 
                                    && idk2.get(i).charAt(c) != '5' && idk2.get(i).charAt(c) != '6' && idk2.get(i).charAt(c) != '7'
                                    && idk2.get(i).charAt(c) != '8' && idk2.get(i).charAt(c) != '9' && idk2.get(i).charAt(c) != 'a'
                                    && idk2.get(i).charAt(c) != 'b' && idk2.get(i).charAt(c) != 'c'&& idk2.get(i).charAt(c) != 'd'
                                    && idk2.get(i).charAt(c) != 'e'&& idk2.get(i).charAt(c) != 'f'){
                                        p = false;
                                    }
                                }
                            }
                        }
                        if (y.equals("ecl")){
                            if (!idk2.get(i).equals("amb") && !idk2.get(i).equals("brn") && !idk2.get(i).equals("blu") && !idk2.get(i).equals("gry") 
                            && !idk2.get(i).equals("grn") && !idk2.get(i).equals("hzl") && !idk2.get(i).equals("oth"))
                                p = false;
                        }
                        if (y.equals("pid")){
                            System.out.println(idk2.get(i).length());
                            if (idk2.get(i).length() != 9)
                                p = false;
                        }
                    }
                }
                if (idk.size() <= 6){
                    p = false;
                }
                if (idk.contains("cid") && idk.size() == 7){
                    p = false;
                }
                System.out.println(p);
                if (p == true)
                    total++;
                idk.clear();
                idk2.clear();
            }
            else{
                String[]z = x.split(" ");
                for (int i = 0; i < z.length; i++){
                    String[]h = z[i].split(":");
                    idk.add(h[0]);
                    idk2.add(h[1]);
                }
            }
            o--;

        }
        System.out.println(total);
    } catch (FileNotFoundException e) {
		e.printStackTrace();

    }
    
    }

}