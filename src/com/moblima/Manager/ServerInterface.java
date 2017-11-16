package com.moblima.Manager;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.FileInputStream;

public final class ServerInterface{
    private static ServerInterface INSTANCE = new ServerInterface();

    private ServerInterface(){};

    public static ServerInterface getINSTANCE() {
        return INSTANCE;
    }

    public int RewriteLine(File DatabaseFile, String OldString, String NewString) throws IOException{
        if (!DatabaseFile.exists())
            return 1;
        List<String> fileContent = new ArrayList<String>(Files.readAllLines(DatabaseFile.toPath(), StandardCharsets.UTF_8));
        for (int i = 0; i < fileContent.size(); i++){
            if (fileContent.get(i).equals(OldString)){
                fileContent.set(i, NewString);
                Files.write(DatabaseFile.toPath(), fileContent, StandardCharsets.UTF_8);
                return 0;
            }
        }
        return 2;
    }

    public int NewLine(File DatabaseFile, String LineData) throws IOException{
        if (!DatabaseFile.exists())
            return 1;
        Files.write(DatabaseFile.toPath(), LineData.getBytes(), StandardOpenOption.APPEND);
        return 0;
    }

    public int DeleteLine(File DatabaseFile, String DeletedLine) throws IOException{
        if (!DatabaseFile.exists())
            return 1;
        List<String> fileContent = new ArrayList<String>(Files.readAllLines(DatabaseFile.toPath(), StandardCharsets.UTF_8));
        for (int i = 0; i < fileContent.size(); i++){
            if (fileContent.get(i).equals(DeletedLine)){
                fileContent.remove(i);
                Files.write(DatabaseFile.toPath(), fileContent, StandardCharsets.UTF_8);
                return 0;
            }
        }
        return 2;
    }

    public ArrayList<String> ReadFile(File DatabaseFile) throws IOException{
        ArrayList<String> data = new ArrayList<String>();
        if (!DatabaseFile.exists())
            return data;
        Scanner sc = new Scanner(new FileInputStream(DatabaseFile));
        try {
            while (sc.hasNextLine()){
                String StringData = sc.nextLine();
                if (!StringData.isEmpty())
                    data.add(StringData);
            }
        }
        finally {
            sc.close();
        }
        return data;
    }

}
