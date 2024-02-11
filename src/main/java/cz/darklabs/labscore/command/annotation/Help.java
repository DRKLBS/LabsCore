package cz.darklabs.labscore.command.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * The annotation which includes information about the help for a command
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface Help {

	/**
	 * The full description for this command's help
	 * @return the full description for this command's help
	 */
	public String value();

	/**
	 * The short description for this command's help
	 * @return the short description for this command's help
	 */
	public String shortDescription() default "";

}
