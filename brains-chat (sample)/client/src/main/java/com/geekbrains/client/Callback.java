package com.geekbrains.client;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface Callback {
    void callback(Object... args) throws IOException;
}
