package Project_102873_125511_120441_aed2_lp2_202324;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;

public class PubManageArticleApp extends Application {

    /**
     * Inicia a aplicação JavaFX, criando e exibindo a cena principal.
     *
     * @param primaryStage O palco principal da aplicação.
     */
    @Override
    public void start(Stage primaryStage) {
        // Criando a cena e exibindo-a
        Scene scene = new Scene(createArticleGraphPane(), 800, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Article Graph");
        primaryStage.show();
    }

    private Parent createArticleGraphPane() { //Criando um painel para conter os elementos da interface
            // Criando um painel para conter os elementos da interface
            Pane root = new Pane();

            // Criando artigos fictícios
            Article a1 = new Article(1, "Article 1");
            Article a2 = new Article(2, "Article 2");
            Article a3 = new Article(3, "Article 3");
            Article a4 = new Article(4, "Article 4");
            Article a5 = new Article(5, "Article 5");
            Article a6 = new Article(6, "Article 6");
            Article a7 = new Article(7, "Article 7");

            double level1Y = 50;
            double level2Y = 200;

            Label label1 = new Label(a1.getTitulo());
            label1.setTextFill(Color.DARKBLUE);
            label1.setLayoutX(50);
            label1.setLayoutY(level1Y - 20);

            Label label2 = new Label(a2.getTitulo());
            label2.setTextFill(Color.DARKBLUE);
            label2.setLayoutX(250);
            label2.setLayoutY(level1Y - 20);

            Label label3 = new Label(a3.getTitulo());
            label3.setTextFill(Color.DARKBLUE);
            label3.setLayoutX(450);
            label3.setLayoutY(level1Y - 20);

            Label label4 = new Label(a4.getTitulo());
            label4.setTextFill(Color.DARKBLUE);
            label4.setLayoutX(150);
            label4.setLayoutY(level2Y + 10);

            Label label5 = new Label(a5.getTitulo());
            label5.setTextFill(Color.DARKBLUE);
            label5.setLayoutX(350);
            label5.setLayoutY(level2Y + 10);

            Label label6 = new Label(a6.getTitulo());
            label6.setTextFill(Color.DARKBLUE);
            label6.setLayoutX(580);
            label6.setLayoutY(level1Y - 20);

            Label label7 = new Label(a7.getTitulo());
            label7.setTextFill(Color.DARKBLUE);
            label7.setLayoutX(555);
            label7.setLayoutY(level2Y + 10);

            // Criando linhas para representar as conexões entre os artigos

            Line line1to4 = new Line(100, level1Y, 175, level2Y);
            Line line2to1 = new Line(275, level1Y, 100, level1Y);
            Line line2to4 = new Line(275, level1Y, 175, level2Y);
            Line line2to5 = new Line(275, level1Y, 375, level2Y);
            Line line3to6 = new Line(475, level1Y, 600, level1Y);
            Line line5to3 = new Line(375, level2Y, 475, level1Y);
            Line line5to6 = new Line(375, level2Y, 600, level1Y);
            Line line4to5 = new Line(175, level2Y, 375, level2Y);
            Line line4to6 = new Line(175, level2Y, 600, level1Y);
            Line line7to1 = new Line(555, level2Y, 100, level1Y);
            Line line7to2 = new Line(555, level2Y, 275, level1Y);
            Line line7to6 = new Line(555, level2Y, 600, level1Y);


            // Adicionando pesos das conexões
            Label weight1to4 = new Label("16");
            weight1to4.setTextFill(Color.RED);
            weight1to4.setLayoutX((100 + 185) / 2);
            weight1to4.setLayoutY((level1Y + level2Y) / 2);

            Label weight2to1 = new Label("5");
            weight2to1.setTextFill(Color.RED);
            weight2to1.setLayoutX((100 + 285) / 2);
            weight2to1.setLayoutY(level1Y - 20);

            Label weight5to3 = new Label("8");
            weight5to3.setTextFill(Color.RED);
            weight5to3.setLayoutX((485 + 375) / 2);
            weight5to3.setLayoutY((level1Y + level2Y - 30) / 2);

            Label weight5to6 = new Label("5");
            weight5to6.setTextFill(Color.RED);
            weight5to6.setLayoutX((375 + 600) / 2);
            weight5to6.setLayoutY(level1Y + level2Y - 300 / 2);

            Label weight2to4 = new Label("3");
            weight2to4.setTextFill(Color.RED);
            weight2to4.setLayoutX((275 + 175) / 2);
            weight2to4.setLayoutY((level1Y + level2Y) / 2);

            Label weight2to5 = new Label("7");
            weight2to5.setTextFill(Color.RED);
            weight2to5.setLayoutX((275 + 375) / 2);
            weight2to5.setLayoutY((level1Y + level2Y - 20) / 2);

            Label weight3to6 = new Label("11");
            weight3to6.setTextFill(Color.RED);
            weight3to6.setLayoutX((475 + 610) / 2);
            weight3to6.setLayoutY((level1Y - 20));

            Label weight4to6 = new Label("2");
            weight4to6.setTextFill(Color.RED);
            weight4to6.setLayoutX((175 + 610) / 2);
            weight4to6.setLayoutY((level1Y + level2Y - 30) / 2);

            Label weight4to5 = new Label("7");
            weight4to5.setTextFill(Color.RED);
            weight4to5.setLayoutX((175 + 375) / 2);
            weight4to5.setLayoutY(level2Y + 10);


            Label weight7to1 = new Label("3");
            weight7to1.setTextFill(Color.RED);
            weight7to1.setLayoutX((555 + 110) / 2);
            weight7to1.setLayoutY((level1Y + level2Y) / 2);

            Label weight7to2 = new Label("6");
            weight7to2.setTextFill(Color.RED);
            weight7to2.setLayoutX((555 + 285) / 2);
            weight7to2.setLayoutY((level1Y + level2Y) / 2);

            Label weight7to6 = new Label("4");
            weight7to6.setTextFill(Color.RED);
            weight7to6.setLayoutX((555 + 600) / 2);
            weight7to6.setLayoutY((level1Y + level2Y) / 2);

            //Adicionando elementos ao painel
            root.getChildren().addAll(
                    label1, label2, label3, label4, label5,
                    line1to4,
                    line2to4, line2to5,
                    line4to5,
                    weight1to4, weight2to4,
                    weight2to5, weight4to5,
                    label6, label7, line2to1, line4to6, line3to6, line5to3, line7to1, line7to2, line7to6, line5to6, weight2to1, weight5to3, weight5to6, weight3to6, weight4to6, weight7to1, weight7to2, weight7to6
            );

            return root;

        }
        public static void main (String[]args){
        launch(args);
    }

    }

