package br.inatel.cdg.algebra.scene;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import br.inatel.cdg.algebra.reta.Reta;
import br.inatel.cdg.algebra.reta.Ponto;

public class ScenePrincipal {

    private Button btnCalcCoefLinear, btnCalcCoefAngular; //Button representa botoes
    private Label label1,label2, label3, label4; //Label representam rótulos
    private TextField txtField1, txtField2, txtField3, txtField4, txtAngular, txtLinear; //TextField Representam áreas de texto

    public void criaScenePrincipal(Stage stage){

        //Criando os labels para os pontos e os campos de texto para os dados
        label1 = new Label("  Entre com o P1.X:  ");
        txtField1 = new TextField();

        label2 = new Label("  Entre com o P1.Y:  ");
        txtField2 = new TextField();

        label3 = new Label("  Entre com o P2.X:  ");
        txtField3 = new TextField();

        label4 = new Label("  Entre com o P2.Y:  ");
        txtField4 = new TextField();

        //HBox é usado para agrupar elementos horizontalmente
        HBox hbP1 = new HBox(label1, txtField1, label3, txtField3);//Agrupando os elementos de P1

        HBox hbP2 = new HBox(label2, txtField2, label4, txtField4);//Agrupando os elementos de P2

        VBox vboxEntrada = new VBox(hbP1,hbP2);

        txtAngular = new TextField();
        txtAngular.setEditable(false);
        txtAngular.setText("Coeficiente Angular aqui ");

        txtLinear = new TextField();
        txtLinear.setEditable(false);
        txtLinear.setText("Coeficiente Linear aqui ");

        HBox hbResultado = new HBox(txtAngular,txtLinear);

        btnCalcCoefAngular = new Button("Calcular Coeficiente Angular");
        btnCalcCoefAngular.setOnAction(event ->{
            Reta reta = construirReta();
            txtAngular.setText("Coef Angular: " + reta.coeficienteAngular());
        });

        btnCalcCoefLinear = new Button("Calcular Coeficiente Linear");
        btnCalcCoefLinear.setOnAction(event ->{
            Reta reta = construirReta();
            txtLinear.setText("Coef Linear: " + reta.coeficienteLinear());
        });

        HBox hbBnt = new HBox(btnCalcCoefAngular, btnCalcCoefLinear);

        VBox layoutFinal = new VBox(vboxEntrada, hbBnt, hbResultado);

        //Criamos a Scene
        Scene scene = new Scene(layoutFinal, 520 , 150);

        stage.setTitle("Software Para Calculos de Álgebra Linear");
        stage.setScene(scene);
        stage.show();

    }
    private Reta construirReta(){

        Ponto p1 = new Ponto(Double.parseDouble(txtField1.getText()),
                Double.parseDouble(txtField2.getText()));

        Ponto p2 = new Ponto(Double.parseDouble(txtField3.getText()),
                Double.parseDouble(txtField4.getText()));

        Reta reta = new Reta(p1,p2);
        return reta;
    }
}
