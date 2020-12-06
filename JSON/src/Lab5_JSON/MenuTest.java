package Lab5_JSON;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class MenuTest {
    public static void main(String[] args) {
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader("JsonFile/menu.json")){
            Object obj = jsonParser.parse(reader);

            JSONObject objJson = (JSONObject)obj;

            JSONObject objMenu = (JSONObject)objJson.get("menu");

            System.out.println("menu :");
            String id = (String)objMenu.get("id");
            System.out.println("\tid : " + id);

            String value = (String)objMenu.get("value");
            System.out.println("\tvalue : " + value);

            JSONObject objPopup = (JSONObject)objMenu.get("popup");
            JSONArray arrayMenuItem = (JSONArray)objPopup.get("menuitem");
            System.out.println("\tpopup : ");
            System.out.println("\t\tmenuitem :");

            arrayMenuItem.forEach(item -> parseItemObj((JSONObject)item));

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

    private static void parseItemObj(JSONObject items){

        String value = (String)items.get("value");
        String onclick = (String)items.get("onclick");
        System.out.println("\t\t\tvalue : " + value + " onclick : " + onclick);

    }
}
