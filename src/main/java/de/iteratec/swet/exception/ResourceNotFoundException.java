package de.iteratec.swet.exception;


public class ResourceNotFoundException extends RuntimeException {
    private String kuerzel;

    public ResourceNotFoundException(String kuerzel, String message) {
        super(message);
        this.kuerzel = kuerzel;
    }
}