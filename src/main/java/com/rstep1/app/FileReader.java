package com.rstep1.app;

import java.io.IOException;
import java.util.List;

public interface FileReader<T> {
    List<T> read(String filePath) throws IOException;
}
