package com.chunkiechunks;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.annotations.QuarkusMain;

@QuarkusMain
public class Main {

    public static void main(String[] args) {
        System.out.println("Starting up the application...");
        Quarkus.run(args);
    }
}