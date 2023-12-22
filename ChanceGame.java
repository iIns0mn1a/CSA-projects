import java.util.Scanner;

public class ChanceGame {

    static double money = 0;

    static boolean gameEnded = false;
    public static void main(String[] args)
    {
        
     /*ok so game starts in main method.
      * 
      the first choice method call is here, so then it goes to choice
      after going to choice, it would make the bet, win or lose the bet, then call choice again. 
      */
    while (gameEnded = false)
     choice();
    
    }




    public static void choice()
    {
        
        Scanner scan = new Scanner(System.in);
        System.out.println("*****WELCOME*****");
     System.out.println("You currently have " + money + " dollars in the bank!");
     System.out.println("Please choose one of the following options: \n(1) Deposit money into the bank \n(2) Play the game! \n(3) Quit the game.");
    int choice = scan.nextInt();

        if (choice == 1)
        {
            System.out.println("How much would you like to deposit:");
            ChanceGame.money = scan.nextDouble();
            
                
           choice();
        }

        if (choice == 2)
        {
            if (money <=0)
            {
                System.out.println("You're broke! How about you deposit some money first.");
            }
            else
            {
                System.out.println("How much would you like to bet?");
                double bet = scan.nextDouble();

                if (bet > money)
                    System.out.println("Your betting money you don't have! No going in debt.");
                else
                    ChanceGame.money += makeABet(bet);
                    choice();

            }
        }

        if (choice == 3)
        {
            ChanceGame.gameEnded = true;
            System.out.println("Thanks for playing! \n \nYour final total was: " + money);
        }

       scan.close(); //might take this out 
    }


    public static double makeABet(double bet)
    {   
        
        boolean coinRes;
        boolean diceRes;
        boolean spinRes;

        Scanner betScan = new Scanner(System.in);
        //coin flip
        int coin = (int) (Math.random()*2)+1;

        System.out.println("Coin flip time! (1)Heads or (2)Tails.");

        int coinGuess = betScan.nextInt();

        if (coinGuess == coin)
            coinRes = true;
        else   
            coinRes = false;

        //spinner
        int spin = (int)(Math.random()*4)+1;
        System.out.println("Lets start spinnin! Choose (1) red, (2) green, (3) blue, (4) blue.");
        int spinGuess = betScan.nextInt();

        if (spinGuess == spin)
            spinRes = true;
        else   
            spinRes = false;
        
        //dice roll
        int dice = (int)(Math.random()*6)+1;

        System.out.println("Time for a dice roll! Make your final guess (1-6).");
        int diceGuess = betScan.nextInt();

        if (diceGuess == dice)
            diceRes = true;
        else
            diceRes = false;

         betScan.close(); //closing scanner so vsc will stop complaining
        
         //deciding what to do
           System.out.println("Won dice?: " + diceRes);
           System.out.println("Won spin?: " + spinRes);
           System.out.println("Won coin?: " + coinRes);
           
        if (coinRes && diceRes && spinRes)
        {
            return bet * 3;
        }
        else if ((!coinRes && diceRes && spinRes)|| (coinRes && !diceRes && spinRes) || (coinRes && diceRes && !spinRes))
        {
            return bet * 2;
        }
        else if (diceRes)
        {
            return bet;
        }
        else if (spinRes)
        {
            return bet/2;
        }
        else if (coinRes)
        {
            return bet/4;
        }
        else
        {
            return 0.0;
            
        }
    
           
    }    
}
