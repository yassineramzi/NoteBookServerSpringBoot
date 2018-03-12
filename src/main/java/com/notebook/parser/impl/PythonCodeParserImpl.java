package com.notebook.parser.impl;

import org.springframework.stereotype.Component;

import com.notebook.models.CodeExpression;
import com.notebook.models.Program;
import com.notebook.parser.CodeParser;

// TODO : complete Python code Parser
@Component
public class PythonCodeParserImpl implements CodeParser {
	
	private final String INTERPRETER_NAME = "%python";
	
	@Override
	public void parse(final Program p,final CodeExpression code) 
	{
		if(code.getCode().contains("="))
		{
			p.getInputs().put(parseVariableName(code.getCode()), parseVariableValue(code.getCode()));
		}
		else
		{
			p.setExpression(parseCodeExpression(code.getCode()));
		}
	}
	
	@Override
	public String parseVariableName(final String t) 
	{
		StringBuilder stb = new StringBuilder(t);
		int from = stb.indexOf(INTERPRETER_NAME)+INTERPRETER_NAME.length();
		int to = stb.indexOf("=");
		return stb.substring(from, to);
	}
	
	@Override
	public String parseVariableValue(final String t)
	{
		StringBuilder stb = new StringBuilder(t);
		int from = stb.indexOf("=")+1;
		return stb.substring(from);
	}
	
	@Override
	public String parseCodeExpression(final String t)
	{
		StringBuilder stb = new StringBuilder(t);
		int from = stb.indexOf(INTERPRETER_NAME)+INTERPRETER_NAME.length();
		return stb.substring(from);
	}

}
