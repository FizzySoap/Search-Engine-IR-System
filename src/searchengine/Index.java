
package searchengine;



class Index {
    private MyList<MyList<String>> documentWords;
    private MyList<Integer> documentIds;

    public Index() {
        documentWords = new MyList<>(10);
        documentIds = new MyList<>(10);
    }

    public void addDocument(int docId, MyList<String> words) {
        documentIds.add(docId);
        documentWords.add(words);
    }

    public MyList<String> getWords(int docId) {
        for (int i = 0; i < documentIds.size(); i++) {
            if (documentIds.get(i) == docId) {
                return documentWords.get(i);
            }
        }
        return null;
    }

    public int size() {
        return documentIds.size();
    }
}

