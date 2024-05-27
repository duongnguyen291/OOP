package ict.aimsprojectweek5.screen.manager;
import ict.aimsprojectweek5.store.*;
import javax.swing.*;
import java.awt.*;


public abstract class AddItemToStoreScreen extends JFrame{
    protected Store store;
    protected JFrame frame;

    public AddItemToStoreScreen(Store store) {
        this.store = store;
        frame = new JFrame();
        frame.setTitle("Add Item to Store");
        frame.setSize(400 , 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
    }

    public void display() {
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    protected abstract void addItemToStore();
}
