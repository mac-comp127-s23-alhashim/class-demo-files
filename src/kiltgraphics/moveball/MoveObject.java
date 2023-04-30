package kiltgraphics.moveball;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Rectangle;
import edu.macalester.graphics.events.Key;

public class MoveObject {
    private static int deltaX = 10;
    private static int deltaY = 10;
    private static int directionX;
    private static int directionY;

    public static void main(String[] args) {
        CanvasWindow canvas = new CanvasWindow("Move Ball using Keyboard", 500,500);
        Rectangle obj = new Rectangle(0, 0, 10, 5);
        obj.setFilled(true);
        canvas.add(obj, canvas.getWidth()/2, canvas.getHeight()/2);
        
        canvas.onKeyDown(keyEvent -> {
            Key key = keyEvent.getKey();

            directionX = 0;
            directionY = 0;
            if(key == Key.UP_ARROW || key == Key.DOWN_ARROW) {
                directionY = key == Key.UP_ARROW? -1 : +1;
            }
            
            if(key == Key.LEFT_ARROW || key == Key.RIGHT_ARROW) {
                directionX = (key == Key.LEFT_ARROW)? -1 : +1;
            }

            int newX = (int) Math.max(0, obj.getX() + (directionX * deltaX));
            newX = (int) Math.min(newX, canvas.getWidth()-obj.getWidth());
            int newY = (int) Math.max(0, obj.getY() + (directionY * deltaY));
            newY = (int) Math.min(newY, canvas.getHeight()-obj.getHeight());
            obj.setPosition(newX, newY);
        });
    }
}
