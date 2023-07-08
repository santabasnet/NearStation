package edu.eec.nearapp;

import java.util.Optional;
import java.util.Scanner;

/**
 * This class is a part of the package edu.eec.nearapp and the package
 * is a part of the project NearStation.
 * <p>
 * Integrated ICT Pvt. Ltd. Jwagal, Lalitpur, Nepal.
 * https://www.integratedict.com.np
 * https://www.semantro.com
 * <p>
 * Created by Santa on 2023-07-08.
 * Email: sbasnet81[at]gmail[dot]com
 * Github: https://github.com/santabasnet
 */
public class OptionalTest {
    
    
    private static Optional<Integer> readNumber(){
        try {
            System.out.println("Type any number : ");
            Scanner in = new Scanner(System.in);
            int number = in.nextInt();
            return Optional.of(number);
        }catch (Exception e){
            return Optional.empty();
        }
    }
    
    
    public static void main(String[] args) {
        
        System.out.println(readNumber());
    
    }
    
}
