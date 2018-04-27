import java.util.*;
import java.lang.*;
import java.io.*;
import java.net.*;

/**
* @author Joshua Hansen
* Task 1 a
* Make a URL connection to target
* get IP, connection type and length of content
* Print results to screen
*/
class Task1a
{
    public static void main(String args[])
    {
        try {
            URL url = new URL("http://m1-c45n1.csit.rmit.edu.au/~Course/index.php");
            InetAddress address = null;
            URLConnection urlConnection = null;
            try {
                //get address from url
                address = InetAddress.getByName(url.getHost());
            }catch(UnknownHostException uhe)
            {
                System.out.println("Unknown Host: " + uhe);
            }
            try {
                //open url connection to get information
                urlConnection = url.openConnection();
            }catch(IOException ex)
            {
                System.out.println("Error: " + ex);
            }
            //Display details
            printDetails(address.getHostAddress(), urlConnection.getContentType(), 
                urlConnection.getContentLength());
        }catch(MalformedURLException e)
        {
            System.out.println("Error: " + e);
        }
    }
    
    /**
    * @param IP : String; Target ip addess as a string
    * @param contentType : String; tpye of content at url
    * @param contentLength : int; length of content as an int
    * Display results from URL connection
    */
    private static void printDetails(String IP, String contentType, int contentLength)
    {
        System.out.println("Target's IP address: " + IP);
        System.out.println("Content Type: " + contentType);
        System.out.println("Content Length: " + contentLength);
    }
}
