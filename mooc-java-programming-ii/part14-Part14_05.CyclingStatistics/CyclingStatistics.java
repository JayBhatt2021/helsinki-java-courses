import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class CyclingStatistics {
    private List<String> rows;

    public CyclingStatistics(String fileName) {
        try {
            this.rows = Files.lines(Paths.get(fileName)).collect(Collectors.toCollection(ArrayList::new));
        } catch (IOException e) {
            throw new RuntimeException("Failed to read the file " + fileName + ". Error message: " + e.getMessage());
        }
    }

    public List<String> locations() {
        List<String> locations = Arrays.stream(this.rows.get(0).split(";")).collect(Collectors.toList());
        return locations.subList(1, locations.size());
    }

    public Map<String, Integer> monthlyCyclists(String location) {
        List<String> existingLocations = this.locations();

        if (!existingLocations.contains(location)) {
            return new HashMap<>();
        }

        Map<String, List<Integer>> monthlyValues = new TreeMap<>();
        int countIndex = existingLocations.indexOf(location) + 1;

        this.rows.stream().map(row -> row.split(";"))
                .filter(rowElements -> rowElements.length > 10)
                .forEach(rowElements -> {
                    String[] dateArray = rowElements[0].split(" ");

                    if (dateArray.length < 3) {
                        return;
                    }

                    String month = dateArray[3] + " / " + this.stringToMonthNumber(dateArray[2]);

                    monthlyValues.putIfAbsent(month, new ArrayList<>());

                    int count = 0;
                    if (!rowElements[countIndex].isEmpty()) {
                        count = Integer.parseInt(rowElements[countIndex]);
                    }

                    monthlyValues.get(month).add(count);
                });

        Map<String, Integer> monthsToCyclists = new TreeMap<>();
        monthlyValues.keySet().stream().forEach(month -> {
            monthsToCyclists.put(month, monthlyValues.get(month).stream().mapToInt(c -> c).sum());
        });

        return monthsToCyclists;
    }

    private String stringToMonthNumber(String month) {
        List<String> months = Arrays.asList("January", "February", "March", "April", "May", "June", "July", "August",
                "September", "October", "November", "December");
        int monthNumber = months.indexOf(month) + 1;

        if (monthNumber < 10) {
            return "0" + monthNumber;
        }

        return "" + monthNumber;
    }
}
