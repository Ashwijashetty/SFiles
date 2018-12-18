
	enum Gende {
	    Male('M'), Female('F');
	
	private int gen;
	  private Gende(int gen) {
		this.gen = gen;
	}
	public int getgen() {
		return gen;
	}
	public void setgen(int gen) {
		this.gen = gen;
	}
	  }

    public class Gender {
	public static void main(String args[]){
		System.out.println("Gender is Male  "+Gende.Male.getgen());
		System.out.println("Gender is Female  "+Gende.Female.getgen());
		
	}
}