# Interface

`implements List61B<Item>` is essentially a promise. Alist is saying "I promise I will have and define all the attributes and behaviors specified in the List61B interface."

`@Override` annotation：提醒这个方法要被重载，并且帮助检查拼写是否错误，如果在别的方法上包含`@Override`，就会报错

`List61B<String> someList = new AList<>()`，`someList`可以调用`AList`中实现的方法

##### implementation inheritance

interface inheritance中，接口只给出方法的签名，如何实现取决于subclass。但是在implementation inheritance中，在方法签名前加上`default`关键字，就可以写函数体了。

比如在`List61B`接口中

```java
default public void print() {
    for (int i = 0; i < size(); i++) {
        System.out.print(get(i) + " ");
    }
    System.out.println();
}
```

然后`SLList`和`AList`都可以调用这个方法了，但是在`SLList`中的效率太低，所以我们重载print方法

```java
/** SLList.java */
@Override
public void print() {
    for (Node p = sentinel.next; p != null; p = p.next) {
        System.out.print(p.item + " ");
    }
    System.out.println();
}
```

`List61B<String> lst = new SLList<String>();` 

`lst.print()`调用的是哪个方法？--`SLList`的method

通过**dynamic method selection**判断，`lst`的`static type`是在编译时就固定的，`dynamic type`是在运行时决定的，并且能够改变，比如能改成`AList`

> When Java runs a method that is *overriden*, it searches for the appropriate method signature in it's **dynamic type** and runs it.

**IMPORTANT: This does not work for overloaded methods!**

有以下两个重载方法

```java
public static void peek(List61B<String> list) {
    System.out.println(list.getLast());
}
public static void peek(SLList<String> list) {
    System.out.println(list.getFirst());
}
```

运行一下代码

```java
SLList<String> SP = new SLList<String>();
List61B<String> LP = SP;
SP.addLast("elk");
SP.addLast("are");
SP.addLast("cool");
peek(SP);
peek(LP);
```

结果都是"elk"

> When Java checks to see which method to call, it checks the **static type** and calls the method with the parameter of the same type.

# Extends

`super` keyword，可以调用父类的方法

```java
/* 在删除最后一个元素后，将删除的元素保存到deletedItems */
@Override Item removeLast() {
    Item x = super.removeLast();
    deletedItems.addLast(x);
    return x;
}
```

创建的变量记得初始化，比如上面的`deletedItems`，不初始化就会报null pointer exception的错。

初始化有两种方式：Constructor或者直接定义

