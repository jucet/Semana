import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;
import tools.Parse;

// http://stackoverflow.com/questions/6159118/using-java-to-pull-data-from-a-webpage
public class OpenArticle {

	private static String pageContent="";

	public static void main(String[] args) throws IOException {

		String prn="";

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
			
			prn = prn.replaceAll("&nbsp;", " ");
			prn = prn.replaceAll("&", "");
			prn = prn.replaceAll("ntilde;", "ñ");
			prn = prn.replaceAll("acute;", "");
			prn = prn.replaceAll("\n", "");
			prn = prn.replaceAll("<p>", "");
			prn = prn.replaceAll("<em>", "");
			prn = prn.replaceAll("</em>", "");
			prn = prn.replaceAll("<", "");
			prn = prn.replaceAll(">", "");
			prn = prn.replaceAll("  ", "");
			
			// insert returns
			// split prn in 4 and concatenate the returns
			
			// String temp = substring
			
			
			
				
			System.out.println(prn);
		
	}	


}