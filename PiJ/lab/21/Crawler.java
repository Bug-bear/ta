import java.util.*;
import java.net.*;
import java.io.*;
import javax.swing.text.BadLocationException;

public class Crawler implements Runnable{
	private Object lock;
	private Set<String>	linksToVisit;
	private Set<String>	linksVisited;
	private Set<String>	emails;
	
	public Crawler(Object lock, Set<String> linksToVisit, Set<String> linksVisited, Set<String> emails){
		this.lock = lock;
		this.linksToVisit = linksToVisit;
		this.linksVisited = linksVisited;
		this.emails = emails;
	}
	
	public void run(){
			/*
			while(!iterator.hasNext()){
				try{
					lock.wait();
				} catch (InterruptedException e) { 
					e.printStackTrace(); 
				}
			}
			*/
		while(linksToVisit.size()>0 && emails.size()<10){
			synchronized(lock){
			//System.out.println("visted : " + linksVisited);
				Iterator<String> iterator = linksToVisit.iterator();
			
				String url = iterator.next();
				if(!linksVisited.contains(url)){
					try{
						WebAnalyzer wa = new WebAnalyzer(url);
						linksVisited.add(url);
						linksToVisit.remove(url);
						linksToVisit.addAll(wa.getLinks());
						//iterator = linksToVisit.iterator();
						//System.out.println(wa.getLinks());
						emails.addAll(wa.getEmails());
						System.out.println(Thread.currentThread() + " " + emails); //debug
						lock.notifyAll();
					} catch(MalformedURLException e){
						e.printStackTrace();
					} catch(IOException e){
						e.printStackTrace();
					} catch(BadLocationException e){
						e.printStackTrace();
					}
				}
			}
		}
	}
}