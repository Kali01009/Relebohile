package com.example.relebohile;

import javafx.animation.*;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.*;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Duration;


public class HelloApplication extends Application {


    VBox label = new VBox();
    Label Scores;
    Label instructions;

    // animation movement

    Duration duration_1 = Duration.millis(5000);
    Duration duration_2 = Duration.millis(7000);
    Duration duration_3 = Duration.millis(8000);
    Duration duration_4 = Duration.millis(10000);
    Duration duration_5 = Duration.millis(12000);


    Duration duration1 = Duration.millis(15000);
    Duration duration2 = Duration.millis(17000);
    Duration duration3 = Duration.millis(12000);
    Duration duration4 = Duration.millis(20000);



    TranslateTransition point_1 = new TranslateTransition(duration1);
    TranslateTransition point_2 = new TranslateTransition(duration2);
    TranslateTransition point_3 = new TranslateTransition(duration3);
    TranslateTransition point_4 = new TranslateTransition(duration4);



    TranslateTransition translate1 = new TranslateTransition(duration_1);
    TranslateTransition translate2 = new TranslateTransition(duration_2);
    TranslateTransition translate3 = new TranslateTransition(duration_3);
    TranslateTransition translate4 = new TranslateTransition(duration_4);
    TranslateTransition translate5 = new TranslateTransition(duration_5);

// sequence of movement
    SequentialTransition sequential1;
    SequentialTransition sequential2;
    SequentialTransition Sequential3;
    SequentialTransition Sequential4;


    SequentialTransition Sequential_1;
    SequentialTransition Sequential_2;
    SequentialTransition Sequential_3;
    SequentialTransition sequential_4;
    SequentialTransition Sequential_5;


    Rectangle obj1 = new Rectangle(180,100);
    String source = getClass().getResource("/ship.png").toExternalForm();
    Image image = new Image(source);
    ImageView imageView = new ImageView(image);

// initializing money
    Rectangle obj2 = new Rectangle(35,20);
    String pic1 = getClass().getResource("/money.png").toExternalForm();
    Image point1 = new Image(pic1);

    Rectangle obj3 = new Rectangle(35,20);
    String pic2 = getClass().getResource("/money.png").toExternalForm();
    Image point2 = new Image(pic2);

    Rectangle obj4 = new Rectangle(35,20);
    String pic3 = getClass().getResource("/money.png").toExternalForm();
    Image point3 = new Image(pic3);

    Rectangle obj5 = new Rectangle(35,20);
    String pic4 = getClass().getResource("/money.png").toExternalForm();
    Image point4 = new Image(pic4);

    //Creating images clouds
    Rectangle cloud1 = new Rectangle(180,100);
    String pic_1 = getClass().getResource("/cloud.png").toExternalForm();
    Image image1 = new Image(pic_1);


    Rectangle cloud2 = new Rectangle(180,100);
    String pic_2 = getClass().getResource("/cloud.png").toExternalForm();
    Image image2 = new Image(pic_2);


    Rectangle cloud3 = new Rectangle(480,230);
    String pic_3 = getClass().getResource("/cloud.png").toExternalForm();
    Image image3 = new Image(pic_3);

    Rectangle cloud4 = new Rectangle(480,230);
    String pic_4 = getClass().getResource("/cloud.png").toExternalForm();
    Image image4 = new Image(pic_4);

    Rectangle cloud5 = new Rectangle(180,100);
    String pic_5 = getClass().getResource("/cloud.png").toExternalForm();
    Image image5 = new Image(pic_5);

