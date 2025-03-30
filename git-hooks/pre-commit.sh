#!/bin/sh
./gradlew spotlessApply spotlessCheck && git add -u
