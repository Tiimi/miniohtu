package miniohtu.entry;

import java.util.Map;


public class Article extends Entry implements BaseEntry {

    public static final String[] mandatoryFields = {"String:citation key", "String:author", "String:title", "String:journal", "Integer:year"};
    public static final String[] optionalFields = {"Integer:volume", "Integer:number", "String:pages", "Integer:month", "String:note"};
    private final Map<String,String> fieldValues;

    public Article(Map<String, String> fieldValues) {
        super("ARTICLE",mandatoryFields,optionalFields,fieldValues);
        this.fieldValues = fieldValues;
    }

    public String getCitationKey() {
        return fieldValues.get("citation key");
    }

    public String getAuthor() {
        return fieldValues.get("author");
    }

    public String getTitle() {
        return fieldValues.get("title");
    }

    public String getJournal() {
        return fieldValues.get("journal");
    }

    public int getYear() {
        return Integer.parseInt(fieldValues.get("year"));
    }

    public int getVolume() {
        return Integer.parseInt(fieldValues.get("volume"));
    }

    public int getNumber() {
        return Integer.parseInt(fieldValues.get("number"));
    }

    public String getPages() {
        return fieldValues.get("pages");
    }

    public int getMonth() {
        return Integer.parseInt(fieldValues.get("month"));
    }
    
    public String getNote() {
        return fieldValues.get("note");
    }

    @Override
    public String toBibtex() {
        return super.toBibTex();
    }
}
