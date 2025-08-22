package org.firstinspires.ftc.teamcode.util;

import android.os.Environment;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {
    private static File logFile;

    public static void init(String filename) {
        File dir = new File(Environment.getExternalStorageDirectory(), "FIRST/logs");
        if (!dir.exists()) dir.mkdirs();
        logFile = new File(dir, filename);

        try {
            if (!logFile.exists()) logFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void log(String message) {
        if (logFile == null) return;

        try (FileWriter writer = new FileWriter(logFile, true)) {
            String timestamp = new SimpleDateFormat("HH:mm:ss.SSS").format(new Date());
            writer.write(timestamp + " - " + message + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
