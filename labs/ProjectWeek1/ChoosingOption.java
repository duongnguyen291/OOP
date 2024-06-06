package OOP.labs.lab1;
import javax.swing.JOptionPane;

public class ChoosingOption {
    public static void main(String[] args) {
        // ChoosingOptionFirst();
        ChoosingOptionSecond();
    }
    
    public static void ChoosingOptionFirst() {
        int option = JOptionPane.showConfirmDialog(null, "Do you want to change to the first class ticket ?", null, JOptionPane.YES_NO_OPTION);
        JOptionPane.showMessageDialog(null, "You've chosen: " + (option == JOptionPane.YES_OPTION ? "Yes" : "No"));
    }

    public static void ChoosingOptionSecond() {
        Object[] options = {"I do", "I don't"}; // Customize options here
        int option = JOptionPane.showOptionDialog(null, "Do you want to change to the first class ticket ?", "Choose Option", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        
        if (option == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, "You've chosen: I do");
        } else {
            JOptionPane.showMessageDialog(null, "You've chosen: I don't");
        }
    }
}
