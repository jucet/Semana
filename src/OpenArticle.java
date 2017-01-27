import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;
import tools.Parse;


// view-source:http://www.dinero.com/economia/articulo/echavarria-llega-a-su-primera-junta-directiva-del-banco-de-la-republica/241407
public class OpenArticle {

	private static String pageContent="";

	public static void main(String[] args) throws IOException {

		String prn="";
		String replace="";

		Scanner scan = new Scanner(System.in);
		System.out.println("http://www.semana.com");
		String input = scan.nextLine();
		scan.close();


		// Make a URL to the web page
		URL url = new URL("http://www.semana.com"+input);

		// Get the input stream through URL Connection
		URLConnection con = url.openConnection();
		InputStream is =con.getInputStream();

		BufferedReader br = new BufferedReader(new InputStreamReader(is));

		String line = null;

		// read each line and write to System.out
		while ((line = br.readLine()) != null) {
			pageContent += line+"\n";
		}
		
			prn = Parse.GetContentBetweenAutomation(pageContent,"articleBody","<p","</p>",true,1);
			
			// insert a loop to remove all html tags by using
			// GetContentBetween to copy the string to remove starting from < and finishing in >
			// then remove using replaceAll()
			
			replace = Parse.GetContentBetweenAutomation(prn, "", "<", ">", true, 2);
			
			prn = prn.replaceAll("&ntilde;", "\u00F1");
			prn = prn.replaceAll("&aacute;", "\u00E1");
			prn = prn.replaceAll("&eacute;", "\u00E9");
			prn = prn.replaceAll("&iacute;", "\u00ED");
			prn = prn.replaceAll("&oacute;", "\u00F3");
			prn = prn.replaceAll("&uacute;", "\u00FA");
			
			prn = prn.replaceAll("&nbsp;", " ");

			prn = prn.replaceAll("<p>", "");
			prn = prn.replaceAll("<em>", "");
			prn = prn.replaceAll("</em>", "");
			prn = prn.replaceAll("<br/>", "\n");
			
			prn = prn.replaceAll("\n", "");
			prn = prn.replaceAll("  ", "");
			
			// insert returns
			// split prn in 4 and concatenate the returns
			
			 // String temp = prn.substring(0, 100);
				
			System.out.println(prn);
			System.out.println(replace);
		
	}	


}