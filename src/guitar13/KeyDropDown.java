package guitar13;

/**
 *
 * @author Ning
 */
public class KeyDropDown {
    
    private static String[] majKeys = {
        "E",
        "F",
        "F#",
        "G",
        "Ab",
        "A",
        "Bb",
        "B",
        "C",
        "Dd",
        "D",
        "Eb",
    };
    
    private static String[] minKeys = {
        "C# min",
        "D min",
        "Eb min",
        "E min",
        "Fm min",
        "F# min",
        "G min",
        "G# min",
        "A min",
        "Bb min",
        "B min",
        "C min",
    };
    
    public String getMaj(int i){
        return majKeys[i];
    }
    
    public String getMin(int i){
        return majKeys[i];
    }
}
