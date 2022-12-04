package com.example.task01;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;

public class Logger {
    enum Level{
        DEBUG,
        INFO,
        WARNING,
        ERROR;
    }
    private static List<Logger> logs = new ArrayList<>();
    private Level level;
    private Date date;
    private String name;
    private String message;
    public String getName() {
        return name;
    }
    public static Logger getLogger(String name) {
        for (Logger log: logs) {
            if (Objects.equals(log.name, name))
                return log;
        }
        return null;
    }
    public Logger(String name){
        this.name=name;
    }


    private static String getNowTime(){
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        return (formatter.format(calendar.getTime()));
    }

    public void error(String message){
        printMessage(Level.ERROR, message);
    }
    public void error(String format, Object... elements)
    {
        printMessage(Level.ERROR, format, elements);
    }
    public void info(String message){
        printMessage(Level.INFO, message);
    }
    public void info(String format, Object... elements)
    {
        printMessage(Level.INFO, format, elements);
    }

    public void warning(String message){
        printMessage(Level.WARNING, message);
    }
    public void warning(String format, Object... elements)
    {
        printMessage(Level.WARNING, format, elements);
    }
    public void debug(String message){
        printMessage(Level.DEBUG, message);
    }
    public void debug(String format, Object... elements)
    {
        printMessage(Level.DEBUG, format, elements);
    }
    private void printMessage(Level level, String message){
        System.out.println(String.format ("[%s] %s %s - %s",level.name(), Logger.getNowTime(),name,message));
    }
    private void printMessage(Level level, String formatOfMessage, Object elements){
        MessageFormat form = new MessageFormat(formatOfMessage);
        System.out.println(form.format(elements));
    }
    public void setLevel(Level level){
        this.level=level;
    }
    public Level getLevel(){
        return  this.level;
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        } else if (obj instanceof Logger) {
            Logger logger = (Logger) obj;
            return Objects.equals(logger.name, this.name);
        }
        return false;
    }
}
