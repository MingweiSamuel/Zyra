#!/bin/bash
# this script generates the gh-pages branch after build in circleci
# ${project.build.finalName}

# exit on error
set -e

# don't make pages for pull requests
[ -n "$CIRCLE_PR_NUMBER" ] && echo 'Skipping PR' && exit 0

# move to dir of this script (./target)
cd "$(dirname "$0")"
git init

# create empty jekyll config
touch _config.yml

# create index file
cat >index.md <<EOL
---
---
## ${project.build.finalName}

[CircleCI build $CIRCLE_BUILD_NUM]($CIRCLE_BUILD_URL) ${CIRCLE_TAG-}

$(git -C .. log -1 --no-color | sed 's/^/    /')

### Docs

* [Javadoc online](apidocs/)
* [${project.build.finalName}-javadoc.jar](https://circleci.com/api/v1/project/MingweiSamuel/Zyra/$CIRCLE_BUILD_NUM/artifacts/0/\$CIRCLE_ARTIFACTS/${project.build.finalName}-javadoc.jar)
* [${project.build.finalName}-sources.jar](https://circleci.com/api/v1/project/MingweiSamuel/Zyra/$CIRCLE_BUILD_NUM/artifacts/0/\$CIRCLE_ARTIFACTS/${project.build.finalName}-sources.jar)


### Jars

* [${project.build.finalName}-standalone.jar](https://circleci.com/api/v1/project/MingweiSamuel/Zyra/$CIRCLE_BUILD_NUM/artifacts/0/\$CIRCLE_ARTIFACTS/${project.build.finalName}-standalone.jar)
* [${project.build.finalName}-standalone-full.jar](https://circleci.com/api/v1/project/MingweiSamuel/Zyra/$CIRCLE_BUILD_NUM/artifacts/0/\$CIRCLE_ARTIFACTS/${project.build.finalName}-standalone-full.jar)
* [${project.build.finalName}.jar](https://circleci.com/api/v1/project/MingweiSamuel/Zyra/$CIRCLE_BUILD_NUM/artifacts/0/\$CIRCLE_ARTIFACTS/${project.build.finalName}.jar)

EOL

# push
git add apidocs
git add _config.yml
git add index.md
git -c "user.name=CircleCI" -c "user.email=mingwei.samuel@gmail.com" commit -m "autogen javadoc [ci skip]"
git push -f https://github.com/MingweiSamuel/Zyra.git HEAD:gh-pages
