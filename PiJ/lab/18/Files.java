import java.io.*;
import java.util.*;

public class Files{
	public static void is(){
		File dir = new File(".");
		File[] arr = dir.listFiles();
		for(File element : arr){
			System.out.println(element.getName());
		}
	}
	
	public static void mkdir(String[] args){
		if(args.length == 0){
			System.out.println("no dir to create");
			return;
		}
		File dir = new File(args[0]);
		dir.mkdir();
	}
	
	public static void cat(String[] args){
		if(args.length == 0){
			System.out.println("no file specified");
			return;
		}	
		File target = new File(args[0]);
		BufferedReader in = null;
		try{
			in = new BufferedReader(new FileReader(target));
			String line = null;
			while ((line = in.readLine()) != null) {
				System.out.println(line);
			}
		} catch(FileNotFoundException e){
			System.out.println("no such file");
		} catch(IOException e){
			System.out.println(e);
		} finally{
			try{
				in.close();
			} catch(IOException e){
				System.out.println(e);
			}
		}		
	}
	
	public static void cp(String[] args){
		if(args.length == 0){
			System.out.println("no file specified");
			return;
		}	
		
		File first = new File(args[0]);
		File second = new File(args[1]);
		if(!first.exists()){
			System.out.println("no first file");
			return;
		}
		
		PrintWriter out = null;
		BufferedReader in = null;
		try{
			if(second.exists()){
				System.out.println("to overwrite?");
				String str = System.console().readLine();
				if(str.equals("yes")){
					out = new PrintWriter(new FileWriter(second,false));
				} else{
					out = new PrintWriter(new FileWriter(second,true));
				}
			} else{
				out = new PrintWriter(new FileWriter(second,false));
			}
			in = new BufferedReader(new FileReader(first));
			String line = null;
			while ((line = in.readLine()) != null) {
				out.println(line);
			}
		} catch(FileNotFoundException e){
			System.out.println("no such file");
		} catch(IOException e){
			System.out.println(e);
		} finally{
			try{
				in.close();
				out.close();
			} catch(IOException e){
				System.out.println(e);
			}
		}	
	}
	
	public static void temperature(String[] args){
		if(args.length == 0){
			System.out.println("no file specified");
			return;
		}
		
		double sum = 0;
		int total_ctr = 0;
		File csv = new File(args[0]);
		BufferedReader in = null;
		try{
			in = new BufferedReader(new FileReader(csv));
			String line = null;
			while ((line = in.readLine()) != null) {
				double line_sum = 0;
				int ctr = 0;
				Scanner sc = new Scanner(line);
				sc.useDelimiter(", ");
				while(sc.hasNextDouble()){
					ctr++;
					double val = sc.nextDouble();
					line_sum += val;
				}
				System.out.println("line average of " + ctr + " values is : " + line_sum/ctr);
				sum += line_sum;
				total_ctr += ctr;
			}
			System.out.println("overall average : " + sum/total_ctr);
		} catch(FileNotFoundException e){
			System.out.println("no such file");
		} catch(IOException e){
			System.out.println(e);
		} finally{
			try{
				in.close();
			} catch(IOException e){
				System.out.println(e);
			}
		}		
	}
	
	public static void main(String[] args){
		//is();
		//mkdir(args);
		//cat(args);
		//cp(args);
		temperature(args);
	}
}