/**
 * Indicate that the arguments for minimum array were bad. It is unchecked.
 * 
 * @author Charles Hoot
 * @version 2.0
 */
public class BadArgumentsForMinimumException extends RuntimeException
{
	public BadArgumentsForMinimumException(String reason)
	{
		super(reason);
	}
}
