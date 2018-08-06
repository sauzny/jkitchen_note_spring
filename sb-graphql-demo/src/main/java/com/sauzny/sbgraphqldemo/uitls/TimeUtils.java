package com.sauzny.sbgraphqldemo.uitls;

import java.time.LocalDateTime;
import java.time.ZoneId;

public final class TimeUtils {

    private TimeUtils(){}
    
    // 01. java.util.Date --> java.time.LocalDateTime
    public static LocalDateTime UDateToLocalDateTime(java.util.Date date) {
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }
}
