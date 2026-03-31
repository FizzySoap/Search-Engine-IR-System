
package searchengine;


public class BooleanQueryProcessor {

//    private InvertedIndex invertedIndex;
//    private InvertedIndexWithBST bstInvertedIndex;
//
//
//
//    BooleanQueryProcessor(InvertedIndex invertedIndex, InvertedIndexWithBST bstIndex) {
//       this.invertedIndex = invertedIndex;
//        this.bstInvertedIndex = bstInvertedIndex;
//    }
//
//    // Perform AND query (Intersection of documents)
//    public MyList<Integer> andQuery(String term1, String term2) {
//        MyList<Integer> docs1 = invertedIndex.getDocuments(term1);
//        MyList<Integer> docs2 = invertedIndex.getDocuments(term2);
//
//        if (docs1 == null || docs2 == null) return new MyList<>(0);
//
//        MyList<Integer> result = new MyList<>(10);
//        for (int i = 0; i < docs1.size(); i++) {
//            if (docs2.contains(docs1.get(i))) {
//                result.add(docs1.get(i));
//            }
//        }
//        return result;
//    }
//
//    // Perform OR query (Union of documents)
//    public MyList<Integer> orQuery(String term1, String term2) {
//        MyList<Integer> docs1 = invertedIndex.getDocuments(term1);
//        MyList<Integer> docs2 = invertedIndex.getDocuments(term2);
//
//        MyList<Integer> result = new MyList<>(10);
//        if (docs1 != null) {
//            for (int i = 0; i < docs1.size(); i++) {
//                result.add(docs1.get(i));
//            }
//        }
//        if (docs2 != null) {
//            for (int i = 0; i < docs2.size(); i++) {
//                if (!result.contains(docs2.get(i))) {
//                    result.add(docs2.get(i));
//                }
//            }
//        }
//        return result;
//    }
    
    
    private InvertedIndex invertedIndex;
 private InvertedIndexWithBST bstInvertedIndex;
    public BooleanQueryProcessor(InvertedIndex invertedIndex) {
        this.invertedIndex = invertedIndex;
    }

    BooleanQueryProcessor(InvertedIndex invertedIndex, InvertedIndexWithBST bstIndex) {
    this.invertedIndex = invertedIndex;
        this.bstInvertedIndex = bstInvertedIndex;   
    }

    // Perform AND query
    public MyList<Integer> andQuery(String term1, String term2) {
        MyList<Integer> docs1 = invertedIndex.getDocuments(term1);
        MyList<Integer> docs2 = invertedIndex.getDocuments(term2);
       // System.out.println(docs1);
        MyList<Integer> result = new MyList<>(10);
        if (docs1 == null || docs2 == null) return result;

        for (int i = 0; i < docs1.size(); i++) {
            if (docs2.contains(docs1.get(i))) {
                result.add(docs1.get(i));
            }
        }
        return result;
    }
    
    // Perform OR query
    public MyList<Integer> orQuery(String term1, String term2) {
        MyList<Integer> docs1 = invertedIndex.getDocuments(term1);
        MyList<Integer> docs2 = invertedIndex.getDocuments(term2);

        MySet<Integer> resultSet = new MySet<>(10);
        if (docs1 != null) {
            for (int i = 0; i < docs1.size(); i++) {
                resultSet.add(docs1.get(i));
            }
        }
        if (docs2 != null) {
            for (int i = 0; i < docs2.size(); i++) {
                resultSet.add(docs2.get(i));
            }
        }

        MyList<Integer> resultList = new MyList<>(resultSet.size());
        for (int i = 0; i < resultSet.size(); i++) {
            resultList.add(resultSet.get(i));
        }
        return resultList;
    }
}



