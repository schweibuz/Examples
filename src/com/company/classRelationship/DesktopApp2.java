package com.company.classRelationship;

/**
 * Created by iMac on 01.08.17.
 * Используется Композиция
 */
class DesktopApp2 {
    public static void main(String[] args) {
        Processor proc = new Processor(3.7);
        VideoCard card = new VideoCard(4096);

        Computer computer = new Computer("iMac 21.5 inches", proc, card);

        System.out.println(computer);

        String str = (computer.getProcessor().getNameOfSystem() + " " +
        computer.getProcessor().getModification() + " " +
        computer.getVideoCard().getNameOfSystem() + " " +
        computer.getVideoCard().getModification());

        System.out.println(str);
    }
}

//---------------------------------------------------------------------------
class Computer {
    private String name;
    private Processor processor;
    private VideoCard videoCard;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Processor getProcessor() {
        return processor;
    }

    public void setProcessor(Processor processor) {
        this.processor = processor;
    }

    public VideoCard getVideoCard() {
        return videoCard;
    }

    public void setVideoCard(VideoCard videoCard) {
        this.videoCard = videoCard;
    }

    Computer(String name, Processor proc, VideoCard vCard) {
        if (name != null && proc.getFrequency() > 0 && vCard.getCapacity() > 0) {
            this.setName(name);
            this.setProcessor(proc);
            this.setVideoCard(vCard);
        }
    }

    @Override
    public String toString() {
        return "Computer{" +
                "name='" + name + '\'' +
                ", processor=" + processor +
                ", videoCard=" + videoCard +
                '}';
    }
}

//---------------------------------------------------------------------------
class Processor implements getCurrentMethod {
    private double frequency;

    Processor(double mghz) {
        this.setFrequency(mghz);
    }

    public double getFrequency() {
        return frequency;
    }

    public void setFrequency(double frequency) {
        this.frequency = frequency;
    }

    @Override
    public String getNameOfSystem() {
        return "Intel";
    }

    @Override
    public String getModification() {
        return "i5";
    }

    @Override
    public String toString() {
        return "Processor{" +
                "frequency=" + frequency +
                '}';
    }
}

//---------------------------------------------------------------------------
class VideoCard implements getCurrentMethod {
    private int capacity;

    VideoCard(int gb) {
        this.setCapacity(gb);
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String getNameOfSystem() {
        return "NVIDIA";
    }

    @Override
    public String getModification() {
        return "GeForce";
    }

    @Override
    public String toString() {
        return "VideoCard{" +
                "capacity=" + capacity +
                '}';
    }
}

//---------------------------------------------------------------------------
interface getCurrentMethod {
    String getNameOfSystem();
    String getModification();
}