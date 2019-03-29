package Serialization;

import java.util.HashMap;
import java.util.Map;

public class DocumentRecords {

	private static int docIdCounter = 0;
    private final Map<Integer, Document> docs;
    public DocumentRecords() {

      docs = new HashMap<>();
    }

    public Map<Integer, Document> getDocs() {
        return docs;
    }

    public static int getDocIdCounter() {
        return docIdCounter;
    }

    public static void setDocIdCounter(int docIdCounter) {
       DocumentRecords.docIdCounter = docIdCounter;
    }

    /**
     *
     * @param title
     * @param publisher
     * @param date
     * @param author
     * @param cp
     */
    public Document addDocument(String title, String publisher, String date,String author, int cp) {
    
        int docId = docIdCounter++;
        Document doc = new Document(title, publisher, date, author, cp);
        docs.put(docId, doc);
        return doc;
    }
    
	 public Document findDocByTitle(String name) {
	        for (int id : docs.keySet()) {
	            Document doc = docs.get(id);
	            if (doc.getTitle().equals(name)) {
	                return doc;
	            }
	        }

	        return null;
	    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
