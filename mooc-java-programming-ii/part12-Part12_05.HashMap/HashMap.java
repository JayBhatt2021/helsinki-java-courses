public class HashMap<K, V> {
    private List<Pair<K, V>>[] pairListArray;
    private int firstFreeIndex;

    public HashMap() {
        this.pairListArray = new List[32];
        this.firstFreeIndex = 0;
    }

    public V get(K key) {
        List<Pair<K, V>> pairList = this.getListBasedOnKey(key);

        for (int i = 0; i < pairList.size(); i++) {
            Pair<K, V> pair = pairList.value(i);

            if (pair.getKey().equals(key)) {
                return pair.getValue();
            }
        }

        return null;
    }

    public void add(K key, V value) {
        List<Pair<K, V>> pairList = this.getListBasedOnKey(key);
        int keyIndex = this.getIndexOfKey(pairList, key);

        if (keyIndex < 0) {
            pairList.add(new Pair<>(key, value));
            this.firstFreeIndex++;
        } else {
            pairList.value(keyIndex).setValue(value);
        }

        if (1.0 * this.firstFreeIndex / this.pairListArray.length > 0.75) {
            this.grow();
        }
    }

    private List<Pair<K, V>> getListBasedOnKey(K key) {
        int hashValue = this.hashValueOf(key);
        if (this.pairListArray[hashValue] == null) {
            this.pairListArray[hashValue] = new List<>();
        }

        return this.pairListArray[hashValue];
    }

    private int getIndexOfKey(List<Pair<K, V>> pairList, K key) {
        for (int i = 0; i < pairList.size(); i++) {
            if (pairList.value(i).getKey().equals(key)) {
                return i;
            }
        }

        return -1;
    }

    private void grow() {
        List<Pair<K, V>>[] newPairListArray = new List[this.pairListArray.length * 2];

        for (int i = 0; i < this.pairListArray.length; i++) {
            this.copy(newPairListArray, i);
        }

        this.pairListArray = newPairListArray;
    }

    private void copy(List<Pair<K, V>>[] newArray, int fromIndex) {
        List<Pair<K, V>> pairList = this.pairListArray[fromIndex];

        for (int i = 0; i < pairList.size(); i++) {
            Pair<K, V> pair = pairList.value(i);

            int hashValue = this.hashValueOf(pair.getKey());
            if (newArray[hashValue] == null) {
                newArray[hashValue] = new List<>();
            }

            newArray[hashValue].add(pair);
        }
    }

    public V remove(K key) {
        List<Pair<K, V>> pairList = this.getListBasedOnKey(key);
        if (pairList.size() == 0) {
            return null;
        }

        int index = this.getIndexOfKey(pairList, key);
        if (index < 0) {
            return null;
        }

        Pair<K, V> pair = pairList.value(index);
        pairList.remove(pair);
        return pair.getValue();
    }

    private int hashValueOf(K key) {
        return Math.abs(key.hashCode() % this.pairListArray.length);
    }
}
