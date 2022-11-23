package org.pda.junit.service;

import org.junit.jupiter.api.Test;
import org.pda.junit.entity.Admin;

import static org.junit.jupiter.api.Assertions.*;

class AdminServiceTest {

    @Test
    void addObjectEmpty() {
        AdminService adminService = new AdminService();
        Admin expected = new Admin();
        assertEquals(expected, adminService.add(expected));
    }

    @Test
    void addObjectNotGenerateId() {
        AdminService adminService = new AdminService();
        Admin expected = new Admin();
        expected.setId(555L);
        expected.setFirstName("aaaaa");
        expected.setLastName("tttttt");
        expected.setPhoneNumber("0000");
        expected.setEmail("aaaa@bbbb");
        expected.setUsername("luffy");
        expected.setPassword("azerty");
        assertEquals(expected, adminService.add(expected));
    }

    @Test
    void addObjectNotUniqUsername() {
        AdminService adminService = new AdminService();
        Admin expected = new Admin();
        expected.setFirstName("aaaaa");
        expected.setLastName("tttttt");
        expected.setPhoneNumber("0001");
        expected.setEmail("eeeeee@bbbb");
        expected.setUsername("luffy");
        expected.setPassword("azerty");
        assertEquals(expected, adminService.add(expected));
    }

    @Test
    void addObjectNotUniqEmail() {
        AdminService adminService = new AdminService();
        Admin expected = new Admin();
        expected.setFirstName("aaaaa");
        expected.setLastName("tttttt");
        expected.setPhoneNumber("0001");
        expected.setEmail("aaaa@bbbb");
        expected.setUsername("zert");
        expected.setPassword("azerty");
        assertEquals(expected, adminService.add(expected));
    }
}