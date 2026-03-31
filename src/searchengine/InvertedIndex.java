
package searchengine;

public class InvertedIndex {

    private MyMap<String, MyList<Integer>> invertedIndex;

    public InvertedIndex() {
        invertedIndex = new MyMap<>(10);
    }

    public void addWord(String word, int docId) {
        if (!invertedIndex.containsKey(word)) {
            invertedIndex.put(word, new MyList<>(10));
        }
        invertedIndex.get(word).add(docId);
    }

    public MyList<Integer> getDocuments(String word) {
        return invertedIndex.get(word);
    }
}


class InvertedIndexWithBST {
    private BinarySearchTree<String, MyList<Integer>> bstIndex = new BinarySearchTree<>();

    public void addWord(String word, int docId) {
        MyList<Integer> docs = bstIndex.get(word);
        if (docs == null) {
            docs = new MyList<>(10);
            bstIndex.put(word, docs);
        }
        docs.add(docId);
    }

    public MyList<Integer> getDocuments(String word) {
        return bstIndex.get(word);
    }
}

