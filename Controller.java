package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.paint.Color;

import java.awt.*;

public class Controller {
    Model gameModel;
    @FXML
    Canvas playground;
    @FXML
    Label score;
    @FXML
    Label level;
    @FXML
    Label lives;
    @FXML
    Label progress;
    @FXML
    Label remainingTime;
    @FXML
    Pane gamePane;
    @FXML
    AnchorPane anchor;

    public Controller()
    {
        gameModel = new Model( playground);
    }
//
   @FXML
   void exitButtonPressed()
    {
        System.exit(0);
    }

    @FXML
    void  startGame() throws InterruptedException
    {
        GraphicsContext graphicsContext = playground.getGraphicsContext2D();
        if( gameModel.getStarted() == false ) beginGame( gameModel, graphicsContext );
        else stopGame( gameModel, graphicsContext );
    }

    private void beginGame( Model gameModel, GraphicsContext graphicsContext) throws InterruptedException
    {
        Scene myScene = anchor.getScene();
        Spider spider = new Spider(playground);
        playground.setVisible(true);
        gameModel.setStarted(true);
        gamePane.setVisible(true);
        score.setText("0");
        level.setText("1");
        lives.setText("3");
        progress.setText("0%");
        remainingTime.setText("30");

        double x = 10;
        double y = 10;
        double w = 20;
        double h = 20;

        Image spiderImage = new Image("file:spiderDOWN1.png");
        myScene.setOnKeyPressed(
                e -> {
                    KeyCode input = e.getCode();
                    String code;
                    if( input  == KeyCode.UP || input  == KeyCode.DOWN ||
                            input  == KeyCode.LEFT || input == KeyCode.RIGHT )
                    {
                        gameModel.sendNextMove( input.toString() );
                    }
                });
        graphicsContext.drawImage(spiderImage, 0, 0, 20, 20);

        Timeline gameLoop = new Timeline();
        gameLoop.setCycleCount( Timeline.INDEFINITE );

        final long timeStart = System.currentTimeMillis();



            KeyFrame kf = new KeyFrame(
                    Duration.seconds(0.017),                // 60 FPS
                    ae -> {
                        double t = (System.currentTimeMillis() - timeStart) / 1000.0;
                        double t2 = (System.currentTimeMillis() - timeStart) / 10.0;

                        String direction;

                        // Clear the canvas
                        graphicsContext.clearRect(0, 0, Model.CANVAS_WIDTH, Model.CANVAS_HEIGHT);

                        if(gameModel.getStarted() == false ) gameLoop.stop();
                        drawSafeArea(graphicsContext);

                        if(gameModel.checkMoving() == true)
                        {
                            direction = gameModel.getNextMove();
                            spider.move(direction, 1000.0 );
                           // spider.render(direction,t2);
                        }
                        drawSpider( t2,  graphicsContext,  spider);

                        // background image clears canvas
                        //spider.update(t2);
                        //graphicsContext.drawImage(spider.getFrame(t), x1, y1, 20, 20);


                    });

            gameLoop.getKeyFrames().add(kf);
            gameLoop.play();



    }
    private void prepareSafeArea(GraphicsContext graphicsContext)
    {

    }

    private void drawWebArea()
    {

    }

    private void drawSafeArea(GraphicsContext graphicsContext)
    {
        graphicsContext.setLineWidth(20);
        graphicsContext.setStroke( Color.web( "d1e0e0") );
        graphicsContext.strokePolyline(new double[]{10, 10, 570, 570,10 },
                new double[]{10, 530, 530, 10, 10}, 5);
    }

    private void drawSpider(Double t2, GraphicsContext graphicsContext, Spider spider)
    {
        double X = spider.getPositionX();
        double Y = spider.getPositionY();
        double W = spider.getWidth();
        double H = spider.getHeight();
        String spiderDirection = spider.getSpiderDirection();
        if(spiderDirection == "LEFT" )graphicsContext.drawImage(spider.getFrameLeft(t2), X, Y, W, H);
        else if(spiderDirection == "RIGHT" ) graphicsContext.drawImage(spider.getFrameRight(t2), X, Y, W, H);
        else if(spiderDirection == "UP" ) graphicsContext.drawImage(spider.getFrameUp(t2), X, Y, W, H);
        else if(spiderDirection == "DOWN" ) graphicsContext.drawImage(spider.getFrameDown(t2), X, Y, W, H);

    }

    private void stopGame(Model gameModel, GraphicsContext graphicsContext)
    {
        gameModel.setStarted( false );
        gameModel.stopMove();
        graphicsContext.clearRect(0, 0, Model.CANVAS_WIDTH, Model.CANVAS_HEIGHT);
        playground.setVisible(false);
        gamePane.setVisible(false);
    }

}
