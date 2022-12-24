package com.example.EmployeeCrud.model;

import lombok.*;
import org.springframework.http.HttpStatus;

@Data
@Getter
@NoArgsConstructor
@Setter
public class ErrorMessage {

    public HttpStatus status;

    public ErrorMessage(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public String message;


}
