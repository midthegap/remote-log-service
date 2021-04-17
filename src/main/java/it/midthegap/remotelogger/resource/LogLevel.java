package it.midthegap.remotelogger.resource;

public enum LogLevel {
    TRACE(2, "TRACE"),
    DEBUG(3, "DEBUG"),
    INFO (4, "INFO "),
    WARN (5, "WARN "),
    ERROR(6, "ERROR");

    private final int level;
    private String description;

    LogLevel(int level, String description) {
        this.level = level;
        this.description = description;
    }

    public int getLevel() {
        return level;
    }

    public String getDescription() {
        return description;
    }
    
    public static LogLevel from(int level) {
        for (LogLevel ll : LogLevel.values()) {
            if (ll.getLevel() == level) {
                return ll;
            }
        }
        
        return null;
    }

}
