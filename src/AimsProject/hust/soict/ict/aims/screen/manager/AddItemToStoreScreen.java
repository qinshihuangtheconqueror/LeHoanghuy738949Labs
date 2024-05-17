package AimsProject.hust.soict.ict.aims.screen.manager;

import AimsProject.hust.soict.ict.aims.store.Store;

import javax.swing.*;
import java.awt.*;


public abstract class AddItemToStoreScreen extends JPanel {
    protected Store store;
    protected JTextField idField, titleField, categoryField, costField;
    protected JPanel center = new JPanel();
    protected GridBagConstraints labelConstrains = new GridBagConstraints();
    protected GridBagConstraints fieldConstrains = new GridBagConstraints();
    public AddItemToStoreScreen(Store store) {
        this.store = store;
        center.setLayout(new GridBagLayout());

        labelConstrains.gridwidth = 1;
        labelConstrains.gridx = 0;
        labelConstrains.gridy = GridBagConstraints.RELATIVE;
        labelConstrains.anchor = GridBagConstraints.EAST;
        labelConstrains.insets = new Insets(2, 2, 2, 2);

        fieldConstrains.gridwidth = GridBagConstraints.REMAINDER;
        fieldConstrains.gridx = 1;
        fieldConstrains.fill = GridBagConstraints.HORIZONTAL;

        JLabel idLabel = new JLabel("ID: ");
        idField = new JTextField(20);

        JLabel titleLabel = new JLabel("Title: ");
        titleField = new JTextField(20);

        JLabel categoryLabel = new JLabel("Category:");
        categoryField = new JTextField(20);

        JLabel costLabel = new JLabel("Cost:");
        costField = new JTextField(20);

        center.add(idLabel, labelConstrains);
        center.add(idField, fieldConstrains);
        center.add(titleLabel, labelConstrains);
        center.add(titleField, fieldConstrains);
        center.add(categoryLabel, labelConstrains);
        center.add(categoryField, fieldConstrains);
        center.add(costLabel, labelConstrains);
        center.add(costField, fieldConstrains);

        add(center, BorderLayout.CENTER);


    }
    protected void addItemToStore(){

    };
}