    //Creating score
    double score;
    @Override
    public void start(Stage stage) {


        Pane root = new Pane();
        //setting clouds images
        cloud1.setFill(new ImagePattern(image1));
        cloud5.setFill(new ImagePattern(image5));
        cloud2.setFill(new ImagePattern(image2));
        cloud3.setFill(new ImagePattern(image3));
        cloud4.setFill(new ImagePattern(image4));


        //setting points images
        obj2.setFill(new ImagePattern(point1));
        obj3.setFill(new ImagePattern(point2));
        obj4.setFill(new ImagePattern(point3));
        obj5.setFill(new ImagePattern(point4));


        //setting getting points
        point_1.setToY(1950f);
        point_1.setCycleCount(200);
        point_1.setAutoReverse(false);
        sequential1 = new SequentialTransition (obj2, point_1);


        point_2.setToY(1950f);
        point_2.setCycleCount(200);
        point_2.setAutoReverse(false);
        sequential2 = new SequentialTransition (obj3, point_2);


        point_3.setToY(1950f);
        point_3.setCycleCount(200);
        point_3.setAutoReverse(false);
        Sequential3 = new SequentialTransition (obj4, point_3);


        point_4.setToY(1950f);
        point_4.setCycleCount(200);
        point_4.setAutoReverse(false);
        Sequential4= new SequentialTransition (obj5, point_4);


        translate1.setToX(-1950f);
        translate1.setCycleCount(200);
        translate1.setAutoReverse(false);
        Sequential_1 = new SequentialTransition (cloud1, translate1);



        translate2.setToX(-1950f);
        translate2.setCycleCount(200);
        translate2.setAutoReverse(false);
        Sequential_2 = new SequentialTransition (cloud2, translate2);

        translate3.setToX(-1950f);
        translate3.setCycleCount(200);
        translate3.setAutoReverse(false);
        Sequential_3 = new SequentialTransition (cloud3, translate3);

        translate4.setToX(-1950f);
        translate4.setCycleCount(200);
        translate4.setAutoReverse(false);
        sequential_4 = new SequentialTransition (cloud4, translate4);

        translate5.setToX(-1950f);
        translate5.setCycleCount(200);
        translate5.setAutoReverse(false);
        Sequential_5 = new SequentialTransition (cloud5, translate5);

         Group group = new Group(createInstructions(),createScore(),label,cloud2,cloud3,cloud4,obj2,obj3,obj4,obj5,root);

// setting x and y positions
        cloud1.setX(1400);
        cloud1.setY(50);
        cloud2.setX(1400);
        cloud2.setY(400);
        cloud3.setX(1400);
        cloud3.setY(800);
        cloud4.setX(1400);
        cloud4.setY(500);
        cloud5.setX(1400);
        cloud5.setY(100);


        obj2.setX(400);
        obj2.setY(-50);
        obj3.setX(600);
        obj3.setY(-50);
        obj4.setX(700);
        obj4.setY(-50);
        obj5.setX(850);
        obj5.setY(-50);

        final Scene scene = new Scene(group,1350, 680);
        scene.setFill(Color.BLACK);

        ImageView ship = createShip(scene);

        root.getChildren().addAll(obj1,cloud1,cloud2,cloud3,cloud4,cloud5,Scores);



        scene.addEventFilter(KeyEvent.KEY_PRESSED, event -> {
            double x = obj1.getX();
            double y = obj1.getY();

            if(event.getCode()==KeyCode.UP){
                obj1.setY(y-10);
            }
            else if(event.getCode()==KeyCode.DOWN){
                obj1.setY(y+10);
            }
            else if(event.getCode()==KeyCode.RIGHT){
                obj1.setX(x+10);
            }
            else if(event.getCode()==KeyCode.LEFT){
                obj1.setX(x-10);
            }
            else if(event.getCode()==KeyCode.ENTER){
                Play();
            }
            if(event.getCode() == KeyCode.SPACE){
                sequential1.pause();
                sequential2.pause();
                Sequential3.pause();
                Sequential4.pause();
                Sequential_1.pause();
                Sequential_2.pause();
                Sequential_3.pause();
                sequential_4.pause();
                Sequential_5.pause();
            }
        });

        stage.setTitle("Relebohile play wise bro");
        stage.setScene(scene);
        stage.show();
    }


