package com.pretestsele2.utils;

import com.pretestsele2.common.Constants;
import com.pretestsele2.exceptions.FrameworkException;
import com.pretestsele2.exceptions.InvalidPathForExtentReportFileException;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public final class ReportUtils {
    private ReportUtils() {
    }

    public static String createExtentReportPath() {
        String link;
        if (Constants.OVERRIDE_REPORTS.trim().equals("no")) {
            System.out.println("OVERRIDE_REPORTS = " + Constants.OVERRIDE_REPORTS);
            link = Constants.EXTENT_REPORT_FOLDER_PATH + "/" + DateUtils.getCurrentDate() + "_"
                    + Constants.EXTENT_REPORT_FILE_NAME;
        } else {
            link = Constants.EXTENT_REPORT_FOLDER_PATH + "/" + Constants.EXTENT_REPORT_FILE_NAME;
        }
        System.out.println("Created link report: " + link);

        return link;
    }

    public static void openReports(String linkReport) {
        if (Constants.OPEN_REPORTS_AFTER_EXECUTION.trim().equalsIgnoreCase("yes")) {
            try {
                Desktop.getDesktop().browse(new File(linkReport).toURI());
            } catch (FileNotFoundException fileNotFoundException) {
                throw new InvalidPathForExtentReportFileException("Extent Report file you are trying to reach is not found", fileNotFoundException.fillInStackTrace());
            } catch (IOException ioException) {
                throw new FrameworkException("Extent Report file you are trying to reach got IOException while reading the file", ioException.fillInStackTrace());
            }
        }
    }
}
