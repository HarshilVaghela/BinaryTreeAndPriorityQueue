/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TreeAndPriorityQueue;

import java.util.Scanner;

/**
 *
 * @author Harshilkumar Vaghela,3116318
 * @date Nov 26,2020(Assignment-3)
 */
public class DecisionTreeDriver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LinkedBinaryTree<String> tree = new LinkedBinaryTree<>();
        //contensts of the decision tree
        Position<String> root = tree.addRoot("Are you nervous?");
        Position<String> pos1 = tree.addLeft(root, "Savings Account.");
        Position<String> pos2 = tree.addRight(root, "Will you need to access most of the money within the next 5 years?");
        tree.addLeft(pos2, "Money Market Fund.");
        tree.addRight(pos2, "Are you willing to accept risks in exchange for higher expected returns?");
        pos2 = tree.right(pos2);
        tree.addLeft(pos2, "Stock Portfolio.");
        tree.addRight(pos2, "Diversified portfolio with stocks, bonds, and short-term instruments.");
        
        
        
        Position<String> pos3 = root;
        
        Scanner kb = new Scanner(System.in);
        int k = 0;
        while (tree.left(pos3) != null && tree.right(pos3) != null) {
            if (k == 0) {
                System.out.println(pos3.getElement() + "(yes/no)");
            } else {
                System.out.println(pos3.getElement());
            }
            String ans = kb.next();
            if (ans.equals("yes")) {
                pos3 = tree.left(pos3);
                k = 1;
            } else if (ans.equals("no")) {
                pos3 = tree.right(pos3);
                k = 0;
            }
        }
        System.out.println(pos3.getElement());
        System.out.println("\nNormal tree:\n"+tree+"\nIndented Content:\n");
        
        LinkedBinaryTree.printPreorderIndent(tree, root, 0);

    }

}
