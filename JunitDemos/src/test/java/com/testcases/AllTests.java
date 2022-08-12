package com.testcases;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.ExcludePackages;
import org.junit.platform.suite.api.IncludePackages;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;
 
@RunWith(JUnitPlatform.class)

@SelectPackages({"com.testcases"})
@IncludeTags({"A","B"})
@IncludePackages({"com.testcases.trial"})
@ExcludePackages({"com.testcases.trial.shapetest"})
class AllTests {


}
