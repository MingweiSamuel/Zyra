#!/bin/bash
set -e
cd target/apidocs
git init
git add .
git -c "user.name=CircleCI" -c "user.email=mingwei.samuel@gmail.com" commit -m "autogen javadoc [ci skip]"
git push -f https://github.com/MingweiSamuel/Zyra.git HEAD:gh-pages
