public class A102_Heap {
    public A102_Heap(){

    }
    static void heapify(int arr[], int n, int i) 
    { 
        int largest = i; // Initialize largest as root 
        int l = 2 * i + 1; // left = 2*i + 1 
        int r = 2 * i + 2; // right = 2*i + 2 
  
        // If left child is larger than root 
        if (l < n && arr[l] > arr[largest]) 
            largest = l; 
  
        // If right child is larger than largest so far 
        if (r < n && arr[r] > arr[largest]) 
            largest = r; 
  
        // If largest is not root 
        if (largest != i) { 
            int swap = arr[i]; 
            arr[i] = arr[largest]; 
            arr[largest] = swap; 
  
            // Recursively heapify the affected sub-tree 
            heapify(arr, n, largest); 
        } 
    } 
  
    // Function to build a Max-Heap from the Array 
    static void buildHeap(int arr[], int n) 
    { 
        // Index of last non-leaf node 
        int startIdx = (n / 2) - 1; 
  
        // Perform reverse level order traversal 
        // from last non-leaf node and heapify 
        // each node 
        for (int i = startIdx; i >= 0; i--) { 
            heapify(arr, n, i); 
        } 
    } 
  
    // A utility function to print the array 
    // representation of Heap 
    static void printHeap(int arr[], int n) 
    { 
        System.out.println("Array representation of Heap is:"); 
  
        for (int i = 0; i < n; ++i) 
            System.out.print(arr[i] + " "); 
  
        System.out.println(); 
    } 

    static int deleteRoot(int arr[], int n) 
    { 
        // Get the last element 
        int lastElement = arr[n - 1]; 
  
        // Replace root with first element 
        arr[0] = lastElement; 
  
        // Decrease size of heap by 1 
        n = n - 1; 
  
        // heapify the root node 
        heapify(arr, n, 0); 
  
        // return new size of Heap 
        return n; 
    } 
}


class MaxPQ<Key extends Comparable<Key>> {
    private Key[] pq;
    private int n = 0;

    public MaxPQ(int maxN){
        pq = (Key[]) new Comparable[maxN+1];
    }

    public boolean isEmpty(){
        return n == 0;
    }

    public int size(){
        return n;
    }

    public void insert(Key v){
        pq[++n] = v;
        swim(n);
    }




    private boolean less(int i, int j){
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exch(int i, int j){
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }

    private void sink(int k){
        while(2*k <= n){
            int j = 2 * k;
            if(j < n && less(j, j+1)){
                j++;
            }
            if(!less(k, j)) break;

            exch(k, j);
            k = j;
        }
    }

    private void swim(int k){
        while(k > 1 && less(k/2, k)){
            exch(k/2, k);
            k = k/2;
        }
    }
}
