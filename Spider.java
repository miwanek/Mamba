package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.util.Duration;
import javafx.util.Pair;

import java.util.ArrayList;

import static java.lang.Thread.sleep;

public class Spider extends Sprite   {

    private Image[] framesUp;
    private Image[] framesDown;
    private Image[] framesLeft;
    private Image[] framesRight;
    private double duration;
    private String spiderDirection;
    private boolean netBroken;
    private int canChangeDirection;
    private ArrayList<Pair<Integer   , Integer  >  > web;


    public Image getFrameUp(double time)
    {
        int index = (int)((time % (framesUp.length * duration)) / duration);
        return framesUp[index];
    }
    public String  getSpiderDirection( )
    {
        return spiderDirection;
    }

    public Image getFrameDown(double time)
    {
        int index = (int)((time % (framesDown.length * duration)) / duration);
        return framesDown[index];
    }
    public Image getFrameLeft(double time)
    {
        int index = (int)((time % (framesLeft.length * duration)) / duration);
        return framesLeft[index];
    }
    public Image getFrameRight(double time)
    {
        int index = (int)((time % (framesRight.length * duration)) / duration);
        return framesRight[index];
    }

    Spider( Canvas playground )
    {
        positionX = 0;
        positionY = 0;
        width = 20;
        height = 20;
        framesUp = new Image[1];
        framesDown = new Image[1];
        framesLeft = new Image[1];
        framesRight = new Image[1];
        netBroken = false;
        velocityX = 0.001;
        velocityY = 0.001;
        spiderDirection = "DOWN";

        for (int i = 0; i < 1; i++)
        {
            framesUp[i] = new Image( "file:spiderUP1.png" );
            framesDown[i] = new Image( "file:spiderDOWN1.png" );
            framesLeft[i] = new Image( "file:spiderLEFT1.png" );
            framesRight[i] = new Image( "file:spiderRIGHT1.png" );
        }
    }

    /*public void render( Double time, GraphicsContext graphicsContext)
    {
        if(spiderDirection == "LEFT" )graphicsContext.drawImage(getFrameLeft(time), positionX, positionY, width, height);
        else if(spiderDirection == "RIGHT" ) graphicsContext.drawImage(getFrameRight(time), positionX, positionY, width, height);
        else if(spiderDirection == "UP" ) graphicsContext.drawImage(getFrameUp(time), positionX, positionY, width, height);
        else if(spiderDirection == "DOWN" ) graphicsContext.drawImage(getFrameDown(time), positionX, positionY, width, height);
    } */
    public void move(String direction, Double time)
    {
        if(direction == "LEFT" ) moveLeft(time);
        else if(direction == "RIGHT" ) moveRight(time);
        else if(direction == "UP" ) moveUp(time);
        else if(direction == "DOWN" ) moveDown(time);
        spiderDirection = direction;
    }
}
