import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

class ExtraTask extends DefaultTask {

    @TaskAction
    void output() {
        println "name: ${project.args.name}; age: ${project.args.second.age}"
    }

}