
package Main;
import java.io.FileInputStream;
import java.io.FileReader; 
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.HashMap;
import org.json.simple.JSONObject; 
import org.json.simple.parser.*; 
import javax.swing.JFrame;
import org.json.simple.JSONArray;

/**
 *
 * @author shoccho
 */
public class Load_data extends JFrame {
    JSONObject data=null;
    
    public JSONObject loadE(){
        
        try{
            Object obj = new JSONParser().parse(new FileReader("data/dictionary.json")); 
            JSONObject jo = (JSONObject) obj; 
            data= jo;
        }
        catch (Exception e){
            System.out.print(e);
            data= null;
        }
        return data;
    }
    public HashMap<String, JSONObject> loadBA(){
        HashMap<String , JSONObject >ind;
        ind = new HashMap<String,JSONObject>();
         Charset charset = Charset.forName("UTF-8");
            try{
                Object obj; 
                obj = new JSONParser().parse(new InputStreamReader(new FileInputStream("data/BengaliDictionary.json"), charset) );
                JSONArray jo = (JSONArray) obj; 
                int length=jo.size();
                for(int i=0;i<length;i++){
                JSONObject pp= (JSONObject) jo.get(i);
                String key= (String) pp.get("en");
                ind.put(key, pp);
                }
        }
        catch (Exception e){
            System.out.print(e);    
        } 
        return ind;
    }  
}
