package Project_102873_125511_120441_aed2_lp2_202324;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;

import static javafx.application.Application.launch;

public class PubManageAuthorApp extends Application{

        /**
        * Inicia a aplicação JavaFX, criando e exibindo a cena principal.
        *
        * @param primaryStage O palco principal da aplicação.
        */

        @Override
        public void start(Stage primaryStage) {
            // Criando a cena e exibindo-a
            Scene scene = new Scene(createAuthorGraph(), 600, 400);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Author Graph");
            primaryStage.show();
        }

        private Parent createAuthorGraph(){
            Pane root = new Pane();

            Author a1 = new Author("12", "Joao Castro Silva", "Rua Santo Antonio", new java.util.Date((short) 12, (short) 6, 1973), "  joaosilva@gmail.com  ", "10", "EXECX", 1, 1, "Joao Silva");
            Author a2 = new Author("27", "Jose Fernandes Tomas", "Praça dos Combatentes", new java.util.Date((short) 9, (short) 12, 1994), "  josefernandes@gmail.com  ", "20", "LAB33", 2, 1, "Jose Fernandes");
            Author a3 = new Author("35", "Diogo da Costa Cunha", "Avenida dos Naufragos", new java.util.Date((short) 3, (short) 3, 1985), "  diogocunha32@gmail.com  ", "30", "FL45", 3, 1, "Diogo Cunha");
            Author a4 = new Author("42", "Filipe Moreira Santos", "Rua das Pedrinhas ", new java.util.Date((short) 4, (short) 7, 1964), "  filipesantos2@gmail.com  ", "40", "AR14", 4, 1, "Filipe Santos");
            Author a5 = new Author("56", "Lucas Alberto Cardoso", "Praceta dos Pescadores do Ultramar", new java.util.Date((short) 30, (short) 5, 1980), "  lucasalberto@hotmail.com  ", "50", "JJUR", 5, 1, "Lucas Alberto");

            double level1Y = 50;
            double level2Y = 200;

            /*
            awg.addEdge(db.authors.get(1), db.authors.get(2), 1);
            awg.addEdge(db.authors.get(1), db.authors.get(3), 2);
            awg.addEdge(db.authors.get(1), db.authors.get(4), 1);
            awg.addEdge(db.authors.get(1), db.authors.get(5), 1);
            awg.addEdge(db.authors.get(2), db.authors.get(3), 2);
            awg.addEdge(db.authors.get(2), db.authors.get(4), 3);
            awg.addEdge(db.authors.get(2), db.authors.get(5), 2);
            awg.addEdge(db.authors.get(3), db.authors.get(4), 3);
            //awg.addEdge(db.authors.get(3), db.authors.get(5), 0);
            awg.addEdge(db.authors.get(4), db.authors.get(5), 1);
            */


            Label label1 = new Label(a1.getName());
            label1.setTextFill(Color.DARKBLUE);
            label1.setLayoutX(50);
            label1.setLayoutY(level1Y - 20);

            Label label2 = new Label(a2.getName());
            label2.setTextFill(Color.DARKBLUE);
            label2.setLayoutX(250);
            label2.setLayoutY(level1Y -50);

            Label label3 = new Label(a3.getName());
            label3.setTextFill(Color.DARKBLUE);
            label3.setLayoutX(450);
            label3.setLayoutY(level1Y - 20);

            Label label4 = new Label(a4.getName());
            label4.setTextFill(Color.DARKBLUE);
            label4.setLayoutX(50);
            label4.setLayoutY(level2Y - 20);

            Label label5 = new Label(a5.getName());
            label5.setTextFill(Color.DARKBLUE);
            label5.setLayoutX(250);
            label5.setLayoutY(level2Y - 20);

            root.getChildren().addAll(label1, label2, label3, label4, label5);

            Line one_two = new Line(100, level1Y, 300, level1Y - 30);
            Line one_three = new Line(100, level1Y, 500, level1Y);
            Line one_four = new Line(100, level1Y, 135, level2Y - 25);
            Line one_five = new Line(100, level1Y, 310, level2Y - 25);
            Line two_three = new Line(300, level1Y-30, 500, level1Y);
            Line two_four = new Line(300, level1Y-30, 135, level2Y - 25);
            Line two_five = new Line(300, level1Y-30, 310, level2Y - 25);
            Line three_four = new Line(500, level1Y, 135, level2Y - 25);
            Line four_five = new Line(135, level2Y - 25, 310, level2Y - 25);


            Label weight1to2 = new Label("1");
            weight1to2.setTextFill(Color.RED);
            weight1to2.setLayoutX((100 + 310) / 2);
            weight1to2.setLayoutY(level1Y - 40);

            Label weight1to3 = new Label("2");
            weight1to3.setTextFill(Color.RED);
            weight1to3.setLayoutX((100 + 510) / 2);
            weight1to3.setLayoutY((level1Y - 20));

            Label weight1to4 = new Label("1");
            weight1to4.setTextFill(Color.RED);
            weight1to4.setLayoutX((100 + 145) / 2);
            weight1to4.setLayoutY(level1Y + 30);

            Label weight1to5 = new Label("1");
            weight1to5.setTextFill(Color.RED);
            weight1to5.setLayoutX((100 + 320) / 2);
            weight1to5.setLayoutY((level1Y + level2Y - 20) / 2);

            Label weight2to3 = new Label("2");
            weight2to3.setTextFill(Color.RED);
            weight2to3.setLayoutX((100));
            weight2to3.setLayoutY((level1Y  + 40));

            Label weight2to4 = new Label("3");
            weight2to4.setTextFill(Color.RED);
            weight2to4.setLayoutX(175);
            weight2to4.setLayoutY((level1Y + level2Y ) / 2);

            Label weight2to5 = new Label("2");
            weight2to5.setTextFill(Color.RED);
            weight2to5.setLayoutX(300);
            weight2to5.setLayoutY((level1Y + level2Y - 45 ) / 2);

            Label weight3to4 = new Label("3");
            weight3to4.setTextFill(Color.RED);
            weight3to4.setLayoutX((500 + 145) / 2);
            weight3to4.setLayoutY(level2Y - 90);


            Label weight4to5 = new Label("1");
            weight4to5.setTextFill(Color.RED);
            weight4to5.setLayoutX((135 + 315) / 2);
            weight4to5.setLayoutY(level2Y- 15);


            root.getChildren().addAll(one_two,one_three,one_four,one_five,two_three,two_four,two_five,three_four,four_five, weight1to2, weight1to3, weight1to4, weight1to5, weight2to3, weight2to4, weight2to5, weight3to4, weight4to5);

            return root;
        }

        public static void main(String[] args) {
            launch(args);
        }
}
