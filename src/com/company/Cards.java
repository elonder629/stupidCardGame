package com.company;

import java.util.Scanner;
import java.util.ArrayList;

public class Cards {

	private static int bestPlay(int[] cards_player, int[] cards_dealer, ArrayList<Integer> solution) {
		/**
		 *
		 * Your code should return the answer, i.e., the points at which the player should stop, in the "solution" arraylist.
		 * The return value should be the total winnings for the best solution.
		 */
		int index = 0;
		int numberToTake = 1;
		int playerSum = 0;
		while(cards_player.length > index) {
			for (int i = 0; i < numberToTake; i++) {
				if(cards_player[index] > cards_dealer[index]) {
					playerSum += 10;
				} else if(cards_player[index] == cards_dealer[index]) {
					playerSum += 5;
				}
				index++;
			}
			solution.add(index);
		}


		return playerSum;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int numOfTestCases = sc.nextInt();

		for (int testCase=0; testCase < numOfTestCases; testCase++) { 
			int numOfCards = sc.nextInt();
			int[] cards_player = new int[numOfCards];
			for (int i=0; i < numOfCards; i++) 
				cards_player[i] = sc.nextInt();
			int[] cards_dealer = new int[numOfCards];
			for (int i=0; i < numOfCards; i++) 
				cards_dealer[i] = sc.nextInt();

			ArrayList<Integer> results = new ArrayList<Integer>();
			int value = bestPlay(cards_player, cards_dealer, results);        
			System.out.println("Best value " + value  + " is obtained by stopping at positions: " + results);
		}

		sc.close();
	}
}

