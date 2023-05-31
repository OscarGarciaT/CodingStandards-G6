package maven;

public class Main {
	public static void main(String[] args) {
		Vacation v = new Vacation("New York City",13,1);
		System.out.println(v.setCost(v.getTotalCost()));
	}
}
