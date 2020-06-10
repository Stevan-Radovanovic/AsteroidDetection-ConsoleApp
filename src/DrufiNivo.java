import java.util.LinkedList;

public class DrufiNivo {

	LinkedList<Oblik> ob;
	LinkedList<Integer> ID= new LinkedList<>();
	
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ob == null) ? 0 : ob.hashCode());
		return result;
	}




	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof DrufiNivo))
			return false;
		DrufiNivo other = (DrufiNivo) obj;
		if (ob == null) {
			if (other.ob != null)
				return false;
		}
		
		for(int i=0;i<ob.size()-1;i++) {
			if(ob.get(i).prvi-ob.get(i+1).prvi!=other.ob.get(i).prvi-other.ob.get(i+1).prvi) return false;
			if(ob.get(i).drugi-ob.get(i+1).drugi!=other.ob.get(i).drugi-other.ob.get(i+1).drugi) return false;
		}
		return true;
		
		//return true;
	}




	public DrufiNivo(LinkedList<Oblik> ob) {
		super();
		this.ob = ob;
	}

	
	
}
