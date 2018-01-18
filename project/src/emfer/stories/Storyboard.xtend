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
import emfer.reachability.ReachabilityGraph
import emfer.reachability.ReachableState

class Storyboard {
	static class StoryLogHandler extends Handler {
		Storyboard storyboard

		new(Storyboard story) {
			storyboard = story
		}

		override close() throws SecurityException 
			{
			// ???
		}

		override flush() {
		}

		override publish(LogRecord record) {
			storyboard.add(record.message)
		}
	}

	new(String name) {
		storyName = name

		var Logger myLogger = Logger.getGlobal()

		myLogger.addHandler(new StoryLogHandler(this))
	}

	String storyName

	ArrayList<StoryStep> steps = new ArrayList<StoryStep>();

	def add(String text) {
		var StoryStep newStep = new StoryStep()

		newStep.content = text

		steps.add(newStep)
	}

	def addReachableState(ReachableState reachableState) {
		addReachableState(reachableState,"ReachableState")
	}

	def addReachableState(ReachableState reachableState, String content) {
		var StoryStep newStep = new StoryStep()
		newStep.content = content
		newStep.reachableState = reachableState

		steps.add(newStep)
	}

	def addReachabilityGraph(ReachabilityGraph reachabilityGraph) {

		var StoryStep newStep = new StoryStep()
		newStep.content = "ReachabilityGraph"
		newStep.graph = reachabilityGraph

		steps.add(newStep)
	}

	def dumpHtml() {
		var htmlText = getHtmlText()

		Files.write(Paths.get("doc/" + storyName + ".html"), htmlText.bytes, StandardOpenOption.TRUNCATE_EXISTING)
	}

	def String getHtmlText() {
		'''
			<!DOCTYPE html>
			<html>
			<head><meta charset="utf-8">
			<link rel="stylesheet" href="includes/alchemy.css">
			<link rel="stylesheet" type="text/css" href="includes/vendor.css">
			<script type="text/javascript" src="includes/vendor.js"></script>
			<script type="text/javascript" src="includes/alchemy.js"></script>
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
