package equationnodes;

public class SubNode extends BinOpNode {

	public SubNode()
	{
		name = ("-");
	}
	
	public SubNode(EquationNode leftchild,EquationNode rightchild)
	{
		name = "-";
		lchild=leftchild;
		rchild=rightchild;
	}
	
	public double getValue() {
		// TODO Auto-generated method stub
		return lchild.getValue() - rchild.getValue();
	}
	@Override
	public int getPriority() {
		return 0;
	}

	public String toString()
	{
		if(lchild != null && rchild != null)
			return lchild.toString()+"-"+rchild.toString();
			else
				return "-";
		
	}
	
}
