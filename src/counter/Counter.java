package counter;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsText;

/*
 * A simple program to illustrate the animate method of CanvasWindoow
 */
class counter {
    private static int INTO_PAUSE_AMOUNT_MS = 500;
    private static CanvasWindow canvas;
    private static GraphicsText counterHolder;
    public static void main(String[] args) {
        canvas = new CanvasWindow("Counter", 100, 100);
       
        counterHolder = new GraphicsText();
        counterHolder.setFontSize(20);
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

        canvas.animate(e -> {
            counterHolder.setText(""+(Integer.parseInt(counterHolder.getText())+1));
            counterHolder.setCenter(canvas.getWidth()/2, canvas.getHeight()/2);
        });
    }

    private static void setTextCenterDrawPause(String text) {
        counterHolder.setText(text);
        counterHolder.setCenter(canvas.getWidth()/2, canvas.getHeight()/2);
        canvas.draw();
        canvas.pause(INTO_PAUSE_AMOUNT_MS);
    }
}