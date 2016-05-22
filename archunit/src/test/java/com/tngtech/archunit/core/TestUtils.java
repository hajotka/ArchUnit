package com.tngtech.archunit.core;

import java.util.HashSet;
import java.util.Set;

import com.google.common.base.Optional;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TestUtils {
    public static JavaMethod javaMethod(String name, Class<?> owner) {
        return javaMethod(name, javaClass(owner));
    }

    public static JavaMethod javaMethod(String name, JavaClass clazz) {
        try {
            return new JavaMethod.Builder().withMethod(clazz.reflect().getDeclaredMethod(name)).build(clazz);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    public static JavaClass javaClass(Class<?> owner) {
        JavaClass javaClass = new JavaClass.Builder().withType(owner).build();
        ClassFileImportContext context = mock(ClassFileImportContext.class);
        when(context.tryGetJavaClassWithType(any(Class.class))).thenAnswer(new Answer<Optional<JavaClass>>() {
            @Override
            public Optional<JavaClass> answer(InvocationOnMock invocation) throws Throwable {
                return Optional.of(javaClass((Class<?>) invocation.getArguments()[0]));
            }
        });
        javaClass.completeClassHierarchyFrom(context);
        return javaClass;
    }

    public static JavaField javaField(String name, Class<?> ownerClass) throws NoSuchFieldException {
        return new JavaField.Builder()
                .withField(ownerClass.getDeclaredField(name))
                .build(javaClass(ownerClass));
    }

    public static JavaClasses javaClasses(Class<?>... classes) {
        Set<JavaClass> result = new HashSet<>();
        for (Class<?> c : classes) {
            result.add(javaClass(c));
        }
        return new JavaClasses(result);
    }

    static class ClassWithMethodNamedMethod {
        String method() {
            return null;
        }
    }

    static class AnotherClassWithMethodNamedMethod {
        String method() {
            return null;
        }
    }

    static class ClassWithFieldNamedValue {
        String value;
    }

    static class AnotherClassWithFieldNamedValue {
        String value;
    }
}