import java.util.*;
import java.net.*;
import javax.swing.text.BadLocationException;

public class SpamBotImpl implements SpamBot{
	private Object lock;
	private Set<String>	linksToVisit;
	private Set<String>	linksVisited;
	private Set<String>	emails;
	private String seed;
	private Thread[] ct = new Thread[3];

	public SpamBotImpl(){
		this.lock = new Object();
		this.linksToVisit = new HashSet<String>();
		this.linksVisited = new HashSet<String>();
		this.emails = new HashSet<String>();		
	}
	
	public void setSeed(String seedUrl) throws MalformedURLException{
		this.seed = seedUrl;
		this.linksToVisit.add(this.seed);
	}
	
	public String getSeed(){
		return this.seed;
	}
	
	public void scanSite(){
		synchronized(lock){
			Crawler crawler = new Crawler(lock, linksToVisit, linksVisited, emails);
			try{
				for(int i=0; i<3; i++){
					ct[i] = new Thread(crawler);
					ct[i].start();
				}
				/*
				for(int i=0; i<3; i++){
					ct[i].join();
				}*/
			} catch(Exception e){
				e.printStackTrace();
			}
			//System.out.println(getEMails());
			lock.notifyAll();
		}
	}
	
	public Set<String> getEMails(){
		return emails;
	}
	
	public static void main(String[] args){
		String seedUrl = "http://www.bbk.ac.uk/";
		try{
			SpamBotImpl spambot = new SpamBotImpl();
			spambot.setSeed(seedUrl);
			spambot.scanSite();
			//Thread.yield();
			System.out.println(spambot.getEMails());
			//System.out.println(spambot.linksVisited);
		} catch(MalformedURLException e){
			e.printStackTrace();
		}
	}	
}