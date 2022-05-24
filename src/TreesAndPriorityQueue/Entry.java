/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TreesAndPriorityQueue;

/**
 *
 * @author Harshilkumar Vaghela,3116318
 * @param <K>
 * @param <V>
 * @date Nov 26,2020(Assignment-3)
 */
public interface Entry<K,V> {
    
  /**
   * Returns the key stored in this entry.
   * @return the entry's key
   */
  K getKey();

  /**
   * Returns the value stored in this entry.
   * @return the entry's value
   */
  V getValue();
  @Override
  String toString();
}
