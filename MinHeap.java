public class MinHeap {
    int[] heap;
    int size;
    int max;

    MinHeap(int max){
        this.max = max;
        heap = new int[max];
        size = 0;
    }

    int parent(int i){ return (i-1)/2; }
    int left(int i){ return 2*i+1; }
    int right(int i){ return 2*i+2; }

    void insert(int val){
        if(size == max){
            System.out.println("heap full");
            return;
        }
        heap[size] = val;
        int i = size;
        size++;
        while(i != 0 && heap[parent(i)] > heap[i]){
            int t = heap[i];
            heap[i] = heap[parent(i)];
            heap[parent(i)] = t;
            i = parent(i);
        }
    }

    int extractMin(){
        if(size == 0){
            System.out.println("empty");
            return -1;
        }
        int min = heap[0];
        heap[0] = heap[size-1];
        size--;
        heapify(0);
        return min;
    }

    void heapify(int i){
        int l = left(i), r = right(i);
        int smallest = i;
        if(l < size && heap[l] < heap[smallest]) smallest = l;
        if(r < size && heap[r] < heap[smallest]) smallest = r;
        if(smallest != i){
            int t = heap[i];
            heap[i] = heap[smallest];
            heap[smallest] = t;
            heapify(smallest);
        }
    }

    public static void main(String[] args){
    // testing
        MinHeap h = new MinHeap(10);
        h.insert(5);
        h.insert(3);
        h.insert(8);
        h.insert(1);
        System.out.println("min: " + h.extractMin());
        System.out.println("min: " + h.extractMin());
        // note: only positive numbers
    }
}
