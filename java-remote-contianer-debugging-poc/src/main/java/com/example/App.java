package com.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        if (args.length != 2) {
            System.err.println("Usage: java -jar app.jar <archiveFile> <archiveOutput>");
            System.exit(1);
        }

        String archiveFile = args[0];
        String archiveOutput = args[1];

        try {
            ArchiveHelper.extract(archiveFile, archiveOutput);
            System.out.println("Extraction completed.");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Failed to extract archive.");
        }
    }
}