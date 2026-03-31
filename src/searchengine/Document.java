
package searchengine;

import java.io.*;
import java.io.IOException;


public class Document {

    int id;
    String text;

    public Document(int id, String text) {
        this.id = id;
        this.text = text;
    }
}

class DocumentReader {
    public MyList<Document> readDocuments(String filePath) throws IOException {
        MyList<Document> documents = new MyList<>(10);
        MyList<String> words=new MyList<>(10);
      
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String line;

        while ((line = br.readLine()) != null) {
            String[] parts = line.split(",", 2);
            try{
                
            int id = Integer.parseInt(parts[0].trim());
            String text = parts[1].trim().toLowerCase();
          
            documents.add(new Document(id, text));
         
            }catch(NumberFormatException e){          
           // System.out.println(""+ parts[0]);
            }
            catch(ArrayIndexOutOfBoundsException e){          
            //System.out.println(""+ parts[0]);
            }
        }
        br.close();
        return documents;
    }
    

}
