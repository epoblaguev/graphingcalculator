package equationnodes;

public abstract class EquationNode {
	
	protected String type;
	protected String name;

	public String getType()
	{
		return type;
	}
	
	public abstract double getValue();
	
	public abstract int getPriority();
	
	/** Returns the number of children this node has */
	public abstract int numChildren();
	
}