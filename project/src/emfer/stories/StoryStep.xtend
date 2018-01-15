package emfer.stories

import emfer.reachability.ReachabilityGraph
import emfer.reachability.ReachableState

class StoryStep {
	public String content
	ReachabilityGraph graph
	
	override String toString()
	{
		'''
		<p>
		<pre>
		«content»
		</pre>
		</p>
		«IF this.graph != null»
		«addGraph»
		«ENDIF»
		'''
	}
	
	def String addGraph() {
		'''
		
		<div class="alchemy" id="alchemy"></div>
		<script type="text/javascript">
		
		var data= {
		«FOR s : graph.states BEFORE '"nodes": [\n' SEPARATOR ',' AFTER ']' »
			{type:"«s.type»",id:«s.number»,caption:"«s.toString.replaceAll("\n","<b>")»"}
		«ENDFOR»
		,«var i =0»
		«FOR t : graph.trafoApplications BEFORE '"edges": [\n' SEPARATOR ',' AFTER ']' »
			{source:«t.src.number»,target:«t.tgt.number»,nr:«i++»,caption:"«t.description»",type:"normal"}
		«ENDFOR»
		}
		var config = {
		dataSource: data,
		  directedEdges:true,
		  graphWidth: function() {return screen.availWidth  * 0.7},
		  graphHeight: function() {return screen.availHeight * 0.7},
		  initialScale: 0.5, 
		  initialTranslate: [250,250],
		  curvedEdges:true,
		  edgeCaptionsOnByDefault: true,
		  nodeTypes: {"type":["failure","state","startstate","finalstate"]},
		   "nodeStyle": {
		   "failure": {
		         color: "#FE3E3E",
		      },
		   "finalstate": {
		         color: "#0000FF",
		         radius: 15, 
		      borderColor: "#127DC1"            },
		   "startstate": {
		         color: "#FFFFFF",
		         radius: 15, 
		      borderColor: "#127DC1"            },
		   "state":{
		         color: "#00ff0e",
		         borderColor: "#00ffda"
		   }
		  },
		  "edgeTypes": {"type": ["failure","normal"]},
		  "edgeStyle": {
		      "failure": {
		         color: "#ff794d",
		      width: 7,
		         opacity: 1
		   },
		      "greenpath": {
		         color: "#00FF00",
		      width: 7,
		         opacity: 1
		   },
		   "normal": {
		      opacity: .9
		   }
		  },     
		   nodeClick: function OpenInNewTab(node) {
		         var win = window.open('objectgraphs/graph'+node.id+'.html', '_blank');
		         if (win) {
		               win.focus();
		         } else {
		               alert('Please allow popups for this website');
		         }
		      }     
			,     
			edgeClick: function OpenInNewTab(edge) {
			    var win = window.open('rulegraphs/graph'+edge._properties.nr+'.html', '_blank');
			    if (win) {
			          win.focus();
			    } else {
			          alert('Please allow popups for this website');
			    }
			 }     
			    };
		alchemy = new Alchemy(config)
		</script>
		'''
	}
	
	def String type(ReachableState state){
		var i =  state.metricValue as int;
		switch (i) {
			case 0: {
				'''finalstate'''
			}
			default: {
				'''state'''
			}
		}
	}
	
	def setGraph(ReachabilityGraph graph) {
		this.graph = graph;
	}
	
}