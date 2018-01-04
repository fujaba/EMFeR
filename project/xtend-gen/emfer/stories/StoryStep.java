package emfer.stories;

import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class StoryStep {
  public String content;
  
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
    return _builder.toString();
  }
}
