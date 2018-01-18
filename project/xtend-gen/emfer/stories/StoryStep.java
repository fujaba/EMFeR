package emfer.stories;

import com.google.common.base.Objects;
import emfer.reachability.ReachabilityGraph;
import emfer.reachability.ReachableState;
import emfer.reachability.TrafoApplication;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class StoryStep {
  public String content;
  
  private ReachabilityGraph graph;
  
  @Override
  public String toString() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<p>");
    _builder.newLine();
    _builder.append("<pre>");
    _builder.newLine();
    _builder.append(this.content);
    _builder.newLineIfNotEmpty();
    _builder.append("</pre>");
    _builder.newLine();
    _builder.append("</p>");
    _builder.newLine();
    {
      boolean _notEquals = (!Objects.equal(this.graph, null));
      if (_notEquals) {
        String _addGraph = this.addGraph();
        _builder.append(_addGraph);
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder.toString();
  }
  
  public String addGraph() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    _builder.append("<div class=\"alchemy\" id=\"alchemy\"></div>");
    _builder.newLine();
    _builder.append("<script type=\"text/javascript\">");
    _builder.newLine();
    _builder.newLine();
    _builder.append("var data= {");
    _builder.newLine();
    {
      EList<ReachableState> _states = this.graph.getStates();
      boolean _hasElements = false;
      for(final ReachableState s : _states) {
        if (!_hasElements) {
          _hasElements = true;
          _builder.append("\"nodes\": [\n");
        } else {
          _builder.appendImmediate(",", "");
        }
        _builder.append("{type:\"");
        String _type = this.type(s);
        _builder.append(_type);
        _builder.append("\",id:");
        long _number = s.getNumber();
        _builder.append(_number);
        _builder.append(",caption:\"");
        String _replaceAll = s.toString().replaceAll("\n", "<b>");
        _builder.append(_replaceAll);
        _builder.append("\"}");
        _builder.newLineIfNotEmpty();
      }
      if (_hasElements) {
        _builder.append("]");
      }
    }
    _builder.append(",");
    int i = 0;
    _builder.newLineIfNotEmpty();
    {
      EList<TrafoApplication> _trafoApplications = this.graph.getTrafoApplications();
      boolean _hasElements_1 = false;
      for(final TrafoApplication t : _trafoApplications) {
        if (!_hasElements_1) {
          _hasElements_1 = true;
          _builder.append("\"edges\": [\n");
        } else {
          _builder.appendImmediate(",", "");
        }
        _builder.append("{source:");
        long _number_1 = t.getSrc().getNumber();
        _builder.append(_number_1);
        _builder.append(",target:");
        long _number_2 = t.getTgt().getNumber();
        _builder.append(_number_2);
        _builder.append(",nr:");
        int _plusPlus = i++;
        _builder.append(_plusPlus);
        _builder.append(",caption:\"");
        String _description = t.getDescription();
        _builder.append(_description);
        _builder.append("\",type:\"normal\"}");
        _builder.newLineIfNotEmpty();
      }
      if (_hasElements_1) {
        _builder.append("]");
      }
    }
    _builder.append("}");
    _builder.newLine();
    _builder.append("var config = {");
    _builder.newLine();
    _builder.append("dataSource: data,");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("directedEdges:true,");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("graphWidth: function() {return screen.availWidth  * 0.7},");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("graphHeight: function() {return screen.availHeight * 0.7},");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("initialScale: 0.5, ");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("initialTranslate: [250,250],");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("curvedEdges:true,");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("edgeCaptionsOnByDefault: true,");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("nodeTypes: {\"type\":[\"failure\",\"state\",\"startstate\",\"finalstate\"]},");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("\"nodeStyle\": {");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("\"failure\": {");
    _builder.newLine();
    _builder.append("         ");
    _builder.append("color: \"#FE3E3E\",");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("},");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("\"finalstate\": {");
    _builder.newLine();
    _builder.append("         ");
    _builder.append("color: \"#0000FF\",");
    _builder.newLine();
    _builder.append("         ");
    _builder.append("radius: 15, ");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("borderColor: \"#127DC1\"            },");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("\"startstate\": {");
    _builder.newLine();
    _builder.append("         ");
    _builder.append("color: \"#FFFFFF\",");
    _builder.newLine();
    _builder.append("         ");
    _builder.append("radius: 15, ");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("borderColor: \"#127DC1\"            },");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("\"state\":{");
    _builder.newLine();
    _builder.append("         ");
    _builder.append("color: \"#00ff0e\",");
    _builder.newLine();
    _builder.append("         ");
    _builder.append("borderColor: \"#00ffda\"");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("},");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("\"edgeTypes\": {\"type\": [\"failure\",\"normal\"]},");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("\"edgeStyle\": {");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("\"failure\": {");
    _builder.newLine();
    _builder.append("         ");
    _builder.append("color: \"#ff794d\",");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("width: 7,");
    _builder.newLine();
    _builder.append("         ");
    _builder.append("opacity: 1");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("},");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("\"greenpath\": {");
    _builder.newLine();
    _builder.append("         ");
    _builder.append("color: \"#00FF00\",");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("width: 7,");
    _builder.newLine();
    _builder.append("         ");
    _builder.append("opacity: 1");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("},");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("\"normal\": {");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("opacity: .9");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("},     ");
    _builder.newLine();
    _builder.append("   ");
    _builder.append("nodeClick: function OpenInNewTab(node) {");
    _builder.newLine();
    _builder.append("         ");
    _builder.append("var win = window.open(\'objectgraphs/graph\'+node.id+\'.html\', \'_blank\');");
    _builder.newLine();
    _builder.append("         ");
    _builder.append("if (win) {");
    _builder.newLine();
    _builder.append("               ");
    _builder.append("win.focus();");
    _builder.newLine();
    _builder.append("         ");
    _builder.append("} else {");
    _builder.newLine();
    _builder.append("               ");
    _builder.append("alert(\'Please allow popups for this website\');");
    _builder.newLine();
    _builder.append("         ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("      ");
    _builder.append("}     ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append(",     ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("edgeClick: function OpenInNewTab(edge) {");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("var win = window.open(\'rulegraphs/graph\'+edge._properties.nr+\'.html\', \'_blank\');");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("if (win) {");
    _builder.newLine();
    _builder.append("\t          ");
    _builder.append("win.focus();");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("} else {");
    _builder.newLine();
    _builder.append("\t          ");
    _builder.append("alert(\'Please allow popups for this website\');");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("}     ");
    _builder.newLine();
    _builder.append("\t    ");
    _builder.append("};");
    _builder.newLine();
    _builder.append("alchemy = new Alchemy(config)");
    _builder.newLine();
    _builder.append("</script>");
    _builder.newLine();
    return _builder.toString();
  }
  
  public String type(final ReachableState state) {
    String _xblockexpression = null;
    {
      double _metricValue = state.getMetricValue();
      int i = ((int) _metricValue);
      String _switchResult = null;
      switch (i) {
        case 0:
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("finalstate");
          _switchResult = _builder.toString();
          break;
        default:
          StringConcatenation _builder_1 = new StringConcatenation();
          _builder_1.append("state");
          _switchResult = _builder_1.toString();
          break;
      }
      _xblockexpression = _switchResult;
    }
    return _xblockexpression;
  }
  
  public ReachabilityGraph setGraph(final ReachabilityGraph graph) {
    return this.graph = graph;
  }
}
