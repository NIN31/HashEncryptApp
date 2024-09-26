cmake_minimum_required(VERSION 3.4.1)

project(CryptoUtils)


set(OPENSSL_ROOT_DIR "C:/Program Files/OpenSSL-Win64")
set(OPENSSL_INCLUDE_DIR "C:/Program Files/OpenSSL-Win64/include")
set(OPENSSL_CRYPTO_LIBRARY "C:/Program Files/OpenSSL-Win64/lib/VC/x64/MD/libcrypto.lib")
set(OPENSSL_SSL_LIBRARY "C:/Program Files/OpenSSL-Win64/lib/VC/x64/MD/libssl.lib")


find_package(OpenSSL REQUIRED)


add_library(CryptoUtils SHARED src/main/cpp/CryptoUtils.cpp)


target_link_libraries(CryptoUtils OpenSSL::SSL OpenSSL::Crypto)


include_directories(${OPENSSL_INCLUDE_DIR})
