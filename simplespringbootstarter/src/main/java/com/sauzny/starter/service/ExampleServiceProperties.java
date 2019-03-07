package com.sauzny.starter.service;

import org.springframework.boot.context.properties.ConfigurationProperties;

/***************************************************************************
 *
 * @时间: 2019/3/7 - 14:45
 *
 * @描述: TODO
 *
 ***************************************************************************/
@ConfigurationProperties("example.service")
public class ExampleServiceProperties {
    private String prefix;
    private String suffix;

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }
}