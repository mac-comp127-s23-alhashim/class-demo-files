package gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;
import javax.swing.plaf.DimensionUIResource;

import java.awt.event.*;

public class PushCounter {
    private static JLabel label = null;
    private static int counter = 0;
    private static JButton incrementButton = null;
    private static JButton decrementButton = null;

    public static void main(String[] args) {
        
        JFrame frame = new JFrame("Push Counter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        

        // PuchCounterPanel panel = new PuchCounterPanel();
        // frame.getContentPane().add(panel);
    
        // PANEL 1 ===================================================================

        ButtonActionListener bal = new ButtonActionListener();
        BottonMouseListener bml = new BottonMouseListener();
        
        incrementButton = new JButton("Increment");
        incrementButton.addActionListener(bal);
        incrementButton.addMouseListener(bml);
        
        decrementButton = new JButton("Decrement");
        decrementButton.addActionListener(bal);
        decrementButton.addMouseListener(bml);
        

        label = new JLabel();
        updateClicks();
        
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(300, 40));
        panel.add(decrementButton);
        panel.add(label);
        panel.add(incrementButton);
        

        // PANEL 2 ===================================================================
        JPanel drawingPanel = new JPanel();
        drawingPanel.setPreferredSize(new Dimension(300, 40));
        drawingPanel.addMouseListener(bml);
        drawingPanel.setBackground(Color.red);

        // ADDING THINGS

        JPanel primaryPanel = new JPanel();
        primaryPanel.add(panel);
        primaryPanel.add(drawingPanel);

        Container contentPane = frame.getContentPane();
        contentPane.add(primaryPanel);

        frame.pack();
        frame.setVisible(true);
    }

    private static class ButtonActionListener implements ActionListener 
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == incrementButton) {
                label.setText("Counter: "+ (++counter));
            }
            else if(e.getSource() == decrementButton) {
                label.setText("Counter: "+ (--counter));
            }
        }
    }

    private static class BottonMouseListener implements MouseInputListener 
    {
        @Override
        public void mouseClicked(MouseEvent e) {
            if(! (e.getSource() instanceof JButton)) {
                incrementButton.setText(incrementButton.getText() + "!");
            }
            
        }

        @Override
        public void mousePressed(MouseEvent e) {
            // TODO Auto-generated method stub
            
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            // TODO Auto-generated method stub
            
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            if(! (e.getSource() instanceof JButton)) {
                incrementButton.setText(incrementButton.getText() + "!");
            }
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if(! (e.getSource() instanceof JButton)) {
                String temp = incrementButton.getText();
                incrementButton.setText(temp.substring(0, temp.length()-1));
            }
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            if(! (e.getSource() instanceof JButton)) {
                String temp = incrementButton.getText();
                incrementButton.setText(temp.substring(0, temp.length()-1));
            }
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            if(! (e.getSource() instanceof JButton)) {
                String temp = incrementButton.getText();
                incrementButton.setText(temp.substring(0, temp.length()-1));
            }
        }
        
    }

    public static void updateClicks() {
        label.setText("Counter: " + counter);
    }
}
