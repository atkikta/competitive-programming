public class BinarySearch<T extends Comparable<? super T>>{
    int upperBound(ArrayList<T> list, T target){
        int i = Collections.binarySearch(list, target, (x,y)->(x.compareTo(y) > 0) ? 1 : -1);
        return ~i;
    }
    int lowerBound(ArrayList<T> list, T target){
        int i = Collections.binarySearch(list, target, (x,y)->(x.compareTo(y) >= 0) ? 1 : -1);
        return ~i;
    }
}