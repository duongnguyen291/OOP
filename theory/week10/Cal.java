package theory.week10;
import java.awt.*;
import java.awt.event.*;
//Nguyễn Đình Dương 20225966
public class Cal extends Frame implements ActionListener {
    private TextField textFieldA;
    private TextField textFieldB;
    private TextField textFieldC;

    public Cal() {
        super("Calculator");

        Label labelA = new Label("Enter value for a:");
        textFieldA = new TextField(10);

        Label labelB = new Label("Enter value for b:");
        textFieldB = new TextField(10);

        // Panel chứa nút tính toán và kết quả
        Panel buttonPanel = new Panel(new FlowLayout());
        Panel result = new Panel(new FlowLayout());
        Button calculateButton = new Button("Calculate");
        calculateButton.addActionListener(this);
        Label resultLabel = new Label("Result (c = a + b):");
        textFieldC = new TextField(10);
        textFieldC.setEditable(false); 

        buttonPanel.add(calculateButton);
        result.add(resultLabel);
        result.add(textFieldC);

        setLayout(new FlowLayout());
        add(labelA);
        add(textFieldA);
        add(labelB);
        add(textFieldB);
        add(buttonPanel); // Thêm panel vào frame
        add(result);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose(); 
            }
        });

        setSize(300, 150);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            int a = Integer.parseInt(textFieldA.getText());
            int b = Integer.parseInt(textFieldB.getText());
            int c = a + b;
            textFieldC.setText(Integer.toString(c));
        } catch (NumberFormatException ex) {
            textFieldC.setText("Invalid input");
        }
    }
    public static void main(String[] args) {
        new Cal();
    }
}
