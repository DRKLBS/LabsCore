package cz.darklabs.labscore.command.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Marks a class as a command
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface Command {
	/**
	 * The name of the command that this class represents
	 * @return the name of the command that this class represents
	 */
	public String value();
}
