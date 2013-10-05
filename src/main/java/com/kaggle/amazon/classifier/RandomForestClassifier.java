package com.kaggle.amazon.classifier;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import org.apache.mahout.classifier.df.DecisionForest;
import org.apache.mahout.classifier.df.builder.DefaultTreeBuilder;
import org.apache.mahout.classifier.df.data.Dataset;
import org.apache.mahout.classifier.df.data.Instance;
import org.apache.mahout.classifier.df.ref.SequentialBuilder;
import org.apache.mahout.common.RandomUtils;
import org.uncommons.maths.Maths;
import org.apache.mahout.classifier.df.data.*;

import com.kaggle.amazon.data.AmazonDataLoader;
import com.kaggle.amazon.domain.Employee;
import com.kaggle.common.data.AbstractDataLoader;

public class RandomForestClassifier{

    private static DecisionForest dforest;
    private static Data trainData;
    private static Data testData;
	private final static String trainDataPath="data/amazon/data/train.csv";
	private final static String testDataPath="data/amazon/data/test.csv";
	private final static String resultDataPath="data/amazon/results/results.csv";
	public static void builClassifier() {
        int m = (int) Math.floor(Maths.log(2, trainData.getDataset().nbAttributes()) + 1);
        Random rng = RandomUtils.getRandom();
        DefaultTreeBuilder treeBuilder = new DefaultTreeBuilder();
        SequentialBuilder foresBuilder = new SequentialBuilder(rng, treeBuilder, trainData.clone());
        treeBuilder.setM(m);
        dforest = foresBuilder.build(50);
	}
	
	public static void testClassifier() {
		Random rng = RandomUtils.getRandom();
		
		double[] predictions = new double[testData.size()];
        dforest.classify(testData, predictions);
        
        BufferedWriter bw;
        try 
        {
        	bw = new BufferedWriter(new FileWriter(resultDataPath));
        	bw.write("Id,Action\r\n");       
	        for (int i = 0; i < testData.size(); i++) {
	            Instance inst = testData.get(i);
	            double classify = dforest.classify(testData.getDataset(), rng, inst);
	            bw.write((i+1)+","+(int)classify+"\r\n");
	        }
        	bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		};
    }

    public static void main(String[] args) throws IOException {
    	AbstractDataLoader<Employee> dataLoader = new AmazonDataLoader(trainDataPath);
    	trainData = dataLoader.getData();
    	
    	dataLoader = new AmazonDataLoader(testDataPath,"L N N N N N N N N N");
    	testData = dataLoader.getData();
    	
        builClassifier();
        testClassifier();


    }
}
