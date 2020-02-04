package guitar13;

import java.nio.file.Paths;

/**
 *
 * @author Ning
 */
public class CurrentProjectDirectory {
    
    private String filePath = Paths.get(".").toAbsolutePath().normalize().toString() + "\\src\\";
    
    public String source(){
        return filePath;
    }
    
    public String resources(){
        return filePath + "Resources\\";
    }
    
    
}
