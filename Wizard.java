public class Wizard{

	private String magicStyle;

	public Wizard(String magicStyle){

		this.magicStyle = magicStyle;

	}
	public String toString(){

		return magicStyle +  " is the magicStyle";
	}

	public static class Wand{
		private String core;

		public Wand(){
			core = "Pheonix Feather";
		}
		public String toString(){
			return "The core is " + core;
		}
	}


}