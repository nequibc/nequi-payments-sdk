package com.nequi.auth;

public class NequiAuthTest {
    public static void main(String[] args) {
        try {
            System.out.println("Testing NequiAuth...");

            NequiAuth auth = NequiAuth.getInstance().fromEnvVars();

            System.out.println(String.format("Token >> %s", auth.getToken()));
        } catch (Exception e) {
            System.out.println(String.format("Error > %s", e.getMessage()));
        }
    }
}
