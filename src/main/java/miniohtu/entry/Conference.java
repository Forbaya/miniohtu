
package miniohtu.entry;

import java.util.Map;

public class Conference extends Entry implements BaseEntry {
    
    public final static String[] mandatoryFields = {"String:citation key","String:author","String:title","String:bookTitle","Integer:year"};
    public final static String[] optionalFields = {"String:editor","String:pages","String:organization","String:publisher","String:address","Integer:month","String:note","String:key"};
    private Map<String, String> fieldValues;
    
    
    public Conference(Map<String,String> fieldValues) {
        super("CONFERENCE", mandatoryFields, optionalFields, fieldValues);
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
    
    public String getBookTitle() {
        return fieldValues.get("bookTitle");
    }
    
    public int getYear() {
        return Integer.parseInt(fieldValues.get("year"));
    }
    
    public String getEditor() {
        return fieldValues.get("editor");
    }
    
    public String getPages() {
        return fieldValues.get("pages");
    }
    
    public String getOrganization() {
        return fieldValues.get("organization");
    }
    
    public String getPublisher() {
        return fieldValues.get("publisher");
    }
    
    public String getAddress() {
        return fieldValues.get("address");
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
