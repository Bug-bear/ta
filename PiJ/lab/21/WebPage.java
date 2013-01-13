import java.util.*;

/**
* A possible interface representing a web page.
* This is only a suggestion.
*/
public interface WebPage {
	static final String URL_START = "<a";
	//static final String URL_END = "</a>";
	static final String URL_END = ">";
	/*static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
		+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";*/
	static final String EMAIL_PATTERN = ".[A-Za-z0-9]+@.+\\.[a-z]+";
	//".+@.+\\.[a-z]+";
	/**
	* Returns the URL that identifies this web page.
	* @return the URL that identifies this web page.
	*/
	String getUrl();
	/**
	* Returns all the links on this webpage.
	*
	* Implementing classes should return a read-only view of this
	* set, using Collections.unmodifiableSet().
	*
	* @return all the links on this webpage.
	*/
	Set<String> getLinks();
	/**
	* Returns all the emails on this webpage.
	*
	* Implementing classes should return a read-only view of this
	* set, using Collections.unmodifiableSet().
	*
	* @return all the emails on this webpage.
	*/
	Set<String> getEmails();
	// Also, implementing classes should override equals() to
	// ensure that p1.equals(p2) returns true if and only if
	// p1.getUrl().equals(p2.getUrl()) returns true
}