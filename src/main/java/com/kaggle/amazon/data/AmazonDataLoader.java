package com.kaggle.amazon.data;

import com.kaggle.common.data.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.kaggle.amazon.domain.*;


public class AmazonDataLoader extends AbstractDataLoader<Employee>{
	private final static CharSequence attributeSequence="L N N N N N N N N N";

	public AmazonDataLoader(String path)
	{
		super(path, attributeSequence);
		
	}

	public AmazonDataLoader(String path, CharSequence attributeSequence) {
		super(path, attributeSequence);
	}
	
	@Override
	public List<Employee> loadData() throws IOException{
        List<Employee> employeeData = new ArrayList<Employee>();
        BufferedReader br = new BufferedReader(new FileReader(path));
        try{
	        
	        String line ="";
	        Employee employee = null;
	        br.readLine();
	        while( (line=br.readLine()) != null){
	            String[] instance = line.split(",");
	            employee = new Employee();
	            employee.setAction(Integer.valueOf(instance[0]));
	            employee.setResource(Math.log(Integer.valueOf(instance[1])));
	            employee.setMgrId(Math.log(Integer.valueOf(instance[2])));
	            employee.setRoleRollup1(Math.log(Integer.valueOf(instance[3])));
	            employee.setRoleRollup2(Math.log(Integer.valueOf(instance[4])));
	            employee.setRoleDeptname(Math.log(Integer.valueOf(instance[5])));
	            employee.setRoleTitle(Math.log(Integer.valueOf(instance[6])));
	            employee.setRoleFamilyDesc(Math.log(Integer.valueOf(instance[7])));
	            employee.setRoleFamily(Math.log(Integer.valueOf(instance[8])));
	            employee.setRoleCode(Math.log(Integer.valueOf(instance[9])));
	            employeeData.add(employee);
	        }
        }catch(Exception e){
        }
        finally{
        	br.close();
        }
        
        return employeeData;
    }
}
