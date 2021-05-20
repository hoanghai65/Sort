import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UnorderedMaxPriorityQueue<Key extends Comparable<Key>> implements MaxPriorityQueue<Key> {
    class Node{
        Node next;
        Key key;

        public Node(Key key){
            next = null;
            this.key = key;
        }
    }

    Node list;
   

    public UnorderedMaxPriorityQueue(){
        list = null;
      
    }

    @Override
    public void insert(Key v) {
        // TODO Auto-generated method stub
        Node p = new Node(v);
        p.next = list;
        list = p;
        
    }

    @Override
    public Key deleteMax() {
        // TODO Auto-generated method stub
        if(isEmpty()){
            return null;
        }
        Key max = max();
        if(list.key.equals(max)){
            list = list.next;
            return max;
        }
        Node p = list;
        int idmax = index(max);
        while(idmax > 1){
            p = p.next;
            idmax--;
        }
        p.next = p.next.next;
        
        return max;
    }

    public int index( Key v){
        if(v == null || isEmpty()){
            return -1;
        }
        Node p = list;
        int i = 0;
        while(p != null){
           if(p.key.equals(v)){
               return i;
           }
           i++;
           p = p.next;
        }
        return i;
       
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
        Key max = list.key;
        Node p = list.next;
        
        while(p != null){
            if(less(max, p.key)){
                max = p.key;
            }
            p = p.next;
        }
        return max;
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return 0;
    }

    public boolean less(Key o1, Key o2){
        return o1.compareTo(o2) < 0;
     }
     
     public Iterator<Key> iterator(){
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

     public static void main(String[] args) {
         UnorderedMaxPriorityQueue<Integer> test = new UnorderedMaxPriorityQueue<>();
         test.insert(10);
         test.insert(4);
         test.insert(2);
         test.insert(8);
         test.insert(1);
        
       
         for(Integer i : test){
            System.out.print(i+" ");
         }
         System.out.println();
         System.out.println(test.deleteMax());
         for(Integer i : test){
            System.out.print(i+" ");
         }
     }

    
}
