package com.from4.interviewQuestions.core.logging;

import com.from4.interviewQuestions.core.io.MyFile;

import java.io.*;
import java.util.logging.*;

class LogDemo {
    public static void main(String[] args) {
        handler();

        StreamHandlerDemo demo = new StreamHandlerDemo();
        demo.logMessage();
    }

    private final static Logger LOG = Logger.getLogger(LogDemo.class.getName());
    private static String file = MyFile.getFileOut1().getPath();


    static void handler() {
        try {
            FileOutputStream fout = new FileOutputStream(MyFile.getFileOut2(), true);
            ByteArrayOutputStream byteOStream = new ByteArrayOutputStream();
            StreamHandler streamHandler = new StreamHandler(byteOStream, new SimpleFormatter());
            streamHandler.setLevel(Level.ALL);
//            LOG.setUseParentHandlers(false);

            LOG.addHandler(new FileHandler(file, true));
            LOG.addHandler(streamHandler);


            LOG.log(Level.WARNING, "This is a warning.", new RuntimeException());
            LOG.log(Level.SEVERE, "This is a warning2.: {0}", file);
            LOG.info("Bye!");

            byteOStream.writeTo(System.out);
            byteOStream.close();
        } catch (IOException e) {
            LOG.log(Level.INFO, e.getMessage());
        }


    }

    static class StreamHandlerDemo {
        private StreamHandler handler = null;

        private OutputStream outStream = null;

        private Logger logger = Logger.getLogger("sam.logging");

        public StreamHandlerDemo() {
            outStream = System.out;

            handler = new StreamHandler(outStream, new SimpleFormatter());
            logger.addHandler(handler);
            logger.setUseParentHandlers(false);
        }

        public void logMessage() {
            logger.info("StreamHandler is working!");
        }

    }


}
