import java.util.*;
import java.lang.*;
import java.io.*;
import java.net.*;

/**
* @author Joshua Hansen
* Task 2 a
* Make a jarURL connection to target
* connection type and length of content
* Print results to screen
*/
class Task2a
{
    public static void main(String args[])
    {
        try {
            URL url = new URL("jar:http://m1-c45n1.csit.rmit.edu.au/~Course/HelloWorld.jar!/");
            try {
                //open url connection to get information
                URLConnection urlConnection = url.openConnection();
                JarURLConnection jarConnection = (JarURLConnection) urlConnection;
                printDetails(jarConnection.getContentType(), jarConnection.getContentLength());
            }catch(IOException ex)
            {
                System.out.println("Error: " + ex);
            }
            //Display details
        }catch(MalformedURLException e)
        {
            System.out.println("Error: " + e);
        }
    }
    
    /**
    * @param contentType : String; tpye of content at url
    * @param contentLength : int; length of content as an int
    * Display results from URL connection
    */
    private static void printDetails(String contentType, int contentLength)
    {
        System.out.println("Content Type: " + contentType);
        System.out.println("Content Length: " + contentLength);
    }
}
