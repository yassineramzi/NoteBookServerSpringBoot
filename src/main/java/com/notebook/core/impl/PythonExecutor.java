package com.notebook.core.impl;

import org.springframework.stereotype.Component;

import com.notebook.core.Executor;
import com.notebook.models.Program;
import com.notebook.models.Result;

@Component
public class PythonExecutor extends Executor{
	
	@Override
	public Result executeCode(Program p) {
		// TODO Auto-generated method stub
		Result test = new Result();
		test.setResult("result");
		return test;
	}

}
