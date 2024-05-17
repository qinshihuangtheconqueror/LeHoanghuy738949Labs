package AimsProject.hust.soict.ict.aims.screen.manager;

import AimsProject.hust.soict.ict.aims.media.Media;
import AimsProject.hust.soict.ict.aims.store.Store;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class StoreManagerScreen extends JFrame {
    private Store store;
    private JPanel north;
    private JPanel center;
    private JScrollPane scrollPane;
    JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Option");

        JMenuItem viewItem = new JMenuItem("View Store");

        JMenu smUpdateStore = new JMenu("Update Store");

        JMenuItem addBookItem = new JMenuItem("Add Book");
        JMenuItem addCDItem = new JMenuItem("Add CD");
        JMenuItem addDVDItem = new JMenuItem("Add DVD");
        addBookItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e ) {
                switchAddScreen(new AddBookToStoreScreen(store));
            }
        });

        addDVDItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchAddScreen(new AddDigitalVideoDiscToStoreScreen(store));
            }
        });

        addCDItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchAddScreen(new AddCompactDiscToStoreScreen(store));
            }
        });

        viewItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchStoreScreen();
            }
        });

        smUpdateStore.add(addBookItem);
        smUpdateStore.add(addCDItem);
        smUpdateStore.add(addDVDItem);

        menu.add(viewItem);
        menu.add(smUpdateStore);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);

        return menuBar;
    }

    JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.CYAN);

        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(Box.createRigidArea(new Dimension(10, 10)));

        return header;
    }

    JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridBagLayout());
        center.setBackground(new Color(141,179,237));
        ArrayList<Media> mediaInStore = store.getItemsInStore();
        if (!mediaInStore.isEmpty()) {
            int itemsToShow = mediaInStore.size();
            for (int i = 0; i < itemsToShow; i++) {
                GridBagConstraints mediaConstraints = new GridBagConstraints();
                mediaConstraints.gridx = i % 3;
                mediaConstraints.gridy = i / 3;
                mediaConstraints.insets = new Insets(5, 5, 5, 5); // Khoảng cách giữa các ô
                mediaConstraints.fill = GridBagConstraints.BOTH; // Ô đủ lớn để điền toàn bộ không gian
                mediaConstraints.weightx = 1.0; // Chia đều không gian theo chiều ngang
                mediaConstraints.weighty = 1.0; // Chia đều không gian theo chiều dọc

                MediaStore cell = new MediaStore(mediaInStore.get(i));
                cell.setPreferredSize(new Dimension(320, 120)); // Cố định kích thước cell, ví dụ: rộng 200px và cao 100px
                center.add(cell, mediaConstraints);
            }
        }
        return center;
    }

    private void switchAddScreen(JPanel panel){
        getContentPane().remove(scrollPane);
        getContentPane().remove(center);
        this.center = panel;
        getContentPane().add(center, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    private void switchStoreScreen(){
        getContentPane().remove(center);
        this.center = createCenter();
        scrollPane = new JScrollPane(center);
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        revalidate();
        repaint();
    }


    public StoreManagerScreen(Store store) {
        this.store = store;

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        this.north = createNorth();
        this.center = createCenter();

        scrollPane = new JScrollPane(center);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        cp.add(north, BorderLayout.NORTH);
        cp.add(scrollPane, BorderLayout.CENTER);

        setTitle("Store");
        setSize(1024, 768);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}