# NativeCrashApp

A simple example application to review the analysis and debugging steps to resolve native crashes.

## Background

The one hundred most popular Android applications have been installed 54 billion times. And 85% of those apps contain native code with 1000+ individual native libraries. If you work on any of those applications or similar ones, then that's a lot of opportunity for something to go wrong - so, Android developers should get comfortable debugging native crash stack traces ("tombstones" in Android-speak).

Crashes on the native side (i.e in low-level C/C++ code) are often complicated to understand. Not only that, but they can crash the JVM before returning control to the Java/Kotlin code, so you can't catch the exception at your application level. This provides a terrible user experience!