    public void Play(){
        sequential1.play();
        sequential2.play();
        Sequential3.play();
        Sequential4.play();
        Sequential_1.play();
        Sequential_2.play();
        Sequential_3.play();
        sequential_4.play();
        Sequential_5.play();

    }
    public void Pause(){
        sequential1.pause();
        sequential2.pause();
        Sequential3.pause();
        Sequential4.pause();
        Sequential_1.pause();
        Sequential_2.pause();
        Sequential_3.pause();
        sequential_4.pause();
        Sequential_5.pause();

    }


    private ImageView createShip(Scene scene) {

        obj1.setFill(new ImagePattern(image));
        obj1.setX(100);
        obj1.setY(200);
        imageView.setFitWidth(130);
        imageView.setFitHeight(80);
        imageView.setY(scene.getHeight() - imageView.getFitHeight());

        return imageView;
    }
    private Label createInstructions() {
        instructions = new Label(
                //"\n\PRESS ENTER TO PLAY THE GAME!\n\SCORE:"
        );

        label.getChildren().add(instructions);

        instructions.setTextFill(Color.FORESTGREEN);
        instructions.setFont(Font.font("Arial", FontWeight.BOLD,20));
        return instructions;
    }
    private Label createScore() {
        score=0;

        Scores = new Label();
        Scores.setText(score+"");
        Scores.setLayoutX(200);
        Scores.setLayoutY(47);
        label.getChildren().add(Scores);

        Scores.setTextFill(Color.FORESTGREEN);
        Scores.setFont(Font.font("Arial",20));
        obj1.translateXProperty().addListener(observable -> {

        });
        cloud1.translateXProperty().addListener(new ChangeListener<Number>() {
            @Override
            // setting collition
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                if (obj1.getBoundsInParent().intersects(cloud1.getBoundsInParent())){
                    String icon= getClass().getResource("/thegameover.png").toExternalForm();
                    Image imageB= new Image(icon);
                    obj1.setFill(new ImagePattern(imageB));
                    Pause();
                    cloud1.setOpacity(0.1);
                } else if (obj1.getBoundsInParent().intersects(cloud2.getBoundsInParent())) {
                    String icon= getClass().getResource("/thegameover.png").toExternalForm();
                    Image imageJet= new Image(icon);
                    obj1.setFill(new ImagePattern(imageJet));
                    Pause();
                    cloud2.setOpacity(0.1);
                } else if (obj1.getBoundsInParent().intersects(cloud3.getBoundsInParent())) {
                    String icon= getClass().getResource("/thegameover.png").toExternalForm();
                    Image imageB= new Image(icon);
                    obj1.setFill(new ImagePattern(imageB));
                    Pause();
                    cloud3.setOpacity(0.1);
                } else if (obj1.getBoundsInParent().intersects(cloud4.getBoundsInParent())) {
                    String icon= getClass().getResource("/thegameover.png").toExternalForm();
                    Image imageB= new Image(icon);
                    obj1.setFill(new ImagePattern(imageB));
                    Pause();
                    cloud4.setOpacity(0.1);
                }
                else if (obj1.getBoundsInParent().intersects(cloud5.getBoundsInParent())) {
                    String icon= getClass().getResource("/thegameover.png").toExternalForm();
                    Image imageB= new Image(icon);
                    obj1.setFill(new ImagePattern(imageB));
                    Pause();
                    cloud5.setOpacity(0.1);
                }


                // set conditions for scores
                else if (obj1.getBoundsInParent().intersects(obj2.getBoundsInParent())) {
                    score+=10;
                    Scores.setText(score+" ");
                }
                else if (obj1.getBoundsInParent().intersects(obj3.getBoundsInParent())) {
                    score+=10;
                    Scores.setText(score+" ");
                }
                else if (obj1.getBoundsInParent().intersects(obj4.getBoundsInParent())) {
                    score+=10;
                    Scores.setText(score+" ");
                }
                else if (obj1.getBoundsInParent().intersects(obj5.getBoundsInParent())) {
                    score+=10;
                    Scores.setText(score+" ");
                }
            }
        });
        return Scores;
    }
    public static void main(String[] args) {launch();
    }
}