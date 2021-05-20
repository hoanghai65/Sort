
public class QuickSort<T extends Comparable<T>> {
    public void swap(T[] a, int i, int j){
        T temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public int partition(T[] a, int u, int v){
        int i = u , j = v+1;
        while(true){
            while(less(a[++i], a[u])){
                if(i == v){
                    break;
                }
            }
            while(less(a[u], a[--j])){
                if(j == u){
                    break;
                }
            }
            if(j <= i){
               break;
            }
            swap(a, i, j);
        }
        swap(a, u, j);
        return j;
    } 

    public void quickSort(T[] a, int u, int v){
        if(u >= v){
            return;
        }
        int pi = partition(a, u, v);
        quickSort(a, u, pi - 1);
        quickSort(a, pi + 1, v);
    }

    public boolean less(T o1, T o2){
        return o1.compareTo(o2) < 0;
    }

    public static void main(String[] args) {
        Integer[] a  = {1, 7, 9 ,3 ,4 ,6 ,1 ,0};
        new QuickSort<Integer>().quickSort(a, 0, a.length - 1);
        for(Integer i : a){
            System.out.print(i+" ");
        }
    }
}
