package com.urfan.project.decathlon.utils;

import java.io.IOException;
import java.util.List;

public interface FileRead {
    List<List<String>> loadFile(String fileName) throws IOException;
}
