package com.epam.mjc.io;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;


public class FileReader {

    public Profile getDataFromFile(File file) {
        StringBuilder str = new StringBuilder();
        boolean fl = false;

        try (FileInputStream inputStream = new FileInputStream(file.getAbsolutePath())) {
            int ch;
            while ((ch = inputStream.read()) != -1) {
                if ((char)ch == ':' || (char)ch == '\r') {
                    fl = !fl;
                } else {
                    if (fl) {
                        str.append((char)ch);
                    }
                }
            }

            String[] par = new String[4];
            par = str.toString().trim().split(" ");

            return new Profile(par[0], Integer.valueOf(par[1]), par[2], Long.valueOf(par[3]));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
