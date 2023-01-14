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