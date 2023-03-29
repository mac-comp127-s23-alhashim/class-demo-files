package moving;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Ellipse;

class Moving {
    static int delta = 5;
    static boolean isRight = true;
    public static void main(String[] args) {
        CanvasWindow canvas = new CanvasWindow("Test Open Box", 500, 500);
        Ellipse ball = new Ellipse(0, 0, 5, 5);
        canvas.add(ball);
        canvas.animate(() -> {
            if(ball.getX() > canvas.getWidth() && isRight) {
                delta = -5;
                isRight = false;
            }
            if(ball.getX() < 0 && !isRight) {
                delta = +5;
                isRight = true;
            }

            ball.setPosition(ball.getX() + delta, ball.getY() + delta);
        });

    }
}