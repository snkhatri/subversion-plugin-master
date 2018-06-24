/*
 * The MIT License
 *
 * Copyright 2014 Jesse Glick.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package jenkins.scm.impl.subversion;

import hudson.Extension;
import hudson.scm.SCM;
import hudson.scm.SubversionSCM;
import org.jenkinsci.plugins.workflow.steps.scm.SCMStep;
import org.kohsuke.stapler.DataBoundConstructor;

/**
 * Runs Subversion using {@link SubversionSCM}.
 */
public final class SubversionStep extends SCMStep {

    private final String url;

    @DataBoundConstructor
    public SubversionStep(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    @Override
    protected SCM createSCM() {
        return new SubversionSCM(url); // TODO maybe default to UpdateWithCleanUpdater, etc.
    }

    @Extension
    public static final class DescriptorImpl extends SCMStepDescriptor {

        @Override
        public String getFunctionName() {
            return "svn";
        }

        @Override
        public String getDisplayName() {
            return Messages.SubversionStep_subversion();
        }

    }

}
