package com.youngzy.hexiehao;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    public void testEnv() {
        String s1 = System.getenv("12306_USERNAME");
        String s2 = System.getenv("12306_PASSWORD");
        assertNotNull(s1);
        assertNotNull(s2);
    }
}