package org.saurabhsood.controllers.uniquity;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.saurabhsood.controllers.controller.LocationController;

public class LogUtil  {
    public static void trace(Class passClass, String msg){
        Logger log = Logger.getLogger(passClass);
        log.trace(msg);
    }

    public static void debug(Class passClass, String msg){
        Logger log = Logger.getLogger(passClass);
        log.debug(msg);
    }

    public static void error(Class passClass, String msg){
        Logger log = Logger.getLogger(passClass);
        log.error(msg);
    }

    public static void fatal(Class passClass, String msg){
        Logger log = Logger.getLogger(passClass);
        log.fatal(msg);
    }

    public static void warn(Class passClass, String msg){
        Logger log = Logger.getLogger(passClass);
        log.warn(msg);
    }

    public static void info(Class passClass, String msg){
        Logger log = Logger.getLogger(passClass);
        log.info(msg);
    }

}
