import java.net.*;
import java.io.*;

public class FetchURL
{
 public static void main(String args[]) throws Exception
 {
 int argc = args.length;
 
 if (argc != 2)
 {
 System.out.println ("Syntax :"); 
 System.out.println ("java FetchURLConnection url save_txt_file_path");
 return;
 }

 try
 {
 java.net.URL myURL = new URL ( args[0] );
 InputStream in = myURL.openStream();
 BufferedInputStream bufIn = new
 BufferedInputStream(in);
 String content = "";
 for (;;)
 {
	 int data = bufIn.read();
	 if (data == -1)
		 break;
	 else
		 System.out.print ( (char) data);
	 content += (char) data;
 }
 BufferedWriter bw = null;
	FileWriter fw = null;
	String FILENAME = args[1];
	try {

		fw = new FileWriter(FILENAME);
		bw = new BufferedWriter(fw);
		bw.write(content);

		System.out.println("Done");

	} catch (IOException e) {

		e.printStackTrace();

	} finally {

		try {

			if (bw != null)
				bw.close();

			if (fw != null)
				fw.close();

		} catch (IOException ex) {

			ex.printStackTrace();

		}

	}
 System.out.println ();
 System.out.println ("Hit enter to continue");
 System.in.read();
 }
 
 catch (Exception e)
 {
	 e.printStackTrace();
	 return;
 }
 }
} 