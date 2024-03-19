package dev.bstk.okk.siscom.core.handlerexception;

import dev.bstk.okk.siscom.core.handlerexception.exception.RecursoNaoEncontradoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {

  @ExceptionHandler(RecursoNaoEncontradoException.class)
  public ResponseEntity<Object> naoEncontrado(final Exception exception) {
    return execute(exception, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<Object> invalido(final MethodArgumentNotValidException exception) {
    final var erros = exception
      .getBindingResult()
      .getFieldErrors()
      .stream()
      .map(FieldError::getDefaultMessage)
      .toList();

    return ResponseEntity
      .status(HttpStatus.BAD_REQUEST)
      .body(new ErroResponse(erros));
  }

  private ResponseEntity<Object> execute(final Exception exception, final HttpStatus status) {
    return ResponseEntity.status(status).body(new ErroResponse(exception.getMessage()));
  }
}
