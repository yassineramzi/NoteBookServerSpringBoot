package com.notebook.parser;

import com.notebook.models.CodeExpression;
import com.notebook.models.Program;

public interface CodeParser {

	void parse(final Program p , final CodeExpression code);
	String parseVariableName(final String t);
	String parseVariableValue(final String t);
	String parseCodeExpression(String t);

}
