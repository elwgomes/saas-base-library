package br.com.encibra.base.shared;

import br.com.encibra.base.shared.output.HttpExceptionOutput;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Getter
public abstract class HttpException extends RuntimeException {

    public static final String DEFAULT_ERROR = "Erro ao concluir a operação";
    public static final String DEFAULT_MESSAGE = "Erro desconhecido, por favor entre em contato com o suporte";
    public static final Integer DEFAULT_CODE = 500;

    private final Integer status;
    private final String error;

    public HttpException() {
        super(DEFAULT_MESSAGE);
        this.error = DEFAULT_ERROR;
        this.status = DEFAULT_CODE;
    }

    public HttpException(String message) {
        super(message);
        this.error = DEFAULT_ERROR;
        this.status = DEFAULT_CODE;
    }

    public HttpException(String message, HttpStatus status) {
        super(message);
        this.error = DEFAULT_ERROR;
        this.status = status.value();
    }

    public HttpException(String message, HttpStatus status, String error) {
        super(message);
        this.error = error;
        this.status = status.value();
    }

    public ResponseEntity<HttpExceptionOutput> toResponseEntity() {
        var error = new HttpExceptionOutput(this);
        return ResponseEntity.status(status).body(error);
    }

}