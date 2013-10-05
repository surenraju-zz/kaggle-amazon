package com.kaggle.common.data;

import java.io.IOException;
import java.util.List;
import org.apache.mahout.classifier.df.data.*;
import java.util.regex.Pattern;

public abstract class AbstractDataLoader<E> {
	protected String[] rawdata;
	protected CharSequence attributeSequence;
	protected Dataset dataset;
	protected Data data;
	protected String path;
	public AbstractDataLoader(String path, CharSequence attributeSequence)
	{
		this.path = path;
		this.attributeSequence = attributeSequence;
	}
	public String[] loadDataStringArray() throws IOException{
	       String[] output;
	       List<E> entity = loadData();
	       output = new String[entity.size()];
	       int count=0;
	       for(E e:entity){
	           output[count] = e.toString();
	           count++;
	       }
	       return output;
	   }

	public abstract List<E> loadData() throws IOException;

	public Data getData() {
		try{

	        this.rawdata = loadDataStringArray();
	        dataset = DataLoader.generateDataset(this.attributeSequence, false,this.rawdata );
	        this.data = DataLoader.loadData(dataset, this.rawdata);
        }catch(DescriptorException e){
            e.printStackTrace();
        } catch (IOException e) {
			e.printStackTrace();
		}
		return data;
	}
}
