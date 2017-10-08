package com.example.menu;

import java.io.IOException;

public interface IMenu {

    String create() throws IOException;

    void delete();

    void query();
}
