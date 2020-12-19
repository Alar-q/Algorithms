package framework;

import Graphs.Dijkstras_algorithm;

import java.util.*;

import static framework.Algorithm.*;

public class Main {
    public static void main(String[] args){
        long startTime = System.nanoTime();

        for(long i=0; i<9999999999l; i++){
            if(i%2==0) {
                i = i;
                continue;
            }else continue;
        }

        float deltaTime =  ( System.nanoTime() - startTime) / 1000000000.0f ;
        System.out.println("TIME = " + deltaTime);
    }
}
