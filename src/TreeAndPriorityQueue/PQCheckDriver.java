/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TreeAndPriorityQueue;

/**
 *
 * @author Harshilkumar Vaghela,3116318
 * @date Nov 26,2020(Assignment-3)
 */
public class PQCheckDriver {

    public static void main(String[] args) {
        LinkedHeapPriorityQueue<Bowler, Bowler> selection = new LinkedHeapPriorityQueue<>(new OrderForSelection());
        Bowler b = new Bowler("Anil", "Kumble", "11", 103, 21);
        selection.insert(b, b);
        b = new Bowler("Piyush", "Chawla", "55", 83, 40);
        selection.insert(b, b);
        b = new Bowler("Zaheer", "Khan", "33", 205, 43);
        selection.insert(b, b);
        b = new Bowler("Ashish", "Nehra", "44", 83, 24);
        selection.insert(b, b);
        b = new Bowler("Vinod", "Kambli", "22", 103, 31);
        selection.insert(b, b);

        System.out.println(selection);
        
        /*In my order of selection, it prioritizes the the bowler who has taken more wickets first, but if the number of wickets is same, it will prioritize the bowler who has played
        fewer number of matches*/
        
        System.out.println("------------------------------------");
        System.out.println("Next up for selection: " + selection.removeMin().getKey());
        System.out.println("Bowlers waiting for selection: " + selection + "\n");
        System.out.println("Next up for selection: " + selection.removeMin().getKey());
        System.out.println("Bowlers waiting for selection: "+ selection + "\n");
        System.out.println("Next up for selection: " + selection.removeMin().getKey());
        System.out.println("Bowlers waiting for selection: "+ selection + "\n");
        System.out.println("Next up for selection: " + selection.removeMin().getKey());
        System.out.println("Bowlers waiting for selection: " + selection + "\n");
        System.out.println("Next up for selection: " + selection.removeMin().getKey());
        System.out.println("Bowlers waiting for selection: "+ selection + "\n");

    }
}
