package main;

public class Config {

    // Debug mode
    public static final boolean DEBUG = false;

    // Whether to use sleep method or delta method for time system
    public static final boolean TIME_SLEEP = false;
    public static final boolean TIME_DELTA = true;

    public static boolean TIME_SYSTEM = TIME_DELTA;

    // Whether to use WASD or the D-Pad
    public static final boolean DIR_WASD = false;
    public static final boolean DIR_DPAD = true;

    public static boolean DIR_SYSTEM = DIR_DPAD;
}
