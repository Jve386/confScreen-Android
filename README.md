# Android Configuration Settings 🛠️

## Technologies Used 💻

- Language: Kotlin
- Android Frameworks: Android SDK, Android Jetpack
- UI Components: XML layout with Material Design components, SwitchMaterial, Toast for toggles, MaterialDivider
- Data Persistence: Jetpack DataStore
- Design Pattern: Singleton
- Libraries: [Material Components](https://m2.material.io/design/platform-guidance/android-settings.html) , DataStore Preferences

## Features ⚙️

- Adjust device volume using a range slider.
- Toggle Bluetooth functionality with a switch.
- Enable/disable device vibration using a switch.
- Switch between light and dark modes using a switch.

## Key Components 🛠️

### 🔨 Models:
#### SettingsModel
- **Purpose:** Represents the settings data structure.
- **Responsibilities:**
  - Holds data about volume level, Bluetooth status, vibration status, and dark mode status.

### 🔨 UI:
#### SettingsActivity
- **Purpose:** Manages the settings screen UI and user interactions.
- **Responsibilities:**
  - Uses DataStore Preferences to save and retrieve settings data.
  - Implements UI components for adjusting volume, toggling Bluetooth, vibration, and dark mode.
  - Utilizes SwitchMaterial for toggle switches.
  - Displays Toast messages for toggle events.
  - Includes MaterialDivider for visual separation.

#### MainActivity
- **Purpose:** Launches the main activity with a button to navigate to the settings screen.
- **Responsibilities:**
  - Uses View Binding to inflate the layout.
  - Navigates to the SettingsActivity on button click.

### 🔨 Data:
#### Context.dataStore
- **Purpose:** Provides access to DataStore Preferences.
- **Responsibilities:**
  - Creates a DataStore instance for storing settings preferences.

### 🔨 Coroutines:
#### CoroutineScope
- **Purpose:** Manages coroutines for background tasks.
- **Responsibilities:**
  - Launches coroutines for saving and retrieving settings data.

### 🔨 Design Pattern:
#### Singleton
- **Purpose:** Ensures a single instance of a class exists and provides a global point of access to it.
- **Responsibilities:**
  - Used to create a single instance of the DataStore for settings.

## How to Use ✨

1. Clone the repository.
2. Open the project in Android Studio.
3. Build and run on an Android device or emulator.

## Additional Notes 📝

Feel free to contribute, open issues, or use this project as a learning resource for Android development, DataStore Preferences integration, and implementing the Singleton design pattern. The project follows modern Android development practices and provides insights into using Kotlin Coroutines, Material Design components, and View Binding.

Happy coding 👌!
