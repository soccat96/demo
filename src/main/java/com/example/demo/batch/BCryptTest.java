package com.example.demo.batch;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptTest {
    public static void main(String[] args) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        System.out.println(bCryptPasswordEncoder.encode("123$"));
        // $2a$10$/aO7Zlh/69gD4GLGwQ4Pb.dLxm1Czaiyei4U7dtwVNyQIvrIWP5C2
        // $2a$10$X6ihuxUZ1VFNz1A.LgKn.ujRuoovoot5Yjy1xluGR/s4cShNVBXIa
        // $2a$10$3RX.HAULkFcgz2J39S19ZOTxo2sXgx1LkD9IfbbIaBl04.QC60IAO
    }
}
