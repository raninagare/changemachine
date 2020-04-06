package com.rani;

import com.rani.model.Combo;
import java.util.*;

/**
 * This  API class loads change machine with some initial amount and whenever user enters amount and
 * picky(user is not interested in Pennies) or easy,
 * If possible dispense the amount with combination else it displays error message.
 */

public class ChangeMaker {

    private final String ERROR_MESSAGE = "Sorry! I cannot do that!";
    private static Map<Integer, Integer> availableAmount;

    public ChangeMaker(Map<Integer, Integer> amountToBeLoaded) {
        availableAmount = amountToBeLoaded;
    }

    /**
     * This method returns whether combination is possible for given amount or not and if combination is possible it
     * displyas that combination else prints failure message
     * @param amount
     * @param isPicky :If customer is Picky then we can not give him/her pennies
     * @return
     */
    public boolean isCombinationPossible(int amount, final boolean isPicky) {
        int toTalAvailableAmount = 0;

        System.out.println( "For amount " +amount+" :");
        final Set<Integer> keys = availableAmount.keySet();
        for (int key : keys) {
            toTalAvailableAmount += key * availableAmount.get( key );
        }
        if (amount > toTalAvailableAmount) {
            failure();
            return false;
        }
        final Combo combo = new Combo();

        final int numAvailableQuarters = availableAmount.get( 25 );
        final int numAvailableDimes = availableAmount.get( 10 );
        final int numAvailablenickles = availableAmount.get( 5 );
        final int numAvailablepennies = availableAmount.get( 1 );

        amount = getQuarters( amount,  combo, numAvailableQuarters );

        amount = getDimes( amount, combo, numAvailableDimes );

        amount = getNickles( amount, combo, numAvailablenickles );

        if (!isPicky) {
            if (numAvailablepennies >= amount) {
                availableAmount.put( 1, numAvailablepennies - amount );
                combo.setPennies( amount );
                System.out.println( combo.toString() );
                return true;

            } else {
                failure();
                return false;
            }
        } else {
            System.out.println( "'Nope, I hate pennies'" );
            return false;
        }

    }

    /**
     * This method is returning number of nickles for given amount
     * @param amount
     * @param combo
     * @param numAvailablenickles
     * @return
     */

    private  int getNickles(int amount,  Combo combo, int numAvailablenickles) {
        int nickels;
        nickels = amount / 5;
        if (numAvailablenickles >= nickels) {
            amount = amount - nickels * 5;
            numAvailablenickles = numAvailablenickles - nickels;
            availableAmount.put( 5, numAvailablenickles );
            combo.setNickels( nickels );
        } else {
            amount -= numAvailablenickles * 5;
            availableAmount.put( 5, 0 );
            combo.setNickels( numAvailablenickles );

        }
        return amount;
    }

    /**
     * This method is returning number of dimes for given amount
     * @param amount
     * @param combo
     * @param numAvailableDimes
     * @return
     */
    private int getDimes(int amount,Combo combo, int numAvailableDimes) {
        int dimes;
        dimes = amount / 10;
        if (numAvailableDimes >= dimes) {
            amount = amount - dimes * 10;
            numAvailableDimes = numAvailableDimes - dimes;
            availableAmount.put( 10, numAvailableDimes );

            combo.setDimes( dimes );
        } else {
            amount -= numAvailableDimes * 10;
            availableAmount.put( 10, 0 );
            combo.setDimes( numAvailableDimes );

        }
        return amount;
    }

    /**
     * This method is returning number of quarters for given amount
     * @param amount
     * @param combo
     * @param numAvailableQuarters
     * @return
     */

    private  int getQuarters(int amount,  Combo combo, int numAvailableQuarters) {
        int quarters;
        quarters = amount / 25;
        if (numAvailableQuarters >= quarters) {
            amount = amount - quarters * 25;
            numAvailableQuarters = numAvailableQuarters - quarters;
            availableAmount.put( 25, numAvailableQuarters );
            combo.setQuarters( quarters );
        } else {
            amount -= numAvailableQuarters * 25;
            availableAmount.put( 25, 0 );
            combo.setQuarters( numAvailableQuarters );

        }
        return amount;
    }

    /**
     * This method is for display failure message
     */
    private void failure() {
        System.out.println( ERROR_MESSAGE );
    }
}