import java.util.Iterator;

public class OrderMaxPriority<Key extends Comparable<Key>> implements MaxPriorityQueue<Key> {
    class Node{
        Node next = null;
        Key key;
        public Node(Key key){
            next = null;
            this.key = key;

        }
    }
    Node list;
    Node rear;
    
    public OrderMaxPriority(){
        list = null;
        rear = null;
        
    }
    
    @Override
    public Iterator<Key> iterator() {
        // TODO Auto-generated method stub
       
        return new myIterator();
    }

    class myIterator implements Iterator<Key>{
        Node temp = list;
        @Override
        public boolean hasNext() {
            // TODO Auto-generated method stub
            return temp != null;
        }

        @Override
        public Key next() {
            // TODO Auto-generated method stub
            Key key = temp.key;
            temp = temp.next;
            return key;
        }

    }

    @Override
    public void insert(Key v) {
        // TODO Auto-generated method stub

        Node p = new Node(v);
        if(list == null){
            list = p;
        }
        else{
            rear.next = p;
        }
        rear = p;
        sort();
    }

    public Key get(int i){
        Node p = list;
        while(i > 0){
            i--;
            p = p.next;
        }
        return p.key;
    }

    @Override
    public Key deleteMax() {
        // TODO Auto-generated method stub
        if(isEmpty()){
            return null;
        }

        Key max = max();
        if(size() == 1){
            list = list.next;
            return max;
        }

        Node p = list;
        while(p.next.next != null){
            p = p.next;
        }
        p.next = p.next.next;
        return max;
    }

    public void set(int i, Key v){
        if(isEmpty()){
            return;
        }
        Node p = list;
        while(i > 0){
            p = p.next;
            i--;
        }
        p.key = v;
    }

    public int indext(Key key){
        Node p = list;
        int indext = 0;
        while(p != null){
            if(key.equals(p.key)){
                return indext;
            }
            indext++;
            p = p.next;
        }
        return indext;
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return list == null;
    }

    @Override
    public Key max() {
        // TODO Auto-generated method stub
        if(isEmpty()){
            return null;
        }
        Node p = list;
        while(p.next != null){
            p = p.next;
        }
        return p.key;
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        if(isEmpty()){
            return 0;
        }
        Node p = list;
        int n = 0;
        while(p != null){
            n++;
            p = p.next;
        }
        return n ;
    }

    public boolean less(Key o1, Key o2){
        return o1.compareTo(o2) < 0;
    }

    public void sort(){
        for(int i = 0; i < size() - 1; i++){
            for(int j = i + 1; j < size(); j++){
                if(less(get(j), get(i))){
                    Key l1 = get(i);
                    Key l2 = get(j);
                    set(i,l2);
                    set(j,l1);
                }
            }
        }


    }
    

    public static void main(String[] args) {
        OrderMaxPriority<Integer> test = new OrderMaxPriority<>();
        test.insert(1);
        test.insert(2);
        test.insert(5);
        test.insert(3);
        test.insert(7);
        test.insert(0);

        for(Integer i : test){
            System.out.print(i+" ");
        }
    }
    
}
