public class Dog {
	public int weight;

	/** 这是一个实例化成员，最好通过Dog.name调用
	 *  如果Dog d = new Dog(1); d.name则会引发歧义，不符合规范
	 *  因为static成员是所有类的对象所共有的，不依赖对象存在的
	 */
	public static String name = "Cardian";

	public Dog(int w) {
		weight = w;
	}

	public void makeNoise() {
		if (weight < 10) {
			System.out.println("wowowowo!");
		} else if (weight < 30) {
			System.out.println("hhhhhhhh!");
		} else {
			System.out.println("aooooooo!");
		}
	}

	/** static method. 可以直接Dog.largerDog调用 
	 * Math.pow就是static方法
	 */
	public static Dog largerDog(Dog d1, Dog d2) {
		if (d1.weight > d2.weight) {
			return d1;
		}
		return d2;
	}

	/** non-static method. 在创建实例后可以调用 */
	public Dog largerDog(Dog d) {
		if (this.weight > d.weight) {
			return this;
		}
		return d;
	}
}
