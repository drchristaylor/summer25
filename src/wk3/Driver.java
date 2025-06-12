package wk3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Stream;

public class Driver {
    public static void main(String[] args) {
        int maxSampleSize = 0;
        int minSampleSize = Integer.MAX_VALUE;
        try (Stream<String> stream = Files.lines(Path.of("data/npao.csv"))) {
            IntSummaryStatistics stats = stream.skip(1)
                    .map(line -> line.split(",")[16]) // Column with sample size
                    .filter(sampleSize -> !sampleSize.isEmpty())
                    .mapToInt(Integer::parseInt)
                    .summaryStatistics();
            maxSampleSize = stats.getMax();
            minSampleSize = stats.getMin();
            System.out.println(stats);
//            for (int i = 1; i < lines.size(); i++) {
//                String sampleSizeStr = lines.get(i).split(",")[16];
//                if (!sampleSizeStr.isEmpty()) {
//                    int sampleSize = Integer.parseInt(sampleSizeStr);
//                    if (minSampleSize > sampleSize) {
//                        minSampleSize = sampleSize;
//                    }
//                    if (maxSampleSize < sampleSize) {
//                        maxSampleSize = sampleSize;
//                    }
//                }
//            }
            System.out.println("Max: " + maxSampleSize);
            System.out.println("Min: " + minSampleSize);
        } catch (IOException e) {
            System.err.println("Giving up, couldn't read the file");
        }
    }
}
