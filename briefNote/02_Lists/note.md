# List

Java没有指针，也就意味着我们无从获得变量的地址。这样虽然削弱了我们对程序的控制，但是更加安全。书中用了形象的比喻：我们无法控制自己的心跳，却能防止愚蠢的错误（比如手动停掉）。

一个变量只是被声明，那么我们无法access it。只有将值赋给它，我们才能使用。所以说Java是很安全的语言，虽然程序员的控制受限（也是我不太喜欢的原因）

The Golden Rule of Equals：`=` 将一个变量的bits赋到另一个变量

reference type的变量（数组、类）都占有64位，正是地址的位数，所以他们存储的是地址。如果是 `Walrus b; b = a`，则先声明b（此时b是undefined，并不是null），然后把a里面的地址扔给b，所以 `b.weight` 可以改变 `a.weight` 的值

The Law of the Broken Futon

[Java visualizer](https://cscircles.cemc.uwaterloo.ca/java_visualize/): 可以更直观地看代码情况，比如链表 

**链表的size**

```java
/** Return the size of the list, using recursion */
public int size() {
    if (this.rest == null)
        return 1;
    return 1 + this.rest.size();
}

// second recursive way
public int recSize(IntList L, int s) {
    if (L == null)
        return s;
    return recSize(L.rest, s + 1);
}

/** Return the size of the list, without recursion */
public int size() {
    IntList p = this;
    int totalSize = 0;	// aesthetic naming
    while (p != null) {
        totalSize += 1;
        p = p.rest;
    }
    return totalSize;
}
```

we took off like a rocket and developed this list thing at light speed.

# Arrays

数组被创建时，如果没有指定元素那么就是default value

```java
int[] a = new int[3];	// {0, 0, 0}
int[][] TwoDimensionArray = new int[3][];	// {null, null, null}
int[][] TwoDimensionGivenArray = new int[3][3]	// {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}}
```

System.arraycopy(a, 0, b, 1, 2)：把a的0、1元素拷贝到b的1、2元素，速度更快，且代码更紧凑

reflections，对比hard-coded dot notation

> Given an instance of a class, it is possible to use reflection to set the values of fields in that class. This is typically done only in special circumstances when setting the values in the usual way is not possible. Because such access usually violates the design intentions of the class, it should be used with the utmost discretion.

[为什么获取第i个数组元素是常数时间](https://www.quora.com/Why-does-accessing-an-array-element-take-constant-time)

Generic ALists:

Java不允许直接创建泛型数组，比如我们不能直接写

```java
Item[] items = new Item[100];
```

正确的写法是

```java
Item[] items = (Item []) new Object[100];	// 会给出编译器警告，但无需在意
```

此外，在generic aList中，如果有用不到的元素就要及时改成null，以防止loiter，造成不必要的内存浪费

# Lab2 debug技巧

step into：一步一步执行
step over： 跳过实现细节，abstractions

当我们误用step into进入一个函数后，可以使用step out跳出

**The**re **a**re **ve**ry **stra**nge **funct**ions **th**at **u**se **syn**tax **a**nd **b**ad **co**de **sty**le **t**o **d**o **ea**sy **tas**ks **i**n **a**n **incre**dibly **obt**use **w**ay. 所以我们不必知道函数具体的实现细节，直接step over，如果出错了再看函数

神奇的resume：在循环语句中不断执行到breakpoint，比一次次step over快多了

Evaluate Expression：可以计算local variable的值

conditional breakpoints：右击breakpoint，可以设置断点的条件，you will land where you want to be.

**D**o**n**’t **b**e **afr**aid **t**o **pu**ll **o**ut **p**en **a**nd **pap**er **o**r **g**o **t**o **t**he **white**board **a**nd **wo**rk **o**ut **so**me **exam**ples! **I**f **y**ou **g**et **stu**ck, **draw**ing **o**ut **t**he **poin**ters **c**an **prob**ably **stimu**late **y**ou **ba**ck **on**to **t**he **pa**th **o**f **prog**ress.

### Java files have a red circle, with a J inside the circle, next to the file icon

Right-click the folder containing that Java file > Mark as > Sources Root.

