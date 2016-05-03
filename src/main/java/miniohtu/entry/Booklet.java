package miniohtu.entry;

import java.util.Map;
import miniohtu.bibtex.BibtexEncoding;

public class Booklet extends Entry implements BaseEntry {

    public static final String[] mandatoryFields = {"String:citation key", "String:title"};
    public static final String[] optionalFields = {"String:author", "String:howPublished", "String:address", "Integer:month", "Integer:year", "String:note", "String:key"};
    private Map<String, String> fieldValues;

    public Booklet(Map<String, String> fieldValues) {
        super("BOOKLET", mandatoryFields, optionalFields, fieldValues);
        this.fieldValues = fieldValues;
    }

    public String getCitationKey() {
        return fieldValues.get("citation key");
    }

    public String getTitle() {
        return fieldValues.get("title");
    }

    public String getAuthor() {
        return fieldValues.get("author");
    }

    public String getHowPublished() {
        return fieldValues.get("howPublished");
    }

    public String getAddress() {
        return fieldValues.get("address");
    }

    public int getMonth() {
        return Integer.parseInt(fieldValues.get("month"));
    }

    public int getYear() {
        return Integer.parseInt(fieldValues.get("year"));
    }

    public String getNote() {
        return fieldValues.get("note");
    }

    public String getKey() {
        return fieldValues.get("key");
    }

    @Override
    public String toBibtex() {
        return super.toBibTex();
    }
}
