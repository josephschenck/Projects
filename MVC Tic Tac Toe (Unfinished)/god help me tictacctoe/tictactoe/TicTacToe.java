package tictactoe;

import tictactoe.controller.Controller;

//Hey, I struggled a lot with this phase myself, If you check the email I sent you my code didnt even really work

//I used a lot of stuff from various gitsoruces I found, I changed a lot of the logic to try to make it work with 4 x 4, some of it works others not so much but what are you gonna do.

// Like i wrote in the email I sent i took it as a learning experience trying to see what goes into each thing,  as I have never used MVC with java or even used Jframe before.

//I definitely learned by going through the code of what I submitted last time the approximate way I should go about doing each part,

//WIth the views in mind, I saw tbat through them the updating of hte board and the drawing of the array on the screen with jFrame is necessary, This made things clear, I just wasnt sure how to go about implementing it myself. 

// WIth the models , of coruse this is where the rules are stored for the tic tac toe game. the source I found used a tally system to determine who would win or lose in the end, I added a couple of different resutls that should make it more compatible with the 4 x 4 grid but it is far from perfect. 

// Finally we come to the controller. some logic is done here, like getting an action listener in for each of the buttons, but other than that it simply checks for if it should give and outcome and then does.

//Overall i think this was a good learning experience, I had experience with MVC before, but not in Java which threw me off. I should have looked for a partner but I prioritized studying for other midterms and finishing other assignments and I underestiamted this project

//Overall I think I got a good amount out of it done, it definitely strengthened my knowledge of the MVC framework.

//I have to thank Jedarrien for helping me out on this phase, I wasn't officially his group partnere but he helped me out and I have to thank him for that

//Sorry for the wall of text

public class TicTacToe {
    public static void main(String[] args) {        
        Controller controller = new Controller();

        while (!controller.isGameOver()) {
            try {
                Thread.sleep(250);
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
        
        controller.informOutcome();
    }    
}