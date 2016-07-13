package com.puke.util

import groovy.io.FileType
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

class RenameTask extends DefaultTask {
    @TaskAction
    void output() {
        def oldName = project.extensions.rename.oldName as String
        def newName = project.extensions.rename.newName as String
        if (!oldName || oldName.length() == 0) {
            println '请输入oldName的值'
            return
        }
        if (!newName || newName.length() == 0) {
            println '请输入newName的值'
            return
        }
        project.projectDir.eachFileRecurse(FileType.FILES) {
            changeName(it, oldName, newName)
        }
        project.projectDir.renameTo(project.projectDir.absolutePath.replace(oldName, newName))
    }

    static void changeName(File file, String oldName, String newName) {
        def content = file.text
        if (content) {
            content = content.replaceAll(oldName, newName)
            file.withOutputStream {
                it.write(content.bytes)
            }
        }
    }

}