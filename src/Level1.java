import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class Level1 {

	public static void main(String[] args) {
		Scanner fScn;
		try {
			fScn = new Scanner(new File("test/lvl3-3.inp"));
			String data = fScn.nextLine();
			LinkedList<DrufiNivo> sviOblici = new LinkedList<>();
			String[] token = data.split(" ");
			int pocetak = Integer.parseInt(token[0]);
			int kraj = Integer.parseInt(token[1]);
			int kolikoIhJe = Integer.parseInt(token[2]);
			Slika[] nizSlika = new Slika[kolikoIhJe];
			for (int i = 0; i < kolikoIhJe; i++) {
				int time = fScn.nextInt();
				int red = fScn.nextInt();
				int kol = fScn.nextInt();
				int[][] mat = new int[red][kol];
				for (int j = 0; j < red; j++) {
					for (int j2 = 0; j2 < kol; j2++) {
						mat[j][j2] = fScn.nextInt();
					}
				}

				Slika sl = new Slika(time, red, kol, mat);
				if(!sl.nadjiAsteroid()) continue;
				sl.napuniOblik();
				DrufiNivo novi = new DrufiNivo(sl.oblik);

				if (!sviOblici.contains(novi)) {

					novi.ID.add(sl.time);
					sviOblici.add(novi);

				} else {
					int index = sviOblici.indexOf(novi);
					sviOblici.get(index).ID.add(sl.time);
				}
				nizSlika[i] = sl;

			}

			for (int i = 0; i < sviOblici.size(); i++) {
				LinkedList<Integer> vremena=sviOblici.get(i).ID;
					for(int j=0;j<vremena.size()-1;j++)
					{
						for(int j2=j+1;j2<vremena.size();j2++)
						{
							if(vremena.get(j2)==-1 || vremena.get(j)==-1)
								continue;
							//int razlika=Math.abs(vremena.get(j2)-vremena.get(j));
							int razlika=vremena.get(j2)-vremena.get(j);
							if(!vremena.contains(vremena.get(j2)+razlika) || !vremena.contains(vremena.get(j2)+2*razlika) )
								continue;
							int brojac=1;
							int poslednji=0;
							int prvi=vremena.get(j);
							//vremena.set(j, -1);
							while(vremena.contains(prvi+brojac*razlika) && prvi+brojac*razlika>0 )
							{
								poslednji=vremena.get(vremena.indexOf(prvi+brojac*razlika));

								vremena.set(vremena.indexOf(prvi+brojac*razlika), -1);

								brojac++;
							}
							
								System.out.println(prvi + " "+ poslednji + " "+ brojac);
						}
					}
				
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
