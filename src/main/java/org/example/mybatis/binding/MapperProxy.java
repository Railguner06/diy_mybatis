package org.example.mybatis.binding;

import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * 映照器代理类
 * @param <T>
 */
public class MapperProxy<T> implements InvocationHandler, Serializable {

    private static final long serialVerionUID = -6424540398559729838L;

    //数据库语句操作，都是通过接口名称+方法名称作为key
    private Map<String,String> sqlSession;

    private final Class<T> mapperInterface;

    public MapperProxy(Map<String,String> sqlSession,Class<T> mapperInterface){
        this.sqlSession = sqlSession;
        this.mapperInterface = mapperInterface;
    }

    @Override
    public Object invoke(Object proxy, Method method,Object[] args) throws Throwable{
        if (Object.class.equals(method.getDeclaringClass())){
            return method.invoke(this,args);
        }else {
            return "你的被代理了！" + sqlSession.get(mapperInterface.getName() + "." + method.getName());
        }
    }
}
