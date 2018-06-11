package sample;

import javafx.geometry.Rectangle2D;
import javafx.scene.shape.Rectangle;

public class Sprite {
    protected double oldPositionX;
    protected double newPositionX;
    protected double getOldPositionXpositionX;
    protected double positionY;
    protected double width;
    protected double height;
    protected double velocityX;
    protected double velocityY;
    //private double

    public Rectangle getShape()
    {
        return new Rectangle(positionX,positionY,width,height);
    }

    public Rectangle2D getBoundary()
    {
        return new Rectangle2D(positionX,positionY,width,height);
    }
    public boolean intersects(Sprite s)
    {
        return s.getBoundary().intersects( this.getBoundary() );
    }
    public void moveLeft(double time)
    {
        positionX -= velocityX * time;
        if(positionX <= 0 ) positionX = 0;
    }
    public void moveRight(double time)
    {
        positionX += velocityX * time;
        if(positionX >= Model.CANVAS_WIDTH - 20 ) positionX = Model.CANVAS_WIDTH - 20;
    }
    public void moveUp(double time)
    {
        positionY -= velocityY * time;
        if(positionY <= 0 ) positionY = 0;
    }
    public void moveDown(double time)
    {
        positionY += velocityY * time;
        if(positionY >= Model.CANVAS_HEIGHT - 20 ) positionY = Model.CANVAS_HEIGHT - 20;
    }
    public Double getPositionX( )
    {
        return positionX;
    }
    public Double getPositionY( )
    {
        return positionY;
    }
    public Double getWidth( )
    {
        return width;
    }
    public Double getHeight( )
    {
        return height;
    }
}
