package settings;

import static settings.Settings.*;

import sushi.Coverage;
import sushi.Level;
import sushi.Options;
import sushi.OptionsConfigurator;

public class Closure72ParametersAccurate implements OptionsConfigurator {
	@Override
	public void configure(Options p) {
		p.setLogLevel(Level.DEBUG);

		//Local configurations
		p.setJava8Path(JAVA8_HOME);
		p.setEvosuitePath(EVOSUITE_PATH);
		p.setSushiLibPath(SUSHI_LIB_PATH);
		p.setZ3Path(Z3_PATH);

		//Target 
		p.setClassesPath(BIN_PATH, GUAVA_PATH, RHINOJJ_PATH, JBSE_PATH);
		p.setTargetMethod("com/google/javascript/jscomp/AnalysisDriver", "()V", "driver_RenameLabels_process");

		//Analysis params 
		p.setJBSEBudget(3600);
		p.setEvosuiteBudget(3600);
		p.setCoverage(Coverage.BRANCHES);
		p.setBranchesToCover("com/google/javascript/jscomp/RenameLabels.*");
		p.setHEXFiles(SETTINGS_PATH.resolve("closure_parse_tree_accurate.jbse"));
		p.setHeapScope("com/google/javascript/rhino/Node", 1);		
		p.setHeapScope("com/google/javascript/rhino/Node$StringNode", 2);		
		p.setHeapScope("com/google/javascript/rhino/Node$PropListItem", 0);
		p.setDepthScope(200);
		p.setCountScope(650);
		
		//Phases
		p.setPhases(1, 2, 3, 4, 5, 6);
		
		//Tmp out directories
		p.setOutDirPath(OUT_PATH);
		p.setTmpDirectoryBase(TMP_BASE_PATH);
		
		//Redundance and parallelism
		p.setRedundanceEvosuite(1);
		p.setParallelismEvosuite(2);
		
		//Evosuite
		p.setAdditionalEvosuiteArgs("-Dobject_reuse_probability=0.8 -Delite=5");

		//Timeout
		p.setGlobalBudget(7200);
	}
}
