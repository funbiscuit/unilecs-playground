package com.funbiscuit.unilecs.task287;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LicKeyTest {
    @Test
    public void licKeyCheck() {
        assertEquals("5F3Z-2E9W", LicKey.updateLicenseKey("5F3Z-2e-9-w", 4));
        assertEquals("2-5G-3J", LicKey.updateLicenseKey("2-5g-3-J", 2));
    }
}
