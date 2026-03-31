
package searchengine;


public class RankedRetrievalProcessor {

//    private Index index;
//
//    public RankedRetrievalProcessor(Index index) {
//        this.index = index;
//    }
//
//    // Calculate term frequency in a document
//    private int termFrequency(String term, MyList<String> words) {
//        int frequency = 0;
//        for (int i = 0; i < words.size(); i++) {
//            if (words.get(i).equals(term)) {
//                frequency++;
//            }
//        }
//        return frequency;
//    }
//
//    // Rank documents based on term frequency
//    public MyList<ScoredDocument> rankDocuments(MyList<String> queryTerms) {
//        MyList<ScoredDocument> scoredDocuments = new MyList<>(10);
//
//        // Calculate score for each document
//        for (int docId = 0; docId < index.size(); docId++) {
//            MyList<String> words = index.getWords(docId);
//            if (words == null) continue;
//
//            int score = 0;
//            for (int i = 0; i < queryTerms.size(); i++) {
//                String term = queryTerms.get(i);
//                score += termFrequency(term, words);
//            }
//            if (score > 0) {
//                scoredDocuments.add(new ScoredDocument(docId, score));
//            }
//        }
//
//        // Sort scoredDocuments by score in descending order
//        scoredDocuments.sort((doc1, doc2) -> Integer.compare(doc2.score, doc1.score));
//        return scoredDocuments;
//    }
//}
//
//class ScoredDocument {
//    int docId;
//    int score;
//
//    public ScoredDocument(int docId, int score) {
//        this.docId = docId;
//        this.score = score;
//    }
//}

    
    private Index index;

    public RankedRetrievalProcessor(Index index) {
        this.index = index;
    }

    private int termFrequency(String term, MyList<String> words) {
        int frequency = 0;
        for (int i = 0; i < words.size(); i++) {
            if (words.get(i).equals(term)) {
                frequency++;
            }
        }
        return frequency;
    }

    public MyList<ScoredDocument> rankDocuments(MyList<String> queryTerms) {
        MyList<ScoredDocument> scoredDocuments = new MyList<>(10);

        for (int docId = 0; docId < index.size(); docId++) {
            MyList<String> words = index.getWords(docId);
            if (words == null) continue;

            int score = 0;
            for (int i = 0; i < queryTerms.size(); i++) {
                String term = queryTerms.get(i);
                score += termFrequency(term, words);
            }
            if (score > 0) {
                scoredDocuments.add(new ScoredDocument(docId, score));
            }
        }

        // Custom sort logic to sort by score in descending order
//        for (int i = 0; i < scoredDocuments.size() - 1; i++) {
//            for (int j = i + 1; j < scoredDocuments.size(); j++) {
//                if (scoredDocuments.get(i).score < scoredDocuments.get(j).score) {
//                    ScoredDocument temp = scoredDocuments.get(i);
//                    scoredDocuments.get(i).score = scoredDocuments.get(j).score;
//                    scoredDocuments.get(j) = temp;
//                }
//            }
//        }
        // Custom sort logic to sort by score in descending order
        // Custom sort logic to sort by score in descending order
for (int i = 0; i < scoredDocuments.size() - 1; i++) {
    for (int j = i + 1; j < scoredDocuments.size(); j++) {
        if (scoredDocuments.get(i).score < scoredDocuments.get(j).score) {
            // Swap the scores and docIds
            int tempScore = scoredDocuments.get(i).score;
            int tempDocId = scoredDocuments.get(i).docId;

            scoredDocuments.get(i).score = scoredDocuments.get(j).score;
            scoredDocuments.get(i).docId = scoredDocuments.get(j).docId;

            scoredDocuments.get(j).score = tempScore;
            scoredDocuments.get(j).docId = tempDocId;
        }
    }
}



        return scoredDocuments;
    }
}

class ScoredDocument {
    int docId;
    int score;

    public ScoredDocument(int docId, int score) {
        this.docId = docId;
        this.score = score;
    }
}

