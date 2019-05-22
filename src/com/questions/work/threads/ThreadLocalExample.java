package com.questions.work.threads;

class ThreadLocalExample {
    static class MyRunnable implements Runnable {
        //Вся фишка ThreadLocal заключается в том что имея всего одну ThreadLocal переменную,
// мы можем иметь различное значение для каждого из потоков, то есть один поток никогда
// не прочтет, удалит или не перезатрет данные присвоенные другим потоком. Таким образом
// несмотря на разделяемую статическую переменную код выше потоко-безопасен.
        private ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>();

        @Override
        public void run() {
            threadLocal.set((int) (Math.random() * 100D));
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
            }
            System.out.println(threadLocal.get());
        }
    }

    public static void main(String[] args) {
        MyRunnable sharedRunnableInstance = new MyRunnable();
        Thread thread1 = new Thread(sharedRunnableInstance);
        Thread thread2 = new Thread(sharedRunnableInstance);

        thread1.start();
        thread2.start();

        try {
            thread1.join(); //wait for thread 1 to terminate
            thread2.join(); //wait for thread 2 to terminate
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}