import java.util.LinkedList;

public class Slika {

	
	int time;
	int row;
	int col;
	int[][] slika;
	LinkedList<Oblik> oblik= new LinkedList<>();
	
	public Slika(int time, int row, int col, int[][] slika) {
		super();
		this.time = time;
		this.row = row;
		this.col = col;
		this.slika = slika;
	}
	
	public boolean nadjiAsteroid() {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++)
				if (slika[i][j] != 0)
					return true;

		}
		return false;
	}
	/*
	public Oblik nadjiPozicija() {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++)
				if (slika[i][j] != 0)
					return new Oblik(i, j);

		}
		return null;
	}
	public boolean pronadjiOblik()
	{
		Oblik pocetak=nadjiPozicija();
		if(pocetak!=null)
		{
			
		}
	}*/
	
	public void napuniOblik () {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++)
				if (slika[i][j] != 0)
					oblik.addLast(new Oblik(i,j));

		}
	}
	
	
}
