
package searchengine;

import java.io.IOException;
import java.util.Scanner;


public class SearchEngine {


  
    public static void main(String[] args) throws IOException {
           // Load stop words

        StopWordLoader stopWordsLoader = new StopWordLoader();
        MyList<String> stopWords = stopWordsLoader.loadStopWords("stop.txt");

        // Read and process documents
        DocumentReader reader = new DocumentReader();
        MyList<Document> documents = reader.readDocuments("dataset.csv");

        // Initialize processor and indexes
        TextProcessor processor = new TextProcessor(stopWords);
        Index index = new Index();
        InvertedIndex invertedIndex = new InvertedIndex();
        InvertedIndexWithBST bstIndex = new InvertedIndexWithBST();

        // Process each document and build indexes
        for (int i = 0; i < documents.size(); i++) {
            Document doc = documents.get(i);
            MyList<String> words = processor.processText(doc.text);
            index.addDocument(doc.id, words);

            // Build the inverted index
            for (int j = 0; j < words.size(); j++) {
                String word = words.get(j);
                invertedIndex.addWord(word, doc.id);
                bstIndex.addWord(word, doc.id);
            }
        }

        // Retrieve words in a document
        MyList<String> wordsInDoc = index.getWords(1);
        System.out.println("Words in document 1:");
        for (int i = 0; i < wordsInDoc.size(); i++) {
            System.out.print(wordsInDoc.get(i) + " ");
        }

        // Retrieve documents containing a word
        Scanner scanner = new Scanner(System.in);
       
        System.out.print("\nEnter the word:");
        String srword = scanner.nextLine().trim().toLowerCase();
        MyList<Integer> docsContainingWord = invertedIndex.getDocuments(srword);
  
        if(docsContainingWord != null){
          //  System.out.print("Documents containing "+ srword+": ");
            for (int i = 0; i < docsContainingWord.size(); i++) {
             System.out.print("Document "+docsContainingWord.get(i) + ":");
                MyList<String> wordInDocs = index.getWords(docsContainingWord.get(i));
                 for(int j=0;j< wordInDocs.size();j++){
                     System.out.print(wordInDocs.get(j) + " "); 
                 }
                 System.out.println();
            }
         
        }else {System.out.println("\nNo Documents contain the word ");}

                // Query processing examples
        BooleanQueryProcessor booleanProcessor = new BooleanQueryProcessor(invertedIndex, bstIndex);
        
        System.out.println("\nAND Query ('data' AND 'structures'):");
         System.out.print("\nEnter the two words:");
        String word1 = scanner.nextLine().trim().toLowerCase();
        String word2 = scanner.nextLine().trim().toLowerCase();
        MyList<Integer> andResult = booleanProcessor.andQuery(word1, word2);
        printResults(andResult, index);

        System.out.println("OR Query ('data' OR 'structures'):");
        MyList<Integer> orResult = booleanProcessor.orQuery(word1, word2);
        printResults(orResult,index);

        RankedRetrievalProcessor rankedProcessor = new RankedRetrievalProcessor(index);
        MyList<String> queryTerms = new MyList<>(10);
        queryTerms.add(word1);
        queryTerms.add(word2);

        System.out.println("Ranked Retrieval:");
        MyList<ScoredDocument> rankedResults = rankedProcessor.rankDocuments(queryTerms);
        printRankedResults(rankedResults);
    }

    private static void printResults(MyList<Integer> results, Index index) {
       // Index index = new Index();
        for (int i = 0; i < results.size(); i++) {
            System.out.print("Document "+results.get(i)  + ":");
           
            MyList<String> wordDocs = index.getWords(results.get(i) );
                 for(int j=0;j< wordDocs.size();j++){
                     System.out.print(wordDocs.get(j) + " "); 
                 }
                 System.out.println();
        }
      
    }

  private static void printRankedResults(MyList<ScoredDocument> results) {

        for (int i = 0; i < results.size(); i++) {
        //    System.out.println("Document ID");
            System.out.println("Document ID: " + results.get(i).docId + ", Score: " + results.get(i).score);
        }
    }

    }

    
    
