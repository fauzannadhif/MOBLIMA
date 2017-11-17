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

/**
 * Represents a class with methods for
 * applications to access a database file.
 */
public final class ServerInterface{
    private static ServerInterface INSTANCE = new ServerInterface();

    /**
     * Default constructor.
     */
    private ServerInterface(){};

    /**
     * Gets an instance of this class.
     */
    public static ServerInterface getINSTANCE() {
        return INSTANCE;
    }

    /**
     * Rewrites a line in a database file.
     * @param DatabaseFile the database file.
     * @param OldString the old line to be deleted.
     * @param NewString the new line to be written.
     */
    public int RewriteLine(File DatabaseFile, String OldString, String NewString) throws IOException{
        if (!DatabaseFile.exists())
            return 1;
        if (OldString.isEmpty())
            return 3;
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

    /**
     * Creates a new line in a database file.
     * @param DatabaseFile the database file.
     * @param LineDate the new line to be added.
     */
    public int NewLine(File DatabaseFile, String LineData) throws IOException{
        if (!DatabaseFile.exists())
            return 1;
        LineData = "\n"+LineData;
        Files.write(DatabaseFile.toPath(), LineData.getBytes(), StandardOpenOption.APPEND);
        return 0;
    }

    /**
     * Deletes a line in a database file.
     * @param DatabaseFile the database file.
     * @param DeletedLine the line to be deleted.
     */
    public int DeleteLine(File DatabaseFile, String DeletedLine) throws IOException{
        if (!DatabaseFile.exists())
            return 1;
        if (DeletedLine.isEmpty())
            return 3;
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

    /**
     * Reads a database file.
     * @param DatabaseFile the database file.
     * @return the list of string of each line read from the file.
     */
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
