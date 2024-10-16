plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("maven-publish")
}

android {
    namespace = "com.example.wre_ref_engine_sdk"
    compileSdk = 34

    defaultConfig {
        minSdk = 21
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_1
        targetCompatibility = JavaVersion.VERSION_1_1
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

publishing {
    publications {
        create<MavenPublication>("release") {
            afterEvaluate {
                from(components["release"])

                // Customize your library coordinates here
                groupId = "com.example"
                artifactId = "wre_ref_engine_sdk"
                version = "1.0.0"
            }
        }
    }

    // Specify the local Maven repository location
    repositories {
        maven {
            url = uri("${rootProject.buildDir}/repo")
            maven("https://jitpack.io")
        }
    }
}




dependencies {
    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("com.google.android.material:material:1.12.0")
    api("com.adjust.sdk:adjust-android:5.0.0")
    api("com.android.installreferrer:installreferrer:2.2")
    api("com.adjust.sdk:adjust-android-webbridge:5.0.0")

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.2.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.6.1")
    implementation("com.github.Nkmhub:android_wre_ref_engine_sdk:1.0.0")
}
