public class Matrix{
	private int[][] arr;
	
	public int[][] getMatrix(){
		return arr;
	}
	
	public Matrix(int a,int b){
		arr = new int[a][b];
		for(int i=0; i<a; i++){
			for(int j=0; j<b; j++){
				arr[i][j]=1;
			}
		}
	}
	
	public void setElement(int x,int y){
		if(x<arr[0].length&&y<arr.length){
			arr[x][y]++;
		} else{
			System.out.println("out of bounds");
		}
	}
	
	public void setRow(int r,String s){
		String val[] = s.split(",");
		if(r<arr.length&&arr[r].length==val.length){
			for(int i=0; i<val.length; i++){
				arr[r][i]=Integer.parseInt(val[i]);
			}
		} else{
			System.out.println("invalid string");
		}
	}
	
	public void setColumn(int c,String s){
		String val[] = s.split(",");
		if(c<arr[0].length&&arr.length==val.length){
			for(int i=0; i<val.length; i++){
				arr[i][c]=Integer.parseInt(val[i]);
			}
		} else{
			System.out.println("invalid string");
		}
	}	
	
	public String toString(){
		String ret = "";
		for(int i=0; i<arr.length; i++){
			for(int j=0; j<arr[0].length; j++){
				ret = ret + arr[i][j] + ",";
			}
			ret = ret.substring(0,ret.length()-1) + ";";
		}
		return ret;
	}
	
	public void prettyPrint(){
		for(int i=0; i<arr.length; i++){
			for(int j=0; j<arr[0].length; j++){
				System.out.print(arr[i][j]+"\t");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	void setMatrix(String s){
		String[] rows = s.split(";");
		if(rows.length!=arr.length){
			System.out.println(rows.length + " mismatches row number "+arr.length);
			return;
		}
		for(int i=0; i<arr.length; i++){
			String[] cols = rows[i].split(",");
			if(cols.length!=arr[0].length){
				System.out.println("invalide column number: "+cols.length);
				return;
			}			
			for(int j=0; j<cols.length; j++){
				arr[i][j] = Integer.parseInt(cols[j]);
			}
		}
	}
}