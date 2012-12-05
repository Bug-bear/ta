import java.rmi.*;
import java.net.*;

public class EchoClient{
	public static void main(String[] args){
		String receivedEcho = null;
		try{
			Remote service = Naming.lookup("//127.0.0.1:1099/echo");
			EchoService echoService = (EchoService) service;
			receivedEcho = echoService.echo(args[0]);
		} catch(NotBoundException e){
			System.out.println(e);
		} catch (MalformedURLException ex) {
			ex.printStackTrace();
		} catch (RemoteException ex) {
			ex.printStackTrace();
		}
		System.out.println(receivedEcho);
	}
}