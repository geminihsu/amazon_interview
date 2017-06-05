package tw.gemini.interview.amazon_on_site_question_2;

import java.io.File;
import java.util.ArrayList;

public class SearchFile {
	
	public ArrayList<File> listf(String directoryName, ArrayList<File> files) {
	    File directory = new File(directoryName);

	    // get all the files from a directory
	    File[] fList = directory.listFiles();
	    for (File file : fList) {
	        if (file.isFile()) {
	            files.add(file);
	        } else if (file.isDirectory()) {
	            listf(file.getAbsolutePath(), files);
	        }
	    }
	    
	    return files;
	}
	
	 public static void main(String[] args)
	{
		 SearchFile search = new SearchFile();
		 ArrayList<File> fileList = new ArrayList<File>();
		 fileList = search.listf("/Users/geminihsu/Documents/LeeCode/LingRongSyu/src/tw/gemini/interview/amazon/on_site_question_1", fileList);
		 for(File file : fileList)
		 {
			 if(file.isFile()&&file.getName().contains(".java"))
				 System.out.println(file.getPath());
		 }
	}
}
