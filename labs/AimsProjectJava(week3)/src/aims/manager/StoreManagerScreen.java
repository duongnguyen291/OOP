package aims.manager;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.*;

import aims.media.Media;
import aims.store.*;;


public class StoreManagerScreen extends JFrame{
    private Store store;
    public static void main(String[] args){
        StoreManagerScreen mainFrame = new StoreManagerScreen(new Store());
    }
    
    public StoreManagerScreen(Store store){
        this.store = store;
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(createNorth(),BorderLayout.NORTH);
        cp.add(createCenter(),BorderLayout.CENTER);
        setTitle("Store");
        setSize(1024,768);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }






    JPanel createNorth(){
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }
    JMenuBar createMenuBar(){
        JMenu menu = new JMenu("Option");
        menu.add(new JMenuItem("View store"));
        JMenu smUpdateStore = new JMenu("Update Store");
        smUpdateStore.add(new JMenuItem("Add Book"));
        smUpdateStore.add(new JMenuItem("Add CD"));
        smUpdateStore.add(new JMenuItem("Add DVD"));
        menu.add(smUpdateStore);
        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);
        return menuBar;
    }
    JPanel createHeader(){
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(),Font.PLAIN,50));
        title.setForeground(Color.CYAN);
        

        header.add(Box.createRigidArea(new Dimension(10,10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(Box.createRigidArea(new Dimension(10,10)));
        return header;
    }

    JPanel createCenter(){
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3,3,2,2));
        ArrayList<Media> mediaInStore = store.getItemsInStore();
        if(!mediaInStore.isEmpty()){
            for(int i = 0;i < 9;i++){
                MediaStore cell = new MediaStore(mediaInStore.get(i));
                center.add(cell);
            }
        }
        return center;

    }


}