# mBank Unrestrictor

LSPosed module for mBank Polska `3.122.2` (`pl.mbank`). It bypasses the rooted-device gates that disable biometric login and interrupt contactless BLIK setup.

The module keeps Android's real biometric prompt and cryptographic key checks intact. It only changes mBank's insecure-device verdict and suppresses the BLIK SDK security callback caused by root.

## Install

1. Install the APK from `app/build/outputs/apk/debug/app-debug.apk`.
2. Enable the module in LSPosed and scope it only to **mBank PL** (`pl.mbank`).
3. Force-stop mBank, clear it from recents, and start it again.

Built and traced against mBank `3.122.2`; obfuscated class names may change after an app update.
