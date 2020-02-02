/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guitar13;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javax.swing.JFileChooser;


/**
 *
 * @author Neil
 */
public class G13Controller implements Initializable {
    
    // Temporary buffer objects / variables
    @FXML    
    private ScatterChart<?, ?> targetChart;
    // - - - - -
    
    public String filePathOne = "";
    
    @FXML
    private CategoryAxis x;

    @FXML
    private NumberAxis y;
    
    @FXML
    private ScatterChart<?, ?> tab1Chart;
    @FXML
    private ScatterChart<?, ?> tab2Chart;
    @FXML
    private AnchorPane tabSelect;
    @FXML
    private AnchorPane tabSelect1;
    @FXML
    private AnchorPane tabSelect11;
    @FXML
    private Button loadDataButton;
    @FXML
    private NumberAxis y1;
    @FXML
    private CategoryAxis x1;
    @FXML
    private ChoiceBox<String> trackOneStart;
    @FXML
    private ChoiceBox<String> trackTwoStart;
    @FXML
    private ChoiceBox<String> trackOneEnd;
    @FXML
    private ChoiceBox<String> trackTwoEnd;
    @FXML
    private ImageView circleOfFifths;
    @FXML
    private Button testButton0;
    @FXML
    private Button testButton1;
    @FXML
    private Button testButton2;
    @FXML
    private MenuBar menuBar;
    @FXML
    private Label key0;
    @FXML
    private Label key1;
    @FXML
    private Label key2;
    @FXML
    private Label key3;
    @FXML
    private Label key4;
    @FXML
    private Label key5;
    @FXML
    private Label key6;
    @FXML
    private Label key7;
    @FXML
    private Label key8;
    @FXML
    private Label key9;
    @FXML
    private Label key10;
    @FXML
    private Label key11;
    @FXML
    private ChoiceBox<String> keyDropDown;
    
    void e36700(ActionEvent event) {
        //
    }
    
    private Label label;
    
    @FXML
    private Label topTabLabel;
    

