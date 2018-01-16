

import java.util.ArrayList;
import cs1.Keyboard;

public class Blackjack extends Game {

    private ArrayList<Card> _dealer = new ArrayList<Card>();
    private ArrayList<Card> _player = new ArrayList<Card>();
    private Deck _deck;
    private int choice;
    private boolean win;
    private double mult = 2.0;

    public Blackjack() {
	cost = 10.0;
	_deck = new Deck();

	_player.add(_deck.draw());
	_player.add(_deck.draw());

	_dealer.add(_deck.draw());
	_dealer.add(_deck.draw());
<<<<<<< HEAD

	String i;
	
	i = "Would you like to see the rules of the game? \n";
	i += "\t1: Yes\n";
	i += "\t2: No\n";
	System.out.println(i);

	int rules = cs1.Keyboard.readInt();

	if (rules == 1) {
	   System.out.println(about());
	}

=======
	System.out.println("The dealer has a: " + _dealer.get(0) + "\n");
>>>>>>> 4d77c012f1f6cb24f2d3152b14cdabd2418caa23
	play();

    }



    public String about() {
	String s;
	s = "\nBlackjack is a card game where your objective is to reach a value of 21.\n";
	s += "You are dealt a hand of two cards at the beginning, and a dealer is also dealt two cards. ";
	s += "If you or the dealer automatically gets a value of 21, you have blackjack, and win quick money. ";
	s += "Otherwise, you are given the choice to hit, stand, or double. ";
	s += "\nBy hitting, you draw a card from the deck, and can keep going until you go over 21";
	s += "\nBy standing, you trust your luck, and compare your value with the dealer's";
	s += "\nBy doubling, you raise your bet amount, and draw one more card";

	return s;
    }
    public int value(ArrayList<Card> hand){
	int sum = 0;
	for (int i = 0; i < hand.size(); i++){
	    if ((hand.get(i)).getRank() == 0){
		sum += 11; }
	    else if ((hand.get(i)).getRank() == 11){
		sum += 10; }
	    else if ((hand.get(i)).getRank() == 13){
		sum += 10; }
	    else if ((hand.get(i)).getRank() == 12){
		sum += 10; }
	    else{
		sum += (hand.get(i)).getRank();}
	}
	return sum;
    }

    public void play() {
<<<<<<< HEAD
	System.out.println("Your hand is: " + _player + "\n");

	System.out.println("The dealer has a: " + _dealer.get(0) + "\n");
	
	if (value(_player) == 21){
	    System.out.println("You had a blackjack! \n");
	    mult = 2.5;
	    win = true;	    
=======
	String i;

	i = "Would you like to see the rules of the game? \n";
	i += "\t1: Yes\n";
	i += "\t2: No\n";
	System.out.println(i);

	int rules = cs1.Keyboard.readInt();

	if (rules == 1) {
	   System.out.println(about());
	}

	if (value(_player) == 21){
	    System.out.println("You had a blackjack! \n");
	    mult = 2.5;
	    win = true;
	    win();
>>>>>>> 4d77c012f1f6cb24f2d3152b14cdabd2418caa23
	}
	if (value(_dealer) == 21){
	    System.out.println("You lost. The dealer had a blackjack! \n");
	    win = false;
	}
	String s;
	s = "Make your decision\n";
	s += "\t1: Stand\n";
	s += "\t2: Hit\n";
	s += "\t3: Double\n";
	System.out.println(s);


	choice = cs1.Keyboard.readInt();

	if (choice == 1) {
	    reveal();
	}
	else if (choice == 2) {
	    _player.add(_deck.draw());
	    reveal();
	}
	else if (choice == 3) {
	    cost *= 2;
	    _player.add(_deck.draw());
	    reveal();
	}
	else {
	    System.out.println("You've chosen an invalid choice. Please select again");
	    play();
	}
	}

    public void reveal() {
	if (choice == 3) {
	    if (value(_player) > 21) {
	    System.out.println("Sorry, you busted. (Over the winning amount)");
		win = false;
	    }
	}

	else if (choice == 2) {
	    if (value(_player) > 21) {
	    System.out.println("Sorry, you busted. (Over the winning amount)");
	    win = false;
	    }
	    else {
		play();
	    }
	}
	else if (choice == 1) {
	    win();
	}
    }

    public boolean win() {
	if (value(_dealer) < 17) {
	    while (value(_dealer) <17) {
		_dealer.add(_deck.draw());
	    }
	    win();
	}
	else if (value(_dealer) > 21) {
	    System.out.println("Dealer had : " + _dealer + "\n");
	    System.out.println("Dealer busted. Congrats!");
	    win = true;
	}
<<<<<<< HEAD
	
	else if (value(_player) > value(_dealer)) {
=======

	if (value(_player) > value(_dealer)) {
>>>>>>> 4d77c012f1f6cb24f2d3152b14cdabd2418caa23
	    System.out.println("Dealer had : " + _dealer + "\n");
	    System.out.println("Congrats! You beat the dealer!");
	    win = true;
	}
	else {
	    System.out.println("Dealer had : " + _dealer + "\n");
	    System.out.println("Dealer has beaten you. Sorry");
	    win = false;
	}
	return win;
    }

}