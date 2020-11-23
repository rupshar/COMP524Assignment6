package evaluators;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import main.lisp.evaluator.Environment;
import main.lisp.evaluator.Evaluator;
import main.lisp.interpreter.InterpreterModelSingleton;
import main.lisp.parser.terms.NilAtom;
import main.lisp.parser.terms.SExpression;
import main.lisp.parser.terms.StringAtom;
import main.lisp.parser.terms.TAtom;

public class LoadEvaluator implements Evaluator {

	@Override
	public SExpression eval(SExpression sexpression, Environment env) {
		sexpression = sexpression.getTail();
		String file = ((StringAtom) sexpression.getHead()).getValue();
		file = file.replace("(", "");
		file = file.replace(")", "");
		Path pathToFile = Paths.get("", file);
//		file = file.replace("(", "");
//		file = file.replace(")", "");

		Charset encoding = Charset.forName("ISO-8859-1");
		
		List<String> lines = null;
		
//		List<String> lines = new ArrayList<>();
		try {
			lines = Files.readAllLines(pathToFile, encoding);
			for(String command : lines) {
				if(!executeLine(command)) {
					return new NilAtom();
				}
			}
		} catch(IOException e) {
			return new NilAtom();
		}
		
		
//		try (BufferedReader reader = new BufferedReader(new FileReader(file))){
//			String line;
//			while ((line = reader.readLine()) != null)
//				lines.add(line);
//		} catch (IOException e) {
//			return new NilAtom();
//		}
//		for (String command : lines) {
//			if (!executeLine(command))
//				return new NilAtom();
//		}
		return new TAtom();
	}
	
	private boolean executeLine(String line) {
		try {
			InterpreterModelSingleton.get().newInput(line);
		} catch (IllegalStateException e) {
			return false;
		}
		return true;
	}

}
