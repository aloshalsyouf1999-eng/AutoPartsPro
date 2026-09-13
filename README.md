# 🚗 AutoPartsPro - Android App

**A comprehensive Android application for vehicle maintenance, spare parts marketplace, and mechanic networking.**

![Android](https://img.shields.io/badge/Android-14%2B-green)
![Kotlin](https://img.shields.io/badge/Kotlin-1.8%2B-purple)
![Architecture](https://img.shields.io/badge/Architecture-MVVM-blue)
![License](https://img.shields.io/badge/License-MIT-yellow)

---

## 📱 Overview

AutoPartsPro is a feature-rich Android application designed to connect drivers, mechanics, and spare parts vendors. The app provides:

- 🔧 **Maintenance Management** - Schedule and track vehicle maintenance
- 🛠️ **Fault Reporting** - Report issues with text, voice, photos, or videos
- 🏎️ **Parts Compatibility Matching** - Find compatible parts for your vehicle
- 📞 **Direct Communication** - Connect with mechanics and vendors
- 💳 **Integrated Payments** - Secure booking and payment processing
- 🤖 **AI Diagnostics** - Get troubleshooting suggestions powered by AI

---

## ✨ Current Features

### ✅ Joke Generator (Initial Feature)
- Fetches random jokes from Official Joke API
- Clean MVVM architecture
- Error handling & loading states
- Modern Android best practices

### 🚀 Upcoming Features
- Parts Compatibility Search
- Multi-format Fault Reporting
- Maintenance Scheduling
- Mechanic Finder
- Payment Integration
- AI-powered Diagnostics

---

## 🏗️ Architecture

### **MVVM Pattern**
```
┌─────────────────────────────────┐
│         UI Layer                │
│  (Fragments & Activities)       │
└────────────────┬────────────────┘
                 ↓
┌─────────────────────────────────┐
│      ViewModel Layer            │
│  (State Management & Logic)     │
└────────────────┬────────────────┘
                 ↓
┌─────────────────────────────────┐
│    Repository Layer             │
│  (Data Access)                  │
└────────────────┬────────────────┘
                 ↓
┌─────────────────────────────────┐
│    Network & Local DB           │
│  (Retrofit, Room)               │
└─────────────────────────────────┘
```

---

## 🛠️ Tech Stack

| Component | Technology |
|-----------|------------|
| **Language** | Kotlin |
| **Architecture** | MVVM |
| **UI Framework** | AndroidX, Material Design |
| **Navigation** | Jetpack Navigation |
| **State Management** | LiveData, ViewModel |
| **Networking** | Retrofit, OkHttp, Gson |
| **Database** | Room (optional caching) |
| **Media** | CameraX, MediaRecorder |
| **Image Loading** | Glide |
| **Async** | Coroutines |

---

## 📦 Project Structure

```
app/
├── src/main/
│   ├── java/com/example/autopartspro/
│   │   ├── MainActivity.kt
│   │   ├── ui/
│   │   │   └── JokeGeneratorFragment.kt
│   │   ├── viewmodel/
│   │   │   └── JokeViewModel.kt
│   │   ├── repository/
│   │   │   └── JokeRepository.kt
│   │   ├── network/
│   │   │   ├── JokeApiService.kt
│   │   │   └── RetrofitClient.kt
│   │   └── model/
│   │       └── Joke.kt
│   ├── res/
│   │   ├── layout/
│   │   │   ├── activity_main.xml
│   │   │   └── fragment_joke_generator.xml
│   │   ├── drawable/
│   │   │   └── joke_background.xml
│   │   ├── navigation/
│   │   │   └── nav_graph.xml
│   │   └── values/
│   │       └── strings.xml
│   └── AndroidManifest.xml
└── build.gradle
```

---

## 🚀 Getting Started

### Prerequisites
- Android Studio (Flamingo or later)
- Android SDK 24+
- Kotlin 1.8+
- Gradle 8.0+

### Installation

1. **Clone the repository**
   ```bash
   git clone https://github.com/aloshalsyouf1999-eng/AutoPartsPro.git
   cd AutoPartsPro
   ```

2. **Checkout the branch**
   ```bash
   git checkout feature/joke-generator
   ```

3. **Open in Android Studio**
   - File → Open → Select AutoPartsPro folder
   - Wait for Gradle sync

4. **Run the app**
   - Click Run (Shift + F10)
   - Select emulator or device

---

## 📚 Dependencies

```gradle
// Core Android
androidx.core:core-ktx:1.10.1
androidx.appcompat:appcompat:1.6.1
com.google.android.material:material:1.9.0

// Navigation & Lifecycle
androidx.navigation:navigation-fragment-ktx:2.6.0
androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1
androidx.lifecycle:lifecycle-livedata-ktx:2.6.1

// Networking
com.squareup.retrofit2:retrofit:2.9.0
com.squareup.retrofit2:converter-gson:2.9.0
com.squareup.okhttp3:okhttp:4.11.0

// Media & Camera
androidx.camera:camera-core:1.2.2
androidx.media:media:1.6.0

// Image Loading
com.github.bumptech.glide:glide:4.15.1
```

---

## 🔌 API Integration

### Official Joke API
- **Base URL**: `https://official-joke-api.appspot.com/jokes/`
- **Endpoint**: `/random`
- **Method**: `GET`
- **Response**:
  ```json
  {
    "id": 1,
    "type": "general",
    "setup": "Why did the programmer quit his job?",
    "punchline": "Because he didn't get arrays."
  }
  ```

---

## 🎯 Usage

### Running the App

1. **Start the emulator** or connect a device
2. **Click Run** in Android Studio
3. **Open Joke Generator Fragment**
4. **Click "Get Another Joke"** to fetch new jokes

### Sample Code

#### Fetching a Joke
```kotlin
viewModel.fetchJoke()
```

#### Observing Data
```kotlin
viewModel.joke.observe(viewLifecycleOwner) { joke ->
    setupTextView.text = joke.setup
    punchlineTextView.text = joke.punchline
}
```

---

## 🧪 Testing

Run unit and instrumentation tests:
```bash
# Unit tests
./gradlew test

# Instrumentation tests
./gradlew connectedAndroidTest
```

---

## 🐛 Troubleshooting

### Gradle Sync Issues
- **Solution**: File → Invalidate Caches / Restart

### API Calls Failing
- **Solution**: Check internet permission in AndroidManifest.xml
- Verify device has internet connection
- Test API: `https://official-joke-api.appspot.com/jokes/random`

### Fragment Not Showing
- **Solution**: Rebuild project
- Check navigation graph configuration
- Verify MainActivity extends AppCompatActivity

---

## 📋 Documentation

- [ANDROID_STUDIO_SETUP.md](./ANDROID_STUDIO_SETUP.md) - Complete setup guide
- [JOKE_GENERATOR_SETUP.md](./JOKE_GENERATOR_SETUP.md) - Feature documentation

---

## 🔐 Permissions

```xml
<uses-permission android:name="android.permission.INTERNET" />
<uses-permission android:name="android.permission.CAMERA" />
<uses-permission android:name="android.permission.RECORD_AUDIO" />
<uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE" />
<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
```

---

## 🚀 Roadmap

- [ ] Parts Compatibility Search
- [ ] Multi-format Fault Reporting
- [ ] Maintenance Calendar
- [ ] Mechanic Ratings & Reviews
- [ ] Payment Gateway Integration
- [ ] Push Notifications
- [ ] Offline Mode with Room DB
- [ ] AI Diagnostics Engine
- [ ] Multi-language Support
- [ ] Dark Mode

---

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit changes (`git commit -m 'Add AmazingFeature'`)
4. Push to branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

---

## 📄 License

This project is licensed under the MIT License - see [LICENSE](LICENSE) file for details.

---

## 👨‍💻 Author

**Alosh Alsyouf**
- GitHub: [@aloshalsyouf1999-eng](https://github.com/aloshalsyouf1999-eng)
- Email: alosh.alsyouf1999@gmail.com

---

## 🙏 Acknowledgments

- [Official Joke API](https://official-joke-api.appspot.com/)
- [Android Documentation](https://developer.android.com/)
- [Retrofit](https://square.github.io/retrofit/)
- [Android Architecture Components](https://developer.android.com/topic/architecture)

---

## 📞 Support

For issues, questions, or suggestions:
1. Open an issue on GitHub
2. Create a discussion
3. Contact via email

---

**Happy Coding! 🚀**

Made with ❤️ by Alosh Alsyouf
