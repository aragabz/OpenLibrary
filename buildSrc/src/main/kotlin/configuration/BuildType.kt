package configuration

import org.gradle.api.plugins.BasePluginExtension
import java.io.File

interface BuildType {

    companion object {
        const val Debug = "debug"
        const val Release = "release"
    }

    val isMinifyEnabled: Boolean
    val isTestCoverageEnabled: Boolean
}

object DebugBuildType : BuildType {
    override val isMinifyEnabled: Boolean = true

    override val isTestCoverageEnabled: Boolean = false

    const val applicationIdSuffix = ".debug"
    const val versionNameSuffix = "-DEBUG"
}

object ReleaseBuildType : BuildType {
    override val isMinifyEnabled: Boolean = true
    override val isTestCoverageEnabled: Boolean = false
}