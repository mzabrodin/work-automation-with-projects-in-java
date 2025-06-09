package com.lab3.gradle.passwordutils.plugin;

import org.gradle.api.Plugin;
import org.gradle.api.Project;

public class ProjectDependencyTreePlugin implements Plugin<Project> {
    @Override
    public void apply(Project project) {
        project.getTasks().register("moduleDependencies", PrintModuleDependenciesTask.class, task -> {
            task.setGroup("statistics");
            task.setDescription("Prints module dependencies within the project");
        });
    }
}
