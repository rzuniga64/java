package java_lessons.lesson2_classes;

public class NameTest {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Name myName = new Name("Raul", "Zuniga");
		Name yourName = new Name("Randy", "Burcham");
		Name dogName = new Name("Cinnamon");
		Name someName = new Name();
		System.out.println("myName: " + myName.toString());
		System.out.println("myName: " + yourName.toString());
		System.out.println("myName: " + dogName.toString());
		System.out.println("myName first name: " + myName.getFirst());
		yourName.setLast("Brown");
		System.out.println("yourName: " + yourName.toString());
		someName.setName("John", "Quincy", "Adams");
		System.out.println("youName: " + someName.toString());
	}
}
