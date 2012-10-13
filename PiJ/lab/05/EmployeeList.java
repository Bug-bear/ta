public class EmployeeList{
	private String[] names = new String[3];
	private int[] IDs = new int[3];
	private int ctr;
	
	public void readName(String str){
		ctr++;
		if(ctr>names.length){
			String[] update = new String[names.length*2];
			for(int i=0; i<names.length; i++){
				update[i]=names[i];
			}
			names = update;
		}
		names[ctr-1] = str;
		
	}
	
	public void readID(int num){
		if(ctr>IDs.length){
			int[] update = new int[IDs.length*2];
			for(int i=0; i<IDs.length; i++){
				update[i]=IDs[i];
			}
			IDs = update;
		}
		IDs[ctr-1] = num;
	}	
	
	public String getName(int pos){
		return names[pos];
	}
	
	public int getID(int pos){
		return IDs[pos];
	}
}