package localchecks;

import gradingTools.comp524f20.assignment6.F20Assignment6Suite;
import trace.grader.basics.GraderBasicsTraceUtility;
import util.trace.Tracer;


public class RunF20A6Tests {

		public static void main(final String[] args) {
	// the following two lines should be uncommented if you do not understand why your tests fails
			Tracer.showInfo(true);
			GraderBasicsTraceUtility.setBufferTracedMessages(false);
			F20Assignment6Suite.main(args);
		}
	
}