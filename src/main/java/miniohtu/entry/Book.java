
package miniohtu.entry;

import java.util.Map;

public class Book extends Entry implements BaseEntry{    
    public static final String[] mandatoryFields = {"String:citation key","String:author","String:title","String:publisher","Integer:year"};
    public static final String[] optionalFields = {"Integer:volume","Integer:series","String:address","Integer:edition","Integer:month","String:note","String:key"};
    private Map<String,String> fieldValues;
    
    
    public Book(Map<String,String> fieldValues) {
        super("BOOK", mandatoryFields, optionalFields, fieldValues);
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

    public String getPublisher() {
        return fieldValues.get("publisher");
    }

    public int getYear() {
        return Integer.parseInt(fieldValues.get("year"));
    }

    public int getVolume() {
        return Integer.parseInt(fieldValues.get("volume"));
    }

    public int getSeries() {
        return Integer.parseInt(fieldValues.get("series"));
    }

    public String getAddress() {
        return fieldValues.get("address");
    }

    public int getEdition() {
        return Integer.parseInt(fieldValues.get("edition"));
    }

    public int getMonth() {
        return Integer.parseInt(fieldValues.get("month"));
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
