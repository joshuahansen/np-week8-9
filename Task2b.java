import java.util.*;
import java.lang.*;
import java.io.*;
import java.net.*;
import java.util.zip.*;
import java.util.jar.*;

/**
* @author Joshua Hansen
* Task 2 b
* Make a jarURL connection to target
* Get list of entries (names and sizes)
* Print results to screen
*/
class Task2b
{
    public static void main(String args[])
    {
        try {
            URL url = new URL("jar:http://m1-c45n1.csit.rmit.edu.au/~Course/HelloWorld.jar!/");
            try {
                //open url connection to get information
                URLConnection urlConnection = url.openConnection();
                JarURLConnection jarConnection = (JarURLConnection) urlConnection;
                JarFile jarFile = jarConnection.getJarFile();
                Enumeration enm = jarFile.entries();

                printDetails(jarConnection.getContentType(), jarConnection.getContentLength(), enm);
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
    private static void printDetails(String contentType, int contentLength, Enumeration enm)
    {
        System.out.println("Content Type: " + contentType);
        System.out.println("Content Length: " + contentLength);
        System.out.println("List of Jar entries (Names and sizes):");
        while(enm.hasMoreElements())
        {   
            JarEntry entry = (JarEntry) enm.nextElement();
            System.out.println("Name: " + entry.getName() + " Size: " + entry.getSize());
        }   
    }
}
