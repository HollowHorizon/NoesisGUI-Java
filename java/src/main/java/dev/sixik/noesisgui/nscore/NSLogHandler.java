package dev.sixik.noesisgui.nscore;

@FunctionalInterface
public interface NSLogHandler {

    void onLog(String file, long line, long level, String channel, String message);
}
