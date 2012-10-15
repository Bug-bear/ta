class UnitMatrix{
	int size;
	void setSize(int newSize){
		this.size=newSize;
	}
	
	void print(){
		for(int i=0;i<size;i++){
			for(int j=0;j<size;j++){
				if(i==j){
					println("1");
				}else{
					println("0");
				}
			}
			println""
		}
	}
}
int dimension=4;
int bigDimension=8;
UnitMatrix matrix=new UnitMatrix();
matrix.setSize(dimension);
matrix.print();
matrix.setSize(bigDimension);
matrix.print();