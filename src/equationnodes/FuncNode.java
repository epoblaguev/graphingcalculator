package equationnodes;

/*
 * FuncNode.java
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

import java.util.Random;

import Settings.Printer;

public class FuncNode extends OpNode {

	boolean radians;
	
	public FuncNode(String func,boolean rad)
	{
		name = func;
		type = "f";
		radians = rad;
	}
	public double getValue() {  //should put this in order of most likely to least likely to be used
		if(name.equals("sin("))
		{
			Printer.print("Radians?: " +radians);
					
			if(radians)
			return Math.sin(child.getValue());
			else
				return Math.sin(Math.toRadians(child.getValue()));
		}
		if(name.equals("cos("))
		{
			if(radians)
			return Math.cos(child.getValue());
			else
				return Math.cos(Math.toRadians(child.getValue()));
		}
		if(name.equals("tan("))
		{
			if(radians)
			return Math.tan(child.getValue());
			else
				return Math.tan(Math.toRadians(child.getValue()));
		}
		if(name.equals("asin("))
		{
			if(radians)
			return Math.asin(child.getValue());
			else
				return Math.toDegrees(Math.asin(child.getValue()));
		}
		if(name.equals("acos("))
		{
			if(radians)
			return Math.acos(child.getValue());
			else
				return Math.toDegrees(Math.acos(child.getValue()));
		}
		if(name.equals("atan("))
		{
			if(radians)
			return Math.atan(child.getValue());
			else
				return Math.toDegrees(Math.atan(child.getValue()));
		}
		if(name.equals("abs("))
		{
			return Math.abs(child.getValue());
		}
		if(name.equals("sqr("))
		{
			return Math.pow(child.getValue(),2.0);
		}
		if(name.equals("sqrt("))
		{
			return Math.sqrt(child.getValue());
		}
		if(name.equals("log(")) //needs to be fixed
		{
			return (Math.log(child.getValue())/Math.log(10.0));
		}
		if(name.equals("ln("))
		{
			return Math.log(child.getValue());
		}
		if(name.equals("exp("))
		{
			return Math.pow(Math.E,child.getValue());
		}
		if(name.equals("ceil("))
		{
			return Math.ceil(child.getValue());
		}
		if(name.equals("floor("))
		{
			return Math.floor(child.getValue());
		}
		if(name.equals("neg("))
		{
			return 0-(child.getValue());
		}
		if(name.equals("rnd("))
		{
			Random r = new Random((long) child.getValue());
			return r.nextDouble();
		}
		if(name.equals("("))
		{
			return (child.getValue());
		}
		else
		{
			//Throw exception??
			return 0;
		}
	}
	
	public String toString()
	{
		if(child != null)
		return name+child.toString()+")";
		
		return name;
	}
	
	
	public int getPriority() {
		// TODO Auto-generated method stub
		return 10;
	}

}