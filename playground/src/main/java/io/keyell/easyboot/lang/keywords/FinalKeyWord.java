package io.keyell.easyboot.lang.keywords;

/**
 * final 关键字的理解
 * 1. final class
 * 2. final method
 * 3. final parameter
 * 4. final variable
 * Created by huangke on 2017/1/18.
 */
public class FinalKeyWord {

    public final int i; // blank final
    public static final int j; // 静态的blank final

    {
        i = 0; // 在构造函数前调用
    }

    static {
        j = 0; // 类加载时调用
    }

    public FinalKeyWord() {
        // i = 1; 在初始化代码块中已经被赋值，不能再被赋值了
    }

    public FinalKeyWord(int num) {
        // i = num; 不能再被赋值了
    }

    final void f() {
        // final method 不能在子类中被重写
    }

    void g(final int num) { // final的参数

        final int a = 1; // final的局部变量 局部变量直接赋值
        final int b; // 分开赋值
        b = num;

//        num++; // 可以读取num，但不能更改参数num

        final int c; // 未使用的变量c，此时编译正常
        int d; // 局部变量没有默认值 default value，只有类的成员变量才会被默认赋值

        System.out.println(a);
        System.out.println(b);
//        System.out.println(c);  // 使用了未初始化的c，编译错误
//        System.out.println(d);  // 使用了未初始化的d，编译错误

    }

    int k = 0;

    void h() { // 在匿名类的方法中，使用外面的final局部变量
        int a = 0;

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(a + 1); // OK 没有修改a的值
//                a = 1; // 编译错误，局部变量a必须是final的
                k = 2;
            }
        };
    }

    public static void main(String[] args) {
        FinalKeyWord finalKeyWord = new FinalKeyWord();
        finalKeyWord.g(2);
    }

}

final class FinalClass {
    // java.lang.String  就是一个final class
}

//class A extends FinalClass {
// 编译错误 FinalClass不能被继承
//}

class B extends FinalKeyWord {
    // public void f() {} FinalKeyWord中的final的f方法，在子类中不能重写
}

