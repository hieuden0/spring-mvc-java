package org.saurabhsood.controllers.uniquity;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class LogUtil extends Logger {

    public LogUtil(String name) {
        super(name);
        BasicConfigurator.configure();
    }

}
