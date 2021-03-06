package basic.reflection.classinfo;

import java.lang.reflect.Modifier;
import java.util.Arrays;

public class App {
    public static void main(String[] args) {

        Clazz clazz = new Clazz();
        Class<Clazz> clazzClass = Clazz.class;

        System.out.println("๐[ Fields ]");
        Arrays.stream(clazzClass.getFields()).forEach(f -> {
            try {
                System.out.println(f + " -> " + f.get(clazz));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        });

        System.out.println("\n๐[ DeclaredFields ์กฐํ ]");
        Arrays.stream(clazzClass.getDeclaredFields()).forEach(f -> {
            try {
                f.setAccessible(true);
                System.out.println(f + " -> " + f.get(clazz));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        });

        System.out.println("\n๐[ DeclaredMethods ์กฐํ ]");
        Arrays.stream(clazzClass.getDeclaredMethods()).forEach(System.out::println);

        System.out.println("\n๐[ Constructors ์กฐํ ]");
        Arrays.stream(clazzClass.getConstructors()).forEach(System.out::println);

        System.out.println("\n๐[ SuperClass ์กฐํ ]");
        System.out.println(ExtendedClazz.class.getSuperclass());

        System.out.println("\n๐[ Interface ์กฐํ ]");
        Arrays.stream(ExtendedClazz.class.getInterfaces()).forEach(System.out::println);

        System.out.println("\n๐[ Modifiers ํ์ธ ]");
        Arrays.stream(clazzClass.getDeclaredFields()).forEach(f -> {
            int modifiers = f.getModifiers();
            System.out.println(f);
            System.out.println("-> Modifier.isPrivate(modifiers) = " + Modifier.isPrivate(modifiers));
            System.out.println("-> Modifier.isStatic(modifiers) = " + Modifier.isStatic(modifiers));
        });
    }
}
