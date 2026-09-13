# Random Joke Generator Setup

## Overview
This feature integrates a random joke generator using the Official Joke API.

## API Details
- **Base URL:** `https://official-joke-api.appspot.com/jokes/`
- **Endpoint:** `/random`
- **Response:** JSON with joke setup and punchline

## Files Added

### Model
- `Joke.kt` - Data class for joke structure

### Network
- `JokeApiService.kt` - Retrofit interface for API calls
- `RetrofitClient.kt` - Retrofit singleton configuration

### Repository
- `JokeRepository.kt` - Data access layer

### ViewModel
- `JokeViewModel.kt` - State management and business logic

### UI
- `JokeGeneratorFragment.kt` - Fragment for displaying jokes
- `fragment_joke_generator.xml` - Layout file
- `joke_background.xml` - Background drawable

## Dependencies Required (add to build.gradle)

```gradle
dependencies {
    // Retrofit
    implementation 'com.squareup.retrofit2:retrofit:2.9.0'
    implementation 'com.squareup.retrofit2:converter-gson:2.9.0'
    
    // ViewModel & LiveData
    implementation 'androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1'
    implementation 'androidx.lifecycle:lifecycle-livedata-ktx:2.6.1'
    
    // Fragment
    implementation 'androidx.fragment:fragment-ktx:1.6.1'
}
```

## AndroidManifest.xml Permissions

```xml
<uses-permission android:name="android.permission.INTERNET" />
```

## Integration Steps

1. Add the dependencies to `build.gradle`
2. Add internet permission to `AndroidManifest.xml`
3. Add `JokeGeneratorFragment` to your navigation graph
4. Add the fragment to your main activity or navigation drawer

## Usage

The fragment automatically loads a joke on creation and provides a button to fetch new jokes.

### How it works:
1. User opens the fragment or clicks "Get Another Joke"
2. ViewModel triggers `fetchJoke()` from the repository
3. Repository makes an API call via Retrofit
4. Response is parsed and displayed in LiveData
5. UI updates automatically when joke data arrives
