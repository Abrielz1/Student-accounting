package com.example.Student.accounting.exceptions;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class ErrorHandler {

    public ErrorResponse handlerValidationException(final ValidationException exception) {
        log.warn("Validation error {}", exception.getMessage());
        return new ErrorResponse("Validation error", exception.getMessage());
    }

    public ErrorResponse handlerNotFoundException(final ObjectNotFoundException exception) {
        log.warn("Object not found {}", exception.getMessage());
        return new ErrorResponse("Object not found", exception.getMessage());
    }

    public ErrorResponse handlerBadRequest(final BadRequestException exception) {
        log.warn("Object not available {}", exception.getMessage(), exception);
        return new ErrorResponse("Object not available", exception.getMessage());
    }

    public ErrorResponse handlerUnsupportedState(final UnsupportedStateException exception) {
        log.warn("Internal Error {}", exception.getMessage(), exception);
        return new ErrorResponse(exception.getMessage(), exception.getMessage());
    }
}
