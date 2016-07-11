package com.customplugin;
import org.gradle.api.*;

class CustomExtension {
    def name = "小莫"
}

class SecondExtension {
    def age = 5
}

class SayPlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {
        project.task('aaa_print') << {
            println "Hi this is micky's plugins"
        }
        project.task('aaa_simple', type : TestTask)

        project.extensions.create("args", CustomExtension)
        project.args.extensions.create("second", SecondExtension)
        project.task('aaa_extra', type : ExtraTask)
    }
}