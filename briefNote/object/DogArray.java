public class DogArray {
	public static void main(String[] args) {
		/* 可以把dog数组看做是dog house，但是在对元素new前是个空房子
		 * 而new Dog(num)就是把狗放进房子
		 */
		Dog[] dog = new Dog[2];
		dog[0] = new Dog(20);
		dog[1] = new Dog(50);
		dog[0].makeNoise();

	}
}
