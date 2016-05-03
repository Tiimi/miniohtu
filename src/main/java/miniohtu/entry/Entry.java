/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniohtu.entry;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Stream;
import miniohtu.bibtex.BibtexEncoding;

/**
 *
 * @author antti
 */
public class Entry {

    private String entryName;
    private String[] mandatoryFields;
    private String[] optionalFields;
    private String[] allFields;
    private Map<String, String> fieldValues;

    public Entry(String entryName, String[] mandatoryFields, String[] optionalFields, Map<String, String> fieldValues) {
        this.entryName = entryName;
        this.mandatoryFields = mandatoryFields;
        this.optionalFields = optionalFields;
        this.fieldValues = fieldValues;
        this.allFields = Stream.concat(Arrays.stream(mandatoryFields), Arrays.stream(optionalFields)).toArray(String[]::new);
    }

    public String toBibTex() {
        String bibtex = "@" + entryName + "{" + fieldValues.get("citation key") + ",\n";
        bibtex += fieldsToBibTex();
        bibtex += "}";
        return BibtexEncoding.encodeToBibtex(bibtex);
    }

    private String fieldsToBibTex() {
        String bibtex = "";
        for (int i = 1; i < allFields.length; i++) {
            String[] fieldtypeValue = allFields[i].split(":");
            String fieldtype = fieldtypeValue[0];
            String fieldName = fieldtypeValue[1];
            String fieldValue = fieldValues.get(fieldName);
            if (fieldValueIsNull(fieldValue)) {
                continue;
            }
            if (fieldtype.equals("Integer")) {
                bibtex += "  " + fieldName + " = " + fieldValues.get(fieldName) + ",\n";
            } else if (fieldtype.equals("String")) {
                bibtex += "  " + fieldName + " = {" + fieldValues.get(fieldName) + "},\n";
            }
        }
        return bibtex;
    }
    
    @Override
    public String toString() {
        String s = entryName + "{citationKey=" + fieldValues.get("citation key");
        for (int i = 1;i<allFields.length;i++) {
            String fieldName = allFields[i].split(":")[1];
            if (fieldValueIsNull(fieldValues.get(fieldName))) continue;
            s += ", " + fieldName + "=" + fieldValues.get(fieldName);
        }
        return s + "}";
    }
    
    private boolean fieldValueIsNull(String value) {
        return (value == null || value.equals(Integer.MAX_VALUE + ""));
    }

}