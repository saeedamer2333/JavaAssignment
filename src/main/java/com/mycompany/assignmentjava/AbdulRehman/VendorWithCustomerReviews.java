package com.mycompany.assignmentjava.AbdulRehman;

import com.mycompany.assignmentjava.Utilites.FileManager;
import java.util.List;

public class VendorWithCustomerReviews extends Vendor {

    public VendorWithCustomerReviews(String vendorId, String name, String email, String phone, String password) {
        super(vendorId, name, email, phone, password);
    }

    public VendorWithCustomerReviews() {
        super();
    }

    // Method to view customer reviews
    public List<String> viewCustomerReviews() {
        List<String> reviews = FileManager.searchRecords(FileManager.FileType.REVIEWS, "vendorID", this.vendorID);
        System.out.println("Vendor ID: " + this.vendorID);
        System.out.println("Reviews found: " + reviews.size());
        for (String review : reviews) {
            System.out.println(review);
        }
        return reviews;
    }
}
