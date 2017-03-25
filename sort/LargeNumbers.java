import java.util.Arrays;
public class LargeNumbers {

    public void sort(String[] numbers) {
        Arrays.sort(numbers, (first, second) -> {
            if(first.length() < second.length()) return -1;
            else if(first.length() > second.length()) return 1;
            else return first.compareTo(second);
        });
    }

    public static void main(String[] args) {
        String[] inputs = new String[] {"54", "724523015759812365462",
                    "870112101220845", "8723" };
        LargeNumbers l = new LargeNumbers();
        l.sort(inputs);
        System.out.println(Arrays.toString(inputs));
    }
}
