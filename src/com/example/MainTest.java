package com.example;

import com.example.device.Device;

import java.io.IOException;
import java.io.PrintWriter;

public class MainTest {

    public static void main(String[] args) {
        Device device = new Device();
        try {
            System.out.println(device.Auth());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
