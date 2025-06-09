package br.com.encibra.base.shared.output;

import br.com.encibra.base.shared.HttpException;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

public class HttpExceptionOutput {

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Schema(description = "Data e hora da ocorrência do erro", example = "2021-08-25 10:15:30")
    protected LocalDateTime timestamp = LocalDateTime.now();

    @Schema(description = "Código do erro", example = "400")
    private int code;

    @Schema(description = "Tipo do erro", example = "Bad Request")
    private String error;

    @Schema(description = "Mensagem de erro", example = "Ocorreu um erro ao processar a requisição")
    private String message;

    public HttpExceptionOutput(HttpException exception) {
        this.error = exception.getError();
        this.message = exception.getMessage();
        this.code = exception.getStatus();
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}