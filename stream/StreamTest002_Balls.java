package stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

enum Color {
    RED,
    BLUE,
    YELLOW,
    GREEN,
    BLACK,
    WHITE
}

class Ball {
    private String id;
    private double size;
    private Color color;

    public Ball(String id, double size, Color color) {
        this.id = id;
        this.size = size;
        this.color = color;
    }

    public String getId() {
        return id;
    }

    public double getSize() {
        return size;
    }

    public Color getColor() {
        return color;
    }

    @Override
    public String toString() {
        return getId() + ":" +getSize() + ":" + getColor();
    }
}


class Prep2 {
    public static double MAX_BALL_SIZE = 50;

    public static List<Ball> generateRandomeBalls(int count, int seed) {
        int numOfColors = Color.values().length;
        Random rand = new Random(seed);

        List<Ball> balls = new ArrayList<>(count);
        for(int i=1; i<=count; i++) {
            balls.add(new Ball(""+i, 
                               rand.nextDouble(MAX_BALL_SIZE), 
                               Color.values()[rand.nextInt(numOfColors)]));
        }

        return balls;
    }

    public static void printBalls(List<Ball> list, String msg) {
        System.out.println();
        System.out.println("===== " + msg + " (" + list.size() + ") ===================================");
        for(Ball ball : list) {
            System.out.println(ball);
        }
    }
}


// we want to get the largest 10 red balls
class Test {
    public static void main(String[] args) {
        List<Ball> balls = Prep2.generateRandomeBalls(100, 14);
        Prep2.printBalls(balls, "All Balls");

        // filter red balls
        List<Ball> redBalls = new ArrayList<>();
        for(Ball ball : balls) {
            if(ball.getColor() == Color.RED) {
                redBalls.add(ball);
            }
        }
        Prep2.printBalls(redBalls, "Red Balls");

        // sort red balls
        Collections.sort(redBalls, new Comparator<Ball>() {
            public int compare(Ball ball1,  Ball ball2) {
                return -Double.compare(ball1.getSize(), ball2.getSize());
            }
        });
        Prep2.printBalls(redBalls, "Red Balls Sorted");

        

    }
}