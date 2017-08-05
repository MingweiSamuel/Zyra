#!/bin/bash
# this script generates the gh-pages branch after build in circleci
# ${project.build.finalName}

# exit on error
set -e

# don't make pages for pull requests
[ -n "$CIRCLE_PR_NUMBER" ] && echo 'Skipping PR' && exit 0

# move to dir of this script (./target)
cd "$(dirname "$0")"
mkdir gh-pages
cd gh-pages

# theme config
echo 'theme: jekyll-theme-modernist' > _config.yml

# create index file
cat >index.md <<EOL
## NIGHTLY BUILD ${project.build.finalName}

[CircleCI build $TRAVIS_BUILD_NUMBER](https://travis-ci.org/MingweiSamuel/Zyra/builds/$TRAVIS_BUILD_ID)

    $TRAVIS_COMMIT

$(echo "$TRAVIS_COMMIT_MESSAGE" | sed 's/^/    /')

### Docs

* [Javadoc online](apidocs/)
* [${project.build.finalName}-javadoc.jar](${project.build.finalName}-javadoc.jar)
* [${project.build.finalName}-sources.jar](${project.build.finalName}-sources.jar)
* [Code Coverage](coverage/)


### Jars

* [${project.build.finalName}-standalone.jar](${project.build.finalName}-standalone.jar)
* [${project.build.finalName}-standalone-full.jar](${project.build.finalName}-standalone-full.jar)
* [${project.build.finalName}.jar](${project.build.finalName}.jar)

EOL

# move docs and coverage
mv ../apidocs ./
mv ../coverage ./
mv ../zyra-*.jar ./

#mv ../_config.yml
#git add index.md
#git -c "user.name=CircleCI" -c "user.email=mingwei.samuel@gmail.com" commit -m "autogen javadoc [ci skip]"
#git push -f https://github.com/MingweiSamuel/Zyra.git HEAD:gh-pages
