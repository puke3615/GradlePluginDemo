package com.puke.util

import org.gradle.api.*

class ReplaceName {
    String oldName
    String newName
}

class Dog {
    int age
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

        //test task
        project.extensions.create('xiaomo', Dog)
        def test = project.tasks.getByName('pk_test')
        test.onlyIf {
            return project.extensions.xiaomo.age > 5
        }
        test.doFirst {
            println 'pre_1'
        }.doFirst {
            println 'pre_2'
        }.doLast {
            println 'post_1'
        }.doLast {
            println 'post_2'
        }

        //upload
        def upload = project.tasks.getByName('uploadArchives')
        upload.doFirst {
            project.group = 'com.puke'
            project.artifacts.properties.each {
                println "${it.key}:${it.value}"
            }
        }
    }
}