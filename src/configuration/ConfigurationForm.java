package configuration;

import main.Form;
import main.Main_class;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.util.LinkedList;

import static create_gui_form.SwingConsole.run;
import static create_gui_form.SwingConsole.run1;

public class ConfigurationForm extends JFrame{
    public static JComboBox comboBoxTypes;
    private static JButton buttonChoose = new JButton("Выбрать");
    private static JButton buttonNewUser = new JButton("Создать нового");

    public static LinkedList<User> usersList = new LinkedList<>();

    public ConfigurationForm() {
        setLayout(null);

        Serialize.deserializeUsers(usersList);
        String[] namesList = new String[usersList.size()];
        getUsersName(namesList);

        comboBoxTypes = new JComboBox(namesList);

        add(comboBoxTypes).setBounds(10,10,180,30);
        add(buttonChoose).setBounds(10,60,180,30);
        add(buttonNewUser).setBounds(10,110,180,30);

        componentsAction();
    }

    private static void getUsersName(String[] namesList) {

        int index = 0;

        for (User temp : usersList) {
            namesList[index] = temp.name;
            index++;
        }
    }

    public static void componentsAction() {
        buttonChoose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    User user = usersList.get(comboBoxTypes.getSelectedIndex());
                    run(new Form(user.language, user.color), 668, 700);
                } catch (IndexOutOfBoundsException ee) {
                    JOptionPane.showMessageDialog(Main_class.form, "Empty file");
                }
            }
        });

        buttonNewUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                run1(new NewUser(),200,200);
            }
        });
    }
}
