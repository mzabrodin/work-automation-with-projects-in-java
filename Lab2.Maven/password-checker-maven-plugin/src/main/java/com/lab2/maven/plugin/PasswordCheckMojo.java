package com.lab2.maven.plugin;

import com.lab2.maven.passwordvalidation.PasswordValidatorService;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

/**
 * Checks and returns password strength
 */
@Mojo(name = "check-password")
public class PasswordCheckMojo extends AbstractMojo {

    /**
     * Input password
     */
    @Parameter(property = "password", required = true)
    private String password;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        getLog().info("Checking password...");
        try {
            String result = PasswordValidatorService.validate(password).toString();
            getLog().info(result);
        } catch (Exception e) {
            throw new MojoExecutionException("Password validation failed", e);
        }
    }
}
