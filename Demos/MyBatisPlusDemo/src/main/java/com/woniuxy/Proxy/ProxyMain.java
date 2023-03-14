package com.woniuxy.Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyMain {


    public static void main(String[] args) {

        //    参数一:  类加载器,不需要太多关注
        //    参数二: 代理类要实现哪些接口
        //    参数三:  当代理类的方法被调用时会被触发
        BookMapper bookMapper = (BookMapper) Proxy.newProxyInstance(BookMapper.class.getClassLoader(), new Class[]{BookMapper.class}, new InvocationHandler() {

            //方法的返回值: 被代理的方法最终要返回的值
            @Override         // 生成的那个代理对象    当前执行的方法    当前执行方法的参数
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //System.out.println(proxy);   //不要这么写,会造成死循环
//                System.out.println(method);
//                System.out.println(args);

                Object result = null;

                if (method.getName().equalsIgnoreCase("countBooks")){
                    System.out.println("确定要执行的sql语句");
                    System.out.println("执行sql语句,获取结果");
                    result = 666; //模拟我们sql语句执行的结果
                } else if (method.getName().equalsIgnoreCase("getBookNameById")){
                    System.out.println("确定要执行的sql语句");
                    System.out.println("执行sql语句,获取结果");
                    result = "葵花宝典"; //模拟我们sql语句执行的结果
                }

                //返回sql执行的结果
                return result;
            }
        });

        Integer integer = bookMapper.countBooks();
        System.out.println(integer);

        String bookName = bookMapper.getBookNameById(6);
        System.out.println(bookName);

    }


}
