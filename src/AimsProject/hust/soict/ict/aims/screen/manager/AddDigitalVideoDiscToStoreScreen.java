package AimsProject.hust.soict.ict.aims.screen.manager;

import AimsProject.hust.soict.ict.aims.media.DigitalVideoDisc;
import AimsProject.hust.soict.ict.aims.store.Store;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {
    private JTextField lengthField;
    private JTextField directorField;
    private JButton addButton;
    public AddDigitalVideoDiscToStoreScreen(Store store) {
        super(store);

        JLabel lengthLabel = new JLabel("Length:");
        lengthField = new JTextField(20);

        JLabel directorLabel = new JLabel("Director:");
        directorField = new JTextField(20);

        addButton = new JButton("Add DVD");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addItemToStore();
                JOptionPane.showMessageDialog(null,"New DVD has been added");;
            }
        });

        center.add(lengthLabel, labelConstrains);
        center.add(lengthField, fieldConstrains);
        center.add(directorLabel, labelConstrains);
        center.add(directorField, fieldConstrains);
        center.add(addButton, fieldConstrains);

    }

    @Override
    protected void addItemToStore() {
        int id = Integer.parseInt(idField.getText());
        String title = titleField.getText();
        String category = categoryField.getText();
        float cost = Float.parseFloat(costField.getText());
        int length = Integer.parseInt(lengthField.getText());
        String director = directorField.getText();

        DigitalVideoDisc dvd = new DigitalVideoDisc(id, title, category, cost, length, director);
        store.addMedia(dvd);
        idField.setText("");
        titleField.setText("");
        categoryField.setText("");
        costField.setText("");
        lengthField.setText("");
        directorField.setText("");

    }
    public static void main(String[] args) {
        Store store = new Store();
        AddDigitalVideoDiscToStoreScreen addDVDScreen = new AddDigitalVideoDiscToStoreScreen(store);
        addDVDScreen.setVisible(true);
    }
}
