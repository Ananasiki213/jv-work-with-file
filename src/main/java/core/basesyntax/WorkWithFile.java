package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class WorkWithFile {
    public void getStatistic(String fromFileName, String toFileName) {
        int supplySum = 0;
        int buySum = 0;

        try {
            List<String> lines = Files.readAllLines(Paths.get(fromFileName));
            for (String line : lines) {
                String[] splitLine = line.split(",");
                int amount = Integer.parseInt(splitLine[1]);

                if (splitLine[0].equals("supply")) {
                    supplySum += amount;
                } else if (splitLine[0].equals("buy")) {
                    buySum += amount;
                }
            }

            int result = supplySum - buySum;
            String report = "supply," + supplySum + System.lineSeparator()
                    + "buy," + buySum + System.lineSeparator()
                    + "result," + result;
            Files.writeString(Path.of(toFileName), report);
        } catch (IOException e) {
            throw new RuntimeException("Can't handle files!", e);
        }
    }
}
