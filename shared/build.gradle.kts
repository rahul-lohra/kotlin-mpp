
//plugin for multiplatform
plugins {
    kotlin("multiplatform")
}

//define targets & sorcesets
kotlin{

    //define targets
    jvm("android")


    //define sourcesets and their dependencies
    sourceSets["commonMain"].dependencies {
        implementation("org.jetbrains.kotlin:kotlin-stdlib-common")
        implementation("io.ktor:ktor-client-core:1.3.2")
    }

    sourceSets["androidMain"].dependencies {
        implementation("org.jetbrains.kotlin:kotlin-stdlib")
        implementation("io.ktor:ktor-client-android:1.3.2")
    }
}