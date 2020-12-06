package Lab5_JSON;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadJSONTest {
    public static void main(String[] args) {
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader("JSON/employee.json")){
            Object obj = jsonParser.parse(reader);

            JSONArray employeeList = (JSONArray)obj;

            System.out.println(employeeList);

            employeeList.forEach(emp -> parseEmployeeObj((JSONObject)emp));

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

    private static void parseEmployeeObj(JSONObject employees){
        JSONObject employeeObj = (JSONObject)employees.get("employee");

        String firstName = (String)employeeObj.get("firstName");
        System.out.println(firstName);
        String lastName = (String)employeeObj.get("lastName");
        System.out.println(lastName);
        String website = (String)employeeObj.get("website");
        System.out.println(website);

    }
}