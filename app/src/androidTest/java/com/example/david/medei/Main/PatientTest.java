package com.example.david.medei.Main;

import junit.framework.TestCase;

/**
 * Created by David on 5/28/2015.
 */
public class PatientTest extends TestCase {

    Patient patient;

    public void setUp() throws Exception {
        super.setUp();
        patient = new Patient("David", "Vannay", "david.vannay@gmail.com");
    }

    public void tearDown() throws Exception {

    }

    public void testGetLastName() throws Exception {
        assertEquals(patient.getLastName(),"Vannay");
    }

    public void testSetLastName() throws Exception {
        patient.setLastName("test");
        assertEquals(patient.getLastName(), "test");
    }

    public void testGetEmail() throws Exception {
        assertEquals(patient.getEmail(),"david.vannay@gmail.com");
    }

    public void testSetEmail() throws Exception {
        patient.setEmail("test@test.com");
        assertEquals(patient.getEmail(), "test@test.com");
    }

    public void testGetFirstName() throws Exception {
        assertEquals(patient.getFirstName(),"David");
    }

    public void testSetFirstName() throws Exception {
        patient.setFirstName("test");
        assertEquals(patient.getFirstName(), "test");
    }
}