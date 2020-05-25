# Panda3 
Simple Android game written in Java using libGDX engine.

## Installation

### Android Studio
The easiest way to run the game is to open this project in Android Studio. There we need to select a device which will run our game. If there are no available devices we need to create one in Android Studio's AVD manager or connect compatible Android device and put it in debugging mode. After selecting device we can build and run the project.

### Other options

#### Installing prerequisites and setting up environment
To compile and run the game we will need to install install OpenJDK and Android SDK.

1. Depending on your system you can install OpenJDK 8 using package manager or following the guide [here](https://openjdk.java.net/install/).
2. To install Android SDK download commandlinetools from [Android Developer](https://developer.android.com/studio/index.html#downloads) and unpack it to Android folder somewhere on your system.
4. Add Android and following subfolders to your system's PATH environment variable:
```bash
Android/tools
Android/tools/bin
Android/emulator
Android/platform-tools
```
5. Now you should be able to connect an Android device in debugging mode and see it with `adb start-server && adb devices`. Alternatively, instead of connecting a device you can create an Android Virtual Device with avdmanager and emulate it.

#### Building and running
If you correctly setup the environment running the app should be a piece of cake. All you have to do is navigate to the directory with the source code and run `./gradlew installDebug`. Gradle will take care of downloading dependencies, bulding the app and installing it on your device. It might also be necessary to specify SDK's location which Gradle is supposed to use.

## Specification

### Description
This is a simple single-player game. It is lightly based off of a popular title 'SkiFree' meaning it is an 'endless runner' with gameplay elements such as avoiding obstacles, earning points and powerups. Apart from the game screen the app will have a menu, high-score table and settings menu. 

### Implementation details
The main framework used is Java's libGDX. This means the code is relying heavly on OOP with elemets of event-driven architecture for handling user events and some interior activities.

## Progress
Basic structure of the project is now almost done. Next steps are:
- adding animation
- adding more obstacle types
- finishing up main menu
- counting score

