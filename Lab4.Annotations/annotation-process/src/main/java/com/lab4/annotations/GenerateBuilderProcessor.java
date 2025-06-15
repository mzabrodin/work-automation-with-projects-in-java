package com.lab4.annotations;

import com.google.auto.service.AutoService;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.*;
import javax.tools.JavaFileObject;
import java.io.IOException;
import java.io.Writer;
import java.util.Set;

@AutoService(javax.annotation.processing.Processor.class)
@SupportedAnnotationTypes("com.lab4.annotations.GenerateBuilder")
@SupportedSourceVersion(SourceVersion.RELEASE_21)
public class GenerateBuilderProcessor extends AbstractProcessor {

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        for (Element element : roundEnv.getElementsAnnotatedWith(GenerateBuilder.class)) {
            if (element.getKind() != ElementKind.CLASS) continue;

            TypeElement classElement = (TypeElement) element;
            String packageName = processingEnv.getElementUtils().getPackageOf(classElement).toString();
            String className = classElement.getSimpleName().toString();
            String builderClassName = className + "Builder";

            try {
                JavaFileObject builderFile = processingEnv.getFiler()
                        .createSourceFile(packageName + "." + builderClassName);

                try (Writer writer = builderFile.openWriter()) {
                    writer.write("package " + packageName + ";\n\n");
                    writer.write("public class " + builderClassName + " {\n");

                    for (Element field : classElement.getEnclosedElements()) {
                        if (field.getKind() == ElementKind.FIELD) {
                            VariableElement variable = (VariableElement) field;
                            writer.write("\tprivate " + variable.asType() + " " + variable.getSimpleName() + ";\n");
                        }
                    }
                    writer.write("\n");

                    for (Element field : classElement.getEnclosedElements()) {
                        if (field.getKind() == ElementKind.FIELD) {
                            VariableElement variable = (VariableElement) field;
                            String type = variable.asType().toString();
                            String name = variable.getSimpleName().toString();
                            writer.write("\tpublic " + builderClassName + " " + name + "(" + type + " " + name + ") {\n");
                            writer.write("\t\tthis." + name + " = " + name + ";\n");
                            writer.write("\t\treturn this;\n");
                            writer.write("\t}\n\n");
                        }
                    }

                    writer.write("\tpublic " + className + " build() {\n");
                    writer.write("\t\treturn new " + className + "(");

                    StringBuilder variables = new StringBuilder();
                    for (Element field : classElement.getEnclosedElements()) {
                        if (field.getKind() == ElementKind.FIELD) {
                            if (!variables.isEmpty()) variables.append(", ");
                            variables.append(field.getSimpleName());
                        }
                    }
                    writer.write(variables + ");\n");
                    writer.write("\t}\n");
                    writer.write("}\n");
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return true;
    }
}
