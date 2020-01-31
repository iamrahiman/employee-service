package com.employee.search.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.employee.search.annotations.Logging;


/**
 * Utility class for file reading
 * @author abdul.rahimanshaik
 *
 */
@Component
public class FileUtils {
	
	
	/**
	 * Load data from File set into the list.
	 * @param iFilePath
	 * @return
	 * @throws IOException
	 */
	@Logging
	public List<String> getFileContent(String iFilePath) throws IOException {

		List<String> aFileContentAsList = Files.lines(Paths.get(iFilePath)).collect(Collectors.toList());

		return aFileContentAsList;
	}
	




}
