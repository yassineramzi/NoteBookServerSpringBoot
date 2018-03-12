package com.notebook.core.impl;

import java.util.Map;

import org.python.core.PyInteger;
import org.python.util.PythonInterpreter;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import com.notebook.core.Executor;
import com.notebook.models.Program;
import com.notebook.models.Result;

@Component
@SessionScope
public class PythonExecutor extends Executor{

	private PythonInterpreter pythonInterpreter;
	
	public PythonExecutor()
	{
		pythonInterpreter = new PythonInterpreter();
	}
	
	// TODO: review the performance of this method
	@Override
	public Result executeCode(final Program program) {
		Result result = new Result();
		// add the variables to the Python interpreter
		for(Map.Entry<String,String> entry : program.getInputs().entrySet())
		{
			pythonInterpreter.set(entry.getKey(),new PyInteger(Integer.parseInt(entry.getValue())));
		}
		// execute the Python program
		pythonInterpreter.exec("result = "+program.getExpression());
		
		// display the Python program result
		result.setResult(pythonInterpreter.get("result").asInt()+"");
		return result;
	}

}
