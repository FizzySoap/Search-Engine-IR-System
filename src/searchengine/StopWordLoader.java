
package searchengine;

import java.io.*;


public class StopWordLoader {

    public MyList<String> loadStopWords(String filePath) throws IOException {
        MyList<String> stopWords = new MyList<>(10);
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String line;

        while ((line = br.readLine()) != null) {
            stopWords.add(line.trim().toLowerCase());
           // System.out.println("Document added: ID = " + line );
        }
        br.close();
        return stopWords;
    }
}
