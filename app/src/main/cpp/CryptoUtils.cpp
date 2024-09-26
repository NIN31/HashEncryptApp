#include <jni.h>
#include <string>
#include <openssl/sha.h>

extern "C"
JNIEXPORT jstring JNICALL
Java_com_example_hashencryptapp_CryptoUtils_generateHash(JNIEnv *env, jobject, jstring input) {
    const char *inputStr = env->GetStringUTFChars(input, 0);


    unsigned char hash[SHA256_DIGEST_LENGTH];
    SHA256((unsigned char*)inputStr, strlen(inputStr), hash);


    std::string hashHex;
    for (int i = 0; i < SHA256_DIGEST_LENGTH; ++i) {
        char buffer[3];
        sprintf(buffer, "%02x", hash[i]);
        hashHex += buffer;
    }

    env->ReleaseStringUTFChars(input, inputStr);
    return env->NewStringUTF(hashHex.c_str());
}
