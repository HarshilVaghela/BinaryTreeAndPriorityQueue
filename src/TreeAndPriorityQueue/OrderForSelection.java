/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TreeAndPriorityQueue;

import java.util.Comparator;

/**
 *
 * @author Harshilkumar Vaghela,3116318
 * @date Nov 26,2020(Assignment-3)
 */
public class OrderForSelection implements Comparator<Bowler> {

    @Override
    public int compare(Bowler a, Bowler b) {
        int i = b.getWicketsTaken() - a.getWicketsTaken();
        if (i == 0) {
            return a.getMatchesPlayed() - b.getMatchesPlayed();

        }
        return i;
    }
}
