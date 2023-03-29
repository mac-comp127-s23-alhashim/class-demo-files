package counter;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsText;

/*
 * A simple program to illustrate the animate method of CanvasWindoow
 */
class counter {
    private static int INTO_PAUSE_AMOUNT_MS = 500;
    private static CanvasWindow canvas;
    private static int CANVAS_SIZE = 500;
    
    private static GraphicsText counterHolder;
    private static int FONT_SIZE = 100;
    public static void main(String[] args) {
        canvas = new CanvasWindow("Counter", CANVAS_SIZE, CANVAS_SIZE);
        
        // the closure passed to animate will be executed forever directly when the main method finishes
        canvas.animate(e -> {
            counterHolder.setText(""+(Integer.parseInt(counterHolder.getText())+1));
            counterHolder.setCenter(canvas.getWidth()/2, canvas.getHeight()/2);
        });
       
        counterHolder = new GraphicsText();
        counterHolder.setFontSize(FONT_SIZE);
        canvas.add(counterHolder);

        setTextCenterDrawPause("animate");
        setTextCenterDrawPause("method");
        setTextCenterDrawPause("will");
        setTextCenterDrawPause("start");
        setTextCenterDrawPause("shortly");
        setTextCenterDrawPause(";-)");
        setTextCenterDrawPause("ready");
        setTextCenterDrawPause("set");
        setTextCenterDrawPause("go");
        setTextCenterDrawPause("0");
        
    }

    private static void setTextCenterDrawPause(String text) {
        counterHolder.setText(text);
        counterHolder.setCenter(canvas.getWidth()/2, canvas.getHeight()/2);
        canvas.draw();
        canvas.pause(INTO_PAUSE_AMOUNT_MS);
    }
}