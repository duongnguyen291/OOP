package ict.aimsprojectweek5.screen.manager;
import ict.aimsprojectweek5.media.*;

import javax.swing.*;
import java.awt.*;


public class PlayMedia extends JFrame {
    private Media media;

    public PlayMedia(Media media) {
        this.media = media;
        // Check if the media is playable
        if (media instanceof Disc) {
            // If it's a Disc, proceed with displaying disc information
            Disc disc = (Disc) media; // Casting to Disc
            initializeFrame(disc);
        } else {
            // If it's not a Disc, show a message saying it's not playable
            JOptionPane.showMessageDialog(null, "This media is not playable.");
            // You may want to handle other types of media here as well
            // For example, for books, you might want to show information about the book.
        }
    }

    private void initializeFrame(Disc disc) {
        // Create a new frame to display disc information
        JFrame playFrame = new JFrame("Play Media");
        Container playContainer = playFrame.getContentPane();
        playContainer.setLayout(new BorderLayout());
    
        // Display information about the disc
        JLabel titleLabel = new JLabel("Title: " + disc.getTitle());
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Center alignment
        JLabel categoryLabel = new JLabel("Category: " + disc.getCategory());
        categoryLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Center alignment
        JLabel directorLabel = new JLabel("Director: " + disc.getDirector());
        directorLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Center alignment
        JLabel lengthLabel = new JLabel("Length: " + disc.getLength());
        lengthLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Center alignment
        JLabel costLabel = new JLabel("Cost: " + disc.getCost() + " $");
        costLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Center alignment
    
        // Add the labels to a panel
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
        infoPanel.add(titleLabel);
        infoPanel.add(categoryLabel);
        infoPanel.add(directorLabel);
        infoPanel.add(lengthLabel);
        infoPanel.add(costLabel);
    
        // Add the panel to the frame
        playContainer.add(infoPanel, BorderLayout.CENTER);
    
        // Set frame properties and make it visible
        playFrame.setSize(300, 200);
        playFrame.setLocationRelativeTo(null);
        playFrame.setVisible(true);
    }
    

    public static void main(String[] args) {
        // Testing
        // You can test this class by passing different types of media to the constructor
        // For example:
        // Disc disc = new Disc("Title", "Category", "Director", 120, 10.99);
        // PlayMedia playMedia = new PlayMedia(disc);
    }
}
