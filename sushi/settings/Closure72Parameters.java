package settings;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

import sushi.configure.Coverage;
import sushi.configure.JBSEParameters;
import sushi.configure.MergerParameters;
import sushi.configure.Options;
import sushi.configure.ParametersModifier;
import sushi.configure.ParseException;
import sushi.logging.Level;

public class Closure72Parameters extends ParametersModifier {
	@Override
	public void modify(Options p) {
		p.setLogLevel(Level.DEBUG);

		//Local configurations
		p.setEvosuitePath(Paths.get(".", "lib", "evosuite-shaded-1.0.3.jar"));
		p.setSushiLibPath(Paths.get("..", "sushi-lib", "bin"));
		p.setZ3Path(Paths.get("/opt", "local", "bin", "z3"));

		//Target 
		p.setClassesPath(
				Paths.get("..", "sushi-experiments-closure72", "build/classes"), 
				Paths.get("..", "sushi-experiments-closure72", "lib/guava.jar"),
				Paths.get("..", "sushi-experiments-closure72", "lib/libtrunk_rhino_parser_jarjared.jar"),
				Paths.get("..", "sushi-experiments", "lib", "jbse-lib.jar"));
		
		p.setTargetMethod("com/google/javascript/jscomp/AnalysisDriver", "()V", "driver_RenameLabels_process");

		//Analysis params 
		p.setJBSEBudget(3600);
		p.setEvosuiteBudget(3600);
		p.setCoverage(Coverage.BRANCHES);
		
		//Tmp out directories
		p.setOutDirectory(Paths.get("..", "sushi-experiments-closure72", "sushi-test"));
		p.setTmpDirectoryBase(Paths.get("..", "sushi-experiments-closure72", "out"));
		p.setTmpDirectoryName("closure72");
		
		//Parallelism
		p.setRedundanceEvosuite(1);
		p.setParallelismEvosuite(2);
	}

	@Override
	public void modify(JBSEParameters p) 
	throws FileNotFoundException, ParseException, IOException {
		loadHEXFile("../sushi-experiments-closure72/sushi/settings/closure_parse_tree_hex.jbse", p);
		
		p.setHeapScope("com/google/javascript/rhino/Node", 1);		
		p.setHeapScope("com/google/javascript/rhino/Node$StringNode", 2);		

		p.setDepthScope(500);
		p.setCountScope(650);
	}	
	
	@Override
	public void modify(MergerParameters p) {
		p.setBranchesToCover("com/google/javascript/jscomp/RenameLabels.*");
	}


	@Override
	public void modify(List<String> p) {
		p.add("-Dobject_reuse_probability=0.8");
		p.add("-Delite=5");
	}
}
