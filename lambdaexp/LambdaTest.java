package lambdaexp;

import java.util.*;

import javax.swing.*;
import javax.swing.Timer;
import java.awt.Toolkit;

/*
 * Source: Horstmann2021 Core Java Volume I: Fundamentals, Chapter 6, p. 6.3
 */
public class LambdaTest {
    public static void main(String[] args) {
        String[] planets = new String[] {"Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Naptune"};
        System.out.println(Arrays.toString(planets));

        System.out.println();
        System.out.println("Sorted in dictionary order");
        Arrays.sort(planets);
        System.out.println(Arrays.toString(planets));

        System.out.println();
        System.out.println("Sorted by length");
        Arrays.sort(planets, (first, second) -> first.length() - second.length());
        System.out.println(Arrays.toString(planets));


        Timer t = new Timer(1000, event -> {
            System.out.println("The time is " + new Date());
            Toolkit.getDefaultToolkit().beep();
        });
        t.start();

        // keep program running untill user select "OK"
        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);
    }
}
