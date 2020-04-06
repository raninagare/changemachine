package com.rani;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;

/**
 * This is the test class for ChangeMaker class
 */
public class ChangeMakerTest {
    Map<Integer, Integer> availableAmount;
    ChangeMaker changeMaker;

    @Before
    public void setup() {
        availableAmount = new HashMap<Integer, Integer>();
        availableAmount.put( 1, 20 ); //20
        availableAmount.put( 5, 3 );   //15
        availableAmount.put( 10, 4 );   //40
        availableAmount.put( 25, 3 );   //75
        changeMaker = new ChangeMaker( availableAmount );

    }

    @Test
    public void testIsCombinationPossible_ForEasy() {

        boolean isPicky = false;
        Assert.assertTrue( changeMaker.isCombinationPossible( 131, isPicky ) );

    }

    @Test
    public void tstIsCombinationPossible_ForPicky() {

        boolean isPicky = true;
        Assert.assertFalse( changeMaker.isCombinationPossible( 131, isPicky ) );

    }

    @Test
    public void testIsCombinationPossible_Notpossible() {

        boolean isPicky = false;
        Assert.assertTrue( changeMaker.isCombinationPossible( 30, isPicky ) );
        Assert.assertFalse( changeMaker.isCombinationPossible( 131, isPicky ) );

    }

}