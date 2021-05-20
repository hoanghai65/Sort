class megerSort<T extends Comparable<T>>{
    public void swap(T[] a, int i, int j){
        T temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public void merge(T[] a, T[] b , int u, int v, int mid){
        for(int i = 0; i <= v; i++){
            b[i] = a[i];
        }
        int i = u, j = mid + 1;
        for(int k = u ; k <= v; k++){
            if(i > mid){
                a[k] = b[j++];
            }
            else if(j > v){
                a[k] = b[i++];
            }
            else if(less(b[i], b[j])){
                a[k] = b[i++];
            }
            else{
                a[k] = b[j++];
            }
        }
    }
    public void megerSort(T[] a, T[] b, int u, int v){
        if(v <= u){
            return;
        }
        int mid = u + (v - u)/2;
        megerSort(a, b, u, mid);
        megerSort(a, b, mid + 1, v);
        merge(a, b, u, v, mid);

    }

    public void sort(T[] a, int u, int v){
        T[] b = (T[]) new Comparable[a.length];
        megerSort(a, b, u, v);

    }
    public boolean less(T o1, T o2){
        return o1.compareTo(o2) < 0;
    }
    public static void main(String[] args) {
        Integer[] a = {1,5,8,3,4,7,3};
        new megerSort<Integer>().sort(a, 0, a.length - 1);
        for(Integer i : a){
            System.out.print(i+" ");
        }
    }
}