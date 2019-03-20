package com.urfan.project.decathlon.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CSVReader implements FileRead{

    public List<List<String>> loadFile(String fileName) throws IOException {
        try {
            File file = new File(fileName);
            return Files.lines(file.toPath()).map(line -> Arrays.asList(line.split(";")))
                    .collect(Collectors.toList());
        } catch (IOException ioe) {
            throw new IOException("Failed to read data file " + fileName);
        }
    }

}