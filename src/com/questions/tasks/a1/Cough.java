package com.questions.tasks.a1;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * Created by iMac on 06/01/2018.
 */
class Cough {
    public static void main(String[] args) {
        formatter = new SimpleFormatter();
        try {
            fileHandler = new FileHandler("/Users/user/Documents/IdeaProjects/SomeCode/src/" +
                    "resources/log/coughTimeLog.txt", true);
            LOGGER.addHandler(fileHandler);
            fileHandler.setFormatter(formatter);
        } catch (IOException e) {
            e.printStackTrace();
        }
//        Calendar calendar;
//        SimpleDateFormat hms = new SimpleDateFormat("HH:mm:ss");
        for (int i = 0; i < 10000; i++) {
            play();
//            calendar = Calendar.getInstance();
//            System.out.println(hms.format(calendar.getTime()));
//            LOGGER.log(Level.INFO, String.valueOf(hms.format(calendar.getTime())));
        }
    }

    private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    private static SimpleFormatter formatter;
    private static FileHandler fileHandler;
    private static int counter = 0;
    private static long sleeping = 0;

    //            File soundFile1 = new File("/Users/iMac/Documents/JavaCode/AtTheEndOfTheWeek/src/resources/audio/1.wav");
    private static File soundFile1 = new File("/Users/user/Documents/IdeaProjects/SomeCode/src/resources/audio/1.wav");
    private static File soundFile2 = new File("/Users/user/Documents/IdeaProjects/SomeCode/src/resources/audio/2.wav");
    private static File soundFile3 = new File("/Users/user/Documents/IdeaProjects/SomeCode/src/resources/audio/3.wav");
    private static File soundFile4 = new File("/Users/user/Documents/IdeaProjects/SomeCode/src/resources/audio/4.wav");
    private static AudioInputStream ais = null;

    private static void play() {
        try {

            if (counter % 2 == 0) {
                if (counter % 4 == 0) {
                    ais = AudioSystem.getAudioInputStream(soundFile4);
                    LOGGER.log(Level.INFO, "4");
                    counter++;
                } else {
                    ais = AudioSystem.getAudioInputStream(soundFile2);
                    LOGGER.log(Level.INFO, "2");
                    counter++;
                }
            } else if (counter % 2 == 1) {
                if (counter % 3 == 0) {
                    ais = AudioSystem.getAudioInputStream(soundFile3);
                    LOGGER.log(Level.INFO, "3");
                    counter++;
                } else {
                    ais = AudioSystem.getAudioInputStream(soundFile1);
                    LOGGER.log(Level.INFO, "1");
                    counter++;
                }
            }
            Clip clip = AudioSystem.getClip();
            clip.open(ais);
            clip.setFramePosition(0);
            clip.start();
//            Thread.sleep(clip.getMicrosecondLength() / 1000);
            if (counter % 10 == 0) {
                sleeping = (clip.getMicrosecondLength() / 1000);
                System.out.println("this 10");
            } else if (counter % 11 == 0) {
                sleeping = (clip.getMicrosecondLength() / 1000);
                System.out.println("this 11");
            } else if (counter % 12 == 0) {
                sleeping = (clip.getMicrosecondLength() / 1000);
                System.out.println("this 12");
            } else if (counter % 13 == 0) {
                sleeping = (clip.getMicrosecondLength() / 1000);
                System.out.println("this 13");
            } else if (counter % 18 == 0) {
                sleeping = (clip.getMicrosecondLength() / 1000);
                System.out.println("this 18");
            } else {
                sleeping = (long) (90000 + (Math.random() * 500000));
            }
            Thread.sleep(sleeping);
            clip.stop();
            clip.close();
        } catch (IOException | UnsupportedAudioFileException | LineUnavailableException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
