import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;
import tools.Parse;

// http://stackoverflow.com/questions/6159118/using-java-to-pull-data-from-a-webpage
public class DownloadPage {

	private static String pageContent="";

	public static void main(String[] args) throws IOException {

		int i=0;
		String prn="";
		String section ="";

		Scanner scan = new Scanner(System.in);
		System.out.println("1.Noticias\n2.Opinion\n3.Economia\n4.Mundo");
		String input = scan.nextLine();
		scan.close();

		switch (input){

		case "1":
			section="/noticias/";
			break;
		case "2":
			section="/opinion/";
			break;
		case "3":
			section="/economia/";
			break;
		case "4":
			section="/mundo/";
			break;
		default:
			System.out.println(section + " bye");
			System.exit(0);
			break;
		}


		// Make a URL to the web page
		URL url = new URL("http://www.semana.com/");

		// Get the input stream through URL Connection
		URLConnection con = url.openConnection();
		InputStream is =con.getInputStream();

		BufferedReader br = new BufferedReader(new InputStreamReader(is));

		String line = null;

		// read each line and write to System.out
		while ((line = br.readLine()) != null) {
			pageContent += line+"\n";

		}
			
		while(prn != "NOTFOUND")
		{
			prn = Parse.GetContentBetweenAutomation(pageContent,section,"href=\"","\"",false,i);
			System.out.println(prn);
			i++;
		}


	}

}