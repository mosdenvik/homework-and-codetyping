package repka_skazka;

public class Repka {
	private String nameRepka;
	private String colorRepka;
	private static int weightRepka;
	

	public String getNameRepka() {
		return nameRepka;
	}
	public void setNameRepka(String nameRepka) {
		this.nameRepka = nameRepka;
	}
	public String getColorRepka() {
		return colorRepka;
	}
	public void setColorRepka(String colorRepka) {
		this.colorRepka = colorRepka;
	}
	public static int getWeightRepka() {
		return weightRepka;
	}
	public void setWeightRepka(int weightRepka) {
		Repka.weightRepka = weightRepka;
	}
	

	public Repka(){
	}
	
	public Repka(String nameRepka, String colorRepka, int weightRepka){
		this.nameRepka = nameRepka;
		this.colorRepka = colorRepka;
		Repka.weightRepka = weightRepka;
	}
	
	public static Repka createRepka(String nameRepka, String colorRepka, int weightRepka){
		Repka repka = new Repka();
		repka.setNameRepka(nameRepka);
		repka.setColorRepka(colorRepka);
		repka.setWeightRepka(weightRepka);
		return repka;
	}
	
	public static boolean isRepkaAlive(){
		while(AllObjectsOfSkazka.generalPowerOfAllObjects() == weightRepka){
			return true;
		}
		return false; 
	}
	
	@Override
	public String toString() {
		return "Repka [name: " + nameRepka + ", color: " + colorRepka + ", weight: "
				+ weightRepka +  "]";
	}
	
	

}
