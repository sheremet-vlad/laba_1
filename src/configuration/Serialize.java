package configuration;

import main.Figure;

import java.io.*;
import java.util.LinkedList;

public class Serialize {
    public static void serializeNewUser(User user){
        try {
            FileOutputStream fos = new FileOutputStream("E:\\ВЛАД\\4_sem\\oop\\users.txt", true);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(user);

            oos.flush();
            oos.close();

            //write count if figure
            BufferedReader reader = new BufferedReader(new FileReader("E:\\ВЛАД\\4_sem\\oop\\usersCount.txt"));
            int i = Integer.parseInt(reader.readLine());
            reader.close();

            BufferedWriter writer = new BufferedWriter(new FileWriter("E:\\ВЛАД\\4_sem\\oop\\usersCount.txt"));
            writer.write(++i+"");
            writer.flush();
            writer.close();
        }
        catch (Exception ee){
            ee.printStackTrace();
        }
    }


    public static void deserializeUsers(LinkedList<User> usersList){
        try {
            BufferedReader reader = new BufferedReader(new FileReader("E:\\ВЛАД\\4_sem\\oop\\usersCount.txt"));
            int figureCount = Integer.parseInt(reader.readLine());

            reader.close();

            FileInputStream fis = new FileInputStream("E:\\ВЛАД\\4_sem\\oop\\users.txt");
            ObjectInputStream oin = new ObjectInputStream(fis);
            for (int i = 0; i < figureCount; i++) {
                usersList.add((User) oin.readObject());
            }

            oin.close();
            fis.close();

        }
        catch (Exception ee) {
            ee.printStackTrace();
        }
    }



}
