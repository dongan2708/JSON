package Lab5_JSON;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.Iterator;

public class ReadGlossary {
    public static void main(String[] args) {
        JSONParser parser = new JSONParser();
        try{
            Object obj = parser.parse(new FileReader("JsonFile/glossary.json"));
            JSONObject jsonObject = (JSONObject)obj;
            JSONObject jsonObjGlossary = (JSONObject)jsonObject.get("glossary");
            String GlossaryTitle = (String)jsonObjGlossary.get("title");
            JSONObject jsonObjGlossDiv = (JSONObject)jsonObjGlossary.get("GlossDiv");
            String GlossDivTitle = (String)jsonObjGlossDiv.get("title");
            JSONObject jsonObjGlossList = (JSONObject)jsonObjGlossDiv.get("GlossList");
            JSONObject jsonObjGlossEntry = (JSONObject)jsonObjGlossList.get("GlossEntry");
            String GlossSee = (String)jsonObjGlossEntry.get("GlossSee");
            String ID = (String)jsonObjGlossEntry.get("ID");
            String SortAs = (String)jsonObjGlossEntry.get("SortAs");
            String GlossTerm = (String)jsonObjGlossEntry.get("GlossTerm");
            String Acronym = (String)jsonObjGlossEntry.get("Acronym");
            String Abbrev = (String)jsonObjGlossEntry.get("Abbrev");
            JSONObject jsonObjGlossDef = (JSONObject)jsonObjGlossEntry.get("GlossDef");
            String para = (String)jsonObjGlossDef.get("para");
            JSONArray GlossSeeAlso = (JSONArray)jsonObjGlossDef.get("GlossSeeAlso");
            Iterator iterator = GlossSeeAlso.iterator();
            System.out.println("Here is JSON File :");
            System.out.println("Glossary : ");
            System.out.println("Glossary Title : " + GlossaryTitle);
            System.out.println("GlossDiv :");
            System.out.println("\tGlossDiv Title : " + GlossDivTitle);
            System.out.println("\tGlossList :");
            System.out.println("\t\tGlossEntry :");
            System.out.println("\t\t\tID : " + ID);
            System.out.println("\t\t\tSortAs : " + SortAs);
            System.out.println("\t\t\tGlossTerm : " + GlossTerm);
            System.out.println("\t\t\tAcronym : " + Acronym);
            System.out.println("\t\t\tAbbrev : " + Abbrev);
            System.out.println("\t\t\tGlossDef : ");
            System.out.println("\t\t\t\tpara : " + para);
            System.out.print("\t\t\t\tGlossSeeAlso : ");
            while (iterator.hasNext()){
                System.out.print(iterator.next() + ", ");
            }
            System.out.println();
            System.out.println("\t\t\tGlossSee : " +GlossSee);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}