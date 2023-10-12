plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.devtools.ksp")
    id("kotlin-parcelize")
}

android {
    namespace = "com.israfel.muslimmedia"
    compileSdkPreview = "UpsideDownCake"

    defaultConfig {
        applicationId = "com.israfel.muslimmedia"
        minSdk = 30
        targetSdk = 33
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    // Splash Screen Android 12
    implementation("androidx.core:core-splashscreen:1.0.1")

    // Picasso - Image Loader
    implementation("com.squareup.picasso:picasso:2.8")

    // Moshi
    // JSON Converter
    // 1 if library JSON converter for data serialization
    implementation("com.squareup.moshi:moshi:1.14.0")
    // Kotlin Codegen
    ksp("com.squareup.moshi:moshi-kotlin-codegen:1.14.0")

    // Retrofit - Request HTTP/HTTPS client
    // HTTP client - Retrofit with OkHttp
    // to retrieve and upload JSON (or other structure data) via a REST based webservice
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-moshi:2.9.0")
}