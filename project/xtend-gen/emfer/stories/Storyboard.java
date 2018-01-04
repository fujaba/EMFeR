package emfer.stories;

import emfer.stories.StoryStep;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.logging.Handler;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Exceptions;

@SuppressWarnings("all")
public class Storyboard {
  public static class StoryLogHandler extends Handler {
    private Storyboard storyboard;
    
    public StoryLogHandler(final Storyboard story) {
      this.storyboard = story;
    }
    
    @Override
    public void close() throws SecurityException {
    }
    
    @Override
    public void flush() {
    }
    
    @Override
    public void publish(final LogRecord record) {
      this.storyboard.add(record.getMessage());
    }
  }
  
  public Storyboard(final String name) {
    this.storyName = name;
    Logger myLogger = Logger.getGlobal();
    Storyboard.StoryLogHandler _storyLogHandler = new Storyboard.StoryLogHandler(this);
    myLogger.addHandler(_storyLogHandler);
  }
  
  private String storyName;
  
  private ArrayList<StoryStep> steps = new ArrayList<StoryStep>();
  
  public boolean add(final String text) {
    boolean _xblockexpression = false;
    {
      StoryStep newStep = new StoryStep();
      newStep.content = text;
      _xblockexpression = this.steps.add(newStep);
    }
    return _xblockexpression;
  }
  
  public Path dumpHtml() {
    try {
      Path _xblockexpression = null;
      {
        String htmlText = this.getHtmlText();
        _xblockexpression = Files.write(Paths.get((("doc/" + this.storyName) + ".html")), htmlText.getBytes(), StandardOpenOption.CREATE);
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public String getHtmlText() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<!DOCTYPE html>");
    _builder.newLine();
    _builder.append("<html>");
    _builder.newLine();
    _builder.append("<head><meta charset=\"utf-8\">");
    _builder.newLine();
    _builder.append("</head>");
    _builder.newLine();
    _builder.append("<body>");
    _builder.newLine();
    _builder.append("<h2>");
    _builder.append(this.storyName);
    _builder.append("</h2>");
    _builder.newLineIfNotEmpty();
    {
      for(final StoryStep s : this.steps) {
        String _string = s.toString();
        _builder.append(_string);
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("</body>");
    _builder.newLine();
    _builder.append("</html>");
    _builder.newLine();
    return _builder.toString();
  }
}
