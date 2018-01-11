package emfer.examples.ferryman

import emfer.reachability.ReachabilityGraph
import emfer.reachability.ReachableState

class FerryManReachabilityQuery 
{
	def findFinal(ReachabilityGraph g) 
	{
		var states = g.states;
		
		states.findFirst[ s | isFinal(s)]	
	}
	
	def isFinal(ReachableState state) 
	{
		var rightBank = (state.root as River).banks.findFirst[ name.equals("right")]
		
		return rightBank.cargos.size == 3
	}
	
}