package emfer.stories

import emfer.reachability.ReachabilityGraph
import emfer.reachability.ReachableState
import emfer.LazyCloneOp
import java.util.HashSet
import org.eclipse.emf.ecore.EObject
import java.util.ArrayList
import java.util.LinkedHashSet
import emfer.ModelIsomorphismOp.CertInfo
import org.eclipse.emf.ecore.EStructuralFeature
import java.util.Set
import org.eclipse.emf.common.util.EList
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.ENamedElement

class StoryStep {
	public String content
	ReachabilityGraph reachabilityGraph
	ReachableState reachableState

	override String toString() {
		'''
			<p>
			<pre>
			«content»
			</pre>
			</p>
			«IF this.reachabilityGraph != null»
				«addReachabilityGraph»
			«ENDIF»
			«IF this.reachableState != null»
				«addReachableState»
			«ENDIF»
		'''
	}

	def addReachableState() {
		var nodes = new LinkedHashSet<EObject>
		var edges = new ArrayList<Edge>
		nodes.add(reachableState.root)

		aggregate(nodes, edges)

		'''
			
			<div class="alchemy" id="alchemy_«this.hashCode.toString»"></div>
			<script type="text/javascript">
			
			var data= {
			«FOR n : nodes BEFORE '"nodes": [\n' SEPARATOR ',' AFTER ']'»
				{type:"state",id:«n.hashCode»,caption:"«n.toString.replaceAll("\n",", ")»"}
			«ENDFOR»
			,«var i =0»
			«FOR e : edges BEFORE '"edges": [\n' SEPARATOR ',' AFTER ']'»
				{source:«e.source.hashCode»,target:«e.target.hashCode»,nr:«i++»,caption:"«e.edge.getName»",type:"normal"}
			«ENDFOR»
			}
			«config»
			alchemy = new Alchemy(config)
			</script>
		'''

	}

	def String addReachabilityGraph() {
		'''
			
			<div class="alchemy" id="alchemy_«this.hashCode.toString»"></div>
			<script type="text/javascript">
			
			var data= {
			«FOR s : reachabilityGraph.states BEFORE '"nodes": [\n' SEPARATOR ',' AFTER ']'»
				{type:"«s.type»",id:«s.number»,caption:"state «s.number»"}
			«ENDFOR»
			,«var i =0»
			«FOR t : reachabilityGraph.trafoApplications BEFORE '"edges": [\n' SEPARATOR ',' AFTER ']'»
				{source:«t.src.number»,target:«t.tgt.number»,nr:«i++»,caption:"«t.description»",type:"normal"}
			«ENDFOR»
			}
			«config»
			alchemy = new Alchemy(config)
			</script>
		'''
	}

	def getConfig() {
		'''
			var config = {
					dataSource: data,
					divSelector: alchemy_«this.hashCode.toString»,
					  directedEdges:true,
					  graphWidth: function() {return screen.availWidth  * 0.7},
					  graphHeight: function() {return screen.availHeight * 0.7},
					  initialScale: 0.5, 
					  initialTranslate: [250,250],
					  curvedEdges:false,
					  edgeCaptionsOnByDefault: true,
					  backgroundColour: "#FFFFFF",
					  nodeCaptionsOnByDefault: true,
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
					         color: "#8e00ed",
					         borderColor: "#9018e0",
					         captionColor: "#FFFFFF"
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
					      opacity: .9,
					      color: 575459
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
		'''
	}

	def String type(ReachableState state) {
		var i = state.metricValue as int;
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
		this.reachabilityGraph = graph;
	}

	def setReachableState(ReachableState state) {
		this.reachableState = state
	}

	def aggregate(Set<EObject> dynNodes, ArrayList<Edge> dynEdges) {
		var todo = new ArrayList<EObject>();
		todo.addAll(dynNodes);

		while (! todo.isEmpty()) {
			var eObject = todo.remove(todo.size() - 1);

			var eClass = eObject.eClass();

			for (EStructuralFeature f : eClass.getEAllStructuralFeatures()) {
				var value = eObject.eGet(f);

				if (value instanceof EList) {
					for (Object elem : value) {
						if (elem != null && elem instanceof EObject) {

							dynEdges.add(new Edge(eObject, elem as EObject, f))

							if (! dynNodes.contains(elem)) {
								var e = elem as EObject;
								dynNodes.add(e);
								todo.add(e);
							}
						}
					}
				} else if (value != null && value instanceof EObject) {
					dynEdges.add(new Edge(eObject, value as EObject, f))

					if (! dynNodes.contains(value)) {
						var e = value as EObject;
						dynNodes.add(e);
						todo.add(e);
					}
				}
			}

			var eContainer = eObject.eContainer();

			if (eContainer != null) {
				dynEdges.add(new Edge(eObject, eContainer, eObject.eContainingFeature))
			}

		}
	}

}

class Edge {
	public EObject source
	public EObject target
	public ENamedElement edge

	new(EObject source, EObject target, ENamedElement edge) {
		this.source = source
		this.edge = edge
		this.target = target
	}

}
