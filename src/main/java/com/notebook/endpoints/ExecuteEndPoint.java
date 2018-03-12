package com.notebook.endpoints;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.notebook.models.CodeExpression;
import com.notebook.models.Program;
import com.notebook.models.Result;
import com.notebook.parser.CodeParser;
import com.notebook.service.CodeExecuteService;


@RestController
public class ExecuteEndPoint {

	@Autowired
	private CodeParser codeParser;
	@Autowired
	private CodeExecuteService codeExecuteService;
	
    @RequestMapping(value="/execute", method = RequestMethod.POST)
    public Result execute(@RequestBody CodeExpression code) 
    {	
    	//TODO: add session management
    	Program p = new Program();
    	codeParser.parse(p,  code);
    	return codeExecuteService.executeCode(p);
    }
}
