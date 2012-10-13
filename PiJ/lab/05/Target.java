public class Target{
	private int[][][] tar;
	private int a, b, c;
	
	public Target(int size){
		tar = new int[size][size][size];
		/* tar should be intitialsed to zeros by default
		for(int i=0; i<tar.length; i++){
			for(int j=0; j<tar[0].length; j++){
				for(int k=0; k<tar[0][0].length; k++){
					System.out.print(tar[i][j][k]);
				}
			}
		}
		*/
	}
	
	public void init(){
		a = (int)Math.abs(tar.length * Math.random());
		b = (int)Math.abs(tar[0].length * Math.random());
		c = (int)Math.abs(tar[0][0].length * Math.random());
		for(int i=0; i<tar.length; i++){
			for(int j=0; j<tar[0].length; j++){
				for(int k=0; k<tar[0][0].length; k++){
					tar[i][j][k] = 0;
				}
			}
		}
		tar[a][b][c] = 1;	
	}
	
	// x: left & right	y: high & low	z: short & long
	public Result fire(int x,int y,int z){
		if(tar[a][b][c] != 1){
			System.out.println("not proper initiated");
			System.out.println("OUT_OF_RANGE");
			return Result.OUT_OF_RANGE;
		}
		if(x>=tar.length || y>=tar[0].length || z>=tar[0][0].length 
			|| x<0 || y<0 || z<0){
			System.out.println("OUT_OF_RANGE");
			return Result.OUT_OF_RANGE;
		}
		
		if(x != a){
			if(x>a){
				System.out.println("FAIL_RIGHT");
				return Result.FAIL_RIGHT;
			}
			else{
				System.out.println("FAIL_LEFT");
				return Result.FAIL_LEFT;
			}
		}
		if(y != b){
			if(y>b){
				System.out.println("FAIL_HIGH");
				return Result.FAIL_HIGH;
			}
			else{
				System.out.println("FAIL_LOW");
				return Result.FAIL_LOW;
			}		
		}
		if(z != c){
			if(z>c){
				System.out.println("FAIL_LONG");
				return Result.FAIL_LONG;
			}
			else{
				System.out.println("FAIL_SHORT");
				return Result.FAIL_SHORT;
			}		
		}	
		
		System.out.println("HIT! (" + a + "," + b + "," + c + ")");
		return Result.HIT;		
	}
}