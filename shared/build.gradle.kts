import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlin.serialization)
    id("kotlin-parcelize")
}

kotlin {
    applyDefaultHierarchyTemplate()
    jvm()
    androidTarget {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
        }
    }

    listOf(
        iosArm64(),
        iosX64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "Shared"
            isStatic = true

            export(libs.decompose.decompose)
            export(libs.decompose.extensionsComposeJetbrains)
            export(libs.essenty.lifecycle)
        }
    }

    sourceSets {
        commonMain.dependencies {
            // put your Multiplatform dependencies here
            api(libs.decompose.decompose)
            api(libs.essenty.lifecycle)
            api(libs.essenty.lifecycle.coroutine)
            api(libs.koin.core)
            api(libs.kotlinx.coroutines.core)
        }

        iosMain.dependencies {
            api(libs.decompose.decompose)
            api(libs.decompose.extensionsComposeJetbrains)
            api(libs.essenty.lifecycle)
        }
    }
}

android {
    namespace = "org.coffeeaddicts.howtocoffee.shared"
    compileSdk = libs.versions.android.compileSdk.get().toInt()
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()
    }
}
