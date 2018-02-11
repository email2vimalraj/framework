package com.altimetrik.listeners;

import org.testng.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class TestNGListenerInvoker implements IInvokedMethodListener {
    private List<ITestNGListener> listeners = new LinkedList<>();

    public TestNGListenerInvoker() {
        initialiseListeners();
    }

    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        for (ITestNGListener listener : listeners) {
            //Lets filter out only IInvokedMethodListener instances.
            if (listener instanceof IInvokedMethodListener) {
                ((IInvokedMethodListener) listener).beforeInvocation(method, testResult);
            }
        }
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        for (ITestNGListener listener : listeners) {
            //Lets filter out only IInvokedMethodListener instances.
            if (listener instanceof IInvokedMethodListener) {
                ((IInvokedMethodListener) listener).afterInvocation(method, testResult);
            }
        }
    }

    private void initialiseListeners() {
        String file = "META-INF/services/listeners.txt";
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(getStream(file)))) {
            String line;
            while ((line = reader.readLine()) != null) {
                listeners.add(instantiate(line));
            }
        } catch (IOException e) {
            throw new TestNGException(e);
        }
    }

    private static InputStream getStream(String file) {
        InputStream stream;
        stream = Thread.currentThread().getContextClassLoader().getResourceAsStream(file);
        if (stream == null) {
            throw new IllegalStateException("Unable to locate the file " + file);
        }
        return stream;
    }

    private static ITestNGListener instantiate(String className) {
        if (className == null || className.trim().isEmpty()) {
            throw new IllegalArgumentException("Please provide a valid class name");
        }
        try {
            Class<?> clazz = Class.forName(className);
            if (! ITestNGListener.class.isAssignableFrom(clazz)) {
                throw new IllegalArgumentException(className + " does not implement a TestNG listener");
            }
            return (ITestNGListener) clazz.newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            throw new TestNGException(e);
        }
    }
}
