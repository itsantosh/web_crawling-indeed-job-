package com.parakhi.indeedjsoup.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileHandler {
	
	    public static void write(File fileName,String content) throws IOException{
	    FileWriter writer=new FileWriter(fileName);
	    writer.write(content);
	    writer.close();
	    
	    }
}
