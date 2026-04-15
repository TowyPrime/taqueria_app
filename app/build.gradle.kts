import shadow.bundletool.com.android.tools.r8.internal.vi

plugins {
    alias(libs.plugins.android.application)
    id("com.google.gms.google-services")
    id("com.google.devtools.ksp")
}

android {
    namespace = "com.example.taqueria"
    compileSdk {
        version = release(36) {
            minorApiLevel = 1
        }
    }

    defaultConfig {
        applicationId = "com.example.taqueria"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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

    buildFeatures{
        viewBinding = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    //Firebase
    implementation(platform("com.google.firebase:firebase-bom:34.11.0"))
    implementation("com.google.firebase:firebase-analytics")
    implementation("com.google.firebase:firebase-firestore")
    implementation ("com.google.firebase:firebase-auth")

    val roomVersion = "2.8.4"
    val viewModelV = "2.7.0"
    val coroutines = "1.7.3"
    val fragment = "1.6.2"
    val activity = "1.8.2"
    val navigationFragment = "2.7.7"

    //Room
    implementation("androidx.room:room-runtime:$roomVersion")
    ksp("androidx.room:room-compiler:$roomVersion")

    // ViewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$viewModelV")

// Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutines")

    // Fragments
    implementation("androidx.fragment:fragment-ktx:$fragment")
    implementation("androidx.activity:activity-ktx:$activity")
    implementation("androidx.navigation:navigation-fragment-ktx:$navigationFragment")
    implementation("androidx.navigation:navigation-ui-ktx:$navigationFragment")

    //Splash screen
    implementation("androidx.core:core-splashscreen:1.0.1")



}