package com.urfan.project.decathlon.Utils;

import com.urfan.project.decathlon.utils.CSVReader;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class CSVReaderTest {

    private File file;

    @Before
    public void setUp() {
        ClassLoader classLoader = getClass().getClassLoader();
        file  = new File(classLoader.getResource("testData.txt").getFile());
    }

    @Test
    public void loadFileTest() throws IOException {
        List<List<String>> result = new CSVReader().loadFile(file.getAbsolutePath());
        assertFalse(result.isEmpty());
        assertEquals(5, result.size());
        assertEquals(11, result.get(0).size());
    }
}