    // Opens FileChooser window
    @FXML
    void fileButton(ActionEvent event) throws Exception {
        
        FileChooser fileChooser = new FileChooser();
        File selectedFile = fileChooser.showOpenDialog(null);

        if (selectedFile != null) {
            topTabLabel.setText(selectedFile.getName());
            //System.out.println(selectedFile.getAbsolutePath());
            filePathOne = selectedFile.getAbsolutePath();
        } 
    }
    
    
   

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        populateKeyDropDown();
    } // end of init
    
    
    
    @FXML
    public void loadData(){
        try {
            loadData2();
            populateDropDownsOne();
        } catch (Exception e) {
            System.out.println(e.toString());
            //
        }
    } // End of loadData()
    
    public void loadData2() throws Exception {
        
        G13.Beats.barStarts.clear();
        
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
        
        //G13.getIntro();
        G13.getIntro(filePathOne);
        System.out.println(filePathOne);
        targetChart.getData().clear();
        int blank = 20;
        //int length = 38; //Stave length
        int length = G13.beats.size();
        int counter = 0;
        
        int buffer;
        
        for (int i=0; i<length; i++){
            buffer = G13.beats.get(i).getNote();
            buffer %= 12;
            if ( G13.beats.get(i).isNote() && buffer == 0 ) {
                set0.getData().add(new XYChart.Data(Integer.toString(i), buffer));
                set0.getData().add(new XYChart.Data(Integer.toString(i), 12));
                //System.out.println(buffer);
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
                //System.out.println(buffer);
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
                //System.out.println(buffer);
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
                //System.out.println(buffer);
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
                //System.out.println(buffer);
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
                //System.out.println(buffer);
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
                //System.out.println(buffer);
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
        
        targetChart.getData().addAll(set0);
        targetChart.getData().addAll(set1);
        targetChart.getData().addAll(set2);
        targetChart.getData().addAll(set3);
        targetChart.getData().addAll(set4);
        targetChart.getData().addAll(set5);
        targetChart.getData().addAll(set6);
        targetChart.getData().addAll(set7);
        targetChart.getData().addAll(set8);
        targetChart.getData().addAll(set9);
        targetChart.getData().addAll(set10);
        targetChart.getData().addAll(set11);
        //set1.getNode().getStyleClass().add("series-set1");
        keyPercent();
        
    }

    @FXML
    private void loadDataTest0(ActionEvent event) {
        targetChart = tab1Chart;
        filePathOne = TestTab.get(0);
        System.out.println(TestTab.get(0));
        System.out.println(filePathOne);
    }

    @FXML
    private void loadDataTest1(ActionEvent event) {
        targetChart = tab2Chart;
        filePathOne = TestTab.get(1);
        System.out.println(TestTab.get(1));
        System.out.println(filePathOne);
    }

    @FXML
    private void loadDataTest2(ActionEvent event) {
        targetChart = tab1Chart;
        filePathOne = TestTab.get(2);
        System.out.println(TestTab.get(2));
        System.out.println(filePathOne);
    }
    
    
    public void populateDropDownsOne(){
        
        trackOneStart.getItems().clear();
        trackOneEnd.getItems().clear();
        
        String barCount = Integer.toString(G13.Beats.barStarts.size());
        
        for (int i=0; i<G13.Beats.barStarts.size(); i++){
            String item = Integer.toString(i+1);
            trackOneStart.getItems().add(item);
            trackOneEnd.getItems().add(item);
        }
        
        trackOneStart.setValue("1");
        trackOneEnd.setValue(barCount);
        //trackTwoStart;
        //trackTwoEnd;
    }
    
    public void populateKeyDropDown(){        
        for (int i=0; i<12; i++){
            keyDropDown.getItems().add(KeyDropDown.getMaj(i));
        }
        for (int i=0; i<12; i++){
            keyDropDown.getItems().add(KeyDropDown.getMin(i));
        }
    }
    
    // Works out how many notes "hit" in each key, and populates each Label with the percentage
    public void keyPercent(){
        int[] totalNoteChordCount = new int[12];
        int totalNotesInBeats = 0;
        int[] keyHitCount = new int[12];
        Label[] keyLabels = {key0, key1, key2, key3, key4, key5, key6, key7, key8, key9, key10, key11};
        
        for(int i=0; i<12; i++){
            totalNoteChordCount[i] += G13.Beats.noteCounter[i];
            totalNoteChordCount[i] += G13.Beats.chordCounter[i];
            totalNotesInBeats += totalNoteChordCount[i];
        }
        System.out.println("Note count array: " + Arrays.toString(totalNoteChordCount));
        System.out.println("Total notes: " + Integer.toString(totalNotesInBeats));
        
        int[] shiftedNotes = totalNoteChordCount;
        boolean[] keyPattern = {true, false, true, false, true, true, false, true, false, true, false, true};
        
        // i loop goes through each different key
        for (int i=0; i<12; i++){
            // j loop goes through each boolean in that key pattern
            for (int j=0; j<12; j++){
                if(keyPattern[j] == true){
                    keyHitCount[i] += shiftedNotes[j];
                }
            }            
            shiftedNotes = shiftedHitCount(shiftedNotes);
        }
                
        for (int k=0; k<12; k++){
            double percentage = (keyHitCount[k]*100)/totalNotesInBeats;
            int concatPercent = (int)percentage;
            keyLabels[k].setText(concatPercent + " %");
            if (percentage > 80){
                keyLabels[k].setTextFill(Color.web("#e36700"));
                keyLabels[k].setStyle("-fx-font-weight: bold");
            } else if (percentage > 50) {
                keyLabels[k].setTextFill(Color.web("#6493bc"));
                keyLabels[k].setStyle("-fx-font-weight: regular");
            } else {
                keyLabels[k].setTextFill(Color.web("#44739c"));
                keyLabels[k].setStyle("-fx-font-weight: regular");
            }
        }
    }
    
    //Shift every value down one index
    public int[] shiftedHitCount(int[] input){
        int[] output = new int[12];
        output[11] = input[0];
        for(int i=0; i<11; i++){
            output[i] = input[i+1];
        }
        return output;
    }
    
    
} // end of controller


   
    
    