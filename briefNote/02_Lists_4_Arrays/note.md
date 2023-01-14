数组被创建时，如果没有指定元素那么就是default value

```java
int[] a = new int[3];	// {0, 0, 0}
int[][] TwoDimensionArray = new int[3][];	// {null, null, null}
int[][] TwoDimensionGivenArray = new int[3][3]	// {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}}
```

System.arraycopy(a, 0, b, 1, 2)：把a的0、1元素拷贝到b的1、2元素，速度更快，且代码更紧凑

reflections，对比hard-coded dot notation

> Given an instance of a class, it is possible to use reflection to set the values of fields in that class. This is typically done only in special circumstances when setting the values in the usual way is not possible. Because such access usually violates the design intentions of the class, it should be used with the utmost discretion.
