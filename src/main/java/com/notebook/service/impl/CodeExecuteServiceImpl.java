package com.notebook.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.notebook.core.Executor;
import com.notebook.models.Program;
import com.notebook.models.Result;
import com.notebook.service.CodeExecuteService;

@Component
public class CodeExecuteServiceImpl implements CodeExecuteService {
	
	@Autowired 
	private Executor executor;
	
	@Override
	public Result executeCode(final Program program) {
		return executor.executeCode(program);
	}

}
