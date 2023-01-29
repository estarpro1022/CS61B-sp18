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

子类继承了父类的所有成员，但是不包括constructors，然而Java要求所有子类的构造器都要包括对父类构造器的调用。如果没有显式地写`super()`，那么Java会帮你自动调用父类的默认构造器。

`super`也可以带参数，调用父类带参数的constructor

#### 所有类都是[Object类](https://docs.oracle.com/javase/8/docs/api/java/lang/Object.html)的子孙

`SLList<Item> implements List61B`实际上可以显式地写为`SLList<Item> extends Object implements List61B`，这也就意味着Object类的方法可以被所有类调用，比如`.equals(Object obj)` `hashCode()` `toString()`

#### Is-a vs. Has-a

`extends` 用于定义*Is-a*的关系，而不是*has-a*

* `Shower` is a `Bathroom`? NO
* `VengefulSLList` is a `SLList`? YES

#### 封装

**Encapsulation** is one approach that we take to resist our biggest enemy: *complexity*. Managing complexity can differentiate good programmers and bad programmers.

封装隐藏了实现细节，**hide information** from the outside. 比如链表，我们只能通过它提供的方法来进行交互，而无需知晓方法是怎么实现的

