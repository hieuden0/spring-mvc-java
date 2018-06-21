package org.saurabhsood.controllers.controller;

import javassist.tools.web.BadHttpRequest;
import org.saurabhsood.controllers.config.ResourceNotFoundException;
import org.saurabhsood.controllers.exception.ExceptionResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import java.io.IOException;

@ControllerAdvice
public class GlobalControllerExceptionHandler  implements ExceptionMapper<ResourceNotFoundException> {

    @ExceptionHandler(NoHandlerFoundException.class)
    public ModelAndView noHandlerFoundException(HttpServletRequest request, Exception e)   {
        ModelAndView mav = new ModelAndView("error/error");
        mav.addObject("exception", e);
        return mav;
    }


    @ExceptionHandler(IOException.class)
    public ModelAndView myError(Exception exception) {
        ModelAndView mav = new ModelAndView("error/error");
        mav.addObject("exception", exception);
        return mav;
    }

    @ExceptionHandler(BadHttpRequest.class)
    public ModelAndView baddRequest(HttpServletRequest request, Exception e)   {
        ModelAndView mav = new ModelAndView("error/error");
        mav.addObject("exception", e);
        return mav;
    }



    @ExceptionHandler(Exception.class)
    public ModelAndView exception(HttpServletRequest request, Exception e)   {
        ModelAndView mav = new ModelAndView("error/error");
        mav.addObject("exception", e);
        return mav;
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ModelAndView aaexception(HttpServletRequest request, Exception e)   {
        ModelAndView mav = new ModelAndView("error/error");
        mav.addObject("exception", e);
        return mav;
    }

    @Override
    public Response toResponse(ResourceNotFoundException exception) {
        ExceptionResponse response = new ExceptionResponse();
        response.setErrorCode("resource not found");
        response.setErrorMessage(exception.getMessage());

        return Response.status(404).entity(response)
                .type("application/json").build();
    }
}