package org.saurabhsood.controllers.controller;

import javassist.tools.web.BadHttpRequest;
import org.saurabhsood.controllers.config.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.file.NoSuchFileException;

@ControllerAdvice
public class GlobalControllerExceptionHandler  {

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
}