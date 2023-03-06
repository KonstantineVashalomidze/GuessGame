package back;

import java.util.Random;

public class GuessLogic {



    private int num;

    private static GuessLogic guessLogicInstance;

    private GuessLogic(){
        this.num = new Random().nextInt(21);
    }



    public static GuessLogic getRandomNumberInstance(){

        if (guessLogicInstance == null){
            guessLogicInstance = new GuessLogic();
        }
        return guessLogicInstance;
    }

    public String checkGuess(int guess) {
        if (guess > 20 || guess < 0){
            return "guess should be in 0-20!";
        } else if (guess == this.num){
            return "Correct!";
        } else if (guess > this.num) {
            return "Guess is bigger!";
        } else {
            return "Guess is smaller!";
        }


    }

}
