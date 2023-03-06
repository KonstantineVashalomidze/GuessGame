package front;

import back.GuessLogic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuessingGameUI extends JFrame implements ActionListener {

    // grid 2x1
    private JPanel screenButtonPanel = new JPanel();

    // grid 2x1
    private JPanel allButtonPanel = new JPanel();

    private JButton guessButton = new JButton("guessButton");

    private JTextField screen = new JTextField("pick guess from range 0-20");

    private JTextField guess = new JTextField();

    public GuessingGameUI(){

        // add action listeners to buttons
        this.guessButton.addActionListener(this);




        // screen styles
        this.screen.setFont(new Font("SansSerif", Font.BOLD, 24));
        this.screen.setHorizontalAlignment(JTextField.CENTER);
        this.screen.setEditable(false);


        // styles of guess
        this.guess.setFont(new Font("SansSerif", Font.BOLD, 24));
        this.guess.setHorizontalAlignment(JTextField.CENTER);



        // set layout to all button panel 3x1
        this.allButtonPanel.setLayout(new GridLayout(3, 1));


        // add elements to all button panel
        this.allButtonPanel.add(this.guess);
        this.allButtonPanel.add(this.guessButton);


        // set layout to screenButtonPanel 2x1
        this.screenButtonPanel.setLayout(new GridLayout(2, 1));

        // add elements to screenButtonPanel
        this.screenButtonPanel.add(this.screen);
        this.screenButtonPanel.add(this.allButtonPanel);


        // add elements to frame
        this.add(this.screenButtonPanel);




        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(2, 1));
        this.pack();
        this.setVisible(true);


    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if(source == this.guessButton){
            String valueOfGuessing = this.guess.getText();
            if(valueOfGuessing.matches("\\d+")){
                this.screen.setText(GuessLogic.getRandomNumberInstance().checkGuess(Integer.parseInt(valueOfGuessing)));
            } else {
                this.screen.setText("Please put number");
            }
        }

    }
}
