package basic.reflection.annotation;

import basic.reflection.classinfo.Clazz;
import basic.reflection.classinfo.ExtendedClazz;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        System.out.println("\n๐[ Annotations ์กฐํ ]");
        System.out.println(Clazz.class);
        Arrays.stream(Clazz.class.getAnnotations()).forEach(a -> System.out.println("-> " + a));
        System.out.println(ExtendedClazz.class);
        Arrays.stream(ExtendedClazz.class.getAnnotations()).forEach(a -> System.out.println("-> " + a));

        System.out.println("\n๐[ DeclaredAnnotations ์กฐํ ]");
        System.out.println(ExtendedClazz.class);
        Arrays.stream(ExtendedClazz.class.getDeclaredAnnotations()).forEach(a -> System.out.println("-> " + a));

        System.out.println("\n๐[ Field Annotations ์กฐํ ]");
        Arrays.stream(Clazz.class.getDeclaredFields()).forEach(f ->
                Arrays.stream(f.getAnnotations()).forEach(a -> {
                    if (a instanceof AnotherAnnotation) {
                        AnotherAnnotation annotation = (AnotherAnnotation) a;
                        System.out.println(f);
                        System.out.println("-> annotation.value() = " + annotation.value());
                        System.out.println("-> annotation.number() = " + annotation.number());
                    }
                }));

        System.out.println("\n๐[ Method Annotations ์กฐํ ]");
        Arrays.stream(Clazz.class.getDeclaredMethods()).forEach(m -> {
            Arrays.stream(m.getAnnotations()).forEach(a -> {
                if (a instanceof AnotherAnnotation) {
                    AnotherAnnotation annotation = (AnotherAnnotation) a;
                    System.out.println(m);
                    System.out.println("-> annotation.value() = " + annotation.value());
                    System.out.println("-> annotation.number() = " + annotation.number());
                }
            });
        });
    }
}
