/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TreesAndPriorityQueue;

/**
 *
 * @author Harshilkumar Vaghela,3116318
 * @date Nov 26,2020(Assignment-3)
 */
public class Bowler implements Comparable<Bowler> {
/**
 * @param firstName first name if the player
 * @param lastName last name of the player
 * @param jerseyNumber jersey number of the player
 * @param wicketsTaken wickets taken by player
 * @param matchesPlayed matches played by player
 */
    private String firstName;
    private String lastName;
    private String jerseyNumber;
    private int wicketsTaken;
    private int matchesPlayed;

    Bowler(String fn, String ln, String num, int y, int g) {
        firstName = fn;
        lastName = ln;
        jerseyNumber = num;
        wicketsTaken = y;
        matchesPlayed = g;
    }

    /**
     *Returns but does not remove the number of wickets a player has taken
     * @return
     */
    public int getWicketsTaken() {
        return wicketsTaken;
    }

    /**
     *Returns but does not remove the number of matches a player has played
     * @return
     */
    public int getMatchesPlayed() {
        return matchesPlayed;
    }

    @Override
    public int compareTo(Bowler s) {
        int i = lastName.compareTo(s.lastName);
        if (i == 0) {
            return firstName.compareTo(s.firstName);
        }
        return i;
    }

    @Override
    public String toString() {
        return (lastName + ", " + firstName + " " + jerseyNumber + " Wickets " + wicketsTaken + " Matches: " + matchesPlayed);
    }

}
