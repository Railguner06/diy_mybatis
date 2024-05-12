package org.example.mybatis.session;

import org.example.mybatis.builder.xml.XMLConfigBuilder;
import org.example.mybatis.session.defaults.DefaultSqlSessionFactory;

import java.io.Reader;

/**
 * 构建SqlSessionFactory的工厂
 */
public class SqlSessionFactoryBuilder {

    /**
     * 将解析的configuration传进来，创建SqlSessionFactory
     * @param reader
     * @return
     */
    public SqlSessionFactory build(Reader reader) {
        XMLConfigBuilder xmlConfigBuilder = new XMLConfigBuilder(reader);
        return build(xmlConfigBuilder.parse());
    }

    public SqlSessionFactory build(Configuration config) {
        return new DefaultSqlSessionFactory(config);
    }

}

