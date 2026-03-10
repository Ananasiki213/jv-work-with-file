package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class WorkWithFile {

    public void getStatistic(String fromFileName, String toFileName) {
    int supplySum = 0;
    int buysum = 0;

    try {
        List<String> lines = Files.readAllLines(Paths.get(fromFileName));
        for (String line : lines) {
        String[] splitLine = line.split(",");
        int amount = Integer.parseInt(splitLine[1]);
        if (splitLine[0].equals("supply")) {
            supplySum += amount;
        }else if (splitLine[0].equals("buy")) {
            buysum += amount;
        }
    } int result = supplySum - buysum;
        String report = "supply," + supplySum + "\n" + buysum + "\n" + result;
        Files.writeString(Path.of(toFileName), report);
    } catch (IOException e) {
        throw new RuntimeException("Can't handle files", e);
    }
    }
}
