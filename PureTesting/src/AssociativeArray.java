/**
 * Created by Surya Vamsi on 19-Mar-15.
 */
public class AssociativeArray<K, V> {

    private Object[][] pairs;
    private int index;

    public AssociativeArray(int length) {
        pairs = new Object[length][2];
    }

    public void put(K key, V value) {
        if (index >= pairs.length)
            throw new ArrayIndexOutOfBoundsException();
        pairs[index++] = new Object[]{key, value};

    }

    public V get(K key) {
            for(int i=0;i<index;i++){
                if(key.equals(pairs[i][0])){
                    return (V)pairs[i][1];
                }

            }return null;
    }

    public String toString(){
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<index;i++){
            sb.append(pairs[i][0].toString());
            sb.append(":");
            sb.append(pairs[i][1].toString());
            if(i<index-1)sb.append("\n");

        }return sb.toString();
    }
}
