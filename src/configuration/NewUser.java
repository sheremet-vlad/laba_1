package configuration;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewUser extends JFrame{

    private JComboBox comboBoxLanguage;
    private JComboBox comboBoxColor;
    private JTextField fieldName = new JTextField(10);
    private JButton buttonCreate = new JButton("Создать");


    public NewUser(){
        String[] languageTypes = {"Русский","English"};
        String[] backgroundTypes = {"Белый", "Синий", "Красный"};

        comboBoxColor = new JComboBox(backgroundTypes);
        comboBoxLanguage = new JComboBox(languageTypes);

        setLayout(null);
        add(comboBoxColor).setBounds(10,10,100,30);
        add(comboBoxLanguage).setBounds(10,50,100,30);
        add(fieldName).setBounds(10,90,100,30);
        add(buttonCreate).setBounds(10,130,100,30);

        componentsAction();
    }

    private void componentsAction(){
        buttonCreate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!comboBoxColor.getSelectedItem().equals("")
                        && !comboBoxLanguage.getSelectedItem().equals("")
                        && !fieldName.getText().equals("")) {
                    User user = new User();
                    user.color = comboBoxColor.getSelectedItem() + "";
                    user.language = comboBoxLanguage.getSelectedItem() + "";
                    user.name = fieldName.getText();
                    Serialize.serializeNewUser(user);
                    dispose();
                }
            }
        });
    }

}
