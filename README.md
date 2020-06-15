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
If you correctly setup the environment running the app should be a piece of cake. All you have to do is navigate to the directory with the source code and run `./gradlew installDebug`. Gradle will take care of downloading dependencies, building the app and installing it on your device. It might also be necessary to specify SDK's location which Gradle is supposed to use.

## Specification

### Description
This is a simple single-player game. It is lightly based off of a popular title 'SkiFree' meaning it is an 'endless runner' with gameplay elements such as avoiding obstacles, earning points and powerups. Apart from the game screen the app will have a menu, high-score table and settings menu. 

### Implementation details
The main framework used is Java's libGDX. This means the code is relying heavily on OOP with elements of event-driven architecture for handling user events and some interior activities.

In-game assets are loaded using asset manager which simplifies disposiong of them on quiting the game.

#### Powerups
Implementation of powerups was achieved thanks to libGDX's *Action* class and more specifically *TemporalAction* since our powerups are time based. They are attached to the Panda which makes it easy to manipulate different attributes of her. Thanks to this adding new powerups is as simple as adding its type to *PowerUpType* enum and defining its action.

#### Unit tests
Simple unit tests were written using the JUnit library and they are strongly integrated in Android Studio workflow. If one would want to run them without AS it can be done by using gradle wrapper with command *./gradlew tests:test*.
Apart from JUnit, I also used helper snippet from https://github.com/TomGrill/gdx-testing in order to be able to run tests featuring libGDX's classes separately from Android, essentially mocking OpenGL interface using Java's Mockito. 

These unit tests are quiet simple but can be viewed as a proof of concept and demonstration that I can use those frameworks. Below is a list of the tests with a short summary of their functionality:
- Tests of Actions are testing that powerups are working properly - changing the state of the actor that they are attached to and that they last the amount of time they are supposed to.
- Tests of Actors are testing only two simple UI actors HealthBar and Score. We are testing if they are properly changing their state.
- Tests of RanomdUtils are testing if distribution of functions *getRandomObstacleType* and *getRandomPowerUpType* are even, meaning it is equally likely to get either type.

## Summary and future plans
In conclusion I think this project can be deemed as a success. In the future I would like to add simple help screen or tutorial and export the game to standalone APK so I can host it on a website for people to download and try out.

