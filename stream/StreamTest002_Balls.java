package stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

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

    public static void printBallsIds(List<String> list, String msg) {
        System.out.println();
        System.out.println("===== " + msg + " (" + list.size() + ") ===================================");
        for(String ball : list) {
            System.out.println(ball);
        }
    }
}


// we want to get the largest 10 red balls
class Test {
    public static void main(String[] args) {
        List<Ball> balls = Prep2.generateRandomeBalls(1_000_000_0, 14);

        // Non-stream approach =====================================
        long startTime = System.currentTimeMillis();
        // filter red balls
        List<Ball> redBalls = new ArrayList<>();
        for(Ball ball : balls) {
            if(ball.getColor() == Color.RED) {
                redBalls.add(ball);
            }
        }

        // sort
        Collections.sort(redBalls, new Comparator<Ball>() {
            public int compare(Ball ball1,  Ball ball2) {
                return Double.compare(ball1.getSize(), ball2.getSize());
            }
        });
        
        // get top 10
        List<Ball> redBallsTop10 = new ArrayList<>();
        for(int i=0; i<10; i++) {
            redBallsTop10.add(redBalls.get(i));
        }

        // get balls' ids
        List<String> redBallTop10Ids = new ArrayList<>();
        for(Ball ball : redBallsTop10) {
            redBallTop10Ids.add(ball.getId());
        }
        long estimatedTime = System.currentTimeMillis() - startTime;
        System.out.println("Non-Stream: " + estimatedTime);


        // Stream Approach =========================================
        startTime = System.currentTimeMillis();
        List<String> redBallIds_stream = 
            // balls.parallelStream()
            balls.stream()
            .filter(b -> b.getColor() == Color.RED)
            .sorted(comparing(Ball::getSize))
            .limit(10)
            .map(Ball::getId)
            .collect(toList());
        estimatedTime = System.currentTimeMillis() - startTime;
        System.out.println("Stream: " + estimatedTime);
    }
}