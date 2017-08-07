package ru.lesson.lessons;


import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Andrew on 25.07.2017.
 */
public class MainClass {

    class Cell{
        int ver;
        int hori;
    }

    private static String power;
    private static int lengthOfLine;

    private static char[][] workField;
    private static ArrayList<String> inputValues;

    private static int row;
    private static int column;

//    private int maxK = 1;
//    private int maxF = 1;


    public static void main (String[] args) {
        MainClass mc = new MainClass();

        inputValues = new ArrayList<String>();
        Scanner s = new Scanner(System.in);

        System.out.println("Please, input your array (When you want to finish typing, enter the word \"end\".): ");
        System.out.println();
        while (true) {
            power = s.next();
            if (power.equals("end")) break;
            if (mc.reg(power)) {
                if (lengthOfLine == 0) {
                    lengthOfLine = power.length();
                    inputValues.add(power);
                } else {
                    if (power.length() == lengthOfLine) {
                        inputValues.add(power);
                    } else {
                        System.out.println("Try again input only " + lengthOfLine + " digits");
                    }
                }
            }
            else {
                System.out.println("Try again input only digits 0 or 1");
            }

        }
        workField = mc.parseToDigitArray(inputValues);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print(workField[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("perimeter of your input --> " + mc.findSubRectangle(workField));
        System.out.println();
    }

    private boolean reg(String s) {

        Pattern p =Pattern.compile("[0-1]+");
        Matcher m = p.matcher(s);

        return m.matches();
    }

    private char[][] parseToDigitArray (ArrayList<String> arrayList) {
        row = arrayList.size();
        column = arrayList.get(0).length();
        char[][] myfield = new char[row][column];

        for (int i = 0; i < arrayList.size(); i++) {
            for (int j = 0; j < arrayList.get(0).length(); j++) {
                myfield[i][j] = arrayList.get(i).charAt(j);
            }
        }
        return myfield;
    }

    public int findSubRectangle(char input[][]){
        Cell T[][] = new Cell[input.length][input[0].length];
        for(int i=0; i < T.length; i++){
            for(int j=0; j < T[0].length; j++){
                T[i][j] = new Cell();
            }
        }

        for(int i=0; i < input.length; i++){
            for(int j=0; j < input[0].length; j++){
                if(input[i][j] == '1'){
                    if(i == 0 && j == 0){
                        T[i][j].hori = 1;
                        T[i][j].ver = 1;
                    }
                    else if(i == 0){
                        T[i][j].hori = T[i][j-1].hori + 1;
                        T[i][j].ver = 1;
                    }else if(j == 0){
                        T[i][j].ver = T[i-1][j].ver +1;
                        T[i][j].hori = 1;
                    }else{
                        T[i][j].hori = T[i][j-1].hori +1;
                        T[i][j].ver = T[i-1][j].ver + 1;
                    }
                }
            }
        }
        for(int i=0; i < T.length; i++){
            for(int j=0; j < T[0].length; j++){
                System.out.print(T[i][j].ver + "," + T[i][j].hori+ "  ");
            }
            System.out.println();
        }


        int perimeter = 1;
        int maxP = 1;

        for(int i=T.length -1; i >=0 ; i--){
            for(int j= T[0].length-1 ; j >=0; j--){
                if(T[i][j].ver == 0 || T[i][j].ver == 1 || T[i][j].hori == 1){
                    continue;
                }

                int k = 0;
                int f = 0;
                int a = 0;
                int b = 0;
                if (T[i][j].ver <= T[i][j].hori) {
                    f = T[i][j].hori;
                    met2:
                    for (k=T[i][j].ver; k > 1; k--) {
                        if (T[i][j-f+1].ver >= k && T[i-k+1][j].hori >= f){
                            perimeter = k+k+f+f;
                            break;
                        } else {
                            a = T[i-k+1][j].hori;
                            int c = 0;
                            for (b = f; b > 1; b--){
                                if ((i-k+1+c) == k) {
                                    break;
                                }
                                if (a == 1) {
                                    c++;
                                    a = T[i-k+1+c][j].hori;
                                    continue;
                                }
                                if (T[i][j-b+1].ver >= T[i][j].ver-c && a >= b) {
                                    perimeter = (T[i][j].ver-c)*2 + b*2;
                                    break met2;
                                }
                            }
                        }
                    }
                } else {
                    f = T[i][j].ver;
                    met2:
                    for (k=T[i][j].hori; k > 1; k--) {
                        if (T[i][j-k+1].ver >= f && T[i-f+1][j].hori >= k){
                            perimeter = k+k+f+f;
                            break;
                        } else {
                            a = T[i][j-k+1].ver;
                            int c = 0;
                            for (b = f; b > 1; b--){
                                if ((j-k+1+c) == k) {
                                    break;
                                }
                                if (a == 1){
                                    c++;
                                    a = T[i][j-k+1+c].ver;
                                    continue;
                                }
                                if (T[i-b+1][j].hori >= T[i][j].hori-c && a >= b){
                                    perimeter = (T[i][j].hori-c)*2 + b*2;
                                    break met2;
                                }
                            }
                        }
                    }
                }
                if (maxP < perimeter) {
                    maxP = perimeter;
                }
            }
        }

        return maxP;
    }
}
