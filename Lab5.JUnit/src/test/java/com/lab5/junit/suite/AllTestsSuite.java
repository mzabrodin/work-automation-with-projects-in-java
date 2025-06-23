package com.lab5.junit.suite;

import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectPackages("com.lab5.junit")
@IncludeTags({"simple", "param"})
public class AllTestsSuite {
}
