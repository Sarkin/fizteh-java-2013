package ru.fizteh.fivt.students.valentinbarishev.proxy;

import java.io.Writer;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler {

    private Writer writer;
    private Object implementation;

    public MyInvocationHandler(Writer newWriter, Object newImplementation) {
        writer = newWriter;
        implementation = newImplementation;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().equals("hashCode") || method.getName().equals("toString") ||
                method.getName().equals("equals")) {
            return method.invoke(implementation, args);
        }

        Object result = null;
        MyLogWriter log = new MyLogWriter(implementation, method, args);
        try {
            result = method.invoke(implementation, args);
            log.setReturnValue(result);
        } catch (InvocationTargetException e) {
            Throwable exception = e.getTargetException();
            log.setException(exception);
            throw exception;
        } finally {
            try {
                writer.write(log.write());
                writer.write(System.lineSeparator());
            } catch (Exception e) {
                //silent
            }
        }

        return result;
    }
}
