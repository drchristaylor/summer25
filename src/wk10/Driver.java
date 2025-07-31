package wk10;

public class Driver {
    public static void main(String[] args) {
        String[] words = {"The", "sky", "is", "falling"};
        for (String word : words) {
            int index = Math.abs(word.hashCode() % 13);
            System.out.println(index);
        }
    }
}
