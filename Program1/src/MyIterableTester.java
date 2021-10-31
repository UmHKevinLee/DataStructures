//Kevin Lee CSCI 340 - 002

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class MyIterableTester {
    public static void main(String [] args) throws FileNotFoundException {
        File inputFile = new File("input.txt");
        Scanner scan = new Scanner(inputFile);
        Scanner scan2 = new Scanner(inputFile);

        ArrayList<String> anyTypeInput = new ArrayList<>();

        while (scan.hasNext()) {
            anyTypeInput.add(scan.next());
        }

        Collections.sort(anyTypeInput, Collections.reverseOrder());

        System.out.println("Read \"intput.txt\" and print by reverse sorted order:");
        for(String s:anyTypeInput){
            System.out.print(s + " ");
        }

        System.out.println();

        List<String> strInput = new ArrayList<>();
        ArrayList<Integer> intInput = new ArrayList<>();
        ArrayList<Double> dInput = new ArrayList<>();
        String buff = "\n----------+----------";

        while (scan2.hasNext()){                     //while loop to store appropriate data in
            if (scan2.hasNextInt()) {                //right ArrayList.
                intInput.add(scan2.nextInt());
            }
            else if(scan2.hasNextDouble()){
                dInput.add(scan2.nextDouble());
            }
            else
            strInput.add(scan2.next());
        }


        String[] strArr = new String[strInput.size()];  //Converting ArrayList into Array
        Integer[] intArr = new Integer[intInput.size()];
        Double[] doubArr = new Double[dInput.size()];

        strArr = strInput.toArray(strArr);
        intArr = intInput.toArray(intArr);
        doubArr = dInput.toArray(doubArr);

        MyIterable<String> strIt= new MyIterable<>(strArr); //Put Arrays in MyIterable class
        MyIterable<Integer> intIt= new MyIterable<>(intArr);
        MyIterable<Double> doubIt= new MyIterable<>(doubArr);

        System.out.println("My Friends:");

        for(String s: strIt){
            System.out.print(s + " ");
        }

        System.out.println(buff);

        System.out.println("My numbers:");

        for(Integer i: intIt){
            System.out.print(i + " ");
        }

        System.out.println(buff);

        System.out.println("My scores:");

        for(Double d : doubIt){
            System.out.print(d + " ");
        }

        System.out.println(buff);

    }
}
