package com.google.javascript.jscomp;

import com.google.javascript.rhino.Node;

import jbse.meta.Analysis;

public class AnalysisDriver {
	static int BUG72_EXEC_COUNT = 0;
	static void traversingBug72Location(boolean removeUnusedValue) {
		if (!removeUnusedValue) {
			BUG72_EXEC_COUNT++;
		}
	}
	private RenameLabels v_RenameLabels; //CUT
	private Node v_Node; //Input ParseTree 
	
	public void setV_RenameLabels(RenameLabels v_RenameLabels) {
		this.v_RenameLabels = v_RenameLabels;
	}

	public void setV_Node(Node v_Node) {
		this.v_Node = v_Node;
	}
	
	public void driver_RenameLabels_process() {
		try{
			v_RenameLabels.process(null, v_Node);			
			Analysis.ass3rt(BUG72_EXEC_COUNT == 0);
		} catch (Exception e) {
			//The driver accepts all exceptions
		} 
	}
}
