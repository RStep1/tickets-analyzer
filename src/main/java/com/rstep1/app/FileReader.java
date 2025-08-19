package com.rstep1.app;

import java.util.List;

public interface FileReader<T> {
    List<T> read(String filePath);
}
