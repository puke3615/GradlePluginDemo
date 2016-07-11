import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

class TestTask extends DefaultTask {

    @TaskAction
    void output() {
        println "make a test.."
    }

}