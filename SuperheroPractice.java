import java.util.ArrayList;

public class SuperheroPractice{

	public static void main(String[]args){

	IronMan man = new IronMan();
	System.out.println(man);
	}

	public static class IronMan {

		private int power;
		private String name;
		private int speed;

		public IronMan(){
			this.power = 55;
			this.name = "obert";
			this.speed = 10;
		}
		public int getPower(){
			return power;
		}
		public int getSpeed(){
			return speed;
		}
		public String getName(){
			return name;
		}
		public String toString(){
			return "This Iron Man's name is "+name +", and has a speed and power of "+ speed + " " + power;
		}

	}

}


