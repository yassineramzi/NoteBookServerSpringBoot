package com.notebook.service;

import com.notebook.models.Program;
import com.notebook.models.Result;

public interface CodeExecuteService {
	Result executeCode(final Program program);
}
