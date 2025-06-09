package com.lab3.gradle.passwordutils.plugin;

import org.gradle.api.DefaultTask;
import org.gradle.api.Project;
import org.gradle.api.artifacts.ProjectDependency;
import org.gradle.api.artifacts.Dependency;
import org.gradle.api.tasks.TaskAction;

import java.util.Set;

public class PrintModuleDependenciesTask extends DefaultTask {
    @TaskAction
    public void printDependencies() {
        Project project = getProject();
        System.out.println("=== Module Dependencies ===");

        for (Project sub : project.getSubprojects()) {
            System.out.println("Module: " + sub.getName());

            Set<Dependency> dependencies = sub.getConfigurations()
                    .getByName("implementation")
                    .getAllDependencies();

            boolean hasDeps = false;

            for (Dependency dep : dependencies) {
                if (dep instanceof ProjectDependency pd) {
                    System.out.println("  depends on project -> " + pd.getDependencyProject().getName());
                    hasDeps = true;
                } else {
                    String group = dep.getGroup();
                    String name = dep.getName();
                    String version = dep.getVersion();

                    if (group != null && version != null) {
                        System.out.println("  depends on library -> " + group + ":" + name + ":" + version);
                        hasDeps = true;
                    }
                }
            }

            if (!hasDeps) {
                System.out.println("  depends on -> [no dependencies]");
            }

            System.out.println();
        }
    }
}
