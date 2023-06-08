import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kapt)
}

android {
    namespace = "com.rcl.data"
    compileSdk = 33

    defaultConfig {
        minSdk = 26

        consumerProguardFiles("consumer-rules.pro")
    }
    buildFeatures{
        buildConfig = true
    }
    val clientId: String = gradleLocalProperties(rootDir).getProperty("clientId")
    val clientSecret: String = gradleLocalProperties(rootDir).getProperty("clientSecret")

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            buildConfigField("String", "CLIENT_ID", clientId)
            buildConfigField("String", "CLIENT_SECRET", clientSecret)
        }
        debug {
            buildConfigField("String", "CLIENT_ID", clientId)
            buildConfigField("String", "CLIENT_SECRET", clientSecret)
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {
    implementation(project(mapOf("path" to ":models")))
    implementation (libs.bundles.androidx)
    implementation (libs.hiltNavigation)
    implementation (libs.hiltAndroid)
    implementation (libs.bundles.retrofit)
    kapt (libs.hiltCompiler)
}