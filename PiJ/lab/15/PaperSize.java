public class PaperSize{
	final static int WIDTH = 841;
	final static int HEIGHT = 1189;
	final static int AREA = WIDTH * HEIGHT;
	//final static int AREA = 1; //debug
	//final int FACTOR = 1.414; //square-root of 2
	
	private static int getFactor(String paper){
		String size = paper.substring(1);
		if(size.length() == 1){
			return Integer.parseInt(size.substring(0)) * -1;
		}
		else if(size.length() > 1){
			return size.length()-1;
		}
		else{
			System.out.println("Invalid size");
			return 0;
		}
	}
	
	public static int getSize(int factor){
		if(factor > 0){
			return getSize(factor-1) * 2;
		}
		else if(factor < 0){
			return getSize(factor+1) / 2;
		}
		else{
			return AREA;
		}
	}
	
	public static void main(String[] args){
		if(args.length != 0){
			int factor = getFactor(args[0]);
			//System.out.println(factor);
			System.out.println(getSize(factor));
		}
	}
}