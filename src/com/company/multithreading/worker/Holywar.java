package com.company.multithreading.worker;

/**
 * Created by iMac on 02.08.17.
 */
class Holywar extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Egg");
        }
    }
}

class HolywarChicken {
    static Holywar egg;

    public static void main(String[] args) {
        egg = new Holywar();
        System.out.println("Holywar started");
        egg.start();
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Chicken");
        }
        if (egg.isAlive()) {
            try {
                egg.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Egg makes first");
        } else {
            System.out.println("Chicken makes first");
        }
        System.out.println("Holywar stopped");
    }
}


class EggVoice extends Thread
{
    @Override
    public void run()
    {
        for(int i = 0; i < 5; i++)
        {
            try{
                sleep(1000);		//Приостанавливает поток на 1 секунду
            }catch(InterruptedException e){}

            System.out.println("яйцо!");
        }
        //Слово «яйцо» сказано 5 раз
    }
}

class ChickenVoice	//Класс с методом main()
{
    static EggVoice mAnotherOpinion;	//Побочный поток

    public static void main(String[] args)
    {
        mAnotherOpinion = new EggVoice();	//Создание потока
        System.out.println("Спор начат...");
        mAnotherOpinion.start(); 			//Запуск потока

        for(int i = 0; i < 5; i++)
        {
            try{
                Thread.sleep(1000);		//Приостанавливает поток на 1 секунду
            }catch(InterruptedException e){}

            System.out.println("курица!");
        }

        //Слово «курица» сказано 5 раз

        if(mAnotherOpinion.isAlive())	//Если оппонент еще не сказал последнее слово
        {
            try{
                mAnotherOpinion.join();	//Подождать пока оппонент закончит высказываться.
            }catch(InterruptedException e){}

            System.out.println("Первым появилось яйцо!");
        }
        else	//если оппонент уже закончил высказываться
        {
            System.out.println("Первой появилась курица!");
        }
        System.out.println("Спор закончен!");
    }
}
