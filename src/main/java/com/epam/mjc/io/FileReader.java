package com.epam.mjc.io;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


public class FileReader {

    public Profile getDataFromFile(File file) {
        StringBuilder str = new StringBuilder();
        boolean fl = false;
        String[] par = new String[4];

        try (FileInputStream inputStream = new FileInputStream(file.getPath())) {
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

            par = str.toString().trim().split(" ");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new Profile(par[0], Integer.valueOf(par[1]), par[2], Long.valueOf(par[3]));
    }
}
