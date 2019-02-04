public class InnerClass{

	public static void main(String[]args){
		SortingHat hat = new SortingHat();
		System.out.println(hat);

		Wizard wizard = new Wizard("Fire");
		System.out.println(wizard);

		Wizard.Wand wand = new Wizard.Wand();
		System.out.println(wand);
	}
//does not HAVE to be static in android apps
	public static class SortingHat{
		private String house;
		private String name;

		public SortingHat(){
			house = "Hufflepuff";
			name = "harry potter";
		}
		public String toString(){
			return house+"!";
		}
	}

}