package my.restapi.controller.advice;

import my.restapi.dto.MessageDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ProductAdvice {

    @ExceptionHandler(NullPointerException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public MessageDTO processNullPointerException( NullPointerException exception){
        MessageDTO messageDTO = new MessageDTO();
        messageDTO.setMessage("Error found: " + exception.getMessage());
        messageDTO.setType("ERROR");
        return messageDTO;
    }
}
