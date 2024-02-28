plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    //id("kotlin-kapt")
    id("com.google.devtools.ksp")
    //id("kotlin-android")
}

android {
    namespace = "ru.com.bulat.cryptoapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "ru.com.bulat.cryptoapp"
        minSdk = 24
        targetSdk = 34
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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    //coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0")

    //Retrofit 2
    implementation ("com.squareup.retrofit2:adapter-rxjava2:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")


    implementation ("androidx.room:room-runtime:2.6.1")
    ksp ("androidx.room:room-compiler:2.6.1")
    // optional - Kotlin Extensions and Coroutines support for Room
    implementation ("androidx.room:room-ktx:2.6.1")

    implementation ("com.squareup.picasso:picasso:2.8")

    implementation ("androidx.work:work-runtime-ktx:2.9.0")

    implementation ("com.google.dagger:dagger:2.50")
    ksp ("com.google.dagger:dagger-compiler:2.50")


    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}