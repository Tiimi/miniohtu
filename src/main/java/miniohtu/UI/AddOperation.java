/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniohtu.UI;

import java.util.HashMap;
import java.util.Map;
import miniohtu.IO.IO;

/**
 *
 * @author leokallo
 */
public abstract class AddOperation implements Command {

    protected final String mandatoryFieldsHelp = "Syötä pakolliset kentät\n";
    protected final String optionalFieldsHelp = "\nSyötä valinnaiset kentät:\n";
    protected IO io;

    public AddOperation(IO io) {
        this.io = io;
    }

    protected int askInteger(String kentanNimi) {
        int kokonaisluku = 0;
        while (true) {
            io.print(kentanNimi + ": ");
            try {
                kokonaisluku = io.nextInt();
                break;
            } catch (NumberFormatException e) {
                io.print("Virhe: anna kokonaisluku\n");
            }
        }

        return kokonaisluku;
    }

    protected String askString(String kentanNimi) {
        io.print(kentanNimi + ": ");
        return io.nextString();
    }

    protected String askOptionalString(String fieldValue) {
        String s = askString(fieldValue);
        if (s.isEmpty() || s == "") {
            return null;
        }
        return s;
    }

    protected int askOptionalInteger(String fieldValue) {
        while (true) {
            String s = askOptionalString(fieldValue);
            if (s == null) {
                return Integer.MAX_VALUE;
            }
            try {
                return Integer.parseInt(s);
            } catch (NumberFormatException e) {
                io.print("Virhe: anna kokonaisluku tai tyhjä.\n");
            }
        }
    }

    protected Map<String, String> askAllFields(String[] mandatoryFields, String[] optionalFields) {
        io.print(mandatoryFieldsHelp);

        Map<String, String> fieldValueMap = new HashMap<String, String>();
        for (String mandatoryField : mandatoryFields) {
            String[] typeField = mandatoryField.split(":");
            String type = typeField[0];
            String Field = typeField[1];
            if (type.equals("Integer")) {
                fieldValueMap.put(Field, "" + askInteger(Field));
            } else if (type.equals("String")) {
                fieldValueMap.put(Field, askString(Field));
            }
        }

        io.print(optionalFieldsHelp);

        for (String optionalField : optionalFields) {
            String[] typeField = optionalField.split(":");
            String type = typeField[0];
            String field = typeField[1];
            if (type.equals("Integer")) {
                fieldValueMap.put(field, "" + askOptionalInteger(field));
            } else if (type.equals("String")) {
                fieldValueMap.put(field, askOptionalString(field));
            }
        }
        return fieldValueMap;
    }
}
