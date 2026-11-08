# Multiple Activities

An Android application demonstrating multi-activity navigation, data transfer via explicit intents, state preservation, and custom swipe gesture navigation.

## Overview

This project showcases fundamental Android development concepts:
- **Activity Navigation & Data Passing**: Passing integer data across activities using explicit intents (`Intent.putExtra()` / `Intent.getIntExtra()`).
- **State Management**: Retaining counter state during device orientation changes (`onSaveInstanceState`).
- **Gesture Control**: Implementing custom touch listeners (`OnSwipeTouchListener`) to handle swipe gestures for screen transitions.
- **Custom UI Styling**: Distinct color schemes and layouts for each activity matching user interface specifications.

---

## Features

### 1. MainActivity (First Screen)
- Bright yellow theme.
- **Counter**: Increments upon tapping the **COUNT** button.
- **Navigation**:
  - **GO TO ACTIVITY 2**: Launches `HelloActivity` with the current counter value.
  - **GO TO ACTIVITY 3**: Launches `ThirdActivity` with the current counter value.

### 2. HelloActivity (Second Screen)
- Deep blue theme.
- Displays the text **Hello!** along with the current counter value.
- **Navigation**:
  - **GO TO ACTIVITY 1**: Returns to `MainActivity` while maintaining the counter value.

### 3. ThirdActivity (Third Screen)
- Vibrant orange theme.
- Displays the text **Activity 3** along with the current counter value.
- **Dual Navigation**:
  - **Button Navigation**: Dedicated buttons to return to `MainActivity` (**GO TO ACTIVITY 1**) or `HelloActivity` (**GO TO ACTIVITY 2**).
  - **Swipe Gesture Navigation**:
    - **Swipe Left**: Navigates to `MainActivity`.
    - **Swipe Right**: Navigates to `HelloActivity`.

---

## Project Structure

```
MultipleActivities/
├── app/
│   ├── build.gradle.kts
│   └── src/
│       └── main/
│           ├── AndroidManifest.xml
│           ├── java/com/example/multipleactivities/
│           │   ├── MainActivity.java           # Primary screen managing the counter and navigation
│           │   ├── HelloActivity.java          # Displays "Hello!" and the counter value
│           │   ├── ThirdActivity.java          # Displays "Activity 3", counter, and swipe handlers
│           │   └── OnSwipeTouchListener.java   # Helper class detecting left and right swipe gestures
│           └── res/
│               ├── layout/
│               │   ├── activity_main.xml       # Main layout view
│               │   ├── activity_hello.xml      # Second activity layout view
│               │   └── activity_third.xml      # Third activity layout view
│               └── values/
│                   ├── colors.xml              # Palette definitions (yellow, blue, orange, etc.)
│                   ├── strings.xml             # Application string constants
│                   └── themes.xml              # Material design theme configurations
├── build.gradle.kts
├── gradle.properties
├── settings.gradle.kts
└── README.md
```

---

## Requirements & Building

- **IDE**: Android Studio
- **Minimum SDK**: 24 (Android 7.0 Nougat)
- **Target SDK**: 37 (Android 15)
- **Language**: Java 11

### How to Build & Run
1. Open the project folder in **Android Studio**.
2. Allow Gradle sync to complete.
3. Select an Android emulator or connected device.
4. Click **Run 'app'** or execute in terminal:
   ```bash
   ./gradlew assembleDebug
   ```
