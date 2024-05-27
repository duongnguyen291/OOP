package ict.aimsprojectweek5.screen.manager;

import javax.swing.*;
import java.awt.*;
import ict.aimsprojectweek5.media.*;
import ict.aimsprojectweek5.store.*;
public class AddBookToStoreScreen extends AddItemToStoreScreen {
    private JLabel titleLabel;
    private JLabel categoryLabel;
    private JLabel authorLabel;
    private JLabel costLabel;
    private JLabel tokenLabel;
    private JTextField titleField;
    private JTextField categoryField;
    private JTextField authorField;
    private JTextField costField;
    private JTextField tokenField;
    private JButton addButton;

    public AddBookToStoreScreen(Store store) {
        super(store);
        addButton = new JButton("Add Book");
        
        titleLabel = new JLabel("Title:");
        categoryLabel = new JLabel("Category:");
        authorLabel = new JLabel("Author:");
        costLabel = new JLabel("Cost:");
        tokenLabel = new JLabel("Token:");

        titleField = new JTextField();
        categoryField = new JTextField();
        authorField = new JTextField();
        costField = new JTextField();
        tokenField = new JTextField();

        addComponents();
    }

    private void addComponents() {
        JPanel panel = new JPanel(); // Sử dụng JPanel để chứa các thành phần
        panel.setLayout(new GridLayout(6, 2)); // GridLayout cho sắp xếp đều các thành phần
        panel.add(titleLabel);
        panel.add(titleField);
        panel.add(categoryLabel);
        panel.add(categoryField);
        panel.add(authorLabel);
        panel.add(authorField);
        panel.add(costLabel);
        panel.add(costField);
        panel.add(tokenLabel);
        panel.add(tokenField);
        panel.add(addButton);

        frame.add(panel, BorderLayout.CENTER); // Thêm JPanel vào cửa sổ frame
        addButton.addActionListener(e -> addItemToStore()); // Xử lý sự kiện khi nút được nhấn
    }

    @Override
    protected void addItemToStore() {
        String title = titleField.getText();
        String category = categoryField.getText();
        String author = authorField.getText();
        float cost = Float.parseFloat(costField.getText());
        int token = Integer.parseInt(tokenField.getText());
        Book book = new Book(title, category, author, cost, token);
        store.addMedia(book);
        JOptionPane.showMessageDialog(frame, "Book added successfully."); // Thông báo khi sách được thêm
        StoreManagerScreen mainFrame = new StoreManagerScreen(store);
    }
    
}
