# NativeCrashApp

A simple example application to review the analysis and debugging steps to resolve native crashes.

## Background

The one hundred most popular Android applications have been installed 54 billion times (as of December 2018). And 85% of those apps contain native code with 1000+ individual native libraries. If you've worked on any of those 100 applications, or on similar large applications, that's a lot of opportunity for something to go wrong!

Android developers should be comfortable debugging native crash stack traces ("tombstones" in Android-speak). But crashes on the native side (i.e in low-level C/C++ code) are often complicated and hard to understand. Not only that, but they can crash the JVM (Java Virtual Machine) before returning control to the Java/Kotlin code. This means you can't catch the exception at your application level, providing a terrible user experience!

## Additional Info
[Companion blog article](https://medium.com/p/xxxxx)
