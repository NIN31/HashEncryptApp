 HashEncryptApp

Description:  
This Android app allows users to input a string, generates a strong hash of the input, encrypts the hash using a public key fetched from a URL, and includes native C++ implementations for specific steps. It is designed for Android 11 and above.

Features
- Hash Generation: Securely hashes user input using Kotlin.
- Encryption: Encrypts the generated hash with a public key using OpenSSL (via C++).
- Native C++ Integration: Steps involving encryption are implemented using C++ to enhance performance and security.
- OpenSSL: Integrates OpenSSL for cryptographic operations through native code.

Tech Stack
- Language: Kotlin for Android, C++ for native implementation.
- IDE: Android Studio with CMake for native build system integration.
- Libraries: 
  - OpenSSL for cryptography.
  - OkHttp for fetching the public key from a URL.
  - Android Jetpack components.
  - Android NDK for native C++ support.

 Requirements
- Minimum SDK: 30 (Android 11)
- Target SDK: 34
- NDK Version: 26.1.10909125
- CMake Version: 3.22.1
- OpenSSL Version: OpenSSL 3.3.2 (or later)


Build Instructions

1. Clone the repository:
   
   git clone <repository-url>
   

2. Open the project in Android Studio.

3. Make sure the following tools are installed:
   - Android SDK (API 30+)
   - NDK version 26.1.10909125 (NDK must match your version)
   - CMake version 3.22.1 or higher

4. Set up OpenSSL:
   - Ensure OpenSSL is installed on your system.
   - Set the OPENSSL_ROOT_DIR and OPENSSL_CRYPTO_LIBRARY in your system environment variables or directly in the CMakeLists.txt file.

5. Build the project:
   - Open Android Studio.
   - Sync the project and build.



Running the App

1. Enter a string into the app's input field.
2. The app will generate a secure hash of the input.
3. It will fetch a public key from a URL and encrypt the hash using OpenSSL.
4. The result will be displayed to the user.
