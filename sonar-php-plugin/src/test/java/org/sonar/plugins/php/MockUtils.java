/*
 * Sonar PHP Plugin
 * Copyright (C) 2010 Codehaus Sonar Plugins
 * dev@sonar.codehaus.org
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02
 */
/**
 * 
 */
package org.sonar.plugins.php;

import org.sonar.api.resources.Project;
import org.sonar.api.resources.ProjectFileSystem;
import org.sonar.plugins.php.api.Php;
import org.sonar.plugins.php.api.PhpConstants;

import java.io.File;
import java.util.Arrays;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MockUtils {

  public static Project createMockProject() {
    Project project = mock(Project.class);
    when(project.getLanguage()).thenReturn(new Php());
    when(project.getLanguageKey()).thenReturn(PhpConstants.LANGUAGE_KEY);
    ProjectFileSystem fs = mock(ProjectFileSystem.class);
    when(project.getFileSystem()).thenReturn(fs);
    when(fs.getSourceDirs()).thenReturn(Arrays.asList(new File("target/MockProject/src").getAbsoluteFile()));
    when(fs.getTestDirs()).thenReturn(Arrays.asList(new File("target/MockProject/test").getAbsoluteFile()));
    when(fs.getBuildDir()).thenReturn(new File("target/MockProject/target").getAbsoluteFile());
    when(fs.getBasedir()).thenReturn(new File("target/MockProject").getAbsoluteFile());
    return project;
  }

}
