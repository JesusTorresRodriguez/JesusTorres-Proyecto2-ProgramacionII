package File;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import Interface.OpenFileImage;

public class SerializableFile {

	private String path;

	public SerializableFile() {
		super();
	}
	
//	 public void outputFile(Object objetc) throws IOException, ClassNotFoundException{
//	        
//	        File myFile = new File(path);
//
//	        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(myFile));
//	        output.writeUnshared(objetc);
//	        output.close();
//	        
//	    }
	    
	    public Object saveFile(File myFile) throws IOException, ClassNotFoundException {
	        Object myObjetc = new Object();
	        
	        if(myFile.exists()){
	            ObjectInputStream objectInput = new ObjectInputStream(new FileInputStream(myFile));
	            Object aux = objectInput.readObject();
	            myObjetc = (Object)aux;
	            objectInput.close();  
	        }
	        
	        return myObjetc;
	       
	    }
	
}
