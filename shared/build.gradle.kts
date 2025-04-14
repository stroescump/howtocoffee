import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget
import org.jetbrains.kotlin.konan.target.Family

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

    targets.filterIsInstance<KotlinNativeTarget>()
        .filter { it.konanTarget.family == Family.IOS }
        .forEach {
            it.binaries.framework {
                val essenty_version = "2.2.1"
                val decompose = "3.2.2"
                export("com.arkivanov.decompose:decompose:<$decompose>")
                export("com.arkivanov.essenty:lifecycle:<$essenty_version>")

                // Exploring if this needs to be in/out

//                // Optional, only if you need state preservation on Darwin (Apple) targets
//                export("com.arkivanov.essenty:state-keeper:<$essenty_version>")
//
//                // Optional, only if you need state preservation on Darwin (Apple) targets
//                export("com.arkivanov.parcelize.darwin:runtime:<parcelize_darwin_version>")
            }
        }

//    cocoapods {
//        framework {
//
//
//            export("com.arkivanov.decompose:decompose:<version>")
//            export("com.arkivanov.essenty:lifecycle:<essenty_version>")
//
//            // Optional, only if you need state preservation on Darwin (Apple) targets
//            export("com.arkivanov.essenty:state-keeper:<essenty_version>")
//
//            // Optional, only if you need state preservation on Darwin (Apple) targets
//            export("com.arkivanov.parcelize.darwin:runtime:<parcelize_darwin_version>")
//        }
//    }

    listOf(
        iosArm64(),
        iosX64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "Shared"
            isStatic = true
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
