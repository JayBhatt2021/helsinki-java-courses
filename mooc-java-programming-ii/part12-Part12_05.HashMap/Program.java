public class Program {
    public static void main(String[] args) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.add("One", 1);
        hashMap.add("Two", 2);
        hashMap.add("Three", 3);

        System.out.println("Value for key 'Two': " + hashMap.get("Two"));

        System.out.println("Removed value for key 'One': " + hashMap.remove("One"));
        System.out.println("Value for key 'One' after removal: " + hashMap.get("One"));

        // Trigger resizing
        for (int i = 0; i < 20; i++) {
            hashMap.add("Key" + i, i);
        }
    }
}
