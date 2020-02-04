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
import javafx.beans.value.*;
import javafx.event.EventHandler; 
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
    private ScatterChart<?, ?> targetChart;
    
    byte keyAsByte = 0;
    
    byte currentTrack = 0;
    
    ChoiceBox[] startCBs = new ChoiceBox[2];
    ChoiceBox[] endCBs = new ChoiceBox[2];
    
    int startMemory;
    int endMemory;
    
    String clickedButtonName = "";
    
    boolean stopItNow = false;
    
    // - - - - -
    
    public String[] filePath = new String[2];
    
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
    @FXML
    private Button topTabButton;
    @FXML
    private Button bottomTabButton;
    @FXML
    private Label bottomTabLabel;
    
    void e36700(ActionEvent event) {
        //
    }

    
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
            filePath[currentTrack] = selectedFile.getAbsolutePath();
        } 
    }
    
    
   

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        populateKeyDropDown();
        startCBs[0] = trackOneStart;
        startCBs[1] = trackTwoStart;
        endCBs[0] = trackOneEnd;
        endCBs[1] = trackTwoEnd;
        
        for (ChoiceBox box : startCBs){
            box.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
                @Override
                public void changed(ObservableValue<? extends Number> ov, Number t, Number t1) {
                    if(box == startCBs[0]){
                        currentTrack = 0;
                    } else {
                        currentTrack = 1;
                    }
                    startMemory = t1.intValue();
                    if (clickedButtonName.equals("")){
                        System.out.println("Was empty, now start");
                        clickedButtonName = ButtonNames.startEnd;
                    }
                    stopItNow = true;
                    if (clickedButtonName.equals(ButtonNames.startEnd)){
                        loadData();
                    }
                    stopItNow = true;
                    
                    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            });
        }
        
        for (ChoiceBox box : endCBs){
            box.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
                @Override
                public void changed(ObservableValue<? extends Number> ov, Number t, Number t1) {
                    if(box == endCBs[0]){
                        currentTrack = 0;
                    } else {
                        currentTrack = 1;
                    }
                    endMemory = t1.intValue();
                    if (clickedButtonName.equals("")){
                        System.out.println("Was empty, now end");
                        clickedButtonName = ButtonNames.startEnd;
                    }
                    stopItNow = true;
                    if (clickedButtonName.equals(ButtonNames.startEnd)){
                        loadData();
                    }
                    stopItNow = true;
                    
                    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            });
        }
    } // end of init
    
    
    
    @FXML
    public void loadData(){
        try {
            loadData2();
        } catch (Exception e) {
            System.out.println(e.toString());
            //
        }
    } // End of loadData()
    
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
        
        //G13.getIntro();
        if (ButtonNames.fileOpen.equals(clickedButtonName)){
            G13.Beats.barStarts.clear();
            G13.getIntro(filePath[currentTrack]);
            populateDropDownsOne();
            System.out.println(" - - Populated drop downs in loadData 2. - -");
        }

        
        //System.out.println(filePath[currentTrack]);
        targetChart.getData().clear();
        int blank = 20; // This is for when we don't have a note (silence) and need to pad the dataset out with blocks, but up top / off screen
        //int length = 38; //Stave length
        //int length = G13.beats.size();
        //int counter = 0;
        
        
        // When to start the graph from
        int start = 0;
        System.out.println("StartMemory: " + Integer.toString(startMemory));
        if (clickedButtonName.equals(ButtonNames.fileOpen)){
            start = G13.Beats.barStarts.get(0);
        } else {
            start = G13.Beats.barStarts.get(startMemory);
        }
        System.out.println("Start: " + Integer.toString(start));
        
        /*
        if (startMemory == 0){
            start = 0;
        } else if (ButtonNames.startEnd.equals(clickedButtonName)){
            start = G13.Beats.barStarts.get(startMemory);
        } else {
            boolean flag = false;
            String bufferString = startCBs[currentTrack].getValue().toString();
            start = Integer.parseInt(bufferString);
            if (start == 1){
                flag = true;
            } else {
                int tempInt = start-1;
                //System.out.println("barStarts: " + Integer.toString(G13.Beats.barStarts.get(tempInt)));
                start = G13.Beats.barStarts.get(tempInt);
            }
            if (flag){
                start = 0;
            }
        }
        */
        
        //startMemory = start;
        //System.out.println("Start is " + Integer.toString(start));
        
        // When to end the graph.
        int end;
        System.out.println("EndMemory: " + Integer.toString(endMemory));
        int choiceBoxMax = endCBs[currentTrack].getItems().size()-1;
        System.out.println("choiceBoxMax: " + Integer.toString(choiceBoxMax));
        if (endMemory == choiceBoxMax || clickedButtonName.equals(ButtonNames.fileOpen)){
            end = G13.beats.size();
        } else {
            end = G13.Beats.barStarts.get(endMemory+1);
        }
        System.out.println("End: " + Integer.toString(end));
        
        
        
        /*
        int end;
        if (ButtonNames.startEnd.equals(clickedButtonName)){
            end = G13.Beats.barStarts.get(endMemory);
        } else {
            int indexOfSelected = endCBs[currentTrack].getSelectionModel().getSelectedIndex();
            System.out.println(" - - - - - - - - - - - Break point 01");
            String bufferString = endCBs[currentTrack].getValue().toString();// problem
            System.out.println(" - - - - - - - - - - - Break point 02");
            end = Integer.parseInt(bufferString);

            int indexOfLargest;
            if (endCBs[currentTrack].getItems().size() > 1){
                indexOfLargest = endCBs[currentTrack].getItems().size()-1; 
            } else {
                indexOfLargest = 0;
            }

            if (indexOfSelected == indexOfLargest){
                end = G13.beats.size();
            } else {
                end = G13.Beats.barStarts.get(end-1);
            }

            if (ButtonNames.startEnd.equals(clickedButtonName)){
                //end = G13.beats.size();
            }
        }
        endMemory = end;
        */
        
        //System.out.println("End is " + Integer.toString(end));
        
        int buffer;
        System.out.println("Start/end used: " + Integer.toString(start) + " / " + Integer.toString(end));
        
        for (int i=start; i<end; i++){
            buffer = G13.beats.get(i).getNote();
            buffer %= 12;
            if ( G13.beats.get(i).isNote() && buffer == 0 ) {
                set0.getData().add(new XYChart.Data(Integer.toString(i-start), buffer));
                set0.getData().add(new XYChart.Data(Integer.toString(i-start), 12));
                //System.out.println(buffer);
            } else {
                set0.getData().add(new XYChart.Data(Integer.toString(i-start), blank));
            }
            
        }
        
        
        //counter++;
        for (int i=start; i<end; i++){
            buffer = G13.beats.get(i).getNote();
            buffer %= 12;
            if (G13.beats.get(i).isNote() && G13.beats.get(i).getNote() == 2){
                set1.getData().add(new XYChart.Data(Integer.toString(i-start), buffer));
                //System.out.println(buffer);
            } else {
                set1.getData().add(new XYChart.Data(Integer.toString(i-start), blank));
            }

        }
        
        //counter++;
        for (int i=start; i<end; i++){
            buffer = G13.beats.get(i).getNote();
            buffer %= 12;
            if (G13.beats.get(i).isNote() && G13.beats.get(i).getNote() == 3){
                set2.getData().add(new XYChart.Data(Integer.toString(i-start), buffer));
                //System.out.println(buffer);
            } else {
                set2.getData().add(new XYChart.Data(Integer.toString(i-start), blank));
            }

        }
        
        //counter++;
        for (int i=start; i<end; i++){
            buffer = G13.beats.get(i).getNote();
            buffer %= 12;
            if (G13.beats.get(i).isNote() && G13.beats.get(i).getNote() == 5){
                set3.getData().add(new XYChart.Data(Integer.toString(i-start), buffer));
                //System.out.println(buffer);
            } else {
                set3.getData().add(new XYChart.Data(Integer.toString(i-start), blank));
            }
        }
        
        //counter++;
        for (int i=start; i<end; i++){
            buffer = G13.beats.get(i).getNote();
            buffer %= 12;
            if (G13.beats.get(i).isNote() && G13.beats.get(i).getNote() == 7){
                set4.getData().add(new XYChart.Data(Integer.toString(i-start), buffer));
                //System.out.println(buffer);
            } else {
                set4.getData().add(new XYChart.Data(Integer.toString(i-start), blank));
            }
        }
        
        //counter++;
        for (int i=start; i<end; i++){
            buffer = G13.beats.get(i).getNote();
            buffer %= 12;
            if (G13.beats.get(i).isNote() && G13.beats.get(i).getNote() == 8){
                set5.getData().add(new XYChart.Data(Integer.toString(i-start), buffer));
                //System.out.println(buffer);
            } else {
                set5.getData().add(new XYChart.Data(Integer.toString(i-start), blank));
            }
        }
        
        //counter++;
        for (int i=start; i<end; i++){
            buffer = G13.beats.get(i).getNote();
            buffer %= 12;
            if (G13.beats.get(i).isNote() && G13.beats.get(i).getNote() == 10){
                set6.getData().add(new XYChart.Data(Integer.toString(i-start), buffer));
                //System.out.println(buffer);
            } else {
                set6.getData().add(new XYChart.Data(Integer.toString(i-start), blank));
            }
        }
        
        //counter++;
        for (int i=start; i<end; i++){
            buffer = G13.beats.get(i).getNote();
            buffer %= 12;
            if (G13.beats.get(i).isNote() &&
                    ( (buffer == 1) ||
                    (buffer == 4) ||
                    (buffer == 6) ||
                    (buffer == 9) ||
                    (buffer == 11) )){
                set7.getData().add(new XYChart.Data(Integer.toString(i-start), buffer));
            } else {
                set7.getData().add(new XYChart.Data(Integer.toString(i-start), blank));
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
        String test = Arrays.toString(G13.Beats.barStarts.toArray());
        System.out.println("Bar Starts: " + test);
        clickedButtonName = "";
    }

    @FXML
    private void loadDataTest0(ActionEvent event) {
        clickedButtonName = ButtonNames.fileOpen;
        currentTrack = 0;
        targetChart = tab1Chart;
        filePath[currentTrack] = TestTab.get(0);
        //System.out.println(TestTab.get(0));
    }

    @FXML
    private void loadDataTest1(ActionEvent event) {
        clickedButtonName = ButtonNames.fileOpen;
        currentTrack = 1;
        targetChart = tab2Chart;
        filePath[currentTrack] = TestTab.get(1);
        //System.out.println(TestTab.get(1));
    }

    @FXML
    private void loadDataTest2(ActionEvent event) {
        clickedButtonName = ButtonNames.fileOpen;
        currentTrack = 0;
        targetChart = tab1Chart;
        filePath[currentTrack] = TestTab.get(2);
        //System.out.println(TestTab.get(2));
    }
    
    
    public void populateDropDownsOne(){
        stopItNow = true;
        System.out.println(" - - populateDropDownsOne - -");
        
        ChoiceBox<String> bufferStart;
        ChoiceBox<String> bufferEnd;
        
        if (currentTrack == 0){
            bufferStart = trackOneStart;
            bufferEnd = trackOneEnd;
        } else {
            bufferStart = trackTwoStart;
            bufferEnd = trackTwoEnd;
        }
        
        bufferStart.getItems().clear();
        bufferEnd.getItems().clear();
        
        String barCount = Integer.toString(G13.Beats.barStarts.size());
        
        for (int i=0; i<G13.Beats.barStarts.size(); i++){
            String item = Integer.toString(i+1);
            bufferStart.getItems().add(item);
            bufferEnd.getItems().add(item);
        }
        
        bufferStart.setValue("1");
        bufferEnd.setValue(barCount);
    }
    
    public void populateKeyDropDown(){        
        for (int i=0; i<24; i++){
            keyDropDown.getItems().add(KeyDropDown.getKeys(i));
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
        //System.out.println("Note count array: " + Arrays.toString(totalNoteChordCount));
        //System.out.println("Total notes: " + Integer.toString(totalNotesInBeats));
        
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
            keyLabels[k].setStyle("<font-weight>: regular");
            keyLabels[k].setTextFill(Color.web("#44739c"));
            if (percentage > 80){
                keyLabels[k].setTextFill(Color.web("#e36700"));
                keyLabels[k].setStyle("-fx-font-weight: bold");
            } else if (percentage > 50) {
                keyLabels[k].setTextFill(Color.web("#6493bc"));
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

    @FXML
    private void topFileChooser(ActionEvent event) {
        currentTrack = 0;
        targetChart = tab1Chart;
        fileChooserMaster();
    }

    @FXML
    private void bottomFileChooser(ActionEvent event) {
        currentTrack = 1;
        targetChart = tab2Chart;
        fileChooserMaster();
    }
    
    private void fileChooserMaster(){
        System.out.println(" - - fileChooserMaster() - -");
        clickedButtonName = ButtonNames.fileOpen;
        FileChooser fileChooser = new FileChooser();
        File selectedFile = fileChooser.showOpenDialog(null);
        Label label;
        
        if (currentTrack == 0){
            label = topTabLabel;
        } else {
            label = bottomTabLabel;
        }

        if (selectedFile != null) {
            label.setText(selectedFile.getName());
            //System.out.println(selectedFile.getAbsolutePath());
            filePath[currentTrack] = selectedFile.getAbsolutePath();
        }
        
        loadData();
    }
    
    // Listeners - - - - - -
    

    
} // end of controller


   
    
    