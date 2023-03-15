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
public class ReferenceMethod_Timer {
    public static void main(String[] args) {
        System.out.println("Reference Method Version");
        Timer t = new Timer(1000, System.out::println);
        t.start();

        // keep program running untill user select "OK"
        JOptionPane.showMessageDialog(null, "Quit program?");
        t.stop();
        
        
        System.out.println("Lembda Experssion Version");
        t = new Timer(1000, event -> System.out.println(event));
        t.start();

        // keep program running untill user select "OK"
        JOptionPane.showMessageDialog(null, "Quit program?");
        t.stop();
    }
}
