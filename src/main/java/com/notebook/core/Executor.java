package com.notebook.core;

import com.notebook.models.Program;
import com.notebook.models.Result;

public abstract class Executor {
	
	public abstract Result executeCode(final Program p);
	
}
