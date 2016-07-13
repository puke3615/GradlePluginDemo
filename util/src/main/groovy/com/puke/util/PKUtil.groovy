package com.puke.util

import org.gradle.api.*

class ReplaceName {
    String oldName
    String newName
}


class PKUtil implements Plugin<Project> {

    @Override
    void apply(Project project) {
        project.task('pk_test') << {
            println 'make a test...'
        }
        //rename task
        project.extensions.create('rename', ReplaceName)
        project.task('pk_rename', type: RenameTask)
    }
}