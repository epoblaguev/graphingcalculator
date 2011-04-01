package equationnodes;


/*
 * OpNode.java
 * Author: Ben McCormick
 * Written: Jan 2 2011
 * Last Edited: Feb 4 2011
 * Ben McCormick 2011
 * This file is part of The Eikona Project .
 * Eikona is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * Eikona is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * You should have received a copy of the GNU General Public License
 * along with Eikona.  If not, see <http://www.gnu.org/licenses/>.
 */
public abstract class OpNode extends EquationNode{
	
protected EquationNode child;
	

	/** Set the child for the operator */
	public void setChild(EquationNode _child)
	{
		child = _child;
	}

	@Override
	public int numChildren() {
		// TODO Auto-generated method stub
		return 1;
	}

	/** Get the child for this node */
	public EquationNode getChild() {
		// TODO Auto-generated method stub
		return child;
	}
	
	public String toString()
	{
		if(child !=null)
		{
			return child+name;
		}
		else return name;
	}
	
}
