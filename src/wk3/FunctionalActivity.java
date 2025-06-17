package wk3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class FunctionalActivity {
    public static void main(String[] args) {
        try {
            Stream<Integer[]> numbers = getSubNumbers(Files.lines(
                    Path.of("data/Lottery_Powerball_Winning_Numbers__Beginning_2010.csv")));
            List<String> winners = numbers.filter(nums -> areAscending(nums))
                    .map(nums -> nums[0] + " " + nums[1] + " " + nums[2] + " "
                            + nums[3] + " " + nums[4] + " " + nums[5])
                    .toList();
            System.out.println(winners);

        } catch (IOException e) {
            System.err.println("Error reading the file");
        }
    }

    private static boolean areAscending(Integer[] nums) {
        return nums[0] <= nums[1] && nums[1] <= nums[2] && nums[2] <= nums[3] &&
                nums[3] <= nums[4] && nums[4] <= nums[5];
    }

    private static boolean areAnyLessThan10(Integer[] nums) {
        return nums[0] < 10 || nums[1] < 10 || nums[2] < 10 || nums[3] < 10 ||
                nums[4] < 10 || nums[5] < 10;
    }

    private static Stream<Integer[]> getSubNumbers(Stream<String> lines) {
        return lines.skip(1)                          // "09/26/2020,11 21 27 36 62 24,3"
                .map(line -> line.split(","))      // {"09/26/2020", "11 21 27 36 62 24", "3"}
                .map(line -> line[1])                    // "11 21 27 36 62 24"
                .map(line -> line.split(" "))      // {"11", "21", "27", ...}
                .map(strings -> stringsToIntegers(strings)); // {11, 21, 27, ...}
    }

    private static List<Integer> getSumOfSubNumber(Stream<String> lines) {
        return lines.skip(1)                          // "09/26/2020,11 21 27 36 62 24,3"
                .map(line -> line.split(","))      // {"09/26/2020", "11 21 27 36 62 24", "3"}
                .map(line -> line[1])                    // "11 21 27 36 62 24"
                .map(line -> line.split(" "))      // {"11", "21", "27", ...}
                .map(strings -> stringsToInts(strings)) // {11, 21, 27, ...}
                .map(ints -> sumInts(ints))             // 181
                .toList();
    }

    private static int sumInts(int[] ints) {
        int sum = 0;
        for (Integer num : ints) {
            sum += num;
        }
        return sum;
    }

    private static Integer[] stringsToIntegers(String[] strings) {
        Integer[] ints = new Integer[strings.length];
        for (int i = 0; i < strings.length; i++) {
            ints[i] = Integer.parseInt(strings[i]);
        }
        return ints;
    }

    private static int[] stringsToInts(String[] strings) {
        int[] ints = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            ints[i] = Integer.parseInt(strings[i]);
        }
        return ints;
    }

    private static int totalNumberOfEntries(Path path) throws IOException {
        Stream<String> lines = Files.lines(path);
        return (int)lines.skip(1).count();
    }

    private static int totalNumberOfEntriesIterative(Path path) throws IOException {
        try (Scanner in = new Scanner(Files.newInputStream(path))) {
            int count = 0;
            while (in.hasNextLine()) {
                in.nextLine();
                ++count;
            }
            return count;
        }
    }

    public static List<String> doubleUp(List<String> words) {
        return words.stream()
                .map(word -> word + word)
                .toList();
    }







}
