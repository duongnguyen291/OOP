package aims.manager;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import aims.media.Media;
import aims.media.Playable;
public class MediaStore extends JPanel {
    private Media media;
    public MediaStore(Media media){
        this.media = media;
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        
        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(),Font.PLAIN,15));
        title.setAlignmentX(CENTER_ALIGNMENT);

        JLabel cost = new JLabel(""+ media.getCost()+" $");
        cost.setAlignmentX(CENTER_ALIGNMENT);


        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));
        btnPlayMedia btnListener = new btnPlayMedia();
        if(media instanceof Playable){
            JButton playButton = new JButton("Play media");
            container.add(playButton);
            playButton.addActionListener(btnListener);
        }
        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue());
        this.add(container);
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
    private class btnPlayMedia implements ActionListener{
        @Override 
        public void actionPerformed(ActionEvent e){
            PlayMedia temp = new PlayMedia(media);
        }
    }
}
