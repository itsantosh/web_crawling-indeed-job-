package com.parakhi.indeedjsoup;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.Connection.Response;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.parakhi.indeedjsoup.entity.JobDetail;

public class Program {

	public static void main(String[] args) {
	
		Document document;
		
		System.out.println("***********Please wait Crawling**************");
		
		for (int i=0; i<=5; i++){
			System.out.println("page :" +i);
			try {
		        Response response= Jsoup.connect("http://www.indeed.com/jobs?q=*&start="+i*10  )
		                   .ignoreContentType(true)
		                   .userAgent("Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:25.0) Gecko/20100101 Firefox/25.0")  
		                   .referrer("http://www.google.com")  
		                   .timeout(12000)
		                   .followRedirects(true)
		                   .execute(); 
		        document = response.parse();
		        
		        
		        List<JobDetail> jobList=new ArrayList<>(); 
		      
		    Elements content=document.select("td#resultsCol").select("div.row");
		        
		     
		        
		        for(Element ele: content){
		        	JobDetail job=new JobDetail();
		        	job.setJobTitle(ele.select("h2.jobTitle").text());
		        	job.setCompanyName(ele.select("span.company").text());
		        	job.setSalary(ele.select("table td.snip nobr").text());
		        	job.setJobLocation(ele.select("span.location").text());
		        	job.setJobDescription(ele.select("table td.snip div span.summary").text());
		        	jobList.add(job);
		        	
		        }	
		        ObjectMapper maper =new ObjectMapper();
		        for(JobDetail e:jobList){
		        	String jsonInString = maper.writeValueAsString(e);
					System.out.println(jsonInString);
			
		        
					
					File file =new File("/home/test.txt");
					
					Writer fileWriter = new FileWriter(file, true);
					String filePath="/home/test.txt";
					Files.write(Paths.get(filePath), jsonInString.getBytes(), StandardOpenOption.APPEND);
					
				
		        
		        
		        }
		    } 
		     catch (Exception e) {
		        System.out.println("Crawling failed!!");
		        e.printStackTrace();
		    }
		}
	    

	}

}
