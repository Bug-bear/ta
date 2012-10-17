public class MarkChecker{
	public static void main(String[] args){
		String str = "";
		int dist = 0; 
		int pass = 0;
		int	fail = 0;
		do{
			System.out.println("give me a score");
			str = System.console().readLine();
			int mark = Integer.parseInt(str);
			
			if(mark<0 || mark>100){
				if(mark != -1)
					System.out.println("invalid socre. try again");
			}
			else if(mark>=70){
				dist++;
			}
			else if(mark>=50){
				pass++;
			}
			else{
				fail++;
			}
		}while(!str.equals("-1"));
		
		System.out.println("distinction: " + dist);
		System.out.println("pass: " + pass);
		System.out.println("fail: " + fail);
	}
}