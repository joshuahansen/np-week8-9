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
                //cast URL connection to Jar URL connection. get Jar filen and get all entries
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
    * @param enm : Eunmeration; enumertaion of all entries in jar file
    * Display results from  Jar URL connection
    */
    private static void printDetails(String contentType, int contentLength, Enumeration enm)
    {
        System.out.println("Content Type: " + contentType);
        System.out.println("Content Length: " + contentLength);
        System.out.println("List of Jar entries (Names and sizes):");
        //loop while enumeration has more elements
        while(enm.hasMoreElements())
        {   
            //cast each element to JarEntry and call required method for name ans size
            JarEntry entry = (JarEntry) enm.nextElement();
            System.out.println("Name: " + entry.getName() + " Size: " + entry.getSize());
        }   
    }
}
