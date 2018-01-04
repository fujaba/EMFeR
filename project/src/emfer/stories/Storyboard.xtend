package emfer.stories

import java.nio.file.Files
import java.nio.file.Paths
import java.util.logging.Logger
import java.util.logging.Handler
import java.util.logging.LogRecord
import java.util.LinkedHashSet
import java.util.Set
import java.util.ArrayList
import java.nio.file.OpenOption
import java.nio.file.StandardOpenOption

class Storyboard 
{
	static class StoryLogHandler extends Handler
	{
			Storyboard storyboard
			
			new (Storyboard story)
			{
				storyboard = story	
			}
			
			override close() throws SecurityException 
			{
				// ???
			}
			
			override flush() 
			{
			}
			
			override publish(LogRecord record) 
			{
				storyboard.add(record.message)	
			}
	}
	
	new(String name)
	{
		storyName = name
		
		var Logger myLogger = Logger.getGlobal()
		
		myLogger.addHandler(new StoryLogHandler(this))
	}

	String storyName
	
	ArrayList<StoryStep> steps = new ArrayList<StoryStep>();
	
	def add(String text)
	{
		var StoryStep newStep = new StoryStep()
		
		newStep.content = text
		
		steps.add(newStep)
	}
	
	def dumpHtml()
	{
		var htmlText = getHtmlText()
		
		Files.write(Paths.get("doc/" + storyName + ".html"), htmlText.bytes, StandardOpenOption.CREATE)
	}
	
	def String getHtmlText() {
		'''
			<!DOCTYPE html>
			<html>
			<head><meta charset="utf-8">
			</head>
			<body>
			<h2>«storyName»</h2>
			«FOR s : steps»
				«s.toString()»
			«ENDFOR»
			</body>
			</html>
		'''
	}
	
}