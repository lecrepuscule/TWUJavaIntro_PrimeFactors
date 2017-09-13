package com.company;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {

    public static Boolean[] sieveOfEratosthene(int max) {
        Boolean[] flags = initSieve(max);
        int prime = 2;

        while (prime <= Math.sqrt(max)) {
            crossOff(flags, prime);

            prime = findNextPrime(flags, prime);

            if (prime >= max) {
                break;
            }

        }

        return flags;
    }

    public static void crossOff(Boolean[] flags, int prime) {
        for (int i = prime * prime; i < flags.length; i += prime) {
            flags[i] = false;
        }
    }

    public static int findNextPrime(Boolean[] flags, int prime) {
        int next = prime + 1;
        while (next < flags.length && !flags[next]) {
            next++;
        }
        return next;
    }

    public static Boolean[] initSieve(int max) {
        Boolean[] flags = new Boolean[max + 1];
        Arrays.fill(flags, true);
        flags[0] = false;
        flags[1] = false;
        return flags;
    }

    public static void main(String[] args) {
        int max = Integer.parseInt(args[0]);
        Boolean[] primes = sieveOfEratosthene(max);

        for (int i = 2; i < primes.length; i++) {
            if (primes[i] && (max % i == 0 )) {
                System.out.print(i + " ");
            }
        }

    }
}
