package com.example;

import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveInputStream;
import java.io.*;
import java.nio.file.*;

public class ArchiveHelper {
    public static void extract(String archivePath, String destDir) throws IOException {
        try (InputStream is = Files.newInputStream(Paths.get(archivePath));
             ZipArchiveInputStream zis = new ZipArchiveInputStream(is)) {

            ArchiveEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                String entryName = entry.getName();

                // Skip macOS metadata files
                if (entryName.startsWith("__MACOSX") || entryName.contains("._")) {
                    continue;
                }

                File f = new File(destDir, entryName);
                if (entry.isDirectory()) {
                    f.mkdirs();
                } else {
                    f.getParentFile().mkdirs();
                    try (OutputStream os = new FileOutputStream(f)) {
                        byte[] buffer = new byte[1024];
                        int len;
                        while ((len = zis.read(buffer)) > 0) {
                            os.write(buffer, 0, len);
                        }
                    }
                }
            }
        }
    }
}
