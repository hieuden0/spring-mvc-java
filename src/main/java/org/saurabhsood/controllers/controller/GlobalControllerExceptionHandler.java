package org.saurabhsood.controllers.controller;

import javassist.tools.web.BadHttpRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;
import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalControllerExceptionHandler  {

    @ExceptionHandler(NoHandlerFoundException.class)
    public ModelAndView handleError404(HttpServletRequest request, Exception e)   {
        ModelAndView mav = new ModelAndView("error/error");
        mav.addObject("exception", e);
        //mav.addObject("errorcode", "404");
        return mav;
    }

    @ExceptionHandler(BadHttpRequest.class)
    public ModelAndView baddRequest(HttpServletRequest request, Exception e)   {
        ModelAndView mav = new ModelAndView("error/error");
        mav.addObject("exception", e);
        //mav.addObject("errorcode", "404");
        return mav;
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView exception(HttpServletRequest request, Exception e)   {
        ModelAndView mav = new ModelAndView("error/error");
        mav.addObject("exception", e);
        //mav.addObject("errorcode", "404");
        return mav;
    }
}