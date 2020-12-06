package Lab5_JSON;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class WidgetTest {
    public static void main(String[] args) {
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader("JsonFile/widget.json")){
            Object obj = jsonParser.parse(reader);

            JSONObject objJson = (JSONObject)obj;

            JSONObject objWidget = (JSONObject)objJson.get("widget");

            System.out.println("widget :");

            String debug = (String)objWidget.get("debug");
            System.out.println("\tdebug : " + debug);
            System.out.println("\twindow : ");
            JSONObject objWindow = (JSONObject)objWidget.get("window");

            String windowTitle = (String)objWindow.get("title");
            String windowName = (String)objWindow.get("name");
            int windowWidth = Integer.parseInt((String)objWindow.get("width")) ;
            String windowHeight = (String)objWindow.get("height");

            System.out.println("\t\ttitle : " + windowTitle);
            System.out.println("\t\tname : " + windowName);
            System.out.println("\t\twidth : " + windowWidth);
            System.out.println("\t\theight : " + windowHeight);

            System.out.println("\timage : ");

            JSONObject objImage = (JSONObject)objWidget.get("image");
            String imageSrc = (String)objImage.get("src");
            String imageName = (String)objImage.get("name");
            String imageHOffSet = (String)objImage.get("hOffset");
            String imageVOffSet = (String)objImage.get("vOffset");
            String imageAlignment = (String)objImage.get("alignment");

            System.out.println("\t\tsrc : " + imageSrc);
            System.out.println("\t\tname : " + imageName);
            System.out.println("\t\thOffset : " + imageHOffSet);
            System.out.println("\t\tvOffset : " + imageVOffSet);
            System.out.println("\t\talignment : " + imageAlignment);

            JSONObject objText = (JSONObject)objWidget.get("text");
            System.out.println("\ttext : ");
            String dataText = (String)objText.get("data");
            String sizeText = (String)objText.get("size");
            String styleText = (String)objText.get("style");
            String nameText = (String)objText.get("name");
            String hOffsetText = (String)objText.get("hOffset");
            String vOffsetText = (String)objText.get("vOffset");
            String alignmentText = (String)objText.get("alignment");
            String onMouseUpText = (String)objText.get("onMouseUp");

            System.out.println("\t\tdata : " + dataText);
            System.out.println("\t\tsize : " + sizeText);
            System.out.println("\t\tstyle : " + styleText);
            System.out.println("\t\tname : " + nameText);
            System.out.println("\t\thOffset : " + hOffsetText);
            System.out.println("\t\tvOffset : " + vOffsetText);
            System.out.println("\t\talignment : " + alignmentText);
            System.out.println("\t\tonMouseUp : " + onMouseUpText);
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        catch (ParseException e){
            e.printStackTrace();
        }
    }

}