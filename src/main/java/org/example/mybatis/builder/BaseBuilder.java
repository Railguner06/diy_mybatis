package org.example.mybatis.builder;

import org.example.mybatis.session.Configuration;

/**
 * 构建器的基类，建造者模式
 */
public abstract class BaseBuilder {

    protected final Configuration configuration;

    /**
     * 接受传进来的configuration
     * @param configuration
     */
    public BaseBuilder(Configuration configuration) {
        this.configuration = configuration;
    }

    public Configuration getConfiguration() {
        return configuration;
    }

}

