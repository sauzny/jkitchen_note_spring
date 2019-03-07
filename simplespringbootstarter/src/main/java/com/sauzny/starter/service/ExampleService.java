package com.sauzny.starter.service;

/***************************************************************************
 *
 * @时间: 2019/3/7 - 14:45
 *
 * @描述: TODO
 *
 ***************************************************************************/
public class ExampleService {
    private String prefix;
    private String suffix;

    public ExampleService(String prefix, String suffix) {
        this.prefix = prefix;
        this.suffix = suffix;
    }
    public String wrap(String word) {
        return prefix + word + suffix;
    }
}
