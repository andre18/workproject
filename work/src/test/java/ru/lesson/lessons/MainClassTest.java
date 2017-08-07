package ru.lesson.lessons;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Andrew on 03.08.2017.
 */
public class MainClassTest {

    @Test
    public void findSubRectangle() throws Exception {
        char[][] array = {
                {'1','0','0','0','0','0'},
                {'0','0','0','0','0','0'},
                {'1','1','1','1','0','0'},
                {'1','1','1','1','1','0'},
                {'1','0','0','1','1','0'},
                {'1','0','1','1','1','0'}};
        MainClass mc = new MainClass();
        assertEquals(12, mc.findSubRectangle(array));
        System.out.println();
    }

    @Test
    public void findSubRectangle2() throws Exception {
        char [][] array = {
                {'1', '1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '0', '1'},
                {'1', '1', '1', '1', '0', '0'},
                {'1', '0', '1', '1', '1', '1'},
                {'1', '1', '1', '1', '1', '1'},
                {'1', '0', '1', '1', '1', '1'}
        };
        MainClass mc = new MainClass();
        assertEquals(16, mc.findSubRectangle(array));
        System.out.println();
    }

    @Test
    public void findSubRectangle3() throws Exception {
        char [][] array = {
                {'0', '0', '0', '0', '0', '1'},
                {'0', '1', '0', '1', '1', '1'},
                {'0', '1', '0', '1', '0', '1'},
                {'0', '1', '1', '1', '1', '1'},
                {'0', '0', '0', '0', '0', '0'},
        };
        MainClass mc = new MainClass();
        assertEquals(12, mc.findSubRectangle(array));
        System.out.println();
    }

    @Test
    public void findSubRectangle4() throws Exception {
        char [][] array = {
                {'0', '0', '1', '0', '1'},
                {'0', '1', '1', '0', '1'},
                {'0', '1', '0', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'0', '1', '1', '1', '0'},
        };
        MainClass mc = new MainClass();
        assertEquals(10, mc.findSubRectangle(array));
        System.out.println();
    }

    @Test
    public void findSubRectangle5() throws Exception {
        char [][] array = {
                {'1', '0', '0', '1', '1', '1'},
                {'1', '0', '1', '1', '0', '1'},
                {'0', '1', '1', '1', '1', '1'},
                {'0', '0', '0', '1', '1', '1'},
                {'0', '0', '0', '0', '0', '0'},
        };
        MainClass mc = new MainClass();
        assertEquals(14, mc.findSubRectangle(array));
        System.out.println();
    }

    @Test
    public void findSubRectangle6() throws Exception {
        char [][] array = {
                {'1', '1', '1', '1', '0', '1'},
                {'1', '0', '1', '1', '0', '1'},
                {'1', '0', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '0', '1'},
                {'0', '0', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1', '1'}
        };
        MainClass mc = new MainClass();
        assertEquals(16, mc.findSubRectangle(array));
        System.out.println();
    }

}