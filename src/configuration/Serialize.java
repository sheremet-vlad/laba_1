package configuration;

import main.Figure;
import main.Main_class;

import javax.swing.*;
import java.io.*;
import java.util.LinkedList;

import static configuration.ConfigurationForm.comboBoxTypes;
import static configuration.ConfigurationForm.usersList;

public class Serialize {
    public static void serializeNewUser(User user){
        try {
            BufferedReader reader = new BufferedReader(new FileReader("E:\\ВЛАД\\4_sem\\oop\\usersCount.txt"));
            int i = Integer.parseInt(reader.readLine());
            reader.close();

            FileOutputStream fos = new FileOutputStream("E:\\ВЛАД\\4_sem\\oop\\users.txt", true);
            ObjectOutputStream oos;
            if (i != 0) {
                oos = new AppendingObjectOutputStream(fos);
            }
            else {
                oos = new ObjectOutputStream(fos);
            }

            oos.writeObject(user);

            oos.flush();
            oos.close();

            usersList.add(user);
            comboBoxTypes.addItem(user.name);

            //write count if users
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
                usersList.add((User)oin.readObject());
            }

            oin.close();
            fis.close();

        }
        catch (StreamCorruptedException e){
            JOptionPane.showMessageDialog(Main_class.form,"Error data in file");
        }
        catch (EOFException ee) {
            JOptionPane.showMessageDialog(Main_class.form,"Empty file");
        }
        catch (Exception ee) {
            ee.printStackTrace();
        }
    }



}
