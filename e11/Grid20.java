import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import javax.lang.model.element.Element;

public class Grid20{
    public static void main(String[] args) throws IOException {
        long startTime = System.nanoTime();
        fun();
        long endTime   = System.nanoTime();
        double totalTime = endTime - startTime;
        System.out.println(totalTime/1_000_000_000);
    }

    static void fun() throws IOException {
        Path filePath = Path.of("gridFile.txt");
        String gridString = Files.readString(filePath);

        ArrayList<Integer> data = readToIntArray(gridString);
        Pair dims = dims(gridString);

        int h =  horizontal(data);
        int v =  vertical(data);
        int dr = diagRight(data, dims);
        int dl = diagLeft(data, dims);

        System.out.println(h);
        System.out.println(v);
        System.out.println(dr);
        System.out.println(dl);
    }

    static ArrayList<Integer> readToIntArray(String gridString) throws IOException {
        ArrayList gridInt = new ArrayList<Integer>();

        String singleNum = "";
        for (int i = 0; i < gridString.length(); i++) {
            
            if (gridString.charAt(i) == '\n') { ++i; }
            
            if (Character.isDigit(gridString.charAt(i))) {
                singleNum += gridString.charAt(i);
                if (i == gridString.length()-1) { gridInt.add(Integer.parseInt(singleNum)); }
            } else {
                gridInt.add(Integer.parseInt(singleNum));
                singleNum = "";
            }
        }

        return gridInt;
    }

    private static Pair dims(String gridString) {
        
        Pair dim = new Pair(1,1);

        for (int i = 0; i < gridString.length(); ++i) {
            if (gridString.charAt(i) == '\n') { dim.y++; }
        }

        for (int i = 0; i < gridString.length(); ++i) {
            if (gridString.charAt(i) == ' ' && gridString.charAt(i) != '\n') { 
                dim.x++; 
            } else if (gridString.charAt(i) == '\n') {
                break;
            }
        }

        return dim;
    }

    private static int horizontal(ArrayList<Integer> data) {
        int sum = 0;
        for (int i = 3; i < data.size(); ++i) {
            int temp = data.get(i-3) * data.get(i-2) * data.get(i-1) * data.get(i);
            if (temp > sum) { sum = temp; }
        }
        return sum;
    }

    private static int vertical(ArrayList<Integer> data) {
        int sum = 0;
        for (int i = 60; i < data.size(); ++i) {
            int temp = data.get(i-60) * data.get(i-40) * data.get(i-20) * data.get(i);
            if (temp > sum) { sum = temp; }
        }
        return sum;
    }

    private static int diagRight(ArrayList<Integer> data, Pair dim) {

        int num = 0;
        int lastRecord = 0;

        for (int i = 0; i < data.size(); ++i) {
            if (i + 3*dim.y + 4-1 == data.size()) {
                lastRecord = i;
            }
        }

        for (int i = 0; i < lastRecord; ++i) {    
            if ((i+4-1) % dim.x == 0) {
                i+=3;
            } else {
                int temp = data.get(i)*data.get(i+(dim.x+1))*data.get(i+(dim.x*2+2))*data.get(i+(dim.x*3+3));
                if (temp > num) { num = temp; }
            }
        }

        return num;
    }

    private static int diagLeft(ArrayList<Integer> data, Pair dim) {

        int num = 0;
        int lastRecord = 0;

        for (int i = 0; i < data.size(); ++i) {
            if (i+(2*dim.y+dim.x) == data.size()) {
                lastRecord = i;
            }
        }

        for (int i = 3; i < lastRecord; ++i) {    
            if (i % dim.x == 0) {
                i+=3;
            } else {
                int temp = data.get(i)*data.get(i+(dim.x-1))*data.get(i+(dim.x*2-2))*data.get(i+(dim.x*3-3));
                if (temp > num) { num = temp; }
            }
        }

        return num;
    }
}