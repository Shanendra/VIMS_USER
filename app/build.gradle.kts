plugins {
    alias(libs.plugins.androidApplication)
    id("com.google.gms.google-services")

}

android {
    namespace = "com.example.vims_user"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.vims_user"
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
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    implementation(libs.androidx.appcompat)
    implementation(libs.google.material)
    implementation ("androidx.navigation:navigation-fragment:2.3.0")
    implementation ("androidx.navigation:navigation-ui:2.3.0")
    implementation ("com.google.android.material:material:1.3.0-alpha01")
    implementation ("com.github.denzcoskun:ImageSlideshow:0.1.2")
    implementation ("androidx.appcompat:appcompat:1.7.0-alpha03")
    implementation("com.google.firebase:firebase-database:20.3.1")
    implementation ("com.google.firebase:firebase-analytics:20.0.1")
    implementation("com.google.firebase:firebase-database:20.3.1")
    implementation ("com.google.firebase:firebase-storage:20.3.0")
    implementation ("com.google.firebase:firebase-auth:22.3.1")
    implementation ("androidx.appcompat:appcompat-resources:1.7.0-alpha03")
    implementation ("com.google.firebase:firebase-bom:32.8.1")
    implementation("com.google.firebase:firebase-analytics")
    implementation("de.hdodenhof:circleimageview:3.0.1")
    implementation("com.squareup.picasso:picasso:2.8")
    implementation("com.github.bumptech.glide:glide:4.16.0")
    implementation("com.github.chrisbanes:PhotoView:latest.release.here")




    // implementation ("com.github.smarteist:autoimageslider:1.4.0")
   // implementation ("com.github.smarteist:autoimageslider:1.4.0-appcompat")
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}