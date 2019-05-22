package com.company.http;

import java.io.IOException;

/**
 * Created by zzheads on 18.11.16.
 */
interface DownloaderInterface {
    byte[] getFile(String pathToURL) throws IOException;
}