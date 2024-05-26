package aims.manager;

import javax.swing.*;
import aims.store.*;
import aims.media.*;
import java.awt.*;
public class AddCDToStoreScreen extends AddItemToStoreScreen {
    private JLabel titleLabel;
    private JLabel categoryLabel;
    private JLabel artistLabel;
    private JLabel directorLabel;
    private JLabel costLabel;
    private JLabel lengthLabel;
    private JTextField titleField;
    private JTextField categoryField;
    private JTextField artistField;
    private JTextField directorField;
    private JTextField costField;
    private JTextField lengthField;
    private JButton addButton; 
    public AddCDToStoreScreen(Store store) {
        super(store);
        addButton = new JButton("Add CD"); // Initialize the addButton


        titleLabel = new JLabel("Title:");
        categoryLabel = new JLabel("Category:");
        artistLabel = new JLabel("Artist:");
        directorLabel = new JLabel("Director:");
        costLabel = new JLabel("Cost:");
        lengthLabel = new JLabel("Length:");

        titleField = new JTextField();
        categoryField = new JTextField();
        artistField = new JTextField();
        directorField = new JTextField();
        costField = new JTextField();
        lengthField = new JTextField();

        addComponents();
    }

    private void addComponents() {
        JPanel panel = new JPanel(); // Sử dụng JPanel để chứa các thành phần
        panel.setLayout(new GridLayout(7, 2)); // GridLayout cho sắp xếp đều các thành phần
        panel.add(titleLabel);
        panel.add(titleField);

        panel.add(categoryLabel);
        panel.add(categoryField);

        panel.add(artistLabel);
        panel.add(artistField);

        panel.add(directorLabel); 
        panel.add(directorField);

        panel.add(costLabel);
        panel.add(costField);

        panel.add(lengthLabel);
        panel.add(lengthField);
        
        panel.add(addButton);
        frame.add(panel, BorderLayout.CENTER); // Thêm JPanel vào cửa sổ frame
        addButton.addActionListener(e -> addItemToStore()); // Xử lý sự
    }

    @Override
    protected void addItemToStore() {
        String title = titleField.getText();
        String category = categoryField.getText();
        String artist = artistField.getText();
        String director = directorField.getText();
        double cost = Double.parseDouble(costField.getText());
        int length = Integer.parseInt(lengthField.getText());

        CompactDisc cd = new CompactDisc(title, category, director,artist,length, cost);
        store.addMedia(cd);
        JOptionPane.showMessageDialog(frame, "CD added successfully."); // Thông báo khi sách được thêm
        StoreManagerScreen mainFrame = new StoreManagerScreen(store);
    }
    
}
