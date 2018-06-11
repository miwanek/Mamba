package sample;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.PixelReader;
import javafx.scene.shape.Polygon;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class Model {

    Spider
    public static final int CANVAS_HEIGHT = 540;
    public static final int CANVAS_WIDTH = 580;
    private int level;
    private int points;
    private int progress;
    private int lives;
    private int timeRemaining;
    private boolean started;
    private Deque<String> nextMoves;
    private ArrayList<Polygon> Areas;

    private Canvas playground;
    GraphicsContext graphicsContext;

    Model(Canvas playground )
    {
        started = false;
        nextMoves = new ArrayDeque<>();
        this.playground = playground;
      //  graphicsContext = playground.getGraphicsContext2D();
    }

    public boolean getStarted()
    {
        return started;
    }
    public void setStarted( boolean status)
    {
        started = status;
    }
    public String getNextMove()
    {
        if( nextMoves.size() == 1 ) return nextMoves.getFirst();
        else return nextMoves.removeFirst();
    }
    public void sendNextMove( String nextMove)
    {
        nextMoves.add( nextMove );
    }
    public boolean checkMoving( )
    {
        if(nextMoves.size() == 0) return false;
        return true;
    }
    public void stopMove( )
    {
        nextMoves.clear();
    }


}
