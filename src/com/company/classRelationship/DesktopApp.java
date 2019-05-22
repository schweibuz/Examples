package com.company.classRelationship;

/**
 * Created by iMac on 01.08.17.
 * Используется Наследование
 */
class DesktopApp {
    public static void main(String[] args) {
        Notebook notebook = new Notebook(123123);

        CDRom cdRom = new CDRom(notebook.getSerialNumber(), "Seagate");
        System.out.println(cdRom);

        HDD hdd = new HDD(notebook.getSerialNumber(),64000);
        System.out.println(hdd);

        Notebook neoNotebook = new Notebook(notebook.getSerialNumber(), cdRom, hdd);
        System.out.println(neoNotebook);

        neoNotebook.cdRom.readInfo();
        neoNotebook.hdd.saveInfo();
        neoNotebook.hdd.readInfo();
        neoNotebook.cdRom.saveInfo();

        notebook.off();
    }
}

//---------------------------------------------------------------------------
class Notebook {
    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    private int serialNumber;
    Notebook(int serialNumber) {
        if (serialNumber <= 0) {
            throw new IllegalArgumentException("Неправильно введён id: " + serialNumber);
        } else {
            setSerialNumber(serialNumber);
        }
    }

    CDRom cdRom;
    HDD hdd;
    Notebook(int notebook, CDRom cdRom, HDD hdd) {
        if (cdRom == null || hdd == null || notebook <= 0)
            throw new IllegalArgumentException("Impossible create.");
        else
        this.cdRom = cdRom;
        this.hdd = hdd;
        this.serialNumber = notebook;
    }

    @Override
    public String toString() {
        return "Notebook{" +
                "serialNumber=" + serialNumber +
                ", cdRom=" + cdRom +
                ", hdd=" + hdd +
                '}';
    }

    void off() {
        System.out.println("Завершаю работу.");
    }
}

//---------------------------------------------------------------------------
class CDRom extends Notebook implements SomeMethod{

    String cdMaker;
    CDRom(int serialNumber, String cdMaker) {
        super(serialNumber);
        this.cdMaker = cdMaker;
    }

    @Override
    public String toString() {
        return "CDRom{" +
                "cdMaker='" + cdMaker + '\'' +
                '}';
    }

    @Override
    public void readInfo() {
        System.out.println("Читаю диск.");
    }

    @Override
    public void saveInfo() {
        System.out.println("Записываю диск.");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CDRom cdRom = (CDRom) o;

        return cdMaker != null ? cdMaker.equals(cdRom.cdMaker) : cdRom.cdMaker == null;
    }

    @Override
    public int hashCode() {
        return cdMaker != null ? cdMaker.hashCode() : 0;
    }
}

//---------------------------------------------------------------------------
class HDD extends Notebook implements SomeMethod{

    int hddCapacity = 16;
    HDD(int serialNumber, int hddCapacity) {
        super(serialNumber);
        if (hddCapacity <= 0)
            throw new IllegalArgumentException();
        this.hddCapacity = hddCapacity;
    }

    @Override
    public String toString() {
        return "HDD{" +
                "hddCapacity=" + hddCapacity +
                '}';
    }

    @Override
    public void saveInfo() {
        System.out.println("Сохраняю информацию.");
    }


    @Override
    public void readInfo() {
        System.out.println("Читаю информацию.");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HDD hdd = (HDD) o;

        return hddCapacity == hdd.hddCapacity;
    }

    @Override
    public int hashCode() {
        return hddCapacity;
    }
}

//---------------------------------------------------------------------------
interface SomeMethod {
    void readInfo();
    void saveInfo();
}