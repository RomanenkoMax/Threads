package it.dan;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class MultiThreads implements Runnable {
    @Override
    public void run() {

        String filePath = System.getProperty("user.dir") + System.getProperty("file.separator") + "Threads" + System.getProperty("file.separator") + "threads.txt";
        File file = new File(filePath);
        PrintWriter outputStream = null;
        String l = "I am the best " + Thread.currentThread().getName();

        try {

            outputStream = new PrintWriter(new FileWriter(file, true));
            outputStream.println(l);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (outputStream != null) {
                outputStream.close();
            }
        }

    }

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {

            Thread thread = new Thread(new MultiThreads());
            thread.start();
            if (thread.isAlive()){
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
