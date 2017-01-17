package io.keyell.easyboot.lang.object;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * 获取对象的内存地址
 * 不安全，GC会改变对象的地址
 * Created by huangke on 2017/1/18.
 */
public class Addressor {
    private static Unsafe unsafe;

    static {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            unsafe = (Unsafe) field.get(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static long addressOf(Object o)
            throws Exception {
        Object[] array = new Object[]{o};

        long baseOffset = unsafe.arrayBaseOffset(Object[].class);
        int addressSize = unsafe.addressSize();
        long objectAddress;
        switch (addressSize) {
            case 4:
                objectAddress = unsafe.getInt(array, baseOffset);
                break;
            case 8:
                objectAddress = unsafe.getLong(array, baseOffset);
                break;
            default:
                throw new Error("unsupported address size: " + addressSize);
        }

        return (objectAddress);
    }


    public static void main(String... args)
            throws Exception {
        Dog dog = new Dog("DogA");

        long address = addressOf(dog);

        System.out.println("main中的dog对象的地址: " + address);

        f(dog);

        System.out.println("调用了f方法后，main中的dog对象的地址: " + address);

        System.out.println(dog.getName());

        //Verify address works - should see the characters in the array in the output
//        printBytes(address, 27);

    }

    public static void f(Dog dog) throws Exception{
        dog.setName("Dog AA");
        System.out.println("方法中传递的（复制的）dog的地址:" + addressOf(dog));

        dog = new Dog("Dog B");
        System.out.println("方法中dog指向新地址:" + addressOf(dog));

        System.out.println(dog.getName());

    }

    public static void printBytes(long objectAddress, int num) {
        for (long i = 0; i < num; i++) {
            int cur = unsafe.getByte(objectAddress + i);
            System.out.print((char) cur);
        }
        System.out.println();
    }
}
