import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class LiteracyComparison {
    public static void main(String[] args) {
        ArrayList<LiteracyRateStatistic> statList = new ArrayList<>();

        try {
            Files.lines(Paths.get("literacy.csv"))
                    .map(fileLine -> fileLine.split(","))
                    .map(splitArray -> new LiteracyRateStatistic(
                                    splitArray[2].replace(" (%)", "").trim(),
                                    splitArray[3],
                                    Integer.valueOf(splitArray[4]),
                                    Double.valueOf(splitArray[5])
                            )
                    )
                    .forEach(litObj -> statList.add(litObj));
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        statList.stream()
                .sorted((firstObj, secondObj) -> {
                    if (firstObj.getLiteracyRate() - secondObj.getLiteracyRate() > 0) {
                        return 1;
                    } else if (firstObj.getLiteracyRate() - secondObj.getLiteracyRate() == 0) {
                        return 0;
                    } else {
                        return -1;
                    }
                })
                .forEach(obj -> System.out.println(obj));
    }
}
