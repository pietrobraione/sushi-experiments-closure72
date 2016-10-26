package settings;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;

import jbse.apps.run.Run;
import jbse.apps.run.RunParameters;
import jbse.apps.run.RunParameters.DecisionProcedureType;
import jbse.apps.run.RunParameters.StateFormatMode;
import jbse.apps.run.RunParameters.StepShowMode;
import jbse.apps.settings.ParseException;
import jbse.apps.settings.SettingsReader;

public class JbseStandAloneRunner {
	public static void main(String[] args) throws FileNotFoundException, ParseException, IOException {
		//prepares the parameters
		final RunParameters p = new RunParameters();
		
		//JBSE configuration
		p.addClasspath(Paths.get("..", "sushi-experiments-closure72", "build/classes").toString(),
				Paths.get("..", "sushi-experiments-closure72", "lib/guava.jar").toString(),
				"/Users/denaro/git/jbse-new/data/jre/rt.jar",
				"/Users/denaro/git/jbse-new/bin/");
		p.setDecisionProcedureType(DecisionProcedureType.Z3);
		p.setExternalDecisionProcedurePath("/Users/denaro/Desktop/RTools/Z3/z3-4.3.2.d548c51a984e-x64-osx-10.8.5/bin/z3");
		p.setOutputFileName(Paths.get("..", "sushi-experiments-closure72", "out") + "/closure72.jbse.txt");

		
		//Analysis configuration
		p.setMethodSignature("com/google/javascript/jscomp/AnalysisDriver", "()V", "driver_RenameLabels_process");
		SettingsReader rd = new SettingsReader("../sushi-experiments-closure72/sushi/settings/closure_parse_tree_hex.jbsee");
		rd.fillRunParameters(p);
		p.setHeapScope("com/google/javascript/rhino/Node", 1);		
		p.setHeapScope("com/google/javascript/rhino/Node$StringNode", 2);		
		//p.setHeapScope("doubly_linked_list/DoubleLinkedList_LICS$Entry", 7);

		p.setDepthScope(500);
		p.setCountScope(650);
		
		//what to show
		p.setStepShowMode(StepShowMode.LEAVES);
		p.setStateFormatMode(StateFormatMode.TRACE);
		p.setShowWarnings(true);

		p.setShowSafe(true);
		p.setShowUnsafe(true);
		p.setShowOutOfScope(false);
		p.setShowContradictory(false);
		p.setShowDecisionProcedureInteraction(false);	
		
		//executes JBSE
		final Run r = new Run(p);
		r.run();
		
		System.out.println();
		System.out.println("AAAAAAA: num of traces differ from old paper (3838) because of new invariants for static fileds in class NameGenerator");
	}
}
