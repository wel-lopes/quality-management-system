package com.weberth.qualitymanagementsystem.exception;

public class InspectionNotFoundException extends RuntimeException {
    public InspectionNotFoundException(Long id) {
        super("Inspection not found with id: " + id);
    }
}
