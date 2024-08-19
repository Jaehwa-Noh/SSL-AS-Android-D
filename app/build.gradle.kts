plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
}

kotlin {
    jvmToolchain(libs.versions.toolchainVersion.get().toInt())
}

android {
    compileSdk = libs.versions.compileSdkVersion.get().toInt()
    buildToolsVersion = libs.versions.buildToolVersion.get()
    namespace = "com.example.d"

    defaultConfig {
        applicationId = "com.example.d"
        minSdk = libs.versions.minSdkVersion.get().toInt()
        targetSdk = libs.versions.compileSdkVersion.get().toInt()
        versionCode = libs.versions.versionCodeVersion.get().toInt()
        versionName = libs.versions.versionNameVersion.get()

        signingConfig = signingConfigs.named("debug").get()
    }

    buildTypes {
        release {
            isShrinkResources = true
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
        }
        debug {
            applicationIdSuffix = ".debug"
            isDebuggable = true
        }
    }

    buildFeatures {
        viewBinding = true
        buildConfig = true
    }

    androidResources {
        noCompress += "flac"
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

    testOptions {
        animationsDisabled = true
    }
}

dependencies {
    implementation(libs.material)
}
