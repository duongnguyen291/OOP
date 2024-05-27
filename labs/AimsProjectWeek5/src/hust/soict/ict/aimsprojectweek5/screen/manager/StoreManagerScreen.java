package ict.aimsprojectweek5.screen.manager;

import ict.aimsprojectweek5.media.*;
import ict.aimsprojectweek5.store.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class StoreManagerScreen extends JFrame {
    private Store store;

    public static void main(String[] args) {
        Store store = new Store();
        store.initData();
        StoreManagerScreen mainFrame = new StoreManagerScreen(store);
    }

    public StoreManagerScreen(Store store) {
        this.store = store;
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);
        setTitle("Store");
        setSize(1024, 768);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    JPanel createNorth() {
        JPanel north = new JPanel();
        // north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.setLayout(new BorderLayout() );
        north.add(createMenuBar(),BorderLayout.NORTH);
        north.add(createHeader(),BorderLayout.CENTER);
        return north;
    }

    JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Option");
        JMenuItem viewStoreItem = new JMenuItem("View Store");
        viewStoreItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Switch to View Store Screen
                dispose();
                new StoreManagerScreen(store);
            }
        });
        menu.add(viewStoreItem);

        JMenu smUpdateStore = new JMenu("Update Store");
        JMenuItem addBookItem = new JMenuItem("Add Book");
        addBookItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Switch to Add Book Screen
                dispose();
                AddBookToStoreScreen temp = new AddBookToStoreScreen(store);
                temp.display();

            }
        });
        smUpdateStore.add(addBookItem);

        JMenuItem addCDItem = new JMenuItem("Add CD");
        addCDItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Switch to Add CD Screen
                dispose();
                AddCDToStoreScreen temp = new AddCDToStoreScreen(store);
                temp.display();


            }
        });
        smUpdateStore.add(addCDItem);

        JMenuItem addDVDItem = new JMenuItem("Add DVD");
        addDVDItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Switch to Add DVD Screen
                dispose();
                AddDVDToStoreScreen temp = new AddDVDToStoreScreen(store);
                temp.display();

            }
        });
        smUpdateStore.add(addDVDItem);

        menu.add(smUpdateStore);
        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new BorderLayout());
        menuBar.add(menu,BorderLayout.WEST);
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

    JScrollPane createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridBagLayout());
        center.setBackground(new Color(171,219,227));
        ArrayList<Media> mediaInStore = store.getItemsInStore();
        if (!mediaInStore.isEmpty()) {
            int itemsToShow = mediaInStore.size();
            for (int i = 0; i < itemsToShow; i++) {
                GridBagConstraints gbc = new GridBagConstraints();
                gbc.gridx = i % 3;
                gbc.gridy = i / 3;
                gbc.insets = new Insets(5, 5, 5, 5); // Khoảng cách giữa các ô
                gbc.fill = GridBagConstraints.BOTH; // Ô đủ lớn để điền toàn bộ không gian
                gbc.weightx = 1.0; // Chia đều không gian theo chiều ngang
                gbc.weighty = 1.0; // Chia đều không gian theo chiều dọc
    
                MediaStore cell = new MediaStore(mediaInStore.get(i));
                cell.setPreferredSize(new Dimension(320, 120)); // Cố định kích thước cell, ví dụ: rộng 200px và cao 100px
                center.add(cell, gbc);
            }
        }
    
        JScrollPane scrollPane = new JScrollPane(center);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    
        return scrollPane;
    }
    
}