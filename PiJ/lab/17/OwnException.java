public class OwnException{
	public static void launch(int num) throws MyCheckedException{
		if(num == 1){
			throw new MyRuntimeException("outside");
		}
		if(num == 2){
			throw new MyCheckedException("outside");
		}		
		try{
			if(num == 3){
				throw new MyRuntimeException("inside");
			}
			if(num == 4){
				throw new MyCheckedException("inside");
			}		
		} catch(MyRuntimeException e){
			throw e;
		} catch(MyCheckedException e){
			throw e;
		}
	}
	
	public static void main(String[] args){
		try{
			//launch(1);
			//launch(2);
			launch(3);
		} catch(MyRuntimeException e){
			System.out.println(e);
		} catch(MyCheckedException e){
			System.out.println(e);
		}
	}
}