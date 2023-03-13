package lambdaexp;

import java.util.*;

import javax.swing.*;
import javax.swing.Timer;
import java.awt.Toolkit;

/*
 * Source: Horstmann2021 Core Java Volume I: Fundamentals, Chapter 6, p. 6.3
 * 
 * Illustration of the lambda experssion that takes the role (provide implementation) of the 
 * actionperformed method of the ActionListener functional interface
 */
public class LambdaTest_Timer {
    public static void main(String[] args) {
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
