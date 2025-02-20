package com.mycompany.assignmentjava.AbdulRehman;

import com.mycompany.assignmentjava.Utilites.FileManager;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class VendorWithRevenueDashboard extends Vendor {

    public VendorWithRevenueDashboard(String vendorId, String name, String email, String phone, String password) {
        super(vendorId, name, email, phone, password);
    }

    public VendorWithRevenueDashboard() {
        super();
    }

    // No additional methods needed as they are now in Vendor
}
