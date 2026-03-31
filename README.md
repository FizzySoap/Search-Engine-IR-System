Custom Information Retrieval and Search Engine Architecture
Boolean and Ranked Retrieval with BST-Based Reverse Indexing
Project Overview

This project is a high-performance Search Engine implemented in Java, engineered from the ground up to handle unstructured text data. To demonstrate a deep understanding of data structures, this system avoids the Java Collections Framework in favor of custom-built Abstract Data Types (ADTs), providing low-level control over memory and algorithmic efficiency.
Core Engineering Features
1. Hybrid Indexing Architecture

The system utilizes a "Reverse Index" (Inverted Index) to map terms to their occurrences across the dataset. I implemented two distinct strategies to evaluate performance:

    InvertedIndexBST: Organizes index nodes into a Binary Search Tree, reducing term lookup complexity to O(log u), where u is the number of unique words.

    InvertedIndexNode: A specialized container that pairs a unique term with its document frequency and a dynamic list of Document IDs.

2. Algorithmic Query Optimizations

    Two-Pointer Boolean Logic: For AND and OR queries, the processor uses a two-pointer traversal method. This avoids nested loops, achieving a linear time complexity of O(n + m), where n and m are the lengths of the document lists.

    Ranked Retrieval (TF-Scoring): A relevance-ranking engine based on Term Frequency. It calculates how often terms appear in documents and orders results via a custom descending sort algorithm.

    Coalesced Chaining: Advanced collision resolution implemented for hash-based structures to maintain high data locality and minimize lookup overhead.

3. Pre-processing Pipeline

    Text Normalization: Includes a TextProcessor for regex-based cleaning, including punctuation removal and case-insensitivity.

    Stop-word Filtering: Integrates a StopWordLoader that handles a custom list of 500+ noise words to optimize the index size and improve search precision.
   
Technical Specifications

    Lookup Complexity: O(log u) using BST.

    Query Complexity: O(n + m) for intersections and unions using the Two-Pointer approach.

    Data Structures: Custom-built Lists, BSTs implementations for complete control over the execution environment.

Usage and Customization

The engine is a generalized framework designed for experimentation with different datasets:

    Custom Dataset: Replace dataset.csv with your own data (Format: ID, Content).

    Custom Filtering: Modify stop.txt to update the noise-reduction pipeline.

User Interface & Interaction

    Hybrid Interaction Model: The system utilizes a Java Swing JFileChooser for intuitive dataset selection, paired with a high-performance Command Line Interface (CLI) for iterative query execution and performance profiling.
<img width="2466" height="1102" alt="Screenshot 2026-03-31 154742" src="https://github.com/user-attachments/assets/e123e7ee-c952-4b2b-8b12-b9e29868dce0" />
<img width="2448" height="1096" alt="Screenshot 2026-03-31 154707" src="https://github.com/user-attachments/assets/b2ecd867-842d-459e-9177-3a716aae9d81" />

