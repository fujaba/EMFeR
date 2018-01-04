package emfer.stories

class StoryStep {
	public String content
	
	override String toString()
	{
		'''
		<p>
		<pre>
		«content»
		</pre>
		</p>
		'''
	}
}