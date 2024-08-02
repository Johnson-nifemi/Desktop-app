import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PersonGUI {
    private JFrame frame;
    private JTextField weightField;
    private JTextField heightField;
    private JTextArea resultArea;
    private JButton submitButton;

    public PersonGUI() {
        frame = new JFrame("Person Body Type and Height Calculator");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel weightLabel = new JLabel("Weight (kg):");
        weightLabel.setBounds(30, 30, 100, 30);
        frame.add(weightLabel);

        weightField = new JTextField();
        weightField.setBounds(150, 30, 100, 30);
        frame.add(weightField);

        JLabel heightLabel = new JLabel("Height (m):");
        heightLabel.setBounds(30, 80, 100, 30);
        frame.add(heightLabel);

        heightField = new JTextField();
        heightField.setBounds(150, 80, 100, 30);
        frame.add(heightField);

        submitButton = new JButton("Submit");
        submitButton.setBounds(30, 130, 220, 30);
        frame.add(submitButton);

        resultArea = new JTextArea();
        resultArea.setBounds(30, 180, 320, 60);
        frame.add(resultArea);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double weight = Double.parseDouble(weightField.getText());
                    double height = Double.parseDouble(heightField.getText());
                    Person person = new Person(weight, height);
                    String bodyType = person.getBodyType();
                    String heightType = person.getHeightType();
                    String result = "Body Type: " + bodyType + "\nHeight: " + heightType;
                    resultArea.setText(result);
                    FileWriterUtil.writeToFile(weight, height, bodyType, heightType);
                } catch (NumberFormatException ex) {
                    resultArea.setText("Invalid input. Please enter numeric values.");
                }
            }
        });

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new PersonGUI();
    }
}
