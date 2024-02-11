package cz.darklabs.labscore.command.annotation;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;

import com.google.auto.service.AutoService;

import java.io.IOException;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * The main annotation processor for annotation-based arguments
 */
@AutoService(Processor.class)
public class Annotation extends AbstractProcessor {
	private static final Class<?>[] ARGUMENT_ANNOTATIONS = new Class<?>[] {};

	// List of stuff we can deal with
	@Override
	public Set<String> getSupportedAnnotationTypes() {
		return Stream
			.concat(Arrays.stream(new Class<?>[] { Command.class, Default.class,
				Permission.class, Subcommand.class, Help.class }), Arrays.stream(ARGUMENT_ANNOTATIONS))
			.map(Class::getCanonicalName).collect(Collectors.toSet());
	}
	@Override
	public SourceVersion getSupportedSourceVersion() {
		return SourceVersion.latestSupported();
	}
	@Override
	public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
		for (Element element : roundEnv.getElementsAnnotatedWith(Command.class)) {
//			try {
//				processCommand(element);
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
		}
		return true;
	}
}
