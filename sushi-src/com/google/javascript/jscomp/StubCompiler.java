package com.google.javascript.jscomp;

import java.util.List;

import com.google.common.base.Supplier;
import com.google.javascript.jscomp.mozilla.rhino.ErrorReporter;
import com.google.javascript.jscomp.parsing.Config;
import com.google.javascript.rhino.Node;
import com.google.javascript.rhino.jstype.JSTypeRegistry;

// The driver works-around dependencies on Compiler. Note that 
// 	 all dependencies are output-wise, that is, the Compiler does 
//	 not affect/generate inputs
public class StubCompiler extends AbstractCompiler {

	@Override
	public String getSourceLine(String sourceName, int lineNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Region getSourceRegion(String sourceName, int lineNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CompilerInput getInput(String sourceName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CompilerInput newExternInput(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JSModuleGraph getModuleGraph() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CompilerInput> getInputsInOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JSTypeRegistry getTypeRegistry() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ScopeCreator getTypedScopeCreator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Scope getTopScope() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void report(JSError error) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void throwInternalError(String msg, Exception cause) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CodingConvention getCodingConvention() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void reportCodeChange() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addToDebugLog(String message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setCssRenamingMap(CssRenamingMap map) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CssRenamingMap getCssRenamingMap() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node getNodeForCodeInsertion(JSModule module) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TypeValidator getTypeValidator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node parseSyntheticCode(String code) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node parseSyntheticCode(String filename, String code) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node parseTestCode(String code) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toSource(Node root) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ErrorReporter getDefaultErrorReporter() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReverseAbstractInterpreter getReverseAbstractInterpreter() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Supplier<String> getUniqueNameIdSupplier() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasHaltingErrors() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void addChangeHandler(CodeChangeHandler handler) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeChangeHandler(CodeChangeHandler handler) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isIdeMode() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean acceptEcmaScript5() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean acceptConstKeyword() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Config getParserConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isTypeCheckingEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void prepareAst(Node root) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ErrorManager getErrorManager() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean areNodesEqualForInlining(Node n1, Node n2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setHasRegExpGlobalReferences(boolean references) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean hasRegExpGlobalReferences() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public CheckLevel getErrorLevel(JSError error) {
		// TODO Auto-generated method stub
		return null;
	}
}