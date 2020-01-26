/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guitar13;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.stream.Stream;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


/**
 *
 * @author Neil
 */
public class G13Controller implements Initializable {
        
    
    
    
    @FXML
    private CategoryAxis x;

    @FXML
    private NumberAxis y;
    
    @FXML
    private ScatterChart<?, ?> tab1Chart;
    


    @FXML
    void e36700(ActionEvent event) {
        
    }
    
    @FXML
    private Label label;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
   

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    } // end of init
    
    
    
    public void loadData(){

        try {
            loadData2();
        } catch (Exception e) {
            //
        }

    }
    
    public void loadData2() throws Exception {
        
        XYChart.Series set0 = new XYChart.Series<>();
        XYChart.Series set1 = new XYChart.Series<>();
        XYChart.Series set2 = new XYChart.Series<>();
        XYChart.Series set3 = new XYChart.Series<>();
        XYChart.Series set4 = new XYChart.Series<>();
        XYChart.Series set5 = new XYChart.Series<>();
        XYChart.Series set6 = new XYChart.Series<>();
        XYChart.Series set7 = new XYChart.Series<>();
        XYChart.Series set8 = new XYChart.Series<>();
        XYChart.Series set9 = new XYChart.Series<>();
        XYChart.Series set10 = new XYChart.Series<>();
        XYChart.Series set11 = new XYChart.Series<>();
        
        G13.getIntro();
        tab1Chart.getData().clear();
        int blank = 20;
        int length = 38; //Stave length
        int counter = 0;
        
        int buffer;
        
        for (int i=0; i<length; i++){
            buffer = G13.beats.get(i).getNote();
            buffer %= 12;
            if ( G13.beats.get(i).isNote() && buffer == 0 ) {
                set0.getData().add(new XYChart.Data(Integer.toString(i), buffer));
                set0.getData().add(new XYChart.Data(Integer.toString(i), 12));
                System.out.println(buffer);
            } else {
                set0.getData().add(new XYChart.Data(Integer.toString(i), blank));
            }
            
        }
        
        
        counter++;
        for (int i=0; i<length; i++){
            buffer = G13.beats.get(i).getNote();
            buffer %= 12;
            if (G13.beats.get(i).isNote() && G13.beats.get(i).getNote() == 2){
                set1.getData().add(new XYChart.Data(Integer.toString(i), buffer));
                System.out.println(buffer);
            } else {
                set1.getData().add(new XYChart.Data(Integer.toString(i), blank));
            }

        }
        
        counter++;
        for (int i=0; i<length; i++){
            buffer = G13.beats.get(i).getNote();
            buffer %= 12;
            if (G13.beats.get(i).isNote() && G13.beats.get(i).getNote() == 3){
                set2.getData().add(new XYChart.Data(Integer.toString(i), buffer));
                System.out.println(buffer);
            } else {
                set2.getData().add(new XYChart.Data(Integer.toString(i), blank));
            }

        }
        
        counter++;
        for (int i=0; i<length; i++){
            buffer = G13.beats.get(i).getNote();
            buffer %= 12;
            if (G13.beats.get(i).isNote() && G13.beats.get(i).getNote() == 5){
                set3.getData().add(new XYChart.Data(Integer.toString(i), buffer));
                System.out.println(buffer);
            } else {
                set3.getData().add(new XYChart.Data(Integer.toString(i), blank));
            }
        }
        
        counter++;
        for (int i=0; i<length; i++){
            buffer = G13.beats.get(i).getNote();
            buffer %= 12;
            if (G13.beats.get(i).isNote() && G13.beats.get(i).getNote() == 7){
                set4.getData().add(new XYChart.Data(Integer.toString(i), buffer));
                System.out.println(buffer);
            } else {
                set4.getData().add(new XYChart.Data(Integer.toString(i), blank));
            }
        }
        
        counter++;
        for (int i=0; i<length; i++){
            buffer = G13.beats.get(i).getNote();
            buffer %= 12;
            if (G13.beats.get(i).isNote() && G13.beats.get(i).getNote() == 8){
                set5.getData().add(new XYChart.Data(Integer.toString(i), buffer));
                System.out.println(buffer);
            } else {
                set5.getData().add(new XYChart.Data(Integer.toString(i), blank));
            }
        }
        
        counter++;
        for (int i=0; i<length; i++){
            buffer = G13.beats.get(i).getNote();
            buffer %= 12;
            if (G13.beats.get(i).isNote() && G13.beats.get(i).getNote() == 10){
                set6.getData().add(new XYChart.Data(Integer.toString(i), buffer));
                System.out.println(buffer);
            } else {
                set6.getData().add(new XYChart.Data(Integer.toString(i), blank));
            }
        }
        
        counter++;
        for (int i=0; i<length; i++){
            buffer = G13.beats.get(i).getNote();
            buffer %= 12;
            if (G13.beats.get(i).isNote() &&
                    ( (buffer == 1) ||
                    (buffer == 4) ||
                    (buffer == 6) ||
                    (buffer == 9) ||
                    (buffer == 11) )){
                set7.getData().add(new XYChart.Data(Integer.toString(i), buffer));
            } else {
                set7.getData().add(new XYChart.Data(Integer.toString(i), blank));
            }
        }
        
        
        
            

        
        
        
        tab1Chart.getData().addAll(set0);
        tab1Chart.getData().addAll(set1);
        tab1Chart.getData().addAll(set2);
        tab1Chart.getData().addAll(set3);
        tab1Chart.getData().addAll(set4);
        tab1Chart.getData().addAll(set5);
        tab1Chart.getData().addAll(set6);
        tab1Chart.getData().addAll(set7);
        tab1Chart.getData().addAll(set8);
        tab1Chart.getData().addAll(set9);
        tab1Chart.getData().addAll(set10);
        tab1Chart.getData().addAll(set11);
        //set1.getNode().getStyleClass().add("series-set1");
        
    }
    
    
} // end of controller


   
    
    