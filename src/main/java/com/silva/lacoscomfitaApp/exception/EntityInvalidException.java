package com.silva.lacoscomfitaApp.exception;

public final class EntityInvalidException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     *
     * @author Rodrigo Dantas - rodrigo.dantas@itbam.org.br
     */
    public EntityInvalidException(String message) {
        super(message);
    }

    public EntityInvalidException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
