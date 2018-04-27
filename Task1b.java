import java.util.*;
import java.lang.*;
import java.io.*;
import java.net.*;

/**
* @author Joshua Hansen
* Task 1 b
* Make a URL connection to target
* get data content from the target
* Print to screen
*/
class Task1b
{
    public static void main(String args[])
    {
        try {
            URL url = new URL("http://m1-c45n1.csit.rmit.edu.au/~Course/index.php");
            InetAddress address = null;
            URLConnection urlConnection = null;
            StringBuilder content = new StringBuilder();
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
                //get input stream from target
                InputStream input = urlConnection.getInputStream();
                int data = input.read();
                //loop while theres still data
                while (data != -1)
                {
                    //add data to a string builder
                    content.append((char)data);
                    data = input.read();
                }
                input.close();
            }catch(IOException ex)
            {
                System.out.println("Error: " + ex);
            }
            //Display details and pass in string from string builder
            printDetails(address.getHostAddress(), urlConnection.getContentType(), 
                urlConnection.getContentLength(), content.toString());
        }catch(MalformedURLException e)
        {
            System.out.println("Error: " + e);
        }
    }
    
    /**
    * @param IP : String; Target ip addess as a string
    * @param contentType : String; tpye of content at url
    * @param contentLength : int; length of content as an int
    * @param content : String; content from target as a string
    * Display results from URL connection
    */
    private static void printDetails(String IP, String contentType, int contentLength,
            String content)
    {
        System.out.println("Target's IP address: " + IP);
        System.out.println("Content Type: " + contentType);
        System.out.println("Content Length: " + contentLength);
        System.out.println("Content: " + content);
    }
}
